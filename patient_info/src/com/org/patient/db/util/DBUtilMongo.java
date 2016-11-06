package com.org.patient.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Collection;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;

import org.apache.log4j.Logger;

public class DBUtilMongo {
private static Logger logger = Logger.getLogger(DBUtilMongo.class.getName());
	
    private static DBUtilMongo dbutil;
    
    private static MongoClient mongoClient=null;
    private static DB db=null;
    public DBUtilMongo()
    {
    	//MongoCredential credential = MongoCredential.createCredential("readWrite", "CCW360", "M0ng0readWr!te".toCharArray());
		  //mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
    	MongoClientURI uri=new MongoClientURI("mongodb://parma:azadAZAD1@ds035485.mlab.com:35485/patient");
    	mongoClient =new MongoClient(uri);
				
    	
      
       // Now connect to your databases
   		db = mongoClient.getDB("patient");
       logger.info(db);
    
    }
    
   
    
    
    
    
    public static DBUtilMongo getInstance() {
        
        if (dbutil == null) {
            
            synchronized (DBUtilMongo.class) {
                
                if (dbutil == null) {
                    dbutil = new DBUtilMongo();
                }
                
            }
            
        }
        
        return dbutil;
    }
    
    
    
    
    
    public static DBCollection getCollectionByName(String collection){
    	DBCollection coll = null;
        try {
            coll =  db.getCollection(collection);
       logger.info("*************************************");
      //logger.info(coll.count());
        } catch (Exception ex) {
        	logger.error("Did NOT get a DB Connection", ex);
        }
        
        return coll;
    }
}
