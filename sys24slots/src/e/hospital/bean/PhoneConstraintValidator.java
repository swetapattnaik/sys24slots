package e.hospital.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

	 
	    public void initialize(Phone paramA) {
	        // TODO Auto-generated method stub

	    }

	   
	    public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
	        // TODO Auto-generated method stub
	        if(phoneNo == null) {
	         return false;
	        }

	        //Validate phone numbers of format "1234567890"
	         if (phoneNo.matches("\\d{10}")) return true;

	        //validating phone number with -, . or spaces
	        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;

	     

	         //return false if nothing matches the input
	        else return false;
	    }
	
}
