/*
<h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.LiftCellMenu------------------------------------
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
---com.interworldtransport.highflyer.LiftCellMenu------------------------------------
 */

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

/** com.interworldtransport.highflyer.LiftCellMenu
 * The LiftCellMenu class is intended to be the class that encapsulates the menu
 * used in the LiftCell class.
 * <p>
 * There is nothing especially important about the layout of this class.  It
 * should not be instantiated except by the LiftCell application.  Alterations
 * to this class should be made in careful coordination with the classes of the
 * event model.
 * @version 0.10. $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */

 public class LiftCellMenu extends UtilityMenu
{
    public 	LiftCell		ParentGUI;
/**
 * The Actions Parent Menu for the application.
 */
    public	JMenu			mnuActions;
    public	JMenuItem		mniCalculate;
    public	JMenuItem		mniSnap;

/**
 * The Tools Parent Menu for the application.
 */
    public	JMenu			mnuTools;
    public	JMenuItem		mniOptions;

/**
 * The Help Parent Menu for the application.
 */
    public	JMenu			mnuHelp;
    public	JMenuItem		mniSupport;
    public	JMenuItem		mniAbout;

/**
 * The LiftCellMenu class is intended to be the class that encapsulates the menu
 * used in the LiftCell Utility.  For the sake of maintenance
 * this definition is in a separate class and file.
 */
    public	LiftCellMenu(LiftCell pParentGUI)
    {
	super();
	this.ParentGUI=pParentGUI;

	this.mnuActions=new JMenu("Actions");
	this.add(this.mnuActions);
	this.mnuTools=new JMenu("Tools");
	this.add(this.mnuTools);
	this.mnuHelp=new JMenu("Help");
	this.add(this.mnuHelp);  //Menus are added

	this.mniCalculate=new JMenuItem("Calculate Dependent Variables");
	this.mnuActions.add(this.mniCalculate);
	this.mniSnap=new JMenuItem("Take snapshot");
	this.mnuActions.add(this.mniSnap);
	//Actions Menu items added

	this.mniOptions=new JMenuItem("Options");
	this.mnuTools.add(this.mniOptions);
	//Options Menu items added

	this.mniSupport=new JMenuItem("Support");
	this.mnuHelp.add(this.mniSupport);
	this.mniAbout=new JMenuItem("About");
	this.mnuHelp.add(this.mniAbout);
	//Help Menu items added
    }

   }
