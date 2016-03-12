package com.pool.app.client.about;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class AboutView extends ViewWithUiHandlers<AboutUiHandlers> implements AboutPresenter.MyView {
    interface Binder extends UiBinder<Widget, AboutView> {
    }

    @Inject
    AboutView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}