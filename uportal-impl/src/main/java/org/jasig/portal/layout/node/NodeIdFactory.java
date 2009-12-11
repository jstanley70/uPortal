/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */
package org.jasig.portal.layout.node;

import org.jasig.portal.core.ObjectIdFactory;

/**
 * The object Ids factory.
 * @author Michael Ivanov, mvi@immagic.com
 * @version $Revision$
 */
public abstract class NodeIdFactory extends ObjectIdFactory {
	
	protected static class NodeIdImpl extends ObjectIdImpl implements INodeId {
	    
	    public NodeIdImpl(String id) {
	        super(id);
	    }

	    public NodeIdImpl(int id) {
	        super(id);
	    }
	    
	    public NodeIdImpl(long id) {
	        super(id);
	    }

	    public boolean equals(Object obj) {
	        return ( (obj instanceof INodeId) && id.equals(obj.toString()) );
	    }
	}
    
    public static INodeId createNodeId(String id) {
        return new NodeIdImpl(id);
    }
    
    public static INodeId createNodeId(int id) {
        return new NodeIdImpl(id);
    }
    
    public static INodeId createNodeId(long id) {
        return new NodeIdImpl(id);
    }
}