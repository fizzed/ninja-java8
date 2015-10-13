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

import java.io.Serializable;
import ninja.Result;

/**
 * Defines method signatures of a Ninja Controller method.
 * 
 * @author joelauer
 */
public class ControllerMethods {
    
    @FunctionalInterface
    static public interface Method0<A> extends Serializable {
    
        Result apply(A a);
        
    }
    
    @FunctionalInterface
    static public interface Method1<A,B> extends Serializable {
    
        Result apply(A a, B b);
        
    }
    
    @FunctionalInterface
    static public interface Method2<A,B,C> extends Serializable {
    
        Result apply(A a, B b, C c);
        
    }
    
}
