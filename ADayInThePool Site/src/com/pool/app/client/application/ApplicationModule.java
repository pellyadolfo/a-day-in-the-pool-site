package com.pool.app.client.application;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.pool.app.client.NameTokens;
import com.pool.app.client.about.AboutPresenter;
import com.pool.app.client.about.AboutView;
import com.pool.app.client.blog.BlogPresenter;
import com.pool.app.client.blog.BlogView;
import com.pool.app.client.blogitem.BlogItemPresenter;
import com.pool.app.client.blogitem.BlogItemView;
import com.pool.app.client.contact.ContactPresenter;
import com.pool.app.client.contact.ContactView;
import com.pool.app.client.error.ErrorPresenter;
import com.pool.app.client.error.ErrorView;
import com.pool.app.client.home.HomePresenter;
import com.pool.app.client.home.HomeView;
import com.pool.app.client.portfolio.PortfolioPresenter;
import com.pool.app.client.portfolio.PortfolioView;
import com.pool.app.client.pricing.PricingPresenter;
import com.pool.app.client.pricing.PricingView;
import com.pool.app.client.services.ServicesPresenter;
import com.pool.app.client.services.ServicesView;
import com.pool.app.client.shortcodes.ShortCodesPresenter;
import com.pool.app.client.shortcodes.ShortCodesView;

/**
 * @author Joshua Godi
 */
public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
    	
        install(new RpcDispatchAsyncModule());

        // Main Application View
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);

        // eshoping
        bindPresenter(AboutPresenter.class, AboutPresenter.MyView.class, AboutView.class, AboutPresenter.MyProxy.class);
        bindPresenter(BlogPresenter.class, BlogPresenter.MyView.class, BlogView.class, BlogPresenter.MyProxy.class);
        bindPresenter(BlogItemPresenter.class, BlogItemPresenter.MyView.class, BlogItemView.class, BlogItemPresenter.MyProxy.class);
        bindPresenter(ContactPresenter.class, ContactPresenter.MyView.class, ContactView.class, ContactPresenter.MyProxy.class);
        bindPresenter(ErrorPresenter.class, ErrorPresenter.MyView.class, ErrorView.class, ErrorPresenter.MyProxy.class);
        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(PortfolioPresenter.class, PortfolioPresenter.MyView.class, PortfolioView.class, PortfolioPresenter.MyProxy.class);
        bindPresenter(PricingPresenter.class, PricingPresenter.MyView.class, PricingView.class, PricingPresenter.MyProxy.class);
        bindPresenter(ServicesPresenter.class, ServicesPresenter.MyView.class, ServicesView.class, ServicesPresenter.MyProxy.class);
        bindPresenter(ShortCodesPresenter.class, ShortCodesPresenter.MyView.class, ShortCodesView.class, ShortCodesPresenter.MyProxy.class);
        
        // bind constants
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.ERROR);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.ERROR);

        //install(new ServerModule());
    }
}
