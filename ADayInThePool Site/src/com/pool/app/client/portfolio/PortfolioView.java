package com.pool.app.client.portfolio;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.pool.app.client.home.HomePresenter;

public class PortfolioView extends ViewWithUiHandlers<PortfolioUiHandlers> implements PortfolioPresenter.MyView {
    interface Binder extends UiBinder<Widget, PortfolioView> {
    }

    @Inject
    PortfolioView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiField
    FlowPanel poolsPanel;
    
    @Override
    public void addToSlot(final Object slot, final IsWidget content) {
    	if (slot == PortfolioPresenter.SLOT_POOLS)
    		poolsPanel.add(content);
        else super.addToSlot(slot, content);
    }
}