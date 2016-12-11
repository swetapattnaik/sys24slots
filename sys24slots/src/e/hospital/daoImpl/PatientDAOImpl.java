package e.hospital.daoImpl;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.DoctorSearchBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.PatientRegisterBean;
import e.hospital.bean.ScheduleBean;
import e.hospital.dao.AdministratorDao;
import e.hospital.dao.PatientDAO;
import e.hospital.dao.ReporterDao;
import e.hospital.dao.Appointmentdao;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	private SessionFactory sessionfactory;
	@Autowired
	ReporterDao dao3;
	@Autowired
	Appointmentdao dao1;
	@Autowired
	AdministratorDao admin;

	public String createXYZ(PatientRegisterBean patientBean, HttpServletRequest request, HttpServletResponse response) {
		String s = (String) sessionfactory.getCurrentSession().save(patientBean);
		HttpSession s1 = request.getSession();
		s1.setAttribute("pb", patientBean);

		return s;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PatientRegisterBean> viewAilmentDetails(String patientID) {
		System.out.println("here");
		String viewAilmentDetails = "SELECT s FROM com.wipro.ocs.bean.PatientBean AS s";
		ArrayList<PatientRegisterBean> ailmentdetails = (ArrayList<PatientRegisterBean>) sessionfactory
				.getCurrentSession().createQuery(viewAilmentDetails).list();
		return ailmentdetails;
	}

	public boolean update(PatientRegisterBean patientBean) {
		Session session = this.sessionfactory.getCurrentSession();
		session.update(patientBean);
		return true;

	}

	public PatientRegisterBean findByID(String patientID) {
		return (PatientRegisterBean) sessionfactory.getCurrentSession().get(PatientRegisterBean.class, patientID);
	}

	public ArrayList<LeaveBean> findAll() {
		Session session = this.sessionfactory.getCurrentSession();
		ArrayList<LeaveBean> doctorLeave = (ArrayList<LeaveBean>) session.createCriteria(LeaveBean.class).list();
		return doctorLeave;

	}

	public ArrayList<DoctorBean> findAlldoctors() {
		Session session = this.sessionfactory.getCurrentSession();
		ArrayList<DoctorBean> d = (ArrayList<DoctorBean>) session.createCriteria(DoctorBean.class).list();
		return d;
	}

	public DoctorBean findDoctorByID(String doctorID) {
		Session session = this.sessionfactory.getCurrentSession();
		DoctorBean doctorBean = (DoctorBean) session.get(DoctorBean.class, doctorID);
		return doctorBean;
	}

	public String requestforAppointment(String doctorID, Date appointmentDate) {

		System.out.println("Patient date" + appointmentDate);
		// Session session = sessionfactory.getCurrentSession();
		ArrayList<DoctorBean> doc = dao3.viewAllAvailableDoctors(appointmentDate);

		String s1 = "failure";
		Iterator itr = doc.iterator();
		while (itr.hasNext()) {
			DoctorBean d = (DoctorBean) itr.next();
			// System.out.println("available doctors"+d);
			if (d.getDoctorID().equals(doctorID)) {
				s1 = "confirm";
				break;
			}

		}
		return s1;
	}

	public ArrayList<PatientRegisterBean> viewAilmentDetails() {
		String viewAilmentDetails = "SELECT s FROM com.wipro.ocs.bean.PatientBean AS s";
		ArrayList<PatientRegisterBean> ailmentdetails = (ArrayList<PatientRegisterBean>) sessionfactory
				.getCurrentSession().createQuery(viewAilmentDetails).list();
		return ailmentdetails;
	}

	public ArrayList<ScheduleBean> findAll1() {
		Session session = this.sessionfactory.getCurrentSession();
		ArrayList<ScheduleBean> scheduleLeave = (ArrayList<ScheduleBean>) session.createCriteria(ScheduleBean.class)
				.list();
		return scheduleLeave;
	}

	public Map<AppointmentBean, PatientRegisterBean> viewAppointmentDetails(String patientID, Date date) {

		Map<AppointmentBean, PatientRegisterBean> m = new HashMap<AppointmentBean, PatientRegisterBean>();
		// ArrayList<AppointmentBean> l=dao1.findAll();
		System.out.println("abc" + date);
		Session session = this.sessionfactory.getCurrentSession();
		// Iterator itr=l.iterator();
		// while(itr.hasNext())
		// { AppointmentBean l1=(AppointmentBean)itr.next();

		/*
		 * Date date1=l1.getAppointmentDate(); System.out.println("abc1"+date1);
		 * String date11=date1.toString().substring(0,11);
		 * System.out.println(date11);
		 * 
		 * 
		 * 
		 */

		org.hibernate.Query query2 = session.createQuery("from PatientBean where patientID =?");
		query2.setParameter(0, patientID);
		ArrayList<PatientRegisterBean> pb = (ArrayList<PatientRegisterBean>) query2.list();
		AppointmentBean ap11 = null;
		PatientRegisterBean pb11 = null;
		if (pb.size() != 0) {
			pb11 = pb.get(0);

			org.hibernate.Query query1 = session
					.createQuery("from AppointmentBean where appointmentDate =? and patientID=?");
			query1.setParameter(0, date);
			query1.setParameter(1, patientID);
			ArrayList<AppointmentBean> ap = (ArrayList<AppointmentBean>) query1.list();
			/*
			 * 
			 * ArrayList<AppointmentBean> ap=(ArrayList<AppointmentBean>)
			 * query1.list(); Iterator itr=ap.iterator(); while(itr.hasNext()) {
			 * AppointmentBean l1=(AppointmentBean)itr.next(); String
			 * id1=l1.getPatientID();
			 * 
			 * ArrayList<PatientBean> p=viewAilmentDetails(); Iterator
			 * itr1=p.iterator(); while(itr1.hasNext()) { PatientBean
			 * l2=(PatientBean)itr1.next(); String id2=l2.getPatientID();
			 * if(id2.equals(id1)) {
			 * 
			 * m.put(l1,l2); } }
			 */

			if (ap.size() != 0) {
				ap11 = ap.get(0);
			}

		}

		m.put(ap11, pb11);

		return m;

	}

	public ArrayList<DoctorBean> viewListOfDoctors(String specialization, Date date) {
		ArrayList<DoctorBean> array1 = new ArrayList<DoctorBean>();
		array1 = findAlldoctors();
		// get doctors based on specialization
		ArrayList<DoctorBean> array2 = new ArrayList<DoctorBean>();
		// get doctors based on specialization+schedule
		ArrayList<DoctorBean> array4 = new ArrayList<DoctorBean>();

		ArrayList<ScheduleBean> array3 = new ArrayList<ScheduleBean>();
		ArrayList<ScheduleBean> sb = findAll1();
		// date is converted to day
		DateFormat dayFormat = new SimpleDateFormat("EEEE");

		String Day = dayFormat.format(date);

		System.out.println(date);
		System.out.println(Day);

		Iterator itr1 = array1.iterator();
		while (itr1.hasNext()) {
			DoctorBean db = (DoctorBean) itr1.next();
			db.getSpecialization();

			if (specialization.equals(db.getSpecialization())) {
				array2.add(db);
				System.out.println("added");
			}
		}
		Iterator itr4 = array2.iterator();
		while (itr4.hasNext()) {
			DoctorBean db1 = (DoctorBean) itr4.next();
			db1.getDoctorID();
			System.out.println("got id" + db1.getDoctorID());

			Iterator<ScheduleBean> itr2 = sb.iterator();
			while (itr2.hasNext()) {
				System.out.println("else3");
				ScheduleBean s = (ScheduleBean) itr2.next();
				String id = s.getDoctorID();
				array3.add(s);

				if (db1.getDoctorID().equals(id)) {
					String str = s.getAvailableDays();
					ArrayList<String> aList = new ArrayList<String>(Arrays.asList(str.split(",")));
					System.out.println("else");
					Iterator itr3 = aList.iterator();
					while (itr3.hasNext()) {
						if (Day.equals(itr3.next())) {
							System.out.println("success");
							array4.add(admin.findByID(db1.getDoctorID()));

						}
					}
				}

			}
		}

		return array4;
	}

	public ArrayList<DoctorBean> getDoctorListBasedOnSearch() {
		Session session = this.sessionfactory.getCurrentSession();
		StringBuffer query = new StringBuffer();
		query.append("from DoctorBean");
		org.hibernate.Query query2 = session.createQuery(query.toString());
		ArrayList<DoctorBean> doctorBean = (ArrayList<DoctorBean>) query2.list();

		return doctorBean;
	}

}
