/*
 * Copyright 2014 Couchbase, Inc.
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

package com.couchbase.graph.views;

import com.couchbase.graph.resources.FileResourceManager;

/**
 * A view definition has map function and a reduce function. Both functions are
 * JS texts.
 * 
 * TODO: Found later out that ViewDesign of the Couchbase Library is exactly the
 * same thing. Needs to be refactored later.
 * 
 * @author David Maier <david.maier at couchbase.com>
 */
public class ViewDef {
    
    /**
     * The name of a view
     */
    protected String name;
    
    /**
     * The JS map function
     */
    protected String mapFunc;
    
    /**
     * The JS reduce function
     */
    protected String reduceFunc;
 
    /**
     * Has the view definition
     */
    protected boolean hasReduceFunc = false;
    
    /**
     * To construct a view definition with a map function
     * @param name
     * @param mapFuncName 
     */
    public ViewDef(String name, String mapFuncName)
    {
        this.name = name;
        this.mapFunc = FileResourceManager.getFileResource(mapFuncName).toString();
    }
    
    /**
     * To construct a view definition with a map and reduce function
     * @param name
     * @param mapFuncName
     * @param reduceFuncName 
     */
    public ViewDef(String name, String mapFuncName, String reduceFuncName)
    {
        this(name, mapFuncName);
        this.reduceFunc = FileResourceManager.getFileResource(reduceFuncName).toString();
        this.hasReduceFunc = true;
    }

    /**
     * To get the name
     * @return 
     */
    public String getName() {
        return this.name;
    }

    /**
     * To get the map function
     * @return 
     */
    public String getMapFunc() {
        return this.mapFunc;
    }
    
    /**
     * To determine if the view definition has a reduce function
     * @return 
     */
    public boolean hasReduceFunc()
    {
        return this.hasReduceFunc;
    }

    /**
     * To get the reduce function
     * @return 
     */
    public String getReduceFunc() {
        return reduceFunc;
    }
    
}
