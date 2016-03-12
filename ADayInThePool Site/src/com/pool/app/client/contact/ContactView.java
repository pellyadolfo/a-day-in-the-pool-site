package com.pool.app.client.contact;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ContactView extends ViewWithUiHandlers<ContactUiHandlers> implements ContactPresenter.MyView {
    interface Binder extends UiBinder<Widget, ContactView> {
    }

    @Inject
    ContactView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}