package e.hospital.dao;

import java.util.ArrayList;
import java.util.Date;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.SlotBean;

public interface Appointmentdao {
String bookappoint(AppointmentBean appointmentBean);
public ArrayList<AppointmentBean> findAll();
public ArrayList<SlotBean> findslots();
public ArrayList<SlotBean> slotavail(String id,Date date);
}
