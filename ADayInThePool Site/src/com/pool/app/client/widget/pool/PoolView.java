package com.pool.app.client.widget.pool;

import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.pool.app.data.Pool;

public class PoolView extends ViewImpl implements PoolPresenter.MyView {
	
    interface Binder extends UiBinder<Widget, PoolView> {
    }
    
    @Inject
    public PoolView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
    
	@Override
	public void setUiHandlers(PoolUiHandlers uiHandlers) {
		// TODO Auto-generated method stub
		
	}
	
	@UiField
	Text name;
	
	@UiField
	Text description;
	
	@UiField
	Text view;
	
    @UiField
    ImageElement image;

    public void setPool(Pool pool) {
    	name.setText(pool.getName());
    	description.setText(pool.getDescription());
    	view.setText("View");
    	image.setSrc(pool.getPhoto());
    	
       	//amount.setText("(" + brandVO.getCount() + ")");
    	//brand.setText(brandVO.getName());
    }
}