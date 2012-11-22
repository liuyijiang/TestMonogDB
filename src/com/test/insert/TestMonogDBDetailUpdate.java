package com.test.insert;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;


public class TestMonogDBDetailUpdate {

	private Mongo mongo;
	private DB db;
	private DBCollection coll;
	
	
	public TestMonogDBDetailUpdate(String dbname){
		try {
			mongo = new Mongo( "localhost" , 27017 );
			db = mongo.getDB(dbname);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(){
		coll = db.getCollection("student");
//		DBCursor c = coll.find();

		BasicDBObject ref = new BasicDBObject();
		ref.put("age", 19);
		DBCursor c = coll.find(ref);
		display(c);
		DBObject data = coll.findOne(ref);
		
		BasicDBObject updates = new BasicDBObject();
		updates.put("age", 22);
		updates.put("job", "worker");
//	    data.put("$inc", updates);
	    
	    
	    BasicDBObject cc = (BasicDBObject) data;
	    cc.append("$inc", updates);
	    
	    coll.update(ref,cc);
	    display(c);
	}
	
	private void display(DBCursor c){
		while(c.hasNext()){
		System.out.println(c.next()+"\n");
	   }
	}
	
	public static void main(String[] args) {
		TestMonogDBDetailUpdate t = new  TestMonogDBDetailUpdate("test2");
		t.updateData();

	}

}
