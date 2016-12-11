package e.hospital.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="HOSPITAL_PATIENT_REGISTER")
public class PatientRegisterBean {
	
@Id
@GeneratedValue(generator = "my_gen")
@SequenceGenerator(name = "my_gen", sequenceName = "OCS_SEQ_PATIENTID")

@Column(name="PATIENTID")
private String patientID;

@Column(name="USERID")
private String userID;

@Column(name="APPOINTMENT_DATE")
@DateTimeFormat(iso = ISO.DATE)

@NotNull(message="Enter correct format")
private Date appointmentDate;

@Column(name="AILMENT_TYPE")
@NotEmpty
private String ailmentType;

@Column(name="AILMENT_DETAILS")
@NotEmpty
private String ailmentDetails;

@Column(name="DIAGNOSIS_HISTORY")
@NotEmpty
private String diagnosisHistory;

@Transient
@OneToOne(cascade=CascadeType.ALL)
@Column(name="PATIENTID")
private AppointmentBean appointmentBean;

public PatientRegisterBean() {
	super();
}
public String getPatientID() {
	return patientID;
}
public void setPatientID(String patientID) {
	this.patientID = patientID;
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public Date getAppointmentDate() {
	return appointmentDate;
}
public void setAppointmentDate(Date appointmentDate) {
	this.appointmentDate = appointmentDate;
}
public String getAilmentType() {
	return ailmentType;
}
public void setAilmentType(String ailmentType) {
	this.ailmentType = ailmentType;
}
public String getAilmentDetails() {
	return ailmentDetails;
}
public void setAilmentDetails(String ailmentDetails) {
	this.ailmentDetails = ailmentDetails;
}
public String getDiagnosisHistory() {
	return diagnosisHistory;
}
public void setDiagnosisHistory(String diagnosisHistory) {
	this.diagnosisHistory = diagnosisHistory;
}

@Override
public String toString() {
	return "PatientBean [patientID=" + patientID + ", userID=" + userID
			+ ", appointmentDate=" + appointmentDate + ", ailmentType="
			+ ailmentType + ", ailmentDetails=" + ailmentDetails
			+ ", diagnosisHistory=" + diagnosisHistory + "]";
}


}
