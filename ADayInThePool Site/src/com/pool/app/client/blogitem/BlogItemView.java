package com.pool.app.client.blogitem;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class BlogItemView extends ViewWithUiHandlers<BlogItemUiHandlers> implements BlogItemPresenter.MyView {
    interface Binder extends UiBinder<Widget, BlogItemView> {
    }

    @Inject
    BlogItemView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}