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

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import ninja.Result;
import ninja8.utils.Java8Helper;

/**
 *
 * @author joelauer
 */
public class RouteBuilderImpl implements RouteBuilder {
    
    private final ninja.RouteBuilder wrapped;
    
    public RouteBuilderImpl(ninja.RouteBuilder wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public RouteBuilder route(String uri) {
        wrapped.route(uri);
        return this;
    }
    
    @Override
    public void with(MethodReference methodReference) {
        with(methodReference.getMethod().getDeclaringClass(), methodReference.getMethod().getName());
    }
    
    @Override
    public <A> void with(ControllerMethods.Method0<A> method) {
        withLambda(method);
    }

    @Override
    public <A, B> void with(ControllerMethods.Method1<A, B> method) {
        withLambda(method);
    }

    @Override
    public <A, B, C> void with(ControllerMethods.Method2<A, B, C> method) {
        withLambda(method);
    }

    private void withLambda(Object function) {
        try {
            SerializedLambda serializedLambda = Java8Helper.getSerializedLambda(function);
            Method lambdaMethod = Java8Helper.getLambdaMethod(serializedLambda);
            with(lambdaMethod.getDeclaringClass(), lambdaMethod.getName());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    @Override
    public void with(Class controller, String controllerMethod) {
        wrapped.with(controller, controllerMethod);
    }

    @Override
    public void with(Result result) {
        wrapped.with(result);
    }
    
}
