package com.pool.app.server.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.pool.app.data.Pool;
import com.pool.app.dispatch.GetPoolsRequest;
import com.pool.app.server.AServicesFacade;

public class HardcodedDao extends AServicesFacade {

	public List<Pool> getPoolsImpl(GetPoolsRequest action) {
        List<Pool> pools = new ArrayList<Pool>();
        pools.add(new Pool().setName("Acne"));
        pools.add(new Pool().setName("Grune Erde"));
        pools.add(new Pool().setName("Albiro"));
        pools.add(new Pool().setName("Ronhill"));
        pools.add(new Pool().setName("Oddmolly"));
        pools.add(new Pool().setName("Boudestijn"));
        pools.add(new Pool().setName("Rosch Creative Culture"));
        return pools;
	}
	
	// *************************************************************************************************
	// Manage Connection
	// *************************************************************************************************
	@Override
	protected void pre() {
	}
	@Override
	protected void post() {
	}
}