package e.hospital.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import e.hospital.bean.LoginBean;
import e.hospital.bean.ProfileBean;



public interface LoginService {
	
	public 	String register(ProfileBean profileBean);
	public String changePassword(LoginBean credentialsBean,String s1);
	public String login(LoginBean credentialsBean,HttpServletRequest request,HttpServletResponse response);
public boolean logout(String userID);
}

