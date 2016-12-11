package e.hospital.bean;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="OCS_TBL_APPOINTMENTS")
public class AppointmentBean 
{
@Id
	@GeneratedValue
	@Column(name="APPOINTMENTID")
private String appointmentID;

@Column(name="DOCTORID")
private String doctorID;

@Column(name="PATIENTID")
private String patientID;

@Column(name="APPOINTMENT_DATE")
@DateTimeFormat(iso = ISO.DATE)

@NotNull(message="Enter correct format")
private Date appointmentDate;

@Column(name="APPOINTMENT_TIME")
@NotEmpty
private String appointmentTime;


public AppointmentBean() {
	super();
}
public String getAppointmentID() {
	return appointmentID;
}
public void setAppointmentID(String appointmentID) {
	this.appointmentID = appointmentID;
}
public String getDoctorID() {
	return doctorID;
}
public void setDoctorID(String doctorID) {
	this.doctorID = doctorID;
}
public String getPatientID() {
	return patientID;
}
public void setPatientID(String patientID) {
	this.patientID = patientID;
}
public Date getAppointmentDate() {
	return appointmentDate;
}
public void setAppointmentDate(Date appointmentDate) {
	this.appointmentDate = appointmentDate;
}
public String getAppointmentTime() {
	return appointmentTime;
}
public void setAppointmentTime(String appointmentTime) {
	this.appointmentTime = appointmentTime;
}
@Override
public String toString() {
	return "AppointmentBean [appointmentID=" + appointmentID + ", doctorID="
			+ doctorID + ", patientID=" + patientID + ", appointmentDate="
			+ appointmentDate + ", appointmentTime=" + appointmentTime + "]";
}


}
