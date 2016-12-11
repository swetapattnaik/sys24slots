package e.hospital.controller;



import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.LoginBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.PatientRegisterBean;
import e.hospital.bean.ProfileBean;
import e.hospital.service.Administratorservice;
import e.hospital.service.LoginService;
import e.hospital.service.SeqGenService;



@Controller
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	@Autowired
	private Administratorservice adminService;

	@Autowired
	private SeqGenService seqGenService;
	
	
	@RequestMapping(value="/login")
	public ModelAndView loginControl(@ModelAttribute() @Valid LoginBean loginBean,BindingResult result,HttpSession session,HttpServletRequest request,HttpServletResponse response)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("LoginForm");
		}
		else 
		{
		System.out.println();
		String flag=loginService.login(loginBean,request,response);
		
		if(flag.equals("A"))
		{
			 HttpSession s1=request.getSession();
				LoginBean c= (LoginBean) s1.getAttribute("login");
			return new ModelAndView("Page2");
		}
		else if(flag.equals("P"))
		{
			 HttpSession s1=request.getSession();
				LoginBean c= (LoginBean) s1.getAttribute("login");
				System.out.println(c);
			return new ModelAndView("redirect:/patientHome.html");
		}
		else if(flag.equals("R"))
				{
			 HttpSession s1=request.getSession();
				LoginBean c= (LoginBean) s1.getAttribute("login");
					return new ModelAndView("Page4");
				}
		
		else
		{
		return new ModelAndView("failure");
		}
		
	}}
	
	@RequestMapping(value="/index")
	public ModelAndView homepage()
	{    
		System.out.println("index");
		return new ModelAndView("LoginForm","credentialsBean",new LoginBean());
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		LoginBean cb = (LoginBean) session.getAttribute("login");

		loginService.logout(cb.getUserID());

		session.invalidate();

		return new ModelAndView("LoginForm", "credentialsBean", new LoginBean());
	}
	
	
	
	
	@RequestMapping(value="/register")
	public ModelAndView registerpage()
	{
		return new ModelAndView("register","profileBean",new ProfileBean());
	}
	@RequestMapping(value="/registration")
	public ModelAndView registrationControl(@ModelAttribute() @Valid ProfileBean profileBean,BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("register");
		}
		else
		{
			String id=seqGenService.GenerateProfileUserid(profileBean);
			System.out.println("user id: "+id);
			System.out.println("profile");
			profileBean.setUserID(id);
			System.out.println("after profile");
			String flag=loginService.register(profileBean);
			System.out.println("after");
			
		String flag1=loginService.register(profileBean);
		
		if(flag1.equals("failure"))
			return new ModelAndView("failure");
		else
			return new ModelAndView("userregisterpage","username",flag1);
		
	}
	}
	
	
	
	@RequestMapping(value="/pass")
	public ModelAndView passwordpage()
	{
		
		return new ModelAndView("changePassword","command",new LoginBean());
	}
	@RequestMapping(value="/changePassword")
	public ModelAndView passwordControl(@ModelAttribute() LoginBean credentialsBean,@RequestParam String newpassword)
	{
		System.out.println(newpassword);
		String flag=loginService.changePassword(credentialsBean,newpassword);
	
		if(flag.equals("failure"))
			return new ModelAndView("failure");
		else
			return new ModelAndView("userregisterpage","username",flag);
		
	}
	
	
	///Add doctor Form
	
	@RequestMapping(value="/add1")
	public ModelAndView adminpage1()
	{    
		System.out.println("index1");
		return new ModelAndView("adddoctor","doctorBean",new DoctorBean());
	}
	//submit action of add doctor
	@RequestMapping(value="/add")
	public ModelAndView adminpage2(@ModelAttribute() @Valid DoctorBean doctorBean,BindingResult result)
	{   
		if(result.hasErrors()) 
	{
		return new ModelAndView("adddoctor");
	}
		System.out.println("index1");
		String flag=adminService.addDoctor(doctorBean);
		if(flag.equals("SUCCESS"))
		return new ModelAndView("sucess");
		else
			return new ModelAndView("failure");
	}
	
	

	
	@RequestMapping(value="/index1")
	public String adminpage()
	{    
		System.out.println("index1");
		return "Admin"; 
	}
	@RequestMapping(value="/index2")
	public ModelAndView adminpage2()
	{    System.out.println("index2");
		
		return new ModelAndView("redirect:/doctors.html");
	}
	
	
	
	
	@RequestMapping(value="/doctors", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		System.out.println("entering");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors1",adminService.viewAllDoctors());
		System.out.println("maping");
		return new ModelAndView("doctorsList", model);
	}
	//edit first part
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit1Employee(@ModelAttribute("doctorBean")  DoctorBean doctorBean) {
		
		
		//adminService.deleteEmployee(prepareModel(employeeBean));
		System.out.println(doctorBean.getDoctorID());
		
		System.out.println("editing");
		adminService.findByID(doctorBean.getDoctorID());
		System.out.println("find");
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors2", adminService.findByID(doctorBean.getDoctorID()));
		model.put("doctors1",adminService.viewAllDoctors());
		return new ModelAndView("editdoctor", model);
	}

	//edit doctor second part
	@RequestMapping(value="/edit")
	public ModelAndView loginControl2(@Valid @ModelAttribute() DoctorBean doctorBean,BindingResult result)
	
	{
		if(result.hasErrors()) 
		{
			return new ModelAndView("editdoctor");
		}System.out.println("add");
	System.out.println(doctorBean);
		System.out.println();
		boolean flag=adminService.modifyDoctor(doctorBean);
		
		if(flag==true)
			return new ModelAndView("sucess");
		else
			return new ModelAndView("failure");
		
	}
	
	
	//delete doctor method
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editDoctor(@ModelAttribute("command")  DoctorBean doctorBean,BindingResult result) {
		
		//adminService.deleteEmployee(prepareModel(employeeBean));
		System.out.println(doctorBean.getDoctorID());
		adminService.removeDoctor(doctorBean.getDoctorID());
		System.out.println("deleted");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors2", null);
		model.put("doctors1",adminService.viewAllDoctors());
		return new ModelAndView("doctorsList", model);
	}
	
