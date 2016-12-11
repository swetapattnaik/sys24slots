package e.hospital.service;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.ProfileBean;

public interface SeqGenService
{
	public String GenerateProfileUserid(ProfileBean profileBean);
	public int GenerateAppointmentid(AppointmentBean appointmentBean);

}
