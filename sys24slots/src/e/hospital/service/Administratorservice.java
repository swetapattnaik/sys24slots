package e.hospital.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.PatientRegisterBean;

public interface Administratorservice {
	public String addDoctor(DoctorBean doctorBean);
	Boolean modifyDoctor(DoctorBean doctorBean);
	ArrayList<DoctorBean> viewAllDoctors();
	int removeDoctor(String doctorID);
	ArrayList<DoctorBean> suggestDoctors(String patientId, Date date);

	public DoctorBean findByID(String ID);
	
	public Map <PatientRegisterBean, AppointmentBean> viewPatientsByDate(Date appointmentDate);
}
