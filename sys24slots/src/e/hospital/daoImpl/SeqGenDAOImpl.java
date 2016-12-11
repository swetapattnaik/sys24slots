package e.hospital.daoImpl;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.ProfileBean;
import e.hospital.dao.SeqGenDAO;

@Repository

public class SeqGenDAOImpl implements SeqGenDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public String GenerateProfileUserid(ProfileBean profileBean)
	{
		Session session=sessionFactory.getCurrentSession();
		org.hibernate.Query query=session.createSQLQuery("select OCS_SEQ_USERID.NEXTVAL from dual");
		int key = ((BigDecimal)((org.hibernate.Query) query).uniqueResult()).intValue();
		String s = profileBean.getFirstName().substring(0, 2).toUpperCase();
		System.out.println("t : "+key+"    s : "+s);
		return s+key;
		
	}

	@Transactional
	public int GenerateAppointmentid(AppointmentBean appointmentBean) {
		
		Session session=sessionFactory.getCurrentSession();
		org.hibernate.Query query=session.createSQLQuery("select OCS_SEQ_APPOINTMENTID.NEXTVAL from dual");
		int key = ((BigDecimal)((org.hibernate.Query) query).uniqueResult()).intValue();
       System.out.println(key);
       
		/*DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
		Date date = appointmentBean.getAppointmentDate();
		//appointment date
		System.out.println(date);
		//formatting date
		String datestring = dateFormat.format(date); 
		System.out.println(datestring);
		
		//getting substring
	String s = datestring.substring(4,8);
	System.out.println(s);
		return s+key;*/
		

		//String delimeter = "-";
	//String[] s1 = datestring.split(delimeter);
		//String s2 =  Arrays.toString(s1);
		
		
		return key;
	}

}
