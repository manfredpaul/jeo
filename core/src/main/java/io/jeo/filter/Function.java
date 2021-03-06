/* Copyright 2013 The jeo project. All rights reserved.
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
package io.jeo.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Expression that evaluates to the result of a function.
 * 
 * @author Justin Deoliveira, OpenGeo
 */
public abstract class Function implements Expression {

    protected String name;

    protected List<Expression> args;

    protected Function(String name) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        this.args = new ArrayList<Expression>();
    }

    /**
     * The name of the function.
     */
    public String name() {
        return name;
    }

    /**
     * Function arguments.
     */
    public List<Expression> args() {
        return args;
    }

    @Override
    public <R> R accept(FilterVisitor<R> visitor, Object obj) {
        return visitor.visit(this, obj);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append("(");
        for (Expression arg : args) {
            sb.append(arg.toString()).append(",");
        }
        sb.setLength(sb.length()-1);
        return sb.append(")").toString();
    }
}
