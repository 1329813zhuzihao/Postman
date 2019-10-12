package com.zhiyou100.mapper;

import java.util.List;

import com.zhiyou100.model.User;

public interface UserMapper {

	List<User> getAllUser();

	User getUserById(int id);

	int addUser(User user);

	int deleteUserById(int id);

	int updateUserById(User user);

}
