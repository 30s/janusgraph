package com.thinkaurelius.titan.graphdb.types;

import com.google.common.base.Preconditions;
import com.thinkaurelius.titan.core.Parameter;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Arrays;

/**
* @author Matthias Broecheler (me@matthiasb.com)
*/
public class IndexParameters {

    private String indexName;
    private Parameter[] parameters;

    public IndexParameters() {} //For serialization

    public IndexParameters(final String indexName, final Parameter[] paras) {
        this.indexName=indexName;
        this.parameters=paras;
    }

    public String getIndexName() {
        return indexName;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object other) {
        if (this==other) return true;
        else if (!getClass().equals(other.getClass())) return false;
        IndexParameters oth = (IndexParameters)other;
        return Arrays.deepEquals(parameters, oth.parameters) && indexName.equals(oth.indexName);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(indexName).append(parameters).toHashCode();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(indexName).append(":: ");
        for (int i=0;i<parameters.length;i++) {
            if (i>0) str.append(" #:# ");
            str.append(parameters[i].toString());
        }
        return str.toString();
    }

}
