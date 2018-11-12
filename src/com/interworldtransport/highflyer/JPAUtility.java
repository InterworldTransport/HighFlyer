/* <h2>Copyright</h2>
Copyright (c) 2004 Interworld Transport. All rights reserved.<br>
---com.interworldtransport.highflyer.JPAUtility------------------------------------------
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
---com.interworldtransport.highflyer.JPAUtility------------------------------------------
*/
package com.interworldtransport.highflyer;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
/**
 * The JPAUtility class will model the ISA JPAUtility for all platforms that
 * need information from such a model
 *
 * @version  0.10, $Date: 2005/06/05 07:08:59 $
 * @author   Dr Alfred W Differ
 * @since HighFlyer 0.1
 */
 /**
*@author author
*/
public class JPAUtility extends JFrame
{
/**
 * The Status Display Panel for the application.
 */
    public		UtilityStatusBar	StatusLine;
    public		JPanel			HeaderLine;
/** This class holds basic ini properties pulled from the configuration file.
 *  @see <a href="conf/JPAUtility.conf">JPAUtility Configuration File</a>
 */
    public		Properties		IniProps;
/** This FileWriter points to the actual save file for historical snapshot data
 */
    public		FileWriter		to;
    public		File 			fIni;
/**
 * This constant represents how many meters are in one foot
 * Its units are m/ft
 */
    public final static	double	MetricConversionLine=0.3048;
/**
 * This constant represents how many cubic meters are in one cubic foot
 * Its units are m^3/ft^3
 */
    public final static	double 	MetricConversionVol=Math.pow(0.3048, 3);

/**
 * This is the main constructor the the JPAUtility utility
 */
 	public JPAUtility(String pTitle, String pConfig) throws 	CantGetSaveException
	{
	  super(pTitle);

	  this.addWindowListener( new WindowAdapter()
	  	{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
	 );

	 Container cp=this.getContentPane();
	 this.getConfigProps(pConfig);
	 this.getSaveFile();

	 /*
	 * Time to construct the application status bar.
	 */
	this.StatusLine=new UtilityStatusBar();
	cp.add(StatusLine, "South");

	this.HeaderLine=new JPanel();
	cp.add(HeaderLine,"North");

	setLocation(200, 0);

	} //End of primary constructor

    protected void getConfigProps(String pConfName)
	{
	 this.fIni=null;
	 boolean bIni = false;
	 try
	 {
		 fIni=new File(pConfName);
		 bIni=fIni.exists();
		 if (bIni) bIni=fIni.isFile();
		 if (bIni) bIni=fIni.canRead();
		 if (!bIni) throw new CantGetIniException("The configuration file is not present or ready.");
		 //Getting here implied the configuration file has been found and readable

		 this.IniProps=new Properties(System.getProperties());
		 this.IniProps.load(new BufferedInputStream(new FileInputStream(fIni)));

	 }//end of try block
	 catch(Exception e)
	 {
		 System.out.println("IO Problem:  Incomplete Access to Associated INI files.");
		 //throw new CantGetIniException("No Access to INI file.");
	 }
	} //end of getConfigProps

/**
 * This method does the initial file handling for the snapshot save file.
 * It doesn't do much right now except check to see if the file is there.
 */
    protected void getSaveFile() throws CantGetSaveException
    {
	String SaveName = IniProps.getProperty("LiftCell.Desktop.Snapshot");
	//System.out.println("Save File is: "+ SaveName);
	File fSave=null;
	boolean bSave=false;
	try
	{
		fSave=new File(SaveName);
		bSave=fSave.exists();
		if (bSave) bSave=fSave.isFile();
		if (bSave) bSave=fSave.canWrite();
		if (!bSave)
		{
			throw new CantGetSaveException("No access to snapshot save file.");
		}
		//Getting here implies the Save file has been found and is writeable
		this.to=new FileWriter(fSave);
		//if (to!=null) System.out.println("Write file is not null");
		//else System.out.println("Write file is null");
	}//end of try block
	catch(IOException e)
	{
		System.out.println("IO Problem:  Incomplete Save file write");
		System.exit(0);
	}
	finally
	{
		//if (this.to == null) EphemerisSaveON=false;
		fSave=null;
	}
    }

/**
 * This method saves snapshot data to the save file.
 */
    protected void saveSnapshot(String pContent) throws IOException {
	this.to.write(pContent);
	this.to.write("\r\n");
	this.to.flush();
	}//end of saveSnapshot

    protected void terminateModel()
    {
	this.to=null;
	System.exit(0);
    }

} //End of JPAUtility Class
