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
import ninja8.utils.Java8Helper;

/**
 *
 * @author joelauer
 */
public class MethodReference {
    
    final private Method method;
    
    private MethodReference(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    static public <A> MethodReference of(ControllerMethods.Method0<A> method) {
        return new MethodReference(convertLambda(method));
    }
    
    static public <A,B> MethodReference of(ControllerMethods.Method1<A,B> method) {
        return new MethodReference(convertLambda(method));
    }
    
    static public <A,B,C> MethodReference of(ControllerMethods.Method2<A,B,C> method) {
        return new MethodReference(convertLambda(method));
    }
    
    static private Method convertLambda(Object function) {
        try {
            SerializedLambda serializedLambda = Java8Helper.getSerializedLambda(function);
            return Java8Helper.getLambdaMethod(serializedLambda);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
