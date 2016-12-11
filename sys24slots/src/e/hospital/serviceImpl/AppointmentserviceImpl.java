package e.hospital.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.SlotBean;
import e.hospital.service.Appointmentservice;
@Service
public class AppointmentserviceImpl implements Appointmentservice {
	@Autowired
	e.hospital.dao.Appointmentdao appointmentdaointerface;
	public String adddetail(AppointmentBean appointmentBean) {
	   String Id=appointmentdaointerface.bookappoint(appointmentBean);
	   System.out.println("dao"+Id);
	   return Id;
	}
	
	
	
	
	public ArrayList<AppointmentBean> findAll()
	{
		ArrayList<AppointmentBean> a=appointmentdaointerface.findAll();
		return a;
	}
	public ArrayList<SlotBean> findslots()
	{
		ArrayList<SlotBean> slot=appointmentdaointerface.findslots();
		return slot;
	}
	public ArrayList<SlotBean> slotavail(String id,Date date) {
		ArrayList<SlotBean> a=appointmentdaointerface.slotavail(id,date);
		return a;
	}
}
