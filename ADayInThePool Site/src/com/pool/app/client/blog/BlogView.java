package com.pool.app.client.blog;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class BlogView extends ViewWithUiHandlers<BlogUiHandlers> implements BlogPresenter.MyView {
    interface Binder extends UiBinder<Widget, BlogView> {
    }

    @Inject
    BlogView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}