package e.hospital.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table(name="OCS_TBL_LEAVE")
public class LeaveBean {
	@Id
	@GeneratedValue(generator = "my_gen")
	 @SequenceGenerator(name = "my_gen", sequenceName = "OCS_SEQ_LEAVEID")
	@Column(name="LEAVEID")
	private String leaveID;
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="DOCTORID")
	@Column(name="DOCTORID")
//private DoctorBean docbean;
	private String doctorID;
	@Column(name="LEAVE_FROM")
	@DateTimeFormat(iso = ISO.DATE)

	@NotNull(message="Enter correct format")
private Date leaveFrom;
	@Column(name="LEAVE_TO")
	@DateTimeFormat(iso = ISO.DATE)

	@NotNull(message="Enter correct format")
private Date leaveTo;
	@Column(name="REASON")
	@NotNull
private String reason;
	@Column(name="STATUS")
	@NotNull
private int status;
public LeaveBean() {
	super();
}






public String getLeaveID() {
	return leaveID;
}






public void setLeaveID(String leaveID) {
	this.leaveID = leaveID;
}




/*

public DoctorBean getDocbean() {
	return docbean;
}






public void setDocbean(DoctorBean docbean) {
	this.docbean = docbean;
}


*/




public Date getLeaveFrom() {
	return leaveFrom;
}
public String getDoctorID() {
	return doctorID;
}






public void setDoctorID(String doctorID) {
	this.doctorID = doctorID;
}






public void setLeaveFrom(Date leaveFrom) {
	this.leaveFrom = leaveFrom;
}
public Date getLeaveTo() {
	return leaveTo;
}
public void setLeaveTo(Date leaveTo) {
	this.leaveTo = leaveTo;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}






@Override
public String toString() {
	return "LeaveBean [leaveID=" + leaveID + ", doctorID=" + doctorID
			+ ", leaveFrom=" + leaveFrom + ", leaveTo=" + leaveTo + ", reason="
			+ reason + ", status=" + status + "]";
}

}
