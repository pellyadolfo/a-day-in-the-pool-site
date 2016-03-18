package com.pool.app.client.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @Inject
    HomeView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiField
    FlowPanel poolsPanel;
    
    @Override
    public void addToSlot(final Object slot, final IsWidget content) {
    	if (slot == HomePresenter.SLOT_POOLS)
    		poolsPanel.add(content);
        else super.addToSlot(slot, content);
    }
}