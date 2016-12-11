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

import com.google.gson.Gson;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import e.hospital.bean.AppointmentBean;
import e.hospital.bean.LoginBean;
import e.hospital.bean.DoctorBean;
import e.hospital.bean.DoctorSearchBean;
import e.hospital.bean.PatientRegisterBean;
import e.hospital.service.Administratorservice;
import e.hospital.service.PatientService;
import e.hospital.service.ReporterService;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;

	@Autowired
	private ReporterService reportservice;

	@Autowired
	private Administratorservice adminService;

	@RequestMapping(value = "/PatientForm", method = RequestMethod.GET)
	public ModelAndView homepage() {
		ArrayList<DoctorBean> doctorList = patientService.getDoctorListBasedOnSearch();
		//Gson gson = new Gson();
	  //  String jsonDoctors = gson.toJson(doctorList);
		ModelAndView model = new ModelAndView("PatientForm");
	//	System.out.println(jsonDoctors);
		model.addObject("doctors", doctorList);
		return model;

	}

	@RequestMapping(value = "/addAilmentDetails", method = RequestMethod.GET)
	public ModelAndView newAilment(@ModelAttribute("patientBean") PatientRegisterBean patientBean,
			BindingResult result) {

		return new ModelAndView("addAilmentDetails");
	}

	@RequestMapping(value = "/addAilmentDetails", method = RequestMethod.POST)
	public ModelAndView saveAilmentDetails(@Valid @ModelAttribute("patientBean") PatientRegisterBean patientBean,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		if (result.hasErrors()) {
			return new ModelAndView("addAilmentDetails");
		}
		patientService.addAilmentDetails(patientBean, request, response);
		return new ModelAndView("redirect:/addAilmentDetails.html");
	}

	/*
	 * @RequestMapping(value = "/searchDoctor", method = RequestMethod.POST)
	 * public ModelAndView searchDoctor(@ModelAttribute() DoctorSearchBean
	 * doctorSearchBean, BindingResult result) {
	 * System.out.println("inside the search doctor method");
	 * System.out.println(doctorSearchBean.getCity()+"city");
	 * System.out.println(" hospital"+doctorSearchBean.getHospital());
	 * System.out.println(" special"+doctorSearchBean.getSpecialization());
	 * ArrayList<DoctorBean> doctorList =
	 * patientService.getDoctorListBasedOnSearch(doctorSearchBean); Map<String,
	 * Object> model = new HashMap<String, Object>();
	 * model.put("doctors1",doctorList); return new
	 * ModelAndView("suggestdoctor",model); }
	 */

	@RequestMapping(value = "view(or)modifyAilmentDetails1")
	public ModelAndView modifypage(@ModelAttribute("command") PatientRegisterBean patientBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patientAilments", patientService.viewAilmentDetails(patientBean.getPatientID()));
		return new ModelAndView("view(or)modifyAilmentDetails", model);

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modifyAilmentDetails1(@ModelAttribute("patientBean") PatientRegisterBean patientBean,
			BindingResult result) {
		System.out.println(patientBean.getPatientID());
		patientService.findByPatientID(patientBean.getPatientID());

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patientBean", patientService.findByPatientID(patientBean.getPatientID()));

		// model.put("patientAilments",patientService.viewAilmentDetails(patientBean.getPatientID()));

		System.out.println(patientService.viewAilmentDetails(patientBean.getPatientID()));

		return new ModelAndView("modifyAilmentDetails", model);
	}

	@RequestMapping(value = "/view(or)modifyAilmentDetails", method = RequestMethod.GET)
	public ModelAndView modifyAilmentDetails(@ModelAttribute("command") PatientRegisterBean patientBean,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		LoginBean c = (LoginBean) session.getAttribute("login");
		System.out.println(c.getUserID());
		String s = "";

		ArrayList<PatientRegisterBean> p3 = new ArrayList<PatientRegisterBean>();
		ArrayList<PatientRegisterBean> a = patientService.viewAilmentDetails();
		Iterator itr = a.iterator();
		while (itr.hasNext()) {
			PatientRegisterBean p2 = (PatientRegisterBean) itr.next();

			if (c.getUserID().equals(p2.getUserID())) {
				System.out.println(p2);
				p3.add(p2);

			}

		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patientAilments", p3);

		// model.put("patientAilments",patientService.viewAilmentDetails(patientBean.getPatientID()));

		System.out.println(patientService.viewAilmentDetails(patientBean.getPatientID()));

		return new ModelAndView("modifyAilmentDetails1", model);
	}

	@RequestMapping(value = "/modify1")
	public ModelAndView modifyAilmentDetails(@Valid @ModelAttribute() PatientRegisterBean patientBean,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("modifyAilmentDetails");
		}
		System.out.println(patientBean);

		boolean flag = patientService.modifyAilmentDetails(patientBean);

		if (flag == true)
			return new ModelAndView("success");
		else
			return new ModelAndView("failure1");

	}

	/*
	 * 
	 * @RequestMapping(value="/requestForAppointment") public ModelAndView
	 * appointment() { System.out.println("requestForAppointment"); return new
	 * ModelAndView("requestForAppointment","command",new AppointmentBean()); }
	 * 
	 * @RequestMapping(value = "/bookAppointment", method = RequestMethod.GET)
	 * public ModelAndView bookAppointment(@ModelAttribute("command")
	 * AppointmentBean appointmentBean,BindingResult result) {
	 * 
	 * Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("doctors",patientService.requestforAppointment(appointmentBean.
	 * getDoctorID(), appointmentBean.getAppointmentDate())); return new
	 * ModelAndView("requestAppointment",model); }
	 * 
	 * @RequestMapping(value="/requestAppointment") public ModelAndView
	 * requestAppointment(@ModelAttribute AppointmentBean
	 * appointmentBean,BindingResult result) {
	 * System.out.println(appointmentBean);
	 * patientService.requestforAppointment(appointmentBean.getDoctorID(),
	 * appointmentBean.getAppointmentDate()); return new
	 * ModelAndView("success"); }
	 * 
	 * 
	 */

	@RequestMapping(value = "/viewappointsdetails", method = RequestMethod.GET)
	public ModelAndView Details(@ModelAttribute("command") PatientRegisterBean patientBean, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		LoginBean c = (LoginBean) session.getAttribute("login");
		System.out.println(c.getUserID());
		String s = "";

		ArrayList<PatientRegisterBean> p3 = new ArrayList<PatientRegisterBean>();
		ArrayList<PatientRegisterBean> a = patientService.viewAilmentDetails();
		Iterator itr = a.iterator();
		while (itr.hasNext()) {
			PatientRegisterBean p2 = (PatientRegisterBean) itr.next();

			if (c.getUserID().equals(p2.getUserID())) {
				System.out.println(p2);
				p3.add(p2);

			}

		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patientAilments", p3);

		// model.put("patientAilments",patientService.viewAilmentDetails(patientBean.getPatientID()));

		System.out.println(patientService.viewAilmentDetails(patientBean.getPatientID()));

		return new ModelAndView("viewappointments", model);
	}

	@RequestMapping(value = "/ViewAppintmentDetails")
	public ModelAndView ViewAppointmentDetails(@ModelAttribute AppointmentBean appointmentBean, BindingResult result,
			@RequestParam String patientID, @RequestParam String appointmentDate) {
		// patientService.viewAppointmentDetails(patientID, date);

		System.out.println("pateintid" + patientID);
		System.out.println(appointmentDate);
		String s = (appointmentDate).substring(0, 10);
		s.trim();
		java.sql.Date d = Date.valueOf(s);
		System.out.println(d);
		System.out.println("entering");
		System.out.println(patientID);
		System.out.println(appointmentDate);
		PatientRegisterBean p = null;
		AppointmentBean a = null;
		// Map<AppointmentBean, PatientBean>
		// m1=patientService.viewAppointmentDetails("130",Date.valueOf("1998-01-12"));
		Map<AppointmentBean, PatientRegisterBean> m1 = patientService.viewAppointmentDetails(patientID, d);
		Set s1 = m1.entrySet();
		Iterator b = s1.iterator();
		while (b.hasNext()) {
			Map.Entry<AppointmentBean, PatientRegisterBean> r = (Map.Entry<AppointmentBean, PatientRegisterBean>) b
					.next();
			System.out.println(r.getKey() + " " + r.getValue());
			a = r.getKey();
			p = r.getValue();
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patient", p);
		model.put("appoint", a);
		System.out.println("maping");
		return new ModelAndView("AppointmentDetails", model);

	}

	@RequestMapping(value = "/view")
	public ModelAndView viewDoctors(@ModelAttribute() DoctorBean doctorBean, BindingResult result,
			@RequestParam String date, @RequestParam String specialization) {

		Date d = Date.valueOf(date);

		patientService.viewListOfDoctors(specialization, d);

		Map<String, Object> modellist = new HashMap<String, Object>();

		modellist.put("doctors", patientService.viewListOfDoctors(doctorBean.getSpecialization(), d));

		return new ModelAndView("viewDoctors", modellist);
	}

	/*
	 * @RequestMapping(value="/viewListOfDoctors") public ModelAndView
	 * viewDoctors(@ModelAttribute() DoctorBean doctorBean,BindingResult
	 * result,HttpServletRequest request,HttpServletResponse response) {
	 * HttpSession session=request.getSession();
	 * 
	 * CredentialsBean c=(CredentialsBean)session.getAttribute("login");
	 * System.out.println(c.getUserID()); String s="";
	 * 
	 * PatientBean p3=null; ArrayList<PatientBean>
	 * a=patientService.viewAilmentDetails(); Iterator itr =a.iterator();
	 * while(itr.hasNext()) { PatientBean p2=(PatientBean)itr.next();
	 * if(c.getUserID().equals(p2.getUserID())) { p3=p2; break; }
	 * 
	 * } System.out.println(p3);
	 * 
	 * java.util.Date d = p3.getAppointmentDate(); java.sql.Date d1=new
	 * java.sql.Date(d.getTime());
	 * 
	 * patientService.viewListOfDoctors(p3.getAilmentType(),d1);
	 * 
	 * Map<String, Object> modellist = new HashMap<String, Object>();
	 * 
	 * modellist.put("doctors",patientService.viewListOfDoctors(p3.
	 * getAilmentType(),d1));
	 * 
	 * return new ModelAndView("viewDoctors", modellist); }
	 * 
	 * 
	 */

	@RequestMapping(value = "/viewListOfDoctors")
	public ModelAndView viewDoctors(@ModelAttribute() PatientRegisterBean patientBean, BindingResult result,
			Model model) {

		PatientRegisterBean p = patientService.findByPatientID(patientBean.getPatientID());

		java.util.Date d = p.getAppointmentDate();
		java.sql.Date d1 = new java.sql.Date(d.getTime());

		patientService.viewListOfDoctors(p.getAilmentType(), d1);
		System.out.println("here1");

		Map<String, Object> modellist = new HashMap<String, Object>();
		model.addAttribute("id", patientBean.getPatientID());
		model.addAttribute("date", p.getAppointmentDate());
		modellist.put("doctors", patientService.viewListOfDoctors(p.getAilmentType(), d1));
		// modellist.put("patient",patientBean);
		return new ModelAndView("viewDoctors", modellist);
	}

	@RequestMapping(value = "/Notification")
	public ModelAndView Notification(@ModelAttribute() PatientRegisterBean patientBean, @RequestParam String ID,
			@RequestParam String date, @RequestParam String Type, @RequestParam String docid) {
		System.out.println(ID);
		System.out.println(date);
		System.out.println(docid);
		ArrayList<DoctorBean> a1 = null;
		boolean flag = false;
		Date date1 = Date.valueOf(date.substring(0, 11).trim());
		System.out.println(Type);
		ArrayList<DoctorBean> a = reportservice.intimateAdmin(date1, "1");
		Iterator itr = a.iterator();
		while (itr.hasNext()) {
			DoctorBean d = (DoctorBean) itr.next();

			if (d.getDoctorID().equals(docid)) {
				flag = true;
				break;
			}
		}

		if (flag) {
			a1 = adminService.suggestDoctors(ID, date1);

		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctors1", a1);
		model.put("id", ID);
		model.put("date1", date1);
		model.put("flag", flag);
		System.out.println("maping");
		return new ModelAndView("availabledocListpatient", model);

	}
	/*
	 * boolean flag=false;
	 * 
	 * HttpSession session=request.getSession();
	 * 
	 * CredentialsBean c=(CredentialsBean)session.getAttribute("login");
	 * System.out.println(c.getUserID()); String s="";
	 * 
	 * ArrayList<PatientBean> p3=new ArrayList<PatientBean>();
	 * ArrayList<PatientBean> a=patientService.viewAilmentDetails(); Iterator
	 * itr =a.iterator(); while(itr.hasNext()) { PatientBean
	 * p2=(PatientBean)itr.next();
	 * 
	 * if(c.getUserID().equals(p2.getUserID())) {System.out.println(p2);
	 * p3.add(p2);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if(flag==true) return new ModelAndView("success"); else return new
	 * ModelAndView("failure");
	 * 
	 * }
	 */

}
