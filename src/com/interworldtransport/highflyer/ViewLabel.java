/*
<h2>Copyright</h2>
Copyright (c) 1998-2000 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.ViewLabel--------------------------------------
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
---com.interworldtransport.highflyer.ViewLabel--------------------------------------
 */

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;


/**
 * This panel on the status bar dscribes the location of the viewer of the simulation.
 * This panel will eventually switch to an active control allowing changes to be driven.
 * 
 * @version 0.10, $Date: 2005/06/05 07:08:59 $ 
 * @author Dr Alfred W Differ
 */
public class ViewLabel extends JPanel {

	public	String		Name;
	public	String 		Where;
	public	JTextField 	stview;

    public ViewLabel(String pName, String pWhere) {
	super(true);
	this.Name = pName;
	this.Where = pWhere;
	this.setOpaque(true);
	this.setBackground(Color.white);
	this.stview = new JTextField(pWhere, 10);
	this.add(stview);
	this.setView();
	}//end of ViewLabel Panel constructor

    public void setView() 
    {
	this.stview.setText(this.Where);
    }

    public void setWhere(String pWhere) 
    {
	this.Where = pWhere;
	this.setView();
    }

    public String getWhere() {
	return this.Where;
	}

    }//end of ViewLabel class
