package e.hospital.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.PatientRegisterBean;

public interface AdministratorDao {
	public String createXYZ(DoctorBean doctorBean);
	int deleteXYZ(ArrayList<String> A);
	boolean updateXYZ(DoctorBean doctorBean);
	DoctorBean findByID(String s);
	ArrayList<DoctorBean> findAll();
	public int deleteXYZ(String ID);
	public Map<PatientRegisterBean, AppointmentBean> viewPatientsByDate(Date appointmentDate);
	ArrayList<DoctorBean> suggestDoctors(String patientId, Date date);


}


