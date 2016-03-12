package com.pool.app.client.error;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ErrorView extends ViewWithUiHandlers<ErrorUiHandlers> implements ErrorPresenter.MyView {
    interface Binder extends UiBinder<Widget, ErrorView> {
    }

    @Inject
    ErrorView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}