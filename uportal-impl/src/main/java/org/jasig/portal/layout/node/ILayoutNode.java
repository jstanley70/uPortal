/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */
package org.jasig.portal.layout.node;



/**
 * ILayoutNode interface.
 * Defines the generic set of methods on the user layout node.
 *
 * @author <a href="mailto:mvi@immagic.com">Michael Ivanov</a>
 * @version $Revision$
 */

public interface ILayoutNode {

     public String getId();

     public int getNodeType();

     public IUserLayoutNodeDescription getNodeDescription();

     public String getParentNodeId();

     public String getNextNodeId();

     public String getPreviousNodeId();
    
}