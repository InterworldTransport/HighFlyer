/* <h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport. All rights reserved.<br>
---com.interworldtransport.highflyer.LiftCell------------------------------------------
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
---com.interworldtransport.highflyer.LiftCell------------------------------------------
*/
package com.interworldtransport.highflyer;
//import com.interworldtransport.clados.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//import javax.media.j3d.*;
//import javax.vecmath.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
/**
 * The LiftCell class will model the ISA LiftCell for all platforms that
 * need information from such a model
 *
 * @version  0.10, $Date: 2005/06/05 07:08:59 $
 * @author   Dr Alfred W Differ
 * @since HighFlyer 0.1
 */
 /**
*@author author
*/
public class LiftCell extends JPAUtility
{
/**
 * The Menu for the application.
 */
    public		LiftCellMenu		TheMenuBar;
/**
 * The EventModel for the application.
 */
    public		LiftCellEventModel	EventModel;
/**
 * The Center Display Panel for the application.
 */
    protected		LiftCellPanel		CenterAll;

/**
 * This is the main constructor the the LiftCell utility
 */
	public LiftCell(String pTitle, String pConfig) throws CantGetSaveException
	{
	  super(pTitle, pConfig);

	  this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		}
	 );

	 Container cp=this.getContentPane();

	 String splashFile=IniProps.getProperty("LiftCell.Desktop.SplashImage");
	 if (splashFile==null) splashFile="images/SplashImageLC.gif";

	 ClassLoader cl = this.getClass().getClassLoader();
	 ImageIcon splImg = new ImageIcon(cl.getResource(splashFile));
	 SplashWindow LiftCellSplash = new SplashWindow(splImg);

/*
 * Time to construct the application menu bar.
 */
	 this.TheMenuBar=new LiftCellMenu(this);
	 this.setJMenuBar(this.TheMenuBar);

/*
 * Time to construct the application center panels.
 */
	this.CenterAll=new LiftCellPanel(this);
	cp.add(CenterAll, "Center");


	this.HeaderLine.setBackground(new Color(192,192, 192));
	String logoFile=IniProps.getProperty("LiftCell.Desktop.HeaderImage");
	if (logoFile==null) logoFile="images/SplashImageLC2.gif";
	ClassLoader cl2 = this.getClass().getClassLoader();
	ImageIcon splImg2 = new ImageIcon(cl2.getResource(logoFile));
	HeaderLine.add(new JLabel(splImg2));

/*
 * Time to construct a the application event model now that enough of the GUI
 * exists.
 */
	 this.EventModel=new LiftCellEventModel(this.TheMenuBar);

	 if (LiftCellSplash != null)
	 {
	  LiftCellSplash.dispose();
	  LiftCellSplash=null;
	 }

	} //End of primary constructor

	protected void terminateModel()
	{
		System.exit(0);
	}

	public static void main(String[] args)
	{
	 String TitleName="LiftCell_Model";
	 String ConfName="./conf/LiftCell.conf";

	 if (args.length%2==1)
	 {
	  System.out.println("Usage: LiftCell [-t TitleString -c ConfigFile] ");
	  System.exit(0);
	 }

	 for (int i=0; i<args.length; i=i+2)
	 {
	  //System.out.println("Loop "+i+" "+args[i]+" "+args[i+1]);
	  if (args[i].equals("-t")) TitleName=args[i+1];
	  if (args[i].equals("-c")) ConfName=args[i+1];
	 }
	 try
	 {
		 JFrame fr = new LiftCell(TitleName, ConfName);
		 fr.pack();
		 fr.setVisible(true);
	 }
	 catch (UtilitiesException e)
	 {
		 System.out.println("Exception occured while constructing main GUI");
		 System.exit(0);
	 }

	}//end of main method

} //End of LiftCell Class
