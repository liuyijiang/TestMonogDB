package com.test.insert;
import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;


public class TestMonogDBDetailInsert {

	private Mongo mongo;
	private DB db;
	private DBCollection coll;
	
	
	public TestMonogDBDetailInsert(String dbname){
		try {
			mongo = new Mongo( "localhost" , 27017 );
			db = mongo.getDB(dbname);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	 
	public void insertData(String collName){
	    coll = db.getCollection(collName);
		BasicDBObject doc = new BasicDBObject();
		doc.put("name", "liuyijiang");
		coll.insert(doc);//插入基本信息 insert base data
		
	}
	
	public void insertDataBy(String collName){
		coll = db.getCollection(collName);
		BasicDBObject doc = new BasicDBObject();
		doc.put("name", "xuting");
		//BasicDBObject ob = new BasicDBObject();
		doc.put("sex", "nv");
		doc.put("age", 21);
		doc.put("class", "s_class_1");
		//doc.putAll(arg0)
		coll.insert(doc);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("start");
		TestMonogDBDetailInsert t = new  TestMonogDBDetailInsert("test2");
		t.insertDataBy("student");

	}

}
