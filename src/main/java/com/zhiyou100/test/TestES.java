package com.zhiyou100.test;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;


public class TestES {
	
	/**
	 * 索引库插入文档
	 * 插入数据
	 * @throws IOException 
	 * */
	@Test
	public void testInsent() throws IOException{
		//0 创建客户端
		RestHighLevelClient cilent = new RestHighLevelClient(RestClient.builder(
					new HttpHost("192.168.178.131",9200,"http")));
		
		
		//1 创建插入的请求
		IndexRequest request = new IndexRequest("book2","novel","1");
		
		//2 构造json字符串，用户插入数据
		String jsonStr = "{\"ttile\":\"aaa\",\"content\":\"aaa\"}";
		
		//3 把上一步的json字符串设置进请求中
		request.source(jsonStr,XContentType.JSON);
		
		//4 发出请求
		IndexResponse resp = cilent.index(request);
		
		//5 判断有没有插入成功
		if (resp.getResult() == DocWriteResponse.Result.CREATED) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}
		
		//6 关流
		cilent.close();
		
	}
	

	/**
	 * 创建索引
	 * */
	@Test
	public void testESAddIndex() throws IOException{
		//1 创建客户端 
		RestHighLevelClient cilent = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("192.168.178.131",9200,"http")));
		//2 创建索引
		CreateIndexRequest request = new CreateIndexRequest("book2");
		
		//2-1 索引setting配置
		request.settings(Settings.builder().
				put("index.number_of_shards",5)//分片
				.put("index.number_of_replicas",1)//副本数
				);
		
		//3 构建mappings -3种方式  -这里使用json格式
		String jsonValue = "{\"novel\":{\"properties\":{\"title\":{\"type\":\"text\"},\"content\":{\"type\":\"text\"}}}}";
		
		//4发送请求
		cilent.indices().create(request);
		
		//5.关闭客户端
		cilent.close();
		System.out.println("成功");
		
	}
	
	/**
	 * 查询
	 * 1 下载 安装 ik
	 * 2 启动
	 * 3 重新创建索引user2
	 * 		创建索引时指定分词的模式
	 * 4 插入数据
	 * 5 head 插件测试
	 * */
	
	@Test
	public void testESSearch(){
		//1 创建客户端
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("192.168.178.131",9200,"http")));
		
		//2 获得[查询]请求
		SearchRequest searchRequest = new SearchRequest("user2");
		
		
	}
	
}
