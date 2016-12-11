package e.hospital.service;

import java.util.ArrayList;




import java.util.Date;

import e.hospital.bean.DoctorBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.ScheduleBean;

public interface ReporterService {
public	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date);
public ArrayList<DoctorBean> intimateAdmin(Date date, String status);
public String addLeave(LeaveBean leaveBean);
public ArrayList<LeaveBean> viewAllLeave();
public String addschedule(ScheduleBean scheduleBean);
public ScheduleBean findByID(String ID);
public int status(String docid,Date date1,Date date2);

}
