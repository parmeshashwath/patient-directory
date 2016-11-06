package com.org.patient.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

import com.org.patient.db.util.DBUtilMongo;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.org.patient.model.Patient;

public class PatientDAO {
	
	
		private static Logger logger = Logger.getLogger(PatientDAO.class.getName());
		
		public static String insertPatient(Patient pat) {
			logger.info("inserting patient rec");
			logger.info("DOB");
			logger.info(pat.getDob());
			DBCollection col = null;
			String result=null;
			try {

		
			col = DBUtilMongo.getCollectionByName("records");
			
			BasicDBObject patient_query=new BasicDBObject();
			BasicDBObject patient_update=new BasicDBObject();
			patient_query.append("first_name", pat.getFirst_name().toUpperCase())
			.append("last_name", pat.getLast_name().toUpperCase());
			
			patient_update.append("age", pat.getAge())
			.append("dob", new Date(pat.getDob()))
			.append("gender", pat.getGender())
			.append("info",pat.getInfo())
			.append("phone",pat.getPhone());
			
			col.update(patient_query, new BasicDBObject("$set",patient_update), true,false);
			logger.info("inserted successfully");
			result="success";
			}
			catch(Exception e)
			{
				result="failed";
				logger.info(e);
			}
			
			return result;
		}

		public static List<Patient> getPatients() {
			// TODO Auto-generated method stub
			DBCollection col = null;
			List<Patient> pat_lst=new ArrayList<Patient>();
			
			try {

				
				col = DBUtilMongo.getCollectionByName("records");
				DBCursor cursor=col.find();
				while(cursor.hasNext())
				{
					DBObject doc=cursor.next();
					Patient pat =new Patient();
					pat.setAge(Integer.parseInt(doc.get("age").toString()));
					pat.setFirst_name(doc.get("first_name").toString());
					pat.setLast_name(doc.get("last_name").toString());
					Date date = (Date) doc.get("dob");
					pat.setDob(date.getTime());
					pat.setGender(doc.get("gender").toString());
					pat.setInfo(doc.get("info").toString());
					pat.setPhone(doc.get("phone").toString());
					pat_lst.add(pat);
				}
				
				
				}
				catch(Exception e)
				{
				
					logger.info(e);
				}
			return pat_lst;
		}

		
		
		
		

}







