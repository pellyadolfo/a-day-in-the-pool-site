package com.pool.app.server.app.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pool.app.data.Pool;
import com.pool.app.dispatch.GetPoolsRequest;
import com.pool.app.server.AServicesFacade;

public class MongoDBDao extends AServicesFacade {
	
	@Override
	public List<Pool> getPoolsImpl(GetPoolsRequest action) {
		// run query
		FindIterable<Document> iterable = getCollection("PE_ASSET").find().limit(action.getCount());
		
		// create output
		final List<Pool> pools = new ArrayList<Pool>();
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
				String center = (String) ((Document) document.get("document")).get("cen");			
				pools.add(new Pool()
						.setName(center)
						.setDescription("There are many variations of passages of Lorem Ipsum available, but the majority")
						.setPhoto("images/portfolio/recent/item1.png"));
		    }
		});
		System.out.println("records obtained: " + pools.size());

		return pools;
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
		if (db != null && mongoClient != null)
			return db.getCollection(name);
		
		try {
			return getDBByCRC(name);
		} catch (Throwable e) {
			System.out.println("Not CRC authentication");
			try {
				return getDBBySH1(name);
			} catch (Throwable e1) {
				System.out.println("Not SH1 authentication");
				handleException(e1, name);				
			}
		}
		
		return null;
	}
	
	private MongoCollection<Document> getDBByCRC(String name) {
		MongoCredential credential = MongoCredential.createCredential("pool", "pool", "pellyadolfo".toCharArray());
		List<MongoCredential> auths = new ArrayList<MongoCredential>();
		auths.add(credential);

		mongoClient = new MongoClient(new ServerAddress("localhost", 27050), auths);
		
		//mongoClient = new MongoClient( "localhost" , 27050 );
		db = mongoClient.getDatabase( "pool" );
		
		return db.getCollection(name);
	}
	private MongoCollection<Document> getDBBySH1(String name) {
		MongoCredential credential = MongoCredential.createScramSha1Credential("pool", "pool", "pellyadolfo".toCharArray());
		List<MongoCredential> auths = new ArrayList<MongoCredential>();
		auths.add(credential);

		mongoClient = new MongoClient(new ServerAddress("localhost", 27050), auths);
		
		//mongoClient = new MongoClient( "localhost" , 27050 );
		db = mongoClient.getDatabase( "pool" );
		
		return db.getCollection(name);
	}
}