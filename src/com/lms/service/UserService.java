package com.lms.service;

import java.util.List;

import com.lms.bean.UserBean;

public interface UserService {

	public String addUser(UserBean userBean);

	public List<UserBean> usersByName(String userName);

}
