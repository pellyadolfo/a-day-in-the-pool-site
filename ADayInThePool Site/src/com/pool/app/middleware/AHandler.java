package com.pool.app.middleware;

import com.pool.app.server.AServicesFacade;
import com.pool.app.server.app.dao.HardcodedDao;
import com.pool.app.server.app.dao.MongoDBDao;

public class AHandler {
	
	AServicesFacade dao = null;

	protected AServicesFacade getDao() {
		if (dao == null)
			dao = new MongoDBDao();
		return dao;
	}
}