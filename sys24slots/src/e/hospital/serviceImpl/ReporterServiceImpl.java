package e.hospital.serviceImpl;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import e.hospital.bean.DoctorBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.ScheduleBean;
import e.hospital.dao.AdministratorDao;
import e.hospital.dao.ReporterDao;
import e.hospital.service.ReporterService;
@Service
public class ReporterServiceImpl implements ReporterService{

	@Autowired
	ReporterDao dao;
	
	@Autowired
	AdministratorDao dao1;
	
	
	public String addLeave(LeaveBean leaveBean)
	{
		
		dao.createXYZ(leaveBean);
		
		return "A";
	}
	
	
	public ArrayList<LeaveBean> viewAllLeave()
	{
		
		ArrayList<LeaveBean> a1=dao.findAll();
		
		return a1;
	}
	
	
	public String addschedule(ScheduleBean scheduleBean)
	{
		dao.createschedule(scheduleBean);
		return "A";
	}
	
	public ScheduleBean findByID(String ID) {

		ScheduleBean d5=(ScheduleBean)dao.findByID(ID);
		return d5;
	}

	
	
	public ArrayList<DoctorBean> intimateAdmin(Date date, String status)
	{	
		ArrayList<DoctorBean> d=dao.intimateAdmin(date, status);
		return d;
		
	}
		
		
	
	public	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date)
	{
		ArrayList<DoctorBean> d1=dao.viewAllAvailableDoctors(date);
		return d1;
		
	}
	public int status(String docid, Date date1, Date date2) {
		int a=dao.status(docid, date1, date2);
		return a;
	}
	}
