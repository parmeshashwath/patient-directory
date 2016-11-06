package com.org.patient.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.org.patient.db.dao.PatientDAO;
import com.org.patient.model.Patient;


@Path("/patient")
public class PatientService {
	 private static Logger logger = Logger.getLogger(
			 PatientService.class.getName());

		    public PatientService()
		    {
		    	
		    }
		    
		    @GET
			@Path("/get")
			@Produces(MediaType.APPLICATION_JSON)
			public List<Patient> getIncidentDetails()
			{
					logger.info("getting incident details");
				 
		       
				return  PatientDAO.getPatients();
				
			}
		    
		    
		    @POST
			@Path("/insert")
			@Produces(MediaType.TEXT_PLAIN)
			public String getIncidentDetails(Patient pat)
			{
					
				 
		     return PatientDAO.insertPatient(pat);
				
			}
		    
		   
		   
}
