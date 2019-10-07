package com.jcrocherdevDoctor2;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller	
@SpringBootApplication
public class Doctor2Application {

	public static void main(String[] args) {
		SpringApplication.run(Doctor2Application.class, args);
		
		
		
		
	}
	
	@RequestMapping("/doctor/{nbr}")
    @ResponseBody
    public DoctorList dr(@PathVariable int nbr, @RequestParam(defaultValue="") String str) {

		DoctorList william = new DoctorList(9, "William Hartnell");
		DoctorList patrick = new DoctorList(10, "PAtrick Troughton");
		DoctorList jon = new DoctorList(11, "Jon Pertwee");
		DoctorList peter = new DoctorList(12, "Peter Davison");
		DoctorList colin = new DoctorList(13, "Colin Baker");
		
		ArrayList<DoctorList> doctor = new ArrayList<>();
		doctor.add(william);
		doctor.add(patrick);
		doctor.add(jon);
		doctor.add(peter);
		doctor.add(colin);
		
		if(nbr<9) {
	        throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See Other");
	    } 
		 
		else {
			return doctor.get(nbr-9);
		}
	}
	
}
