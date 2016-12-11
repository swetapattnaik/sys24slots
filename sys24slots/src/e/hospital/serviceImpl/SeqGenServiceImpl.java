package e.hospital.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.ProfileBean;
import e.hospital.dao.PatientDAO;
import e.hospital.dao.SeqGenDAO;
import e.hospital.service.SeqGenService;

@Service
public class SeqGenServiceImpl implements SeqGenService
{
	@Autowired
    private SeqGenDAO seqGenDAO;

	public String GenerateProfileUserid(ProfileBean profileBean)
	{
		return seqGenDAO.GenerateProfileUserid(profileBean);
		
	
	}

	public int GenerateAppointmentid(AppointmentBean appointmentBean) {
		
		return seqGenDAO.GenerateAppointmentid(appointmentBean);
	}

}
