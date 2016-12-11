package e.hospital.daoImpl;



import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.ScheduleBean;
import e.hospital.dao.AdministratorDao;
import e.hospital.dao.ReporterDao;
@Repository
public class ReporterDaoImpl implements ReporterDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	AdministratorDao dao1;
	
	
	@Transactional
	public String createXYZ(LeaveBean leaveBean)
	{
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(leaveBean);
		
			return "A";
		
		
		
		
		
	}
	@Transactional
	public String createschedule(ScheduleBean scheduleBean)
	{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(scheduleBean);
		
			return "A";
	}
	
	@Transactional
	 public ArrayList<LeaveBean> findAll()
	 
	 {
		 Session session = this.sessionFactory.getCurrentSession();
			ArrayList<LeaveBean> d1=(ArrayList<LeaveBean>)session.createCriteria(LeaveBean.class).list();
			return d1;
		 
		 
	 }
	
	
	
/*
	@Transactional
	public ScheduleBean findByID(String ID) {
		Session session = this.sessionFactory.getCurrentSession();
		ScheduleBean d1=(ScheduleBean)session.get(ScheduleBean.class,ID);
		System.out.println(d1);
		return d1;
	}

	*/
	@Transactional
	public ScheduleBean findByID(String ID) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("daoid"+ID);
		org.hibernate.Query query = session.createQuery("from ScheduleBean where doctorID=?");
		///query.executeUpdate();
		query.setParameter(0,ID);
		ArrayList<ScheduleBean> sc=(ArrayList<ScheduleBean>) query.list();
		if(sc.size()!=0)
		{ScheduleBean a=sc.get(0);
		return a;}
		else
			return null;
	}

	
	
	
	@Transactional
	 public ArrayList<ScheduleBean> findAll1()
	 
	 {
		 Session session = this.sessionFactory.getCurrentSession();
			ArrayList<ScheduleBean> d2=(ArrayList<ScheduleBean>)session.createCriteria(ScheduleBean.class).list();
			return d2;
		 
		 
	 }
	
	
	
  @Transactional
	public ArrayList<DoctorBean> intimateAdmin(Date date, String status)
	{	System.out.println(date);
		System.out.println(status);
		int a=Integer.parseInt(status);
		/* Session session = this.sessionFactory.getCurrentSession();
		ArrayList<DoctorBean> avail=viewAllAvailableDoctors(date);
		ArrayList<DoctorBean> a2=dao1.findAll();
		a2.removeAll(avail);
		Iterator itr=a2.iterator();
		while(itr.hasNext())
		{
			DoctorBean leavedoc=(DoctorBean) itr.next();
			String did=leavedoc.getDoctorID();
			org.hibernate.Query query = session.createQuery("from LeaveBean where status=?");
			query.setParameter(0,did);
			query.setParameter(0,status);
			
			ArrayList<LeaveBean> appoint=(ArrayList<LeaveBean>) query.list();;
			Iterator it1=appoint.iterator();
			while(it1.hasNext())
			{
				
				
				
			}
			*/
		//list of doctors who are on leave on particular date and status
		ArrayList<DoctorBean> leave=new ArrayList<DoctorBean>();
			Session session = this.sessionFactory.getCurrentSession();
			org.hibernate.Query query1 = session.createQuery("from LeaveBean where trunc(leaveFrom) <= ? and trunc(leaveTo) >= ? and status=?");
			query1.setParameter(0, date);
			query1.setParameter(1, date);
			query1.setParameter(2, a);
			//arraylist contain leavebean
			ArrayList<LeaveBean> listAvailable = (ArrayList<LeaveBean>) query1.list();
			Iterator it1=listAvailable.iterator();
			while(it1.hasNext())
			{
				LeaveBean lb1=(LeaveBean) it1.next();
				
				leave.add(dao1.findByID(lb1.getDoctorID()));
			}
			return leave;
			
		}
		
		
		
		
		
		
		
		
		
		
  




@Transactional
public	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date)
{String s=null;

	System.out.println("patientdate1"+date);

 	ArrayList<DoctorBean> a3=new ArrayList<DoctorBean>();
 	ArrayList<DoctorBean> a2=dao1.findAll();
 	ArrayList<String> ids=new ArrayList<String>();

 //	java.sql.Date d3=new java.sql.Date(date.getTime());
	//System.out.println("date "+d3);
 System.out.println("yahaper may be");
 	System.out.println(date);
 	 java.sql.Date d3=new java.sql.Date(date.getTime());
 		System.out.println("date "+d3);
 		
 		Session session = this.sessionFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery("from LeaveBean where trunc(leaveFrom) <= ? and trunc(leaveTo) >= ?");
		query.setParameter(0, date);
		query.setParameter(1, date);
		ArrayList<LeaveBean> listAvailable = (ArrayList<LeaveBean>) query.list();
		Iterator it1=listAvailable.iterator();
		while(it1.hasNext())
		{
			LeaveBean lb1=(LeaveBean) it1.next();
			ids.add(lb1.getDoctorID());
			a3.add(dao1.findByID(lb1.getDoctorID()));
		}
		a2.removeAll(a3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	Iterator itr=a2.iterator();
	System.out.println("Availabledoctorsbean:::::");
	while(itr.hasNext())
	{			DoctorBean l1=(DoctorBean)itr.next();
				System.out.println(l1);
	}
	
	
	
	
	
	return a2;

}


@Transactional
public int status(String docid, Date date1, Date date2) {
	Session session = this.sessionFactory.getCurrentSession();
	org.hibernate.Query q1=session.createQuery("from  AppointmentBean where doctorID=? and trunc(appointmentDate) between ? and ?");
	q1.setParameter(0,docid);
	q1.setParameter(1,date2);
	q1.setParameter(2,date1);
	ArrayList<AppointmentBean> a=(ArrayList<AppointmentBean>) q1.list();
	if(a.size()!=0)
	{
	return 1;
	}
	else
	{
		return 0;
	}
}

}
