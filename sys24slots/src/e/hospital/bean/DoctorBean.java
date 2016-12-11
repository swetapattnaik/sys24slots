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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "DOCTOR")
public class DoctorBean {
	@Id
	@GeneratedValue(generator = "doc_id")
	@SequenceGenerator(name = "doc_id", sequenceName = "DOCTORID")
	@Column(name = "DOCTORID")
	private String doctorID;
	@Column(name = "DOCTORNAME")
	@NotEmpty
	@Size(min = 3, max = 15)
	private String doctorName;
	
	@Column(name = "GENDER")
	private String gender;

	@Column(name = "HOSPITAL")
	private String hospital;

	@Column(name = "QUALIFICATION")
	@NotEmpty
	private String qualification;
	
	@Column(name = "SPECIALIZATION")
	@NotEmpty
	private String specialization;

	@Column(name = "YEARSOFEXPERIENCE")
	@NotEmpty
	private String yearsOfExperience;
	
	@Column(name = "CITY")
	@NotEmpty
	@Size(min = 5, max = 20)
	private String city;
	
	@Column(name = "EMAILID")
	@Email
	private String emailID;

	@Transient
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name = "DOCTORID")
	private AppointmentBean appointmentBean;

	public DoctorBean() {
		super();
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailID() {
		return emailID;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	// vikas
}
