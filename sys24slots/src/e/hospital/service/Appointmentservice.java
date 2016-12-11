package e.hospital.service;

import java.util.ArrayList;
import java.util.Date;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.SlotBean;

public interface Appointmentservice {
String adddetail(AppointmentBean appointmentBean);
public ArrayList<AppointmentBean> findAll();
public ArrayList<SlotBean> findslots();
public ArrayList<SlotBean> slotavail(String id,Date date);
}
