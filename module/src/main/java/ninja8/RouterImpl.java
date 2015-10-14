/*
 * Copyright 2015 Fizzed Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ninja8;

import com.google.common.base.Optional;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import ninja.Route;

/**
 *
 * @author joelauer
 */
public class RouterImpl implements Router {
    
    private final ninja.Router wrapped;
    
    @Inject
    public RouterImpl(ninja.Router wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public RouteBuilder GET() {
        return new RouteBuilderImpl(wrapped.GET());
    }

    @Override
    public RouteBuilder POST() {
        return new RouteBuilderImpl(wrapped.POST());
    }

    @Override
    public RouteBuilder PUT() {
        return new RouteBuilderImpl(wrapped.PUT());
    }

    @Override
    public RouteBuilder DELETE() {
        return new RouteBuilderImpl(wrapped.DELETE());
    }

    @Override
    public RouteBuilder OPTIONS() {
        return new RouteBuilderImpl(wrapped.OPTIONS());
    }

    @Override
    public RouteBuilder HEAD() {
        return new RouteBuilderImpl(wrapped.HEAD());
    }

    @Override
    public RouteBuilder METHOD(String method) {
        return new RouteBuilderImpl(wrapped.METHOD(method));
    }

    @Override
    public Route getRouteFor(String httpMethod, String uri) {
        return wrapped.getRouteFor(httpMethod, uri);
    }

    @Override
    public String getReverseRoute(Class<?> clazz, String methodName) {
        return wrapped.getReverseRoute(clazz, methodName);
    }

    @Override
    public String getReverseRoute(Class<?> clazz, String methodName, Map<String, Object> parameterMap) {
        return wrapped.getReverseRoute(clazz, methodName, parameterMap);
    }

    @Override
    public String getReverseRoute(Class<?> clazz, String methodName, Object... parameterMap) {
        return wrapped.getReverseRoute(clazz, methodName, parameterMap);
    }

    @Override
    public String getReverseRoute(Class<?> controllerClass, String controllerMethodName, Optional<Map<String, Object>> parameterMap) {
        return wrapped.getReverseRoute(controllerClass, controllerMethodName, parameterMap);
    }

    

    
    @Override
    public String getReverseRoute(MethodReference methodReference) {
        return getReverseRoute(methodReference.getMethod().getDeclaringClass(), methodReference.getMethod().getName());
    }
    
    @Override
    public String getReverseRoute(MethodReference methodReference, Map<String, Object> parameterMap) {
        return getReverseRoute(methodReference.getMethod().getDeclaringClass(), methodReference.getMethod().getName(), parameterMap);
    }
    
    @Override
    public String getReverseRoute(MethodReference methodReference, Object... parameterMap) {
        return getReverseRoute(methodReference.getMethod().getDeclaringClass(), methodReference.getMethod().getName(), parameterMap);
    }

    
    
    @Override
    public void compileRoutes() {
        wrapped.compileRoutes();
    }

    @Override
    public List<Route> getRoutes() {
        return wrapped.getRoutes();
    }

}
