package e.hospital.dao;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.ProfileBean;

public interface SeqGenDAO 
{
	public String GenerateProfileUserid(ProfileBean profileBean);
	public int GenerateAppointmentid(AppointmentBean appointmentBean);

}
