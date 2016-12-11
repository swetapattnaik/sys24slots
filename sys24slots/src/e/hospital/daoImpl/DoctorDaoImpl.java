package e.hospital.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.PatientRegisterBean;
import e.hospital.dao.AdministratorDao;
import e.hospital.dao.PatientDAO;
import e.hospital.dao.ReporterDao;
import e.hospital.dao.Appointmentdao;

@Repository
public class DoctorDaoImpl implements AdministratorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	ReporterDao dao3;
	@Autowired
	Appointmentdao dao1;
	
	@Autowired
	PatientDAO dao2;
	
	@Transactional
	public String createXYZ(DoctorBean BeanObject)
	{
		DoctorBean d=(DoctorBean)BeanObject;
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		
			return "s";
		
	}

	
@Transactional
	public int deleteXYZ(ArrayList<String> A) {
		
		return 0;
	}

	


@Transactional
	public boolean updateXYZ(DoctorBean doctorBean) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.update(doctorBean);
		return true;
		
	}


@Transactional
	public DoctorBean findByID(String ID) {
		Session session = this.sessionFactory.getCurrentSession();
		DoctorBean d1=(DoctorBean)session.get(DoctorBean.class,ID);
		return d1;
	}


	@Transactional
	public ArrayList<DoctorBean> findAll()
	{
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<DoctorBean> d1=(ArrayList<DoctorBean>)session.createCriteria(DoctorBean.class).list();
		return d1;
	
	}


@Transactional
	public int deleteXYZ(String ID) {
	String pid=null;
	 Session session = this.sessionFactory.getCurrentSession();
		DoctorBean d1=(DoctorBean)session.get(DoctorBean.class,ID);
		Query q=session.createQuery("delete LeaveBean where doctorID=?");
		q.setParameter(0,ID);
		q.executeUpdate();
		Query q1=session.createQuery("delete ScheduleBean where doctorID=?");
		q1.setParameter(0,ID);
		q1.executeUpdate();
		
	
		Query q3=session.createQuery("delete AppointmentBean where doctorID=?");
		q3.setParameter(0,ID);
		q3.executeUpdate();
		
		session.delete(d1);
		
		return 1;
	}


@Transactional
public Map<PatientRegisterBean, AppointmentBean> viewPatientsByDate(Date appointmentDate)
{Map<PatientRegisterBean, AppointmentBean> m=new HashMap<PatientRegisterBean, AppointmentBean>();
ArrayList<AppointmentBean> l=dao1.findAll();
Iterator itr=l.iterator();
while(itr.hasNext())
{			AppointmentBean l1=(AppointmentBean)itr.next();
		

			Date date1=l1.getAppointmentDate();
			if(appointmentDate.compareTo(date1)==0)
			{		
				
				String id1=l1.getPatientID();
					
					
					ArrayList<PatientRegisterBean> p=dao2.viewAilmentDetails();
					Iterator itr1=p.iterator();
					while(itr1.hasNext())
					{			PatientRegisterBean l2=(PatientRegisterBean)itr1.next();
								String id2=l2.getPatientID();
								if(id2.equals(id1))
								{
									//a.add(p);
									m.put(l2,l1);
								}
					}
					
					
					
					
					
				}
	
	
			}
			
			return m;
	
}



@Transactional
public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date)
{
	
	/*
	System.out.println("abc");
	System.out.println(patientId);
	System.out.println(date);
	ArrayList<DoctorBean> docfinal=null;
	ArrayList<AppointmentBean> l=dao1.findAll();
	Iterator itr=l.iterator();
	while(itr.hasNext())
	{			AppointmentBean l1=(AppointmentBean)itr.next();
					String pid=l1.getPatientID();
					System.out.println(pid);
					if(pid.equals(patientId))
					{	System.out.println("patientmatch");
						String did=l1.getDoctorID();
						System.out.println("doctorrespectivetopatient"+did);
						Date d5=l1.getAppointmentDate();
						ArrayList<DoctorBean> db=dao3.intimateAdmin(d5,"1");
						System.out.println("initmateworking");
						
						System.out.println(db);
						Iterator itr1=db.iterator();
						while(itr1.hasNext())
						{			DoctorBean l2=(DoctorBean)itr1.next();
						
									String did1=l2.getDoctorID();
									System.out.println("abc"+did);
									System.out.println(did1+"doctoridgot");
									if(did.equals(did1))
										System.out.println("idmatch");
									{	docfinal=dao3.viewAllAvailableDoctors(date);
									
									System.out.println("docfinal"+docfinal);
									break;
									}
										
						}
						
						
					
					}
					


}
*/
	Session session = this.sessionFactory.getCurrentSession();
	org.hibernate.Query query2 = session.createQuery("from PatientBean where patientID =?");
	query2.setParameter(0, patientId);
	PatientRegisterBean p1=null;
	ArrayList<PatientRegisterBean> p=(ArrayList<PatientRegisterBean>) query2.list();
	if(p.size()!=0)
	{
		p1=p.get(0);
	}
		
	String special=p1.getAilmentType();
	//available doctor list on basis of schedulebean and specialization
	ArrayList<DoctorBean> d1=dao2.viewListOfDoctors(special,date);
	//leave doctors list
	ArrayList<DoctorBean> d2=dao3.intimateAdmin(date,"1");
	ArrayList<DoctorBean> d3=dao3.intimateAdmin(date,"0");
	d1.removeAll(d2);
	d1.removeAll(d3);
	
	
	return d1;

}
}