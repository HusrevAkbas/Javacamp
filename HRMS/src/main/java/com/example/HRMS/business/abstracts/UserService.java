package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getByUserId(int id);
	DataResult<User> getByEmail(String email);
}
