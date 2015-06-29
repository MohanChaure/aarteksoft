package com.aartek.repository;

import com.aartek.model.User;

public interface LoginRepository {
	User findByUserName(String userName);
}
