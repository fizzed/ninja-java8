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
package ninja8.utils;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author joelauer
 */
public class Java8Helper {
    
    // getting the SerializedLambda
    static public SerializedLambda getSerializedLambda(Object function) throws Exception {
        if (function == null || !(function instanceof java.io.Serializable)) {
            throw new IllegalArgumentException();
        }

        for (Class<?> clazz = function.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Method replaceMethod = clazz.getDeclaredMethod("writeReplace");
                replaceMethod.setAccessible(true);
                Object serializedForm = replaceMethod.invoke(function);

                if (serializedForm instanceof SerializedLambda) {
                    return (SerializedLambda) serializedForm;
                }
            } catch (NoSuchMethodError e) {
                // fall through the loop and try the next class
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException t) {
                throw new RuntimeException("Error while extracting serialized lambda", t);
            }
        }

        throw new Exception("writeReplace method not found");
    }
    
    // getting the synthetic static lambda method
    static public Method getLambdaMethod(SerializedLambda lambda) throws Exception {
        String implClassName = lambda.getImplClass().replace('/', '.');
        Class<?> implClass = Class.forName(implClassName);

        String lambdaName = lambda.getImplMethodName();

        for (Method m : implClass.getDeclaredMethods()) {
            if (m.getName().equals(lambdaName)) {
                return m;
            }
        }

        throw new Exception("Lambda Method not found");
    }
    
}
