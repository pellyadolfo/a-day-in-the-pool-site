package com.pool.app.client.shortcodes;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ShortCodesView extends ViewWithUiHandlers<ShortCodesUiHandlers> implements ShortCodesPresenter.MyView {
    interface Binder extends UiBinder<Widget, ShortCodesView> {
    }

    @Inject
    ShortCodesView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}