/*
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.pool.app.middleware;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.pool.app.data.Pool;
import com.pool.app.dispatch.GetPoolsRequest;
import com.pool.app.dispatch.GetPoolsResult;

public class GetPoolsHandler extends AHandler implements ActionHandler<GetPoolsRequest, GetPoolsResult> {
    private Provider<HttpServletRequest> requestProvider;
    private ServletContext servletContext;

    @Inject
    GetPoolsHandler(ServletContext servletContext, Provider<HttpServletRequest> requestProvider) {
        this.servletContext = servletContext;
        this.requestProvider = requestProvider;
    }

    @Override
    public GetPoolsResult execute(GetPoolsRequest action, ExecutionContext context) throws ActionException {
        // fetch brands
        List<Pool> brands = getDao().getPools(action);
        GetPoolsResult result = new GetPoolsResult(brands);

        return result;
    }

    @Override
    public Class<GetPoolsRequest> getActionType() {
        return GetPoolsRequest.class;
    }

    @Override
    public void undo(GetPoolsRequest action, GetPoolsResult result, ExecutionContext context) throws ActionException {
        // Not undoable
    }
}
