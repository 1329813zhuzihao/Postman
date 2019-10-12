package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;
import com.zhiyou100.util.ResultObject;

/**
 * 演示前后端分离开发：
 * 		后端Restful风格的代码
 * 		以及使用postman测试接口
 * */
@RestController //该类中的所有方法都返回json数据，每个方法不用再去写@ResponseBody
public class UserController {

	@Autowired
	private UserMapper mapper;
	
	/**
	 * 查询全部
	 * get /user/get 参数无 返回ResultObject :{"code":"200/404/500","msg":"提示信息","":""}
	 * */
	@RequestMapping(value="/user/get",method=RequestMethod.GET)
	public ResultObject getAll(){
		List<User> users = mapper.getAllUser();
		System.out.println("getAll :"+users);
		if(users == null || users.size() == 0){
			return new ResultObject(201,"没有数据！",null);
		}
		
		return new ResultObject(200,"成功！",users);
	}
	
	/**
	 * 查询一个
	 * get /user/get/{id} 参数int id 返回值
	 * */
	@RequestMapping(value="/user/get/{id}",method=RequestMethod.GET)
	public ResultObject getUserById(@PathVariable int id){
		System.out.println("getUserById id:"+id);
		User user = mapper.getUserById(id);
		/**
		 * 对对象的判断
		 * */
		System.out.println("getUserById user:"+user);
		
		return new ResultObject(200,"成功",user);
	}
	
	/**
	 * 添加用户
	 * post /user/add 参数User user 返回值
	 * 参数User user
	 * 	以form表单发送
	 * 	ajax默认形式postman : application/x-www-form-urlencoded
	 * 	发送json数据: postman : row->json
	 * 		而且：如果前台发送的json数据，后台要封装对象，需要使用
	 * 		@RequestBody 解析JSON数据，才能封装对象
	 * 这次演示：
	 * 		前端发送json格式数据
	 * */
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	public ResultObject addUser(@RequestBody User user){
		System.out.println("getUserById id:"+user);
		int row = 0;
		try{
		row = mapper.addUser(user);
		/**
		 * 对对象的判断
		 * */
		}catch(Exception e){
			System.out.println("添加异常");
			row = -1;
		}
		if(row>0){
			return new ResultObject(200,"成功",null);
		}
		
		return new ResultObject(404,"失败",user);
	}
	
	
	/**
	 * 删除一个
	 * delte /user/delete/{id} 参数int id 返回值
	 * */
	@RequestMapping(value="/user/delete/{id}",method=RequestMethod.DELETE)
	public ResultObject delteUserById(@PathVariable int id){
		System.out.println("getUserById id:"+id);
		int row = mapper.deleteUserById(id);
		/**
		 * 对对象的判断
		 * */
		if(row > 0) {
			return new ResultObject(200,"删除成功",null);
		}else{
			return new ResultObject(201,"没有该用户",null);
		}
		
	}
	
	/**
	 * 更新一个
	 * put /user/update 参数json 返回值
	 * */
	@RequestMapping(value="/user/update",method=RequestMethod.PUT)
	public ResultObject updateUserById(@RequestBody User user){
		System.out.println("updateUserById user:"+user);
		int row = mapper.updateUserById(user);
		/**
		 * 对对象的判断
		 * */
		if(row > 0) {
			return new ResultObject(200,"更新成功",null);
		}else{
			return new ResultObject(201,"没有该用户",null);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
