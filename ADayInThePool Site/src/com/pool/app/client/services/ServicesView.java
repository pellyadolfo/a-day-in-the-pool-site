package com.pool.app.client.services;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ServicesView extends ViewWithUiHandlers<ServicesUiHandlers> implements ServicesPresenter.MyView {
    interface Binder extends UiBinder<Widget, ServicesView> {
    }

    @Inject
    ServicesView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}