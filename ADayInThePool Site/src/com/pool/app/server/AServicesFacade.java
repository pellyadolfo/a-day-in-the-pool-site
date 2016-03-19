package com.pool.app.server;

import java.util.ArrayList;
import java.util.List;

import com.pool.app.data.Pool;
import com.pool.app.dispatch.GetPoolsRequest;

public abstract class AServicesFacade {
	
	public List<Pool> getPools(GetPoolsRequest action) {
    	try { prea(); return getPoolsImpl(action); } catch (Throwable e) { handleException(e, action); } finally {posta();} return new ArrayList<Pool>();
	}
    protected abstract List<Pool> getPoolsImpl(GetPoolsRequest action) throws Throwable;
	
    // connection pre
    private void prea() {
    	try {
    		pre();
    	} catch (Throwable e) {
    		handleException(e, null);
    	}
    }
    protected abstract void pre();
    
    // connection post
    private void posta() {
    	try {
    		post();
    	} catch (Throwable e) {
    		handleException(e, null);
    	}
    }
    protected abstract void post();
    
	protected void handleException (Throwable e, Object config) {
		e.printStackTrace();
	}
}