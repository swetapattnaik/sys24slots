package e.hospital.serviceImpl;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.PatientRegisterBean;
import e.hospital.dao.AdministratorDao;
import e.hospital.dao.PatientDAO;
import e.hospital.service.Administratorservice;
import e.hospital.dao.Appointmentdao;

@Service
public class AdministratorserviceImpl implements Administratorservice{

	@Autowired
	AdministratorDao dao;
	
	@Autowired
	Appointmentdao dao1;
	
	@Autowired
	PatientDAO dao2;
	
	public String addDoctor(DoctorBean doctorBean)
	{
		String a=dao.createXYZ(doctorBean);
		if(a.equals("s"))
			return "SUCCESS";
		else
			return "FAIL";
		
	}

	public Boolean modifyDoctor(DoctorBean doctorBean) {
		boolean b=dao.updateXYZ(doctorBean);
		if(b==true)
			return true;
		else
			return false;
		
	}

	public ArrayList<DoctorBean> viewAllDoctors()
	{
		ArrayList<DoctorBean> a1=dao.findAll();
		
		return a1;
		
	}

	public int removeDoctor(String doctorID) {
		int b1= dao.deleteXYZ(doctorID);
		if(b1==1)
			return 1;
		else
			return 0;
		
	}

	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date) {
		
		System.out.println("entering service");
		
		ArrayList<DoctorBean> dm=	dao.suggestDoctors(patientId, date);
		
		return dm;
	}

	public Map<PatientRegisterBean, AppointmentBean> viewPatientsByDate(Date appointmentDate) {
		// TODO Auto-generated method stub
		
		
		Map<PatientRegisterBean, AppointmentBean> r=dao.viewPatientsByDate(appointmentDate);
		return r;
	}

	public DoctorBean findByID(String ID) {

		DoctorBean d5=(DoctorBean)dao.findByID(ID);
		return d5;
	}
}
