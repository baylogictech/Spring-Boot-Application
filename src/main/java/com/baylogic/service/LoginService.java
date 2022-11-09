package com.baylogic.service;

import com.baylogic.model.UserLoginData;

public interface LoginService {
	public boolean register(UserLoginData userLoginData);
	public boolean resetPassword(String email);
	public boolean changePassword(UserLoginData userData);
	public String validatePasswordResetToken(String token);
}
