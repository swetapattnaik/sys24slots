package e.hospital.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.DoctorSearchBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.PatientRegisterBean;
import e.hospital.dao.AdministratorDao;
import e.hospital.dao.PatientDAO;
import e.hospital.dao.ReporterDao;
import e.hospital.service.PatientService;
import e.hospital.dao.Appointmentdao;

@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired
    private PatientDAO patientDAO;
	@Autowired
	private SessionFactory sessionfactory;

	@Autowired
	AdministratorDao dao;
	
	@Autowired
	Appointmentdao dao1;
	@Autowired
	ReporterDao report;
	
	@Transactional
	public String addAilmentDetails(PatientRegisterBean patientBean,HttpServletRequest request,HttpServletResponse response)
	{
		return patientDAO.createXYZ(patientBean,request,response);
		
	}

	@Transactional
	public ArrayList<PatientRegisterBean> viewAilmentDetails(String patientID) {
		 
		return patientDAO.viewAilmentDetails(patientID);
	}

	@Transactional
	public boolean modifyAilmentDetails(PatientRegisterBean patientBean) {
		 
		return patientDAO.update(patientBean);
		
	}

	@Transactional
	public PatientRegisterBean findByPatientID(String patientID)
	{
		
		return patientDAO.findByID(patientID);
	}

	@Transactional
	public ArrayList<DoctorBean> viewListOfDoctors(String specialization,
			Date date)
			{
		
		return patientDAO.viewListOfDoctors(specialization, date);
	}

	@Transactional
	public String requestforAppointment(String doctorID, Date appointmentDate) {

		return patientDAO.requestforAppointment(doctorID, appointmentDate);
	}
	@Transactional
	public Map<AppointmentBean, PatientRegisterBean> viewAppointmentDetails(String patientID, Date date)
	{
		return patientDAO.viewAppointmentDetails(patientID, date);
	}
@Transactional
	public ArrayList<PatientRegisterBean> viewAilmentDetails() {
		
		return patientDAO.viewAilmentDetails();
	}

@Transactional
public ArrayList<DoctorBean> getDoctorListBasedOnSearch() {
	
	return patientDAO.getDoctorListBasedOnSearch();
}
	
	
	
	
}



	
	