/*	@RequestMapping(value="/appoint1")
	public ModelAndView homepage1()
	{    
		System.out.println("index");
		return new ModelAndView("Appointment","credentialsBean",new CredentialsBean());
	}
*/
	
	
	
	
	
	
	
	/*@RequestMapping(value="/doctors1", method = RequestMethod.GET)
	//public ModelAndView viewpatientsbydate() {
		public void viewpatientsbydate() {
		System.out.println("entering");
		
		Map<PatientBean, AppointmentBean> m1=adminService.viewPatientsByDate(Date.valueOf("2015-11-06"));
		Set s=m1.entrySet();
		Iterator b=s.iterator();
		   while(b.hasNext())
		   {Map.Entry<PatientBean,AppointmentBean> r=( Map.Entry<PatientBean,AppointmentBean>)b.next();
		    System.out.println(r.getKey()+" "+ r.getValue());
		   }}
		
		//Map<String, Object> model = new HashMap<String, Object>();
		//model.put("doctors1",adminService.viewPatientsByDate(appointmentDate));
		//System.out.println("maping");
		//return new ModelAndView("doctorsList", model);
	*/
	
	
	
	//display form for view patient by date
	@RequestMapping(value="/viewPatients", method = RequestMethod.GET)
	public ModelAndView viewpatientsbydate1() {
		
return new ModelAndView("viewpatientbydate");
	
	}
	//second part with date for view patient by date
	
	@RequestMapping(value="/viewPatients1", method = RequestMethod.GET)
	public ModelAndView viewpatientsbydate(@RequestParam String pdate) {
		
		System.out.println("entering");
		PatientRegisterBean p=null;
		AppointmentBean a=null;
		Map<PatientRegisterBean, AppointmentBean> m1=adminService.viewPatientsByDate(Date.valueOf(pdate));
		Set s=m1.entrySet();
		Iterator b=s.iterator();
		   while(b.hasNext())
		   {Map.Entry<PatientRegisterBean,AppointmentBean> r=( Map.Entry<PatientRegisterBean,AppointmentBean>)b.next();
		    System.out.println(r.getKey()+" "+ r.getValue());
		    p=r.getKey();
		    a=r.getValue();
		   }
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patient",p);
		model.put("appoint",a);
		System.out.println("maping");
		return new ModelAndView("viewpatientbydate", model);
	
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	//suggest doctor to patient by patient id and date leave + schedule+special.
	
	@RequestMapping(value="/suggest1", method = RequestMethod.GET)
	public ModelAndView suggessdoctors1() {
		return new ModelAndView("suggestdoctor");
	}

	
	
	
	
@RequestMapping(value="/suggest", method = RequestMethod.GET)
public ModelAndView suggessdoctors(@RequestParam String pid,@RequestParam String pdate) {
	
	System.out.println("entering");
	
	ArrayList<DoctorBean> doc=adminService.suggestDoctors(pid,Date.valueOf(pdate));
	System.out.println(doc);
		
	   Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors1",doc);
	   return new ModelAndView("suggestdoctor", model);
}




}

