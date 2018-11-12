/*
<h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.UtilityEventModel---------------
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
---com.interworldtransport.highflyer.UtilityEventModel---------------
 */

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;

/** com.interworldtransport.highflyer.UtilityEventModel
 *
 *
 * @version 0.10, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */  
public class UtilityEventModel 
{
/** 
 * The GUIParent object maintains a reference to the GUI to which this EventModel applies
 */
    protected 	UtilityMenu	GUIUtilityParentMenu;
/** The FileEvents object collects all File Event Handlers in one place in case there
 *  are actions they all share.  This object is responsible for constructing all File
 *  Event Handlers.
 */
    protected 	FileEvents	FileParts;
/** The ActEvents object collects all Action Event Handlers in one place in case there
 *  are actions they all share.  This object is responsible for constructing all Action
 *  Event Handlers.
 */
    //protected	ActEvents	ActParts;
/** The HelpEvents object collects all Help Event Handlers in one place in case there
 *  are actions they all share.  This object is responsible for constructing all Help
 *  Event Handlers.
 */
    //protected 	HelpEvents	HelpParts;


/** This is the default constructor.  The event structure of the SailAway 
 *  application starts here and finishes with the child components that affect the
 *  physical model.
 */
    public UtilityEventModel(UtilityMenu pGUIParentMenu) 
    {

	this.GUIUtilityParentMenu=pGUIParentMenu;

	this.FileParts = new FileEvents(this.GUIUtilityParentMenu);
	//this.EditParts = new EditEvents(this.GUIParent);
	//this.ToolParts = new ToolEvents(this.GUIParent);
	//this.ActParts = new ActEvents(this.GUIParent);
	//this.HelpParts = new HelpEvents(this.GUIParent);

    }//end of UtilityEventModel constructor


}//end of UtilityEventModel class
