package com.pool.app.server.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.pool.app.data.Pool;
import com.pool.app.dispatch.GetPoolsRequest;
import com.pool.app.server.AServicesFacade;

public class HardcodedDao extends AServicesFacade {

	public List<Pool> getPoolsImpl(GetPoolsRequest action) {
        List<Pool> pools = new ArrayList<Pool>();
        pools.add(new Pool().setName("Acne").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item1.png").setHiddenPhoto("images/portfolio/full/item1.png"));
        pools.add(new Pool().setName("Grune Erde").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item2.png").setHiddenPhoto("images/portfolio/full/item2.png"));
        pools.add(new Pool().setName("Albiro").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item3.png").setHiddenPhoto("images/portfolio/full/item3.png"));
        pools.add(new Pool().setName("Ronhill").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item4.png").setHiddenPhoto("images/portfolio/full/item4.png"));
        pools.add(new Pool().setName("Oddmolly").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item5.png").setHiddenPhoto("images/portfolio/full/item5.png"));
        pools.add(new Pool().setName("Boudestijn").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item6.png").setHiddenPhoto("images/portfolio/full/item6.png"));
        pools.add(new Pool().setName("Rosch Creative Culture").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item7.png").setHiddenPhoto("images/portfolio/full/item7.png"));
        pools.add(new Pool().setName("Suzuki").setDescription("There are many variations of passages of Lorem Ipsum available, but the majority").setPhoto("images/portfolio/recent/item8.png").setHiddenPhoto("images/portfolio/full/item8.png"));

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