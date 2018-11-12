/*
<h2>Copyright</h2>
Copyright (c) 2003 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.LiftCellEventModel---------------
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
Use of this code or executable objects derived from it by the Licensee states their
willingness to accept the terms of the license.
<p>
A prospective Licensee unable to find a copy of the license terms should contact
Interworld Transport for a free copy.
<p>
---com.interworldtransport.highflyer.LiftCellEventModel---------------
 */

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;

/** com.interworldtransport.highflyer.LiftCellEventModel
 *
 *
 * @version 0.10, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */
public class LiftCellEventModel extends UtilityEventModel
{
/**
 * The GUIParent object maintains a reference to the GUI to which this EventModel applies
 */
    protected 	LiftCellMenu		GUIParentMenu;
/** The ActEventsLC object collects all Action Event Handlers in one place in case there
 *  are actions they all share.  This object is responsible for constructing all Action
 *  Event Handlers.
 */
    protected	ActEventsLC		ActParts;
    protected	ToolsEventsLC		ToolParts;
/** The HelpEventsLC object collects all Help Event Handlers in one place in case there
 *  are actions they all share.  This object is responsible for constructing all Help
 *  Event Handlers.
 */
    protected 	HelpEventsLC		HelpParts;


/** This is the default constructor.  The event structure of the SailAway
 *  application starts here and finishes with the child components that affect the
 *  physical model.
 */
    public LiftCellEventModel(LiftCellMenu pGUIParentMenu)
    {
	super(pGUIParentMenu);
	this.GUIParentMenu=pGUIParentMenu;

	this.ToolParts = new ToolsEventsLC(this.GUIParentMenu);
	this.ActParts = new ActEventsLC(this.GUIParentMenu);
	this.HelpParts = new HelpEventsLC(this.GUIParentMenu);

    }//end of LiftCellEventModel constructor


    }//end of LiftCellEventModel class
