package e.hospital.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.DoctorSearchBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.PatientRegisterBean;
import e.hospital.bean.ScheduleBean;

public interface PatientDAO 
{
	String createXYZ(PatientRegisterBean patientBean, HttpServletRequest request, HttpServletResponse response);
	ArrayList<PatientRegisterBean> viewAilmentDetails(String patientID);
	ArrayList<PatientRegisterBean> viewAilmentDetails();
	boolean update(PatientRegisterBean patientBean);
	PatientRegisterBean findByID(String patientID);
	ArrayList<LeaveBean> findAll();
	DoctorBean findDoctorByID(String doctorID);
	ArrayList<DoctorBean> viewListOfDoctors(String specialization, Date date);
	String requestforAppointment(String doctorID, Date appointmentDate);
	public Map<AppointmentBean, PatientRegisterBean> viewAppointmentDetails(String patientID, Date date);
	//ArrayList<DoctorBean> viewListOfDoctors(String specialization, Date date);
	public ArrayList<ScheduleBean> findAll1();
	ArrayList<DoctorBean> findAlldoctors();
	public ArrayList<DoctorBean> getDoctorListBasedOnSearch();
}
