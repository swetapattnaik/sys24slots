package e.hospital.daoImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import e.hospital.bean.LoginBean;
import e.hospital.bean.ProfileBean;
import e.hospital.dao.LoginDAO;



@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

@Transactional
public String login(LoginBean credentialsBean,HttpServletRequest request,HttpServletResponse response) {
Session session = this.sessionFactory.getCurrentSession();
		
		LoginBean cb=(LoginBean) session.get(LoginBean.class, credentialsBean.getUserID());
		if(cb!=null)
		{
		System.out.println(cb);
		if(cb.getPassword().equals(credentialsBean.getPassword()))	
		{
			System.out.println(cb.getUserType());
		cb.setLoginStatus(1);
		Session session1 = this.sessionFactory.getCurrentSession();
		session1.saveOrUpdate(cb);
		
		HttpSession s=request.getSession();
		s.setAttribute("login",cb);
		
			return cb.getUserType();
		}
		}
			return "failure";
	}	
	
@Transactional
	public String register(ProfileBean profileBean) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String s=(String) session.save(profileBean);
		System.out.println(s);
		if(s!=null)
		{
			LoginBean c=new LoginBean();
			c.setUserID(s);
			c.setPassword(profileBean.getPassword());
			c.setUserType("P");
			
			c.setLoginStatus(0);
			Session session1 = this.sessionFactory.getCurrentSession();
		session1.save(c);
		}
		return s;
	}
@Transactional
	public String changePassword(LoginBean credentialsBean, String s1) {
		{
			Session session = this.sessionFactory.getCurrentSession();
			
			LoginBean cb=(LoginBean) session.get(LoginBean.class, credentialsBean.getUserID());
			String password=cb.getPassword();
			String password1=credentialsBean.getPassword();
			if(password.equals(password1))
				
			{
			cb.setPassword(s1);
			
			Session session1 = this.sessionFactory.getCurrentSession();
		
			session1.update(cb);
			return "sucess";
			}
			return "failure";
		}
}
		@Transactional
		public boolean logout(String userId)
		{
			Session session=sessionFactory.getCurrentSession();
			LoginBean cb=(LoginBean) session.get(LoginBean.class, userId);
			cb.setLoginStatus(0);
			
			return false;
		}		
}





