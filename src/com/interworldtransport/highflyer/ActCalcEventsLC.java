/*
<h2>Copyright</h2>
Copyright (c) 2003 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.ActCalcEventsLC------------------------------------
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
---com.interworldtransport.highflyer.ActCalcEventsLC------------------------------------
*/

package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** com.interworldtransport.highflyer.ActCalcEventsLC
 *  This class manages the events associated with running the calculator
 *
 * @version 0.10, $Date: 2005/05/30 20:33:51 $
 * @author Dr Alfred W Differ
 */
public class ActCalcEventsLC implements ActionListener
{
    protected	LiftCellMenu		ParentGUIMenu;
    protected	JMenuItem 		ControlIt;
    protected	ActEventsLC 		Parent;

/**
 * This is the default constructor.
 */
    public ActCalcEventsLC(	LiftCellMenu	pGUIMenu,
    				JMenuItem 	Act,
				ActEventsLC 	pParent)
    {

	ParentGUIMenu=pGUIMenu;
	ControlIt=Act;

	ControlIt.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.alt.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.isa.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.venvmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vdividermass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vliftcellmass.addActionListener(this);
	//ParentGUIMenu.ParentGUI.CenterAll.vmotormass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vpropmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vavmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vtrussmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vpsmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vwiremass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vwetmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vballastmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.liftgasmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.liftgascuft.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.ballonetgasmass.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vlength.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vdiameterw.addActionListener(this);
	ParentGUIMenu.ParentGUI.CenterAll.vdiameterh.addActionListener(this);

	Parent=pParent;

    }//end of ActCalcEventsLC Menu constructor

/**
 * This is the actual action to be performed by this member of the Action menu.
 * It will be made more sophisticated soon when it can distinguish which item on
 * the GUI sent the action and then issue the correct set of orders to the
 * physical model and other GUI parts.
 */
    public void actionPerformed(ActionEvent evt)
    {
	ParentGUIMenu.ParentGUI.CenterAll.takeAction();
    }//end of action performed method.


}//end of ActCalcEventsLC class

