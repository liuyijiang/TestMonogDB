package com.test.insert;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class TestMonogDBInsert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		  Mongo m = new Mongo( "localhost" , 27017 );
		  //多种方式
//		  Mongo m = new Mongo();
//		  Mongo m = new Mongo( "localhost" );
//		  Mongo m = new Mongo( "localhost" , 27017 );
//		  Mongo m = new Mongo(Arrays.asList(new ServerAddress("localhost", 27017), 
//		                                      new ServerAddress("localhost", 27018), 
//		                                      new ServerAddress("localhost", 27019)));
		  
		  //查看数据库
		  List<String> list =  m.getDatabaseNames();
		  for(String str : list){
			  System.out.println(str);
		  }
		  
		  DB db = m.getDB("test1");//获得数据库
		  DBCollection coll = db.getCollection("person");//获得列名
		  
		  BasicDBObject doc = new BasicDBObject();
		  doc.put("name", "MongoDB");
	      doc.put("type", "database");
	      doc.put("count", 1);

//	      BasicDBObject info = new BasicDBObject();
//	      info.put("x", 203);
//	      info.put("y", 102);
//	      doc.put("info", info);

	      coll.insert(doc);
		  
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
