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
package ninja8.application;

import ninja8.Router;
import ninja8.RouterImpl;

/**
 *
 * @author joelauer
 */
public interface ApplicationRoutes extends ninja.application.ApplicationRoutes {

    @Override
    public default void init(ninja.Router wrapped) {
        // create a ninja8 router and call its init
        Router router = new RouterImpl(wrapped);
        init(router);
    }
    
    void init(Router router);
    
}
