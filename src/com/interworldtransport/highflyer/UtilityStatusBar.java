/*
<h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.UtilityStatusBar------------------------------------------
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
---com.interworldtransport.highflyer.UtilityStatusBar------------------------------------------
 */

package com.interworldtransport.highflyer ;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

/** com.interworldtransport.highflyer.UtilityStatusBar
 * The UtilityStatusBar class is intended to be the status bar of the Utility
 * application.
 * <p>
 * @version 0.10, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */

 public class UtilityStatusBar extends JPanel
{
    public	JTextField	stmesgt;
    public	JTextField 	stview;

/**
 * The UtilityStatusBar class is intended to be the status bar of the SailAway
 * application.  There is nothing really special about this class.  It can and
 * used to be defined and built within the SailAway application.  For the sake
 * of maintenance, it has been moved to its own class and file.
 */
    public UtilityStatusBar()
    {
	super();
	this.setBackground(Color.white);
	this.setBorder(BorderFactory.createEtchedBorder());
	this.stmesgt = new JTextField("Initializing GUI and Utility Model", 30);
	this.add(stmesgt);

	this.stview = new JTextField("ISA", 10);
	this.add(stview);
    }

    public void setStatusMsg(String pMsg)
    {
	this.stmesgt.setText(pMsg);
    }

    public void setWhere(String pWhere)
    {
	this.stview.setText(pWhere);
    }

}
