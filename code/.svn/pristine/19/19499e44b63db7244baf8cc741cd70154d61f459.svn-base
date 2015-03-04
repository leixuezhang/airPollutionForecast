package com.airforecast.util;

import java.net.UnknownHostException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class DBUtil {
	static ConfigurableApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("mongo-config.xml");  
	}
//	   HelloMongoDB hello = (HelloMongoDB) context.getBean("helloMongoDB");  
//	   hello.execute();  
//	   System.out.println( "DONE!" );  

	private static DB db;
	
	static{
		try {
			MongoClient mongo = new MongoClient( "192.168.1.6" , 27017 );
			db = mongo.getDB("Nibodha");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the db
	 */
	public static DB getDb() {
		return db;
	}


	/**
	 * @param db the db to set
	 */
	public static void setDb(DB db) {
		DBUtil.db = db;
	}


	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main1(String[] args) throws UnknownHostException {
		MongoClient mongo = new MongoClient( "192.168.1.6" , 27017 );
		System.out.println(mongo.getDatabaseNames());
		DB db = mongo.getDB("Nibodha");
		System.out.println(db.getCollectionNames());
		DBCollection table = db.getCollection("employee");
		DBCursor cursor =table.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
//		BasicDBObject searchQuery = new BasicDBObject();
//		searchQuery.put("name", "mkyong");
//	 
//		DBCursor cursor = table.find(searchQuery);
//	 
//		while (cursor.hasNext()) {
//			System.out.println(cursor.next());
//		}
//		
		
//		for(int i=0;i<50;i++){
//		BasicDBObject document = new BasicDBObject();
//		document.put("name", "mkyong"+i);
//		document.put("age", 30+i);
//		document.put("createdDate", new Date());
//		table.insert(document);
//		}
	}

}
