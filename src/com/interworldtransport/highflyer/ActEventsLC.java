/*
<h2>Copyright</h2>
Copyright (c) 2002 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.ActEventsLC----------------------------------------
<p>
Interworld Transport grants you ("Licensee") a license to this software
under the terms of the GNU General Public License.<br>
A full copy of the license can be found bundled with this package or code file.
<p>
If the license file has become separated from the package, code file, or binary
executable, the Licensee is still expected to read about the license at the
following URL before accepting this material.
<blockquote><code>http://www.opensource.org/gpl-license.html</code></blockquote>
<p>
Use of this code or executable objects derived from it by the Licensee states
their willingness to accept the terms of the license.
<p>
A prospective Licensee unable to find a copy of the license terms should contact
Interworld Transport for a free copy.
<p>
---com.interworldtransport.highflyer.ActEventsLC----------------------------------------
*/

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** com.interworldtransport.highflyer.ActEventsLC
 * This class groups the event listeners associated with the Actions menu.
 * It may be used in the future to act on events associated with the entire Actions menu
 * by having it register as a Listeners with all of its controlled listeners.  The controlled
 * listeners will create an event or call their parent.  It could also register will all the
 * components to which its listeners register....maybe....
 *
 * @version 0.10, $Date: 2005/05/30 20:33:51 $
 * @author Dr Alfred W Differ
 */
public class ActEventsLC implements ActionListener
{
    public		ActCalcEventsLC	f;
    public		ActSnapEventsLC	snap;
    protected 	LiftCellMenu		ParentGUIMenu;

/**
 * This is the default constructor.  The event structure of the Actions menu starts here and
 * finishes with the child menu items.
 */
    public ActEventsLC(LiftCellMenu pTheGUIMenu)
    {
	this.ParentGUIMenu=pTheGUIMenu;
	this.f = new ActCalcEventsLC(			ParentGUIMenu,
									ParentGUIMenu.mniCalculate,
									this);
	this.snap = new ActSnapEventsLC(	ParentGUIMenu,
									ParentGUIMenu.mniSnap,
									this);

    }//end of ActEventsLC Menu constructor

/**
 * This is the default action to be performed by all members of the Action menu.
 * It will be overridden by specific members of the menu.
 */
    public void actionPerformed(ActionEvent evt) {
	;
	}//end of action performed method.

}//end of ActEventsLC class
