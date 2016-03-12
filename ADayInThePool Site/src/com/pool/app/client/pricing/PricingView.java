package com.pool.app.client.pricing;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class PricingView extends ViewWithUiHandlers<PricingUiHandlers> implements PricingPresenter.MyView {
    interface Binder extends UiBinder<Widget, PricingView> {
    }

    @Inject
    PricingView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}