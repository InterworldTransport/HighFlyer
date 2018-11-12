/*
<h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport. All rights reserved.<br>
---com.interworldtransport.highflyer.Messaging------------------------------------------
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
---com.interworldtransport.highflyer.Messaging------------------------------------------
 */

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;


/**
 * This object is responsible for keeping status history messages.  
 * This will be the free form text area of the status bar.
 * 
 * @version 0.10, $Date: 2005/06/05 07:08:59 $ 
 * @author Dr Alfred W Differ
 */
public class Messaging extends JPanel {

	public	String		Name;
	public	JTextField	stmesgt;		//This member should probably be a scrollable text area

    public Messaging(String pName, String pMess) {
	super(true);
	this.Name = pName;
	this.setOpaque(true);
	this.setBackground(Color.white);
	this.stmesgt = new JTextField(pMess, 30);
	this.add(stmesgt);
	}//end of Messaging Panel constructor

    public void setStatusMsg(String pMsg) {
	this.stmesgt.setText(pMsg);
	}

    public String getStatusMsg() {
	return this.stmesgt.getText();
	}

    }//end of Messaging class
