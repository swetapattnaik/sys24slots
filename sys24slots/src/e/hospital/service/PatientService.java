package e.hospital.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.DoctorSearchBean;
import e.hospital.bean.PatientRegisterBean;

public interface PatientService
{
	String addAilmentDetails(PatientRegisterBean patientBean, HttpServletRequest request, HttpServletResponse response);
	ArrayList<PatientRegisterBean> viewAilmentDetails(String patientID);
	boolean modifyAilmentDetails(PatientRegisterBean patientBean);
	PatientRegisterBean findByPatientID(String patientID);
	ArrayList<DoctorBean> viewListOfDoctors(String specialization, Date date);
	String requestforAppointment(String doctorID, Date appointmentDate);
	public Map<AppointmentBean, PatientRegisterBean> viewAppointmentDetails(String patientID, Date date);
	ArrayList<PatientRegisterBean> viewAilmentDetails();
	public ArrayList<DoctorBean> getDoctorListBasedOnSearch();
}
