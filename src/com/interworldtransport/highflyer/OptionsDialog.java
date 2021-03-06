/*
<h2>Copyright</h2>
Copyright (c) 2003 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.OptionsDialog--------------------------------------
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
---com.interworldtransport.highflyer.OptionsDialog--------------------------------------
*/

/*
 * Significant parts of this class are copies with
 * minor alterations of code written by Scott Davis for the Mars Simulation
 * Project.  Information regarding the Mars Simulation Project can be found
 * below.
 *
 * Mars Simulation Project
 * Copyright (C) 1999 Scott Davis
 *
 * home page http://mars-sim.sourceforge.net
 *
 * For questions or comments on this project, contact:
 *
 * Scott Davis
 * 1725 W. Timber Ridge Ln. #6206
 * Oak Creek, WI  53154
 * scud1@execpc.com
 * http://www.execpc.com/~scud1/
 */

package com.interworldtransport.highflyer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**  com.interworldtransport.highflyer.AboutDialog
 * The AboutDialog is an information window that is called from the
 * "Help|About" menu on the main Atmosphere application window.
 * It provides information about the application, credit to contributors
 * and the GPL license.
 */
public class OptionsDialog extends JDialog implements ActionListener
{
    private JButton closeButton;  // The close button

/**
 * The constructor sets up the options dialog box and displays it.
 */
    public OptionsDialog(JPAUtility mainWindow, String pContent)
    {

	super(mainWindow, "Options Panel for JPA Utility", true); //Use parent's constructor

	JPanel mainPane = new JPanel(new BorderLayout());
	mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(mainPane);

	// Create content text area

	JTextArea contentArea = new JTextArea(pContent);
	contentArea.setBackground(Color.lightGray);
	contentArea.setBorder(new EmptyBorder(2, 2, 2, 2));
	contentArea.setLineWrap(true);
	contentArea.setWrapStyleWord(true);
	contentArea.setEditable(false);
	mainPane.add(new JScrollPane(contentArea), "Center");

	// Create close button panel

	JPanel closeButtonPane = new JPanel(new FlowLayout());
	closeButtonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	mainPane.add(closeButtonPane, "South");

	// Create close button

	closeButton = new JButton("Close");
	closeButton.addActionListener(this);
	closeButtonPane.add(closeButton);

	// Set the size of the window

	setSize(400, 500);

	// Center the window on the parent window.

	Point parentLocation = mainWindow.getLocation();
	int Xloc = (int) parentLocation.getX() + ((mainWindow.getWidth() - 300) / 2);
	int Yloc = (int) parentLocation.getY(); //+ ((mainWindow.getHeight() - 400) / 2);
	setLocation(Xloc, Yloc);

	// Display window
	setVisible(true);
    }

	// Implementing ActionListener method

    public void actionPerformed(ActionEvent event)
    {
		dispose();
    }
}//End of OptionsDialog class
