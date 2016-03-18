package com.pool.app.client.widget.pool;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.pool.app.data.Pool;

public class PoolPresenter extends PresenterWidget<PoolPresenter.MyView> implements PoolUiHandlers {
 
    public interface MyView extends View, HasUiHandlers<PoolUiHandlers> {
    	void setPool(Pool brandVO);
    }
    
    Pool pool;

    public void setPool(Pool pool) {
    	this.pool = pool;

    	getView().setPool(pool);
    }

    @Inject
    public PoolPresenter(final EventBus eventBus, final MyView view) {
        super(eventBus, view);
        
        getView().setUiHandlers(this);
    }
}