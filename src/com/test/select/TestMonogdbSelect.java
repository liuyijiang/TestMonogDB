package com.test.select;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class TestMonogdbSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			  Mongo m = new Mongo( "localhost" , 27017 );
			  DB db = m.getDB("test1");//������ݿ�
			  DBCollection coll = db.getCollection("person");//�������
//			  DBCursor cursor = coll.find();
			  //��������ѯ
			  BasicDBObject doc = new BasicDBObject();
			  doc.put("name", "liuyijiang");
			  DBCursor cursor = coll.find(doc);
			  while(cursor.hasNext()) {
				  DBObject ob =   cursor.next();
				  System.out.println(ob.get("name"));
	              //  System.out.println(cursor.next());
	            }
			 
			  
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}

}
