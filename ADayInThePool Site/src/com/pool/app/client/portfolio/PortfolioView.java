package com.pool.app.client.portfolio;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class PortfolioView extends ViewWithUiHandlers<PortfolioUiHandlers> implements PortfolioPresenter.MyView {
    interface Binder extends UiBinder<Widget, PortfolioView> {
    }

    @Inject
    PortfolioView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}