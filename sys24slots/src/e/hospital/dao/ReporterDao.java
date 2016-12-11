package e.hospital.dao;

import java.util.ArrayList;
import java.util.Date;

import e.hospital.bean.DoctorBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.ScheduleBean;

public interface ReporterDao {
	public String createXYZ(LeaveBean leaveBean);
	//int deleteXYZ(ArrayList<String> A);
	//public boolean updateXYZ(LeaveBean leaveBean);
	//public LeaveBean findByID(String s);
	public ArrayList<LeaveBean> findAll();
	//public int deleteXYZ(String ID);
	
	public String createschedule(ScheduleBean scheduleBean);
	public ScheduleBean findByID(String s);
	 public ArrayList<ScheduleBean> findAll1();
	 
	 
	 
	 
	 public	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date);
	 public ArrayList<DoctorBean> intimateAdmin(Date date, String status);
	 public int status(String docid,Date date1,Date date2);
}
