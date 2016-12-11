package e.hospital.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.LoginBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.SlotBean;
import e.hospital.service.Administratorservice;
import e.hospital.service.LoginService;
import e.hospital.service.PatientService;
import e.hospital.service.ReporterService;
import e.hospital.service.SeqGenService;

@Controller
public class appointmentcontroller {
	

	@Autowired
	private e.hospital.dao.Appointmentdao appointmentdaointerface;
	@Autowired
	private e.hospital.service.Appointmentservice appointmenttable;

	@Autowired
	private PatientService Patientservice;
	@Autowired
	private ReporterService reportservice;
	@Autowired
	private Administratorservice adminService;
	@Autowired
	private SeqGenService seqGenService;

	
	
/*	@RequestMapping(value="/appoint")
	public ModelAndView appoint1(@ModelAttribute DoctorBean doctorBean,BindingResult result,@RequestParam String patientID,@RequestParam String date) throws ParseException
	{   
		AppointmentBean a=new AppointmentBean();
	System.out.println(date);
	String s=date.substring(0,10);
	s.trim();

	java.sql.Date d=Date.valueOf(s);
	System.out.println(d);

	a.setAppointmentDate(d);
	
	
	System.out.println("setted date");
	
	DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	String datestring = format1.format(d);
	System.out.println("formatted date:"+datestring);
	
	String ds = datestring.toString().substring(4,8);
	System.out.println("substring:"+ds);

	int num = seqGenService.GenerateAppointmentid(a);
	String number = Integer.toString(num);
	System.out.println("seq number :"+number);

	String id = ds+num;

	System.out.println("appoint id: "+id);
	System.out.println("before");
	a.setAppointmentID(id);
	System.out.println("after");
	
	
	a.setDoctorID(doctorBean.getDoctorID());
	a.setPatientID(patientID);
		System.out.println(patientID);
		doctorBean.getDoctorID();
		
		System.out.println("appoint");
     
System.out.println("1st "+a);
		Map<String, Object> modellist = new HashMap<String, Object>();
		
		return new ModelAndView("AppointmentBean","appointmentBean",a);
	}
	
	
	*/
	
	
	
	
	
	
	
	
/*	
	
	@RequestMapping(value="/appointment")
	public ModelAndView appoint2(@ModelAttribute @Valid AppointmentBean appointmentBean,BindingResult result) throws ParseException
	{  
		if(result.hasErrors())
		{
			return new ModelAndView("AppointmentBean","appointmentBean",appointmentBean);
		}
		System.out.println("2nd "+appointmentBean);
	System.out.println(appointmentBean.getAppointmentDate());

	String s=Patientservice.requestforAppointment(appointmentBean.getDoctorID(),appointmentBean.getAppointmentDate());

	System.out.println("controller "+s);
	ModelAndView m=new ModelAndView("failure");
	if(s.equals("confirm"))
	{	
		ArrayList<SlotBean> s1=appointmenttable.findslots();
		Iterator it11=s1.iterator();
		while(it11.hasNext())
		{ SlotBean s2=(SlotBean)it11.next();
		int a=Integer.parseInt(appointmentBean.getAppointmentTime());
			if(a==s2.getSlotnumber())
			
			{
				String id=appointmenttable.adddetail(appointmentBean);
				//return new ModelAndView("success");
				 m= new ModelAndView("success");
			
			}
			
		}
		
	}
	else
		m=new ModelAndView("failure");
		//return new ModelAndView("failure");
	
	return m;
	}
	*/
	
	/*
	@RequestMapping(value="/Slots")
	public ModelAndView adminpage1(@ModelAttribute SlotBean slot,BindingResult result,@RequestParam String doctorID)
	{    
		System.out.println(doctorID);
		ArrayList<SlotBean> s=appointmenttable.findslots();
		System.out.println(s.get(0));
		Map<String, Object> model = new HashMap<String, Object>();
		
			model.put("slot",s);
		
		
		
		
		return new ModelAndView("Slot",model);
	}
	
	
	
	
	
	
	
	
	*/
	
	
	
	
	
	
	@RequestMapping(value="/Slots")
	public ModelAndView adminpage1(@ModelAttribute SlotBean slot,BindingResult result,@RequestParam String ID,@RequestParam String date)
	//public ModelAndView adminpage1(@ModelAttribute("appointmentBean") AppointmentBean a1,BindingResult result,@RequestParam String ID)
	{    
		System.out.println("xyzzz"+ID);
		System.out.println("xyzzz"+date);
		Date d=Date.valueOf(date);
		ArrayList<SlotBean> s=new ArrayList<SlotBean>();
	
		
		s=appointmenttable.slotavail(ID,d);
	/*	System.out.println("controller avail slot "+s.get(1));
		
		 s1=appointmenttable.findslots();
		 Iterator it3=number.iterator();
		
		System.out.println("s1 wala"+s1.get(3));
		boolean b=s1.removeAll(s);
		
		
		System.out.println("boolean"+b);
		*/
		Map<String, Object> model = new HashMap<String, Object>();
		
			model.put("slot",s);
		
		
		
		
		return new ModelAndView("Slot",model);
	}
	
	
	
	
	
	
	
	

