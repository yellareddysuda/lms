package com.lms.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lms.bean.UserBean;
import com.lms.bean.UserType;

public class UserDao {

	private static final String STAFF = "SF_";
	private static final String STUDENT = "ST_";
	private static int studentNo = 0;
	private static int staffNo = 0;

	private Map<String, UserBean> userMap = new HashMap<>();

	public String addUser(UserBean userBean) {
		String userId = "";
		if (UserType.STUDENT == userBean.getUserType()) {
			userId = STUDENT + ++studentNo;
		} else if (UserType.STAFF == userBean.getUserType()) {
			userId = STAFF + ++staffNo;
		}
		userMap.put(userId, userBean);
		return userId;
	}

	public UserBean getUser(String userId) {
		return userMap.get(userId);
	}

	public List<UserBean> getUserByName(String userName) {
		List<UserBean> userList = new ArrayList<>();
		for (Entry<String, UserBean> entry : userMap.entrySet()) {
			UserBean user = entry.getValue();
			if (userName != null && user.getUserName().contains(userName)) {
				userList.add(user);
			}
		}
		return userList;
	}
}
