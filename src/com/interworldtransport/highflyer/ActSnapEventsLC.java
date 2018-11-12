/*
<h2>Copyright</h2>
Copyright (c) 2002 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.ActSnapEventsLC-----------------------------------------
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
---com.interworldtransport.highflyer.ActSnapEventsLC-----------------------------------------
*/

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** com.interworldtransport.highflyer.ActSnapEventsLC
 *  This class manages the events associated with running the calculator
 *
 * @version 0.10, $Date: 2005/05/30 20:33:51 $
 * @author Dr Alfred W Differ
 */
public class ActSnapEventsLC implements ActionListener
{
    protected	LiftCellMenu			ParentGUIMenu;
    protected	JMenuItem 			ControlIt;
    protected	ActEventsLC 			Parent;

/**
 * This is the default constructor.
 */
    public ActSnapEventsLC(	LiftCellMenu 		pGUIMenu,
    						JMenuItem 		Act,
						ActEventsLC 		pParent)
    {

	this.ParentGUIMenu=pGUIMenu;
	this.ControlIt=Act;
	this.ControlIt.addActionListener(this);
	this.Parent=pParent;
	ParentGUIMenu.ParentGUI.CenterAll.takeSnapshot(1);

    }//end of ActSnapEventsLC Menu constructor

/**
 * This is the actual action to be performed by this member of the Action menu.
 */
    public void actionPerformed(ActionEvent evt)
    {
	ParentGUIMenu.ParentGUI.CenterAll.takeSnapshot(0);
    }//end of action performed method.


}//end of ActSnapEventsLC class

