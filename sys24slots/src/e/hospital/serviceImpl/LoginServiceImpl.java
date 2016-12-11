package e.hospital.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e.hospital.bean.LoginBean;
import e.hospital.bean.ProfileBean;
import e.hospital.dao.LoginDAO;
import e.hospital.service.LoginService;




@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	
	


	public String changePassword(LoginBean credentialsBean, String s1) {

		String s2=loginDAO.changePassword(credentialsBean,s1);
		
		return s2;
		
	}


	public String register(ProfileBean profileBean) {
		String flag=loginDAO.register(profileBean);
		if(flag != null)
		return profileBean.getUserID()+"";
		else
		return "failure";
	}



	public String login(LoginBean credentialsBean,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("service");
		String result=loginDAO.login(credentialsBean,request,response);
		
		return result;
			
	}
public boolean logout(String userID)
{
	boolean logout=loginDAO.logout(userID);
	return logout;
	
}

	

}
