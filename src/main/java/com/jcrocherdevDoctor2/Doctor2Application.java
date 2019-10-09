package com.jcrocherdevDoctor2;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@SpringBootApplication
public class Doctor2Application {

	public static void main(String[] args) {
		
			SpringApplication.run(Doctor2Application.class, args);
				
	}
	
	@RequestMapping("/doctor/{nbr}")
    @ResponseBody
    public DoctorList dr(@PathVariable String nbr) {

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
		
		if(Integer.parseInt(nbr) < 8 ) {
	        throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See Other");
	    } 
		
		else if (Integer.parseInt(nbr) < 1 || Integer.parseInt(nbr) > 13){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation "+ nbr);
		}
		 
		else {
			return doctor.get(Integer.parseInt(nbr) - 9);
		}
	}
	
}
