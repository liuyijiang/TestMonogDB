package com.test.select;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 * 分页显示数据
 * @author jim.liu
 *
 */
public class TestMonogDBFenYeSelect {

	
	private Mongo mongo;
	private DB db;
	private DBCollection coll;
	
	
	public TestMonogDBFenYeSelect(String dbname){
		try {
			mongo = new Mongo( "localhost" , 27017 );
			db = mongo.getDB(dbname);
			coll = db.getCollection("person");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void fenyeSelect(int page,int number){//第几页，每页几个
		//int all = coll.find().count();
		DBCursor c = coll.find().skip((page - 1) * number).limit(number);
		display(c);
		
	}
	
	
	public void select(){
		
		DBCursor c = coll.find();
		display(c);
	}
	
	private void display(DBCursor c){
		while(c.hasNext()){
		System.out.println(c.next()+"\n");
	   }
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestMonogDBFenYeSelect t = new TestMonogDBFenYeSelect("t1");
		//t.select();
        t.fenyeSelect(2, 3);
	}

}
