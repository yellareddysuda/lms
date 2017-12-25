package com.lms.service.impl;

import java.util.List;

import com.lms.bean.UserBean;
import com.lms.persistence.UserDao;
import com.lms.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDao();

	@Override
	public String addUser(UserBean userBean) {
		return dao.addUser(userBean);
	}

	@Override
	public List<UserBean> usersByName(String userName) {
		return dao.getUserByName(userName);
	}

}
