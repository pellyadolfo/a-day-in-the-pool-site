package com.pool.app.client.home;

import com.google.gwt.user.client.rpc.AsyncCallback;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.Slot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.pool.app.client.NameTokens;
import com.pool.app.client.application.ApplicationPresenter;
import com.pool.app.client.widget.pool.PoolPresenter;
import com.pool.app.dispatch.GetPoolsRequest;
import com.pool.app.dispatch.GetPoolsResult;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {
    @ProxyStandard
    @NameToken(NameTokens.HOME)
    public interface MyProxy extends ProxyPlace<HomePresenter> {
    }
    
    public interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
    }
    
    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;

    // presenter is provided with all the information required to work
    // Inject marks the non default constructor
    @Inject
    public HomePresenter(final EventBus eventBus,
                          final MyView view,
                          final MyProxy proxy,
                          PlaceManager placeManager,		// This comes here because Proxy has been declared as place
                          DispatchAsync dispatcher) {		// Need to include dispatcher stuff in .gwt.xml
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);
        
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        
        getView().setUiHandlers(this);
        
        loadPools();
    }
    
    // load pools
    public static final Slot<PoolPresenter> SLOT_POOLS = new Slot<PoolPresenter>();
    @Inject Provider<PoolPresenter> poolPresenterProvider;
    public void loadPools() {
        dispatcher.execute(new GetPoolsRequest("textToServer"), new AsyncCallback<GetPoolsResult>() {
	        @Override
	        public void onFailure(Throwable caught) {
	            //getView().setServerResponse("An error occurred: " + caught.getMessage());
	        }
	
	        @Override
	        public void onSuccess(GetPoolsResult result) {
            	for(int i = 0; i < result.getPools().size(); i++) {
            		PoolPresenter poolPresenter = poolPresenterProvider.get();
            		poolPresenter.setPool(result.getPools().get(i));
    				getView().addToSlot(SLOT_POOLS, poolPresenter);
            	}
	        }
	    });
    }
}
