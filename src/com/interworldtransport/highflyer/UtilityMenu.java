/*
<h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.UtilityMenu------------------------------------
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
---com.interworldtransport.highflyer.UtilityMenu------------------------------------
 */

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

/** com.interworldtransport.highflyer.UtilityMenu
 * The UtilityMenu class is intended to be the class that encapsulates the menu
 * used in the Utility class.
 * <p>
 * There is nothing especially important about the layout of this class.  It
 * should not be instantiated except by the Utility application.  Alterations
 * to this class should be made in careful coordination with the classes of the
 * event model.
 * @version 0.10. $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */

 public class UtilityMenu extends JMenuBar {

/**
 * The File Parent Menu for the application.
 */
    public	JMenu			mnuFile;
    //public	JMenuItem		mniNew;
    //public	JMenuItem		mniOpen;
    //public	JMenuItem		mniSave;
    //public	JMenuItem		mniPrint;
    public	JMenuItem		mniExit;

/**
 * The Edit Parent Menu for the application.
 */
    //public	JMenu			mnuEdit;
    //public	JMenuItem		mniCopy;
    //public	JMenuItem		mniPaste;



/**
 * The UtilityMenu class is intended to be the class that encapsulates the menu
 * used in the Utility Utility.  For the sake of maintenance
 * this definition is in a separate class and file.
 */
    public	UtilityMenu()
    {
	super();

	this.mnuFile=new JMenu("File");
	this.add(this.mnuFile);
	//this.mnuEdit=new JMenu("Edit");
 	//this.add(this.mnuEdit);


	//this.mniNew=new JMenuItem("New File");
	//this.mnuFile.add(this.mniNew);
	//this.mniOpen=new JMenuItem("Open File");
	//this.mnuFile.add(this.mniOpen);
	//this.mniSave=new JMenuItem("Save Data");
	//this.mnuFile.add(this.mniSave);
	//this.mniPrint=new JMenuItem("Print All");
	//this.mnuFile.add(this.mniPrint);
	this.mniExit=new JMenuItem("Exit");
	this.mnuFile.add(this.mniExit);
	//File Menu items added

	//this.mniCopy=new JMenuItem("Copy");
	//this.mnuEdit.add(this.mniCopy);
	//this.mniPaste=new JMenuItem("Paste");
	//this.mnuEdit.add(this.mniPaste);
	//Edit Menu items added



    }

   }
