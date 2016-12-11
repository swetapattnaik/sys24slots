package e.hospital.controller;



import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;





import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import e.hospital.bean.DoctorBean;
import e.hospital.bean.LeaveBean;
import e.hospital.bean.ScheduleBean;
import e.hospital.service.Administratorservice;
import e.hospital.service.ReporterService;



@Controller
@RequestMapping(value="/Report")
public class ReporterController {
	
	
	@Autowired
	private ReporterService reportservice;
	
	
	@Autowired
	private Administratorservice adminService;
	
	@RequestMapping(value="/index3" ,method = RequestMethod.GET)
	public ModelAndView homepage()
	{  
		return new ModelAndView("index3");
	}
	
	
	//Adding Leave main page
	@RequestMapping(value="/indexr1")
	public ModelAndView addleave()
	{    
		System.out.println("indexr1");
		return new ModelAndView("Leave","leaveBean",new LeaveBean());
	}
    //on submit of add leave
	
	
	
	
	
	@RequestMapping(value="/leave",method = RequestMethod.POST)
	public ModelAndView addingleave(@Valid @ModelAttribute() LeaveBean leaveBean,BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("Leave");
		}
		System.out.println("entered leave");
		
		String docid=leaveBean.getDoctorID();
		
		java.sql.Date date1=new java.sql.Date(leaveBean.getLeaveTo().getTime());
		
		java.sql.Date date2=new java.sql.Date(leaveBean.getLeaveFrom().getTime());
		int a1=reportservice.status(docid, date1, date2);
		System.out.print(a1);
		leaveBean.setStatus(a1);
		
		String a=reportservice.addLeave(leaveBean);
		System.out.println(" leave applied");
		
