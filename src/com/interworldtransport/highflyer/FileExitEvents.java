/*
<h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.FileExitEvents------------------------------------------
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
---com.interworldtransport.highflyer.FileExitEvents------------------------------------------
*/

package com.interworldtransport.highflyer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** com.interworldtransport.highflyer.FileExitEvents
 *  This class manages all events relating to the exiting of the applicaiton.
 *
 * @version 0.10, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */
public class FileExitEvents implements ActionListener
 {
    protected UtilityMenu		ParentGUIMenu;
    protected JMenuItem 		ControlIt;
    protected FileEvents 		Parent;

/** This is the default constructor.
 */
    public FileExitEvents(UtilityMenu pGUIMenu, JMenuItem pmniExit, FileEvents pParent)
    {
	this.ParentGUIMenu=pGUIMenu;
	this.ControlIt=pmniExit;
	this.ControlIt.addActionListener(this);
	this.Parent=pParent;

    }//end of FileExitEvents Menu constructor

/** This is the actual action to be performed by this member of the File menu.
 */
    public void actionPerformed(ActionEvent evt)
    {
	System.exit(0);
    }//end of action performed method.

 }//end of FileExitEvents class
