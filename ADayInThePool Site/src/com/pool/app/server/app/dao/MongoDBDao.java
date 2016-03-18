package com.pool.app.server.app.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pool.app.data.Pool;
import com.pool.app.dispatch.GetPoolsRequest;
import com.pool.app.server.AServicesFacade;

public class MongoDBDao extends AServicesFacade {
	
	@Override
	public List<Pool> getPoolsImpl(GetPoolsRequest action) {
		// run query
		BasicDBObject group = new BasicDBObject("$group", new BasicDBObject("_id", "$maker.name").append("count", new BasicDBObject("$sum", 1)));
		BasicDBObject sort = new BasicDBObject("$sort", new BasicDBObject("count", -1));
		BasicDBObject limit = new BasicDBObject("$limit", 7);
		AggregateIterable<Document> output = getCollection("product").aggregate(Arrays.asList(group, sort, limit));
	    
	    // create output
	    final List<Pool> result = new ArrayList<Pool>();
	    //for (Document document : output)
		//	result.add(new Pool().setName("" + document.get("_id")).setCount(Integer.parseInt(document.get("count") + "")));

		return result;
	}
	
	// *************************************************************************************************
	// Manage Connection
	// *************************************************************************************************
	private MongoClient mongoClient = null;
	private MongoDatabase db = null;
	
	@Override
	protected void pre() {
	}
	
	@Override
	protected void post() {
		System.out.println("closing");
		if (mongoClient != null)
			mongoClient.close();
		
		mongoClient = null;
		db = null;
		System.out.println("closed");
	}
	
	private MongoCollection<Document> getCollection(String name) {
		if (db == null || mongoClient == null) {
			System.out.println("opening");
			mongoClient = new MongoClient( "localhost" , 27017 );
			db = mongoClient.getDatabase( "pool" );
		}
				
		return db.getCollection(name);
	}
}