		if(a.equals("A"))
		{
			return new ModelAndView("sucess");
		}
		else 
		{
			return new ModelAndView("failure");
		}
		
	}
	/*@RequestMapping(value="/leave",method = RequestMethod.POST)
	public ModelAndView addingleave(@Valid @ModelAttribute() LeaveBean leaveBean,BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("Leave");
		}
		System.out.println("entered leave");
		String a=reportservice.addLeave(leaveBean);
		System.out.println(" leave applied");
		
		if(a.equals("A"))
		{
			return new ModelAndView("sucess");
		}
		else 
		{
			return new ModelAndView("failure");
		}
		
	}
	
	*/

	
	//Displaying leave
	@RequestMapping(value="/indexr2")
	public ModelAndView displayleave()
	{    System.out.println("index2");
		
		return new ModelAndView("redirect:/Report/leavedisplay.html");
	}
	
	//list of leave display 1st phase
	@RequestMapping(value="/leavedisplay")
	public ModelAndView displayingleave(@ModelAttribute("command")  LeaveBean doctorBean,BindingResult result) {
		System.out.println("entering");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("leavedoc",reportservice.viewAllLeave());
		System.out.println("mapin");
		return new ModelAndView("Leave1", model);
	}

	
	
	//Adding schedule
	@RequestMapping(value="/adds1")
	public ModelAndView addschedule()
	{    
		System.out.println("adddoctorchedule");
		return new ModelAndView("scheduledoctor","scheduleBean",new ScheduleBean());
	}
	
	//on submit of add schdeule
	@RequestMapping(value="/addschedule")
	public ModelAndView addingschedule(@Valid @ModelAttribute() ScheduleBean scheduleBean,BindingResult result)
	{   
		if(result.hasErrors())
		{
			return new ModelAndView("scheduledoctor");
		}
		
		System.out.println("addingschedule");
		String flag=reportservice.addschedule(scheduleBean);
		
		if(flag.equals("A"))
		return new ModelAndView("sucess");
		else
			return new ModelAndView("failure");
	}

	
	/*@RequestMapping(value="/viewdocschedule", method = RequestMethod.GET)
	public ModelAndView viewEmployees(@ModelAttribute("command")  ScheduleBean scheduleBean,BindingResult result) {
		System.out.println("enteringscheduleview");
		System.out.println((scheduleBean.getScheduleID()));
		ScheduleBean s=reportservice.findByID((scheduleBean.getScheduleID()));
		System.out.println(s);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("schedule",s);
		//model.put("employees",reportservice.viewAllAvailableDoctors(d));
		System.out.println("mapin");
		return new ModelAndView("scheduledoctor", model);
	}
	*/
	

	
	
	//View Schedule
	@RequestMapping(value="/index2")
	public ModelAndView adminpage2()
	{    System.out.println("index2");
		
		return new ModelAndView("redirect:/Report/doctors.html");
	}
	
	
	
	
	@RequestMapping(value="/doctors", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		System.out.println("entering");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors1",adminService.viewAllDoctors());
		System.out.println("maping");
		return new ModelAndView("doctorsListreport", model);
	}
	
	
	
	//admin + reporter display schedule method
	
	@RequestMapping(value="/viewdocschedule", method = RequestMethod.GET)
	public ModelAndView viewschedulefromleave(@ModelAttribute("scheduleBean")  ScheduleBean scheduleBean,BindingResult result,@RequestParam String doctorID) {
		System.out.println("enteringscheduleview");
		System.out.println(doctorID);
		ScheduleBean s=reportservice.findByID(doctorID);
		System.out.println(s);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("schedule",s);
		//model.put("employees",reportservice.viewAllAvailableDoctors(d));
		System.out.println("mapin");
		return new ModelAndView("scheduledoctor", model);
	}
	
	
	
	
	
	
	
	
	
	//Intimate Admin 
	
	@RequestMapping(value="/indexr3")
	public ModelAndView datecheck()
	{    
		System.out.println("index3");
		return new ModelAndView("intimateadmin");
	
	}
	
	
	@RequestMapping(value="/viewdoc", method = RequestMethod.GET)
	public ModelAndView intimateadminAvailabledoctors(@ModelAttribute("leaveBean")  LeaveBean leaveBean,BindingResult result,@RequestParam String fieldName,@RequestParam String status) {
		System.out.println("entering");
		Date d=Date.valueOf(fieldName);
		System.out.println(d);
		reportservice.intimateAdmin(d,status);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors",reportservice.intimateAdmin(d,status));
		model.put("leavedoc",reportservice.viewAllLeave());
		System.out.println("mapin");
		return new ModelAndView("Leave", model);
	}
	
	
	
	
	
	
	//View Available Doctors on date
	@RequestMapping(value="/viewavaildoc", method = RequestMethod.GET)
	public ModelAndView viewdoctorsavailability1() throws ParseException {
	
		return new ModelAndView("availdocreport");
	}
	
	
	@RequestMapping(value="/viewdocschedule1", method = RequestMethod.GET)
	public ModelAndView viewdoctorsavailability(@ModelAttribute() ScheduleBean scheduleBean,@RequestParam  String date) throws ParseException {
		System.out.println("enteringscheduleviewavailability");
		//String fieldName="12-NOV-2015";
		//Date d1=Date.valueOf(fieldName);
		Date d1=Date.valueOf(date);
		 // String input_date="13/01/1998";
		  //SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		 // java.util.Date d1=format1.parse(input_date);
		 // java.util.Date d1=format1.parse(date);
		
		ArrayList<DoctorBean> s=reportservice.viewAllAvailableDoctors(d1);
		System.out.println(s);
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("schedule",s);
		model.put("doctors1",reportservice.viewAllAvailableDoctors(d1));
		System.out.println("mapin");
		return new ModelAndView("reportdoctorsList", model);
	}
	
	
	
	
	
	/*
	
	@RequestMapping(value="/patientsuggest", method = RequestMethod.GET)
	public ModelAndView patientsuggest(@RequestParam String doctorID) throws ParseException {
		System.out.println(doctorID);
		
		org.hibernate.Query query2 = session.createQuery("from PatientBean where patientID =?");
		query2.setParameter(0, patientID);
		
		return null;
	}
	
	
	
	
	*/
	
	
	
	
	
}

