/**
 * Copyright � 2001 The JA-SIG Collaborative.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 *    "This product includes software developed by the JA-SIG Collaborative
 *    (http://www.jasig.org/)."
 *
 * THIS SOFTWARE IS PROVIDED BY THE JA-SIG COLLABORATIVE "AS IS" AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE JA-SIG COLLABORATIVE OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package  org.jasig.portal.channels.groupsmanager.commands;

import org.jasig.portal.channels.groupsmanager.*;
import org.jasig.portal.services.*;
import org.jasig.portal.*;
import org.jasig.portal.channels.permissionsmanager.*;
import java.util.*;

/**
 * A Groups Manager command to instantiate a permissions manager servant
 *
 * @author Alex Vigdor
 * @version $Revision$
 */
public class AssignPermissions extends GroupsManagerCommand {

  public AssignPermissions() {
  }
  
   public void execute(CGroupsManagerSessionData sessionData) {
         try {
            ChannelRuntimeData slaveRD = sessionData.runtimeData;
            String[] tgts = new String[1];
            tgts[0] = this.getCommandArg(sessionData.runtimeData);
            sessionData.servantChannel = CPermissionsManagerServantFactory.getPermissionsServant((IPermissible)Class.forName(OWNER).newInstance(),
                  sessionData.staticData, null, null, tgts);
            slaveRD = (ChannelRuntimeData)sessionData.runtimeData.clone();
            Enumeration srd = slaveRD.keys();
            while (srd.hasMoreElements()) {
               slaveRD.remove(srd.nextElement());
            }
            sessionData.runtimeData = slaveRD;
         } catch (Exception e) {
            LogService.instance().log(LogService.ERROR, e);
            sessionData.feedback="Error tring to assign permissions: "+e.getMessage();
         }
   }
}