package in.cg.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.cg.entity.Address;
import in.cg.entity.Employee;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	@GetMapping("/home")
	public ModelAndView getHome(){
		return new ModelAndView("home");
	}
	@GetMapping("/form")
	public ModelAndView getForm() {
		return new ModelAndView("userForm"); 
	}
	@PostMapping("/submitForm")
	public ModelAndView postForm(HttpServletRequest request) {
		String fname=request.getParameter("first_name");
		String lname=request.getParameter("last_name");
		String street=request.getParameter("street_name");
		String city=request.getParameter("city");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		String country=request.getParameter("country");
		String doj=request.getParameter("doj");
		String desg=request.getParameter("designation");
		String org=request.getParameter("org");
		String manager=request.getParameter("manager");
		
		ModelAndView mView=new ModelAndView("profile");
		
		Address address=new Address(street, city, pincode, country);
		Employee employee=new Employee(fname, lname, manager, doj, desg, org, address);
		mView.addObject("e", employee);
		return mView;
	}
}