	@RequestMapping(value="/appointment")
	public ModelAndView appoint2(@ModelAttribute @Valid AppointmentBean appointmentBean,BindingResult result) throws ParseException
	{  
		if(result.hasErrors())
		{
			return new ModelAndView("AppointmentBean","appointmentBean",appointmentBean);
		}
		System.out.println("2nd "+appointmentBean);
	System.out.println(appointmentBean.getAppointmentDate());
/*
	//SimpleDateFormat format1=new SimpleDateFormat("dd-MMM-yy");
	//String a1=format1.format(appointmentBean.getAppointmentDate());
   String a2=appointmentBean.getAppointmentDate().toString();
   System.out.println("dyan dijiye"+a2);
		//Date a=(Date) format1.parse(a1);
	//Date d1=Date.valueOf(a);
	//java.util.Date d1=new java.util.Date(appointmentBean.getAppointmentDate().getTime());
	System.out.println("abc");
	*/
	String s=Patientservice.requestforAppointment(appointmentBean.getDoctorID(),appointmentBean.getAppointmentDate());
	//String s=Patientservice.requestforAppointment(appointmentBean.getDoctorID(),appointmentBean.getAppointmentDate());
	System.out.println("controller "+s);
	ModelAndView m=new ModelAndView("unavailable");
	if(s.equals("confirm"))
	{	
		ArrayList<SlotBean> s1=appointmenttable.slotavail(appointmentBean.getDoctorID(),appointmentBean.getAppointmentDate());
		Iterator it11=s1.iterator();
		while(it11.hasNext())
		{ SlotBean s2=(SlotBean)it11.next();
			int a=Integer.parseInt(appointmentBean.getAppointmentTime());
			if(a==s2.getSlotnumber())
			
			{
				String id=appointmenttable.adddetail(appointmentBean);
				//return new ModelAndView("success");
				 m= new ModelAndView("success");
			}
			/*else
			{
				m= new ModelAndView("unavailable");
			}
			*/
		}
		
	}
	else
		m=new ModelAndView("unavailable");
		//return new ModelAndView("failure");
	
	return m;
	}
	
	
	

	@RequestMapping(value="/appoint")
	public ModelAndView appoint1(@ModelAttribute DoctorBean doctorBean,BindingResult result,@ModelAttribute AppointmentBean appointmentBean,BindingResult result1,@RequestParam String patientID,@RequestParam String date,Model model) throws ParseException
	{   
		AppointmentBean a=new AppointmentBean();
	System.out.println(date);
	String s=date.substring(0,10);
	s.trim();
	java.sql.Date d=Date.valueOf(s);
	System.out.println(d);
	a.setAppointmentDate(d);
	System.out.println("setted date");
	DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	String datestring = format1.format(d);
	System.out.println("formatted date:"+datestring);
	
	String ds = datestring.toString().substring(4,8);
	System.out.println("substring:"+ds);

	int num = seqGenService.GenerateAppointmentid(a);
	String number = Integer.toString(num);
	System.out.println("seq number :"+number);

	String id = ds+num;

	System.out.println("appoint id: "+id);
	System.out.println("before");
	a.setAppointmentID(id);
	System.out.println("after");
	
	
	a.setDoctorID(doctorBean.getDoctorID());
	a.setPatientID(patientID);
		System.out.println(patientID);
		doctorBean.getDoctorID();
		
		System.out.println("appoint");
     
System.out.println("1st "+a);
	model.addAttribute("docid",doctorBean.getDoctorID());
	model.addAttribute("appoint",a);
		return new ModelAndView("AppointmentBean","appointmentBean",model);
	}

}


