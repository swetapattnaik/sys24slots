package e.hospital.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.ScheduleBean;
import e.hospital.bean.SlotBean;
import e.hospital.dao.Appointmentdao;
@Repository
public class AppointmentdaoImpl implements Appointmentdao {
	@Autowired
	SessionFactory  SessionFactory ;
	@Transactional
	public String bookappoint(AppointmentBean appointmentBean) {
		AppointmentBean a=(AppointmentBean)appointmentBean;
		Session session =SessionFactory.getCurrentSession();
		String Id=(String) session.save(a);
		System.out.println("dao"+Id);
		
			return Id;
	
	}
	
	
	
	
	
	@Transactional
	 public ArrayList<AppointmentBean> findAll()
	 
	 {
		 Session session = this.SessionFactory.getCurrentSession();
			ArrayList<AppointmentBean> d2=(ArrayList<AppointmentBean>)session.createCriteria(AppointmentBean.class).list();
			return d2;
		 
		 
	 }
	@Transactional
	public ArrayList<SlotBean> findslots()
	{
		
		
		Session session = this.SessionFactory.getCurrentSession();
		Query q1=session.createQuery("from SlotBean");
		ArrayList<SlotBean> s2=(ArrayList<SlotBean>) q1.list();
		return s2;
		
		
		
	}
	
	


	@Transactional
	public ArrayList<SlotBean> slotavail(String id,Date date) {
		Session session = this.SessionFactory.getCurrentSession();
		Query q1=session.createQuery("select appointmentTime from  AppointmentBean where doctorID=? and trunc(appointmentDate)=?");
		q1.setParameter(0,id);
		q1.setParameter(1,date);
		ArrayList<String> atime=(ArrayList<String>) q1.list();
		Iterator it=atime.iterator();
		while(it.hasNext())
		{
		System.out.println(it.next());	
		}
		
		/*ArrayList<String> slotduration=new ArrayList<String>();
		ArrayList<AppointmentBean> a=(ArrayList<AppointmentBean>) q1.list();
		Iterator it=a.iterator();
		while(it.hasNext())
		{
			AppointmentBean a1=(AppointmentBean) it.next();
			System.out.println(a1);
			String t=a1.getAppointmentTime();
			slotduration.add(t);
		}
		
		ArrayList<SlotBean> slot=new ArrayList<SlotBean>();
		Iterator itrs=slotduration.iterator();
		while(itrs.hasNext())
		{ String dura=(String) itrs.next();
			Query q2=session.createQuery("from SlotBean where slotduration=?");
			q1.setParameter(0,dura);
			ArrayList<SlotBean> a3=(ArrayList<SlotBean>) q1.list();
			if(a3.size()!=0)
			{   
				slot.add(a3.get(0));
			}
		}
		
		return slot;
	}
	*/
		
		
		ArrayList<SlotBean> slot=new ArrayList<SlotBean>();
		Iterator itrs=atime.iterator();
		while(itrs.hasNext())
		{ String dura=(String) itrs.next();
		System.out.println(dura);
		int j=Integer.parseInt(dura);
		System.out.println(j);
			Query q2=session.createQuery("from SlotBean where slotnumber=?");
			q2.setParameter(0,j);
			ArrayList<SlotBean> a3=(ArrayList<SlotBean>) q2.list();
			if(a3.size()!=0)
			{   System.out.println("slotslot"+a3.get(0));
			SlotBean s=(SlotBean)a3.get(0);
			System.out.println(s);
				slot.add(s);
			}
		}
		
		ArrayList<SlotBean> s1=findslots();
		s1.removeAll(slot);
		return s1;
}
}
