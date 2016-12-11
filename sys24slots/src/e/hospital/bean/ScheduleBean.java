package e.hospital.bean;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="OCS_TBL_SCHEDULES")
public class ScheduleBean {
	
	@Id
	@GeneratedValue(generator = "my_gen")
	 @SequenceGenerator(name = "my_gen", sequenceName = "OCS_SEQ_SCHEDULEID")
	@Column(name="SCHEDULEID")
private String scheduleID;
	@Column(name="DOCTORID")
	@NotEmpty
	@Size(min=4,max=4)
private String doctorID;
@Column(name="AVAILABLE_DAYS")
@NotEmpty
private String availableDays;
@Column(name="SLOTS")
@NotEmpty
private String slots;
public ScheduleBean() {
	super();
}
public String getScheduleID() {
	return scheduleID;
}
public void setScheduleID(String scheduleID) {
	this.scheduleID = scheduleID;
}
public String getDoctorID() {
	return doctorID;
}
public void setDoctorID(String doctorID) {
	this.doctorID = doctorID;
}

public String getAvailableDays() {
	return availableDays;
}
public void setAvailableDays(String availableDays) {
	this.availableDays = availableDays;
}
public String getSlots() {
	return slots;
}
public void setSlots(String slots) {
	this.slots = slots;
}
@Override
public String toString() {
	return "ScheduleBean [scheduleID=" + scheduleID + ", doctorID=" + doctorID
			+ ", availableDays=" + availableDays + ", slots=" + slots + "]";
}

}
