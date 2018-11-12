/*
<h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.ToolsOptionsLC---------------------------------------
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
---com.interworldtransport.highflyer.ToolsOptionsLC---------------------------------------
*/

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** com.interworldtransport.highflyer.ToolsOptionsLC
 * This class shows the About dialog box and its related information.
 *
 * @version 0.10, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */
public class ToolsOptionsLC implements ActionListener
{

    protected ToolsEventsLC		Parent;
    protected LiftCellMenu		ParentGUIMenu;
    protected JMenuItem			ControlIt;

/** This is the default constructor.
 */
    public ToolsOptionsLC(LiftCellMenu pGUIMenu, JMenuItem pOpt, ToolsEventsLC pParent)
    {
	this.ParentGUIMenu=pGUIMenu;
	this.ControlIt=pOpt;
	this.Parent=pParent;
	this.ControlIt.addActionListener(this);

    }//end of ToolsOptionsLC Menu constructor

/** This is the actual action to be performed by this menu item.
 */
    public void actionPerformed(ActionEvent evt)
    {
	//Show the Configuration file;

	StringBuffer content = new StringBuffer();

	content.append("Fill Here with Configuration File ");

	String contentstring = new String(content);

	OptionsDialog opt1 = new OptionsDialog(this.ParentGUIMenu.ParentGUI, contentstring);
    }//end of action performed method.

}//end of ToolsOptionsLC class
