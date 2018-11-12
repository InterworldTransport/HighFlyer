/*
<h2>Copyright</h2>
Copyright (c) 2002-2003 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.LiftCellPanel------------------------------------------
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
---com.interworldtransport.highflyer.LiftCellPanel------------------------------------------
 */

package com.interworldtransport.highflyer ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import com.jrefinery.chart.*;
import com.jrefinery.data.*;

/** com.interworldtransport.highflyer.LiftCellPanel
 * The LiftCellPanel class is intended to be the main panel of the LiftCell
 * utility.
 * <p>
 * @version 0.2, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */

 public class LiftCellPanel extends JPanel
{

    public	LiftCell		TheGUI;
    public	AirModel		TheAir;
    //public	EnvelopeModel		PortEnvelope;
    //public	EnvelopeModel		StarboardEnvelope;

    public	String			vname="Test_Vehicle";

    protected	JTextField		alt=new JTextField("0.00", 15);
    protected	JLabel			alttxt=new JLabel("meters");
    protected	JTextField		isa=new JTextField("0.00", 15);
    protected	JLabel			isatxt=new JLabel("K");

    protected	JTextField		temp=new JTextField("0.00", 15);
    protected	JLabel			temptxt=new JLabel("K");
    private	DefaultMeterDataset	datatemp;
    private	JFreeChart		chart;

    protected	JTextField		pres=new JTextField("0.00", 15);
    protected	JLabel			prestxt=new JLabel("mb");
    private	DefaultMeterDataset	datapress;
    private	JFreeChart		chart2;

    protected	JTextField		dens=new JTextField("0.00", 15);
    protected	JLabel			denstxt=new JLabel("kg/m^3");
    private	DefaultMeterDataset	datadens;
    private	JFreeChart		chart3;

    protected	JTextField		sound=new JTextField("0.00", 15);
    protected	JLabel			soundtxt=new JLabel("m/s");
    protected	JTextField		dynvisc=new JTextField("0.00", 15);
    protected	JLabel			dynvisctxt=new JLabel("kg/m*s");
    protected	JTextField		kinvisc=new JTextField("0.00", 15);
    protected	JLabel			kinvisctxt=new JLabel("m^2/s");
    protected	JTextField		conduct=new JTextField("0.00", 15);
    protected	JLabel			conducttxt=new JLabel("W/m*K");

    protected	JTextField		vmass=new JTextField("0.00", 15);
    protected	JTextField		venvmass=new JTextField("0.00", 15);
    protected	JTextField		vliftcellmass=new JTextField("0.00", 15);
    protected	JTextField		vdividermass=new JTextField("0.00", 15);
    //protected	JTextField		vmotormass=new JTextField("0.00", 15);
    protected	JTextField		vpropmass=new JTextField("0.00", 15);
    protected	JTextField		vavmass=new JTextField("0.00", 15);
    protected	JTextField		vtrussmass=new JTextField("0.00", 15);
    protected	JTextField		vpsmass=new JTextField("0.00", 15);
    protected	JTextField		vwiremass=new JTextField("0.00", 15);
    protected	JTextField		vwetmass=new JTextField("0.00", 15);
    protected	JTextField		vballastmass=new JTextField("0.00", 15);

    protected	JTextField		vlength=new JTextField("0.00", 15);
    protected	JTextField		vdiameterw=new JTextField("0.00", 15);
    protected	JTextField		vdiameterh=new JTextField("0.00", 15);
    protected	JTextField		clength=new JTextField("0.00", 15);
    protected	JTextField		cdiameter=new JTextField("0.00", 15);
    protected	JTextField		vfarea=new JTextField("0.00", 15);
    protected	JTextField		vsarea=new JTextField("0.00", 15);
    protected	JTextField		vbarea=new JTextField("0.00", 15);
    protected	JTextField		grosslift=new JTextField("0.00", 15);
    protected	JTextField		netlift=new JTextField("0.00", 15);

    protected	JTextField		vspeed=new JTextField("0.00", 15);
    protected	JTextField		dynlift=new JTextField("0.00", 15);
    protected	JTextField		dyndrag=new JTextField("0.00", 15);
    protected	JTextField		yawl=new JTextField("0.00", 15);
    protected	JTextField		yawr=new JTextField("0.00", 15);
    protected	JTextField		pitch=new JTextField("0.00", 15);
    protected	JTextField		roll=new JTextField("0.00", 15);

    protected	JTextField		liftgasmass=new JTextField("0.00", 15);
    protected	JTextField		liftgascuft=new JTextField("0.00", 15);
    protected	JTextField		ballonetgasmass=new JTextField("0.00", 15);

    protected	JTextField		liftcellavail=new JTextField("0.00", 15);
    protected	JTextField		liftcellpct=new JTextField("0.00", 15);
    private	DefaultMeterDataset	dataliftcell;
    private	JFreeChart		chart4;

    protected	JTextField		ballonetcellpct=new JTextField("0.00", 15);
    protected	JTextField		ballonetcellpress=new JTextField("0.00", 15);
    private	DefaultMeterDataset	datadpress;
    private	JFreeChart		chart5;

    private	double			LiftGasMass;
    private	double			LiftGasCUFt;
    private	double			BallonetGasMass;
    private	double			LiftCellVolume;
    private	double			LiftCellVolUsed;
    private	double			BallonetCellVolUsed;
    private	double			BallonetCellPressure;

    private	double			VehicleLength;
    private	double			VehicleDiameterW;
    private	double			VehicleDiameterH;
    private	double			CellLength;
    private	double			CellDiameter;
    private	double			FrontArea;
    private	double			PlanArea;
    private	double			SideArea;
    private	double			EnvSurfaceArea;
    private	double			DivSurfaceArea;
    private	double			CellSurfaceArea;
    private	int			DividerCount;

    private	double			VehicleMass;
    private	double			LiftEnvelopeDensity;
    private	double			LiftCellDensity;
    private	double			CellDividerDensity;
    private	double			MotorMass;
    private	double			PropMass;
    private	double			AvionicsMass;
    private	double			TrussMass;
    private	double			PowerSupplyMass;
    private	double			WiringMass;
    private	double			WetMass;
    private	double			BallastMass;

    private	double			VehicleSpeed;
    private	double			DynLift;
    private	double			DynDrag;

    private	double			VehicleYawLeft;
    private	double			VehicleYawRight;
    private	double			VehiclePitch;
    private	double			VehicleRoll;

    private	double			DensHeZero;
    private	double			BallonetBurst;

/**
 * This constant represents the gravitational constant 'g' near the Earth's
 * surface.
 * Its units are m/s^2
 */
    private final static double			Gravity = -9.80665d;
/**
 * This constant represents the gas constant found in the ideal gas law.
 * It's units are Nm/kgK
 */
    private final static double			GasR = 287.05287d;

/**
 * The LiftCellPanel class is intended to be the center panel of the Lift Cell
 * Utility application.  Most everything important is displayed on this panel.
 */
    public LiftCellPanel(LiftCell pGUI)
    {
	super();
	if (pGUI!=null)
	{
		this.TheGUI=pGUI;
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.getIniProps();
		this.TheAir=new AirModel(
			TheGUI,
			"Terran Model Atmoshere"
			);
		//this.BouyantCell=new CellModel(
		//			TheGui,
		//			TheAir,
		//			"A Lift Cell"
		//			);

		this.createLayout();
		this.takeAction();
	}
	else
	{
		System.out.println("A GUI must be passed to the StatusLine");
		System.exit(0);
	}

    }

    public void createLayout()
    {
	JTabbedPane TextBlock = new JTabbedPane(JTabbedPane.TOP);

	//Start the ambient air panel

	JPanel block1 = new JPanel();
	block1.setBorder(BorderFactory.createEtchedBorder());
	block1.setBackground(new Color(128, 128, 192, 32));
	block1.setLayout(new GridBagLayout());
	GridBagConstraints cn1 = new GridBagConstraints();
	cn1.insets = new Insets(0, 2, 0, 2);
	cn1.fill=1;
	cn1.anchor=GridBagConstraints.EAST;

	cn1.gridx = 0;
	cn1.gridy=0;
	block1.add(new JLabel("Current Altitude", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	//alt.setToolTipText("Altitude of Cell above sea level");
	block1.add(alt, cn1);
	cn1.gridx++;
	block1.add(alttxt, cn1);
	cn1.gridx++;
	block1.add(new JLabel("Sound Speed", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	//sound.setToolTipText("Speed of Sound at altitude");
	sound.setEditable(false);
	block1.add(sound, cn1);
	cn1.gridx++;
	block1.add(soundtxt, cn1);

	cn1.gridx = 0;
	cn1.gridy++;
	block1.add(new JLabel("Temperature Offset", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	//isa.setToolTipText("Temperature difference with respect to ISA model");
	block1.add(isa, cn1);
	cn1.gridx++;
	block1.add(isatxt, cn1);
	cn1.gridx++;
	block1.add(new JLabel("Dynamic Viscosity", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	//dynvisc.setToolTipText("Coefficient of Viscosity");
	dynvisc.setEditable(false);
	block1.add(dynvisc, cn1);
	cn1.gridx++;
	block1.add(dynvisctxt, cn1);

	cn1.gridx = 0;
	cn1.gridy++;
	block1.add(new JLabel("Air Temperature", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	temp.setEditable(false);
	temp.setHorizontalAlignment(JTextField.LEFT);
	//temp.setToolTipText("ISA Model predicted temperature");
	block1.add(temp, cn1);
	cn1.gridx++;
	block1.add(temptxt, cn1);
	cn1.gridx++;
	block1.add(new JLabel("Kinematic Viscosity", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	//kinvisc.setToolTipText("Coefficient of Viscosity");
	kinvisc.setEditable(false);
	block1.add(kinvisc, cn1);
	cn1.gridx++;
	block1.add(kinvisctxt, cn1);

	cn1.gridx = 0;
	cn1.gridy++;
	block1.add(new JLabel("Air Pressure", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	pres.setEditable(false);
	pres.setHorizontalAlignment(JTextField.LEFT);
	//pres.setToolTipText("ISA Model predicted pressure");
	block1.add(pres, cn1);
	cn1.gridx++;
	block1.add(prestxt, cn1);
	cn1.gridx++;
	block1.add(new JLabel("Conductivity", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	//conduct.setToolTipText("Coefficient of Conductivity");
	conduct.setEditable(false);
	block1.add(conduct, cn1);
	cn1.gridx++;
	block1.add(conducttxt, cn1);

	cn1.gridx = 0;
	cn1.gridy++;
	block1.add(new JLabel("Air Density", SwingConstants.RIGHT), cn1);
	cn1.gridx++;
	dens.setEditable(false);
	dens.setHorizontalAlignment(JTextField.LEFT);
	//dens.setToolTipText("ISA Model predicted density");
	block1.add(dens, cn1);
	cn1.gridx++;
	block1.add(denstxt, cn1);


	TextBlock.addTab("Environment", null, block1, null);

	//Finish the ambient air panel
	//Start LIft Cell and Ballonet section

	JPanel block2 = new JPanel();
	block2.setBorder(BorderFactory.createEtchedBorder());
	block2.setBackground(new Color(64, 128, 255, 32));
	block2.setLayout(new GridBagLayout());
	GridBagConstraints cn2 = new GridBagConstraints();
	cn2.insets = new Insets(0, 2, 0, 2);
	cn2.fill=1;
	cn2.anchor=GridBagConstraints.EAST;
	cn2.gridx = 1;
	cn2.gridy=0;
	block2.add(new JLabel("Lift Cell Column"), cn2);
	cn2.gridx = 4;
	block2.add(new JLabel("Ballonet Column"), cn2);

	cn2.gridx = 0;
	cn2.gridy++;
	block2.add(new JLabel("Available", SwingConstants.RIGHT), cn2);
	cn2.gridx++;
	liftcellavail.setEditable(false);
	block2.add(liftcellavail, cn2);
	cn2.gridx++;
	block2.add(new JLabel("m^3"), cn2);

	cn2.gridx = 0;
	cn2.gridy++;
	block2.add(new JLabel("Used", SwingConstants.RIGHT), cn2);
	cn2.gridx++;
	liftcellpct.setEditable(false);
	liftcellpct.setHorizontalAlignment(JTextField.LEFT);
	block2.add(liftcellpct, cn2);
	cn2.gridx++;
	block2.add(new JLabel("m^3"), cn2);
	cn2.gridx+=2;
	ballonetcellpct.setEditable(false);
	ballonetcellpct.setHorizontalAlignment(JTextField.LEFT);
	block2.add(ballonetcellpct, cn2);
	cn2.gridx++;
	block2.add(new JLabel("m^3"), cn2);

	cn2.gridx = 0;
	cn2.gridy++;
	block2.add(new JLabel("Mass", SwingConstants.RIGHT), cn2);
	cn2.gridx++;
	//liftgasmass.setEditable(false);
	liftgasmass.setHorizontalAlignment(JTextField.LEFT);
	block2.add(liftgasmass, cn2);
	cn2.gridx++;
	block2.add(new JLabel("kg"), cn2);
	cn2.gridx+=2;
	ballonetgasmass.setHorizontalAlignment(JTextField.LEFT);
	block2.add(ballonetgasmass, cn2);
	cn2.gridx++;
	block2.add(new JLabel("kg"), cn2);

	cn2.gridy++;
	cn2.gridx=0;
	block2.add(new JLabel("cu ft STP", SwingConstants.RIGHT), cn2);
	cn2.gridx++;
	liftgascuft.setHorizontalAlignment(JTextField.LEFT);
	block2.add(liftgascuft, cn2);
	cn2.gridx++;
	block2.add(new JLabel("ft^3"), cn2);

	cn2.gridy++;
	cn2.gridx=3;
	block2.add(new JLabel("dPressure", SwingConstants.RIGHT), cn2);
	cn2.gridx++;
	ballonetcellpress.setEditable(false);
	ballonetcellpress.setHorizontalAlignment(JTextField.LEFT);
	block2.add(ballonetcellpress, cn2);
	cn2.gridx++;
	block2.add(new JLabel("mb"), cn2);
	//block2.setMinimumSize(block2.getMinimumSize());

	TextBlock.addTab("Lift Cell", null, block2, null);

	//Finish LIft Cell and Ballonet section
		//Start the vehicle panel

	JPanel block4 = new JPanel();
	block4.setBorder(BorderFactory.createEtchedBorder());
	block4.setMinimumSize(new Dimension(200, 300));
	block4.setBackground(new Color(192, 128, 128, 32));
	block4.setLayout(new GridBagLayout());
	GridBagConstraints cn4 = new GridBagConstraints();
	cn4.insets = new Insets(0, 2, 0, 2);
	cn4.fill=1;
	cn4.anchor=GridBagConstraints.EAST;

	cn4.gridx = 0;
	cn4.gridy = 0;
	block4.add(new JLabel("Cell Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vliftcellmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vliftcellmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Envelope Length", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vlength.setHorizontalAlignment(JTextField.LEFT);
	//vlength.setToolTipText("Drag derived from forward motion");
	block4.add(vlength, cn4);
	cn4.gridx++;
	block4.add(new JLabel("meters"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Divider Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vdividermass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vdividermass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Envelope Width", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vdiameterw.setHorizontalAlignment(JTextField.LEFT);
	//vdiamter.setToolTipText("Wing roll angle");
	block4.add(vdiameterw, cn4);
	cn4.gridx++;
	block4.add(new JLabel("meters"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Envelope Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	venvmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(venvmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Envelope Height", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vdiameterh.setHorizontalAlignment(JTextField.LEFT);
	//vdiamter.setToolTipText("Wing roll angle");
	block4.add(vdiameterh, cn4);
	cn4.gridx++;
	block4.add(new JLabel("meters"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Power Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vpsmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vpsmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Cell Length", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	clength.setHorizontalAlignment(JTextField.LEFT);
	//vlength.setToolTipText("Drag derived from forward motion");
	block4.add(clength, cn4);
	cn4.gridx++;
	block4.add(new JLabel("meters"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Wiring Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vwiremass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vwiremass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Cell Diameter", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	cdiameter.setHorizontalAlignment(JTextField.LEFT);
	//vdiamter.setToolTipText("Wing roll angle");
	block4.add(cdiameter, cn4);
	cn4.gridx++;
	block4.add(new JLabel("meters"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Avionics Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vavmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vavmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Plan Area", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vbarea.setEditable(false);
	vbarea.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vbarea, cn4);
	cn4.gridx++;
	block4.add(new JLabel("m^2"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Propulsion Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vpropmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vpropmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Front Area", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vfarea.setEditable(false);
	vfarea.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vfarea, cn4);
	cn4.gridx++;
	block4.add(new JLabel("m^2"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Truss Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vtrussmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vtrussmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Side Area", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vsarea.setEditable(false);
	vsarea.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vsarea, cn4);
	cn4.gridx++;
	block4.add(new JLabel("m^2"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Wet Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vwetmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vwetmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Gross Lift", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	grosslift.setEditable(false);
	grosslift.setHorizontalAlignment(JTextField.LEFT);
	//grosslift.setToolTipText("Lift provided by lifting gas in cell");
	block4.add(grosslift, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	//block4.add(new JLabel("Motor Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	//vmotormass.setHorizontalAlignment(JTextField.LEFT);
	//block4.add(vmotormass, cn4);
	cn4.gridx++;
	//block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Buoyant Lift", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	netlift.setEditable(false);
	netlift.setHorizontalAlignment(JTextField.LEFT);
	//netlift.setToolTipText("Remaining lift after weight");
	block4.add(netlift, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);

	cn4.gridx = 0;
	cn4.gridy++;
	block4.add(new JLabel("Ballast", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	vballastmass.setHorizontalAlignment(JTextField.LEFT);
	block4.add(vballastmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);
	cn4.gridx++;
	block4.add(new JLabel("Total Mass", SwingConstants.RIGHT), cn4);
	cn4.gridx++;
	//vmass.setToolTipText("Vehicle mass including payload minus lift and ballonet gas");
	block4.add(vmass, cn4);
	cn4.gridx++;
	block4.add(new JLabel("kg"), cn4);


	TextBlock.addTab("Vehicle Statics", null, block4, null);

	JPanel block5 = new JPanel();
	block5.setBorder(BorderFactory.createEtchedBorder());
	block5.setMinimumSize(new Dimension(200, 300));
	block5.setBackground(new Color(192, 128, 128, 32));
	block5.setLayout(new GridBagLayout());
	GridBagConstraints cn5 = new GridBagConstraints();
	cn5.insets = new Insets(0, 2, 0, 2);
	cn5.fill=1;
	cn5.anchor=GridBagConstraints.EAST;

	cn5.gridx = 3;
	cn5.gridy = 0;
	block5.add(new JLabel("Left Yaw", SwingConstants.RIGHT), cn5);
	cn5.gridx++;
	//yawl.setToolTipText("Left wing yaw angle");
	block5.add(yawl, cn5);
	cn5.gridx++;
	block5.add(new JLabel("degrees"), cn5);

	cn5.gridx = 0;
	cn5.gridy++;
	block5.add(new JLabel("Air Speed", SwingConstants.RIGHT), cn5);
	cn5.gridx++;
	//vspeed.setToolTipText("Forward speed of vehicle");
	block5.add(vspeed, cn5);
	cn5.gridx++;
	block5.add(new JLabel("m/s"), cn5);
	cn5.gridx++;
	block5.add(new JLabel("Right Yaw", SwingConstants.RIGHT), cn5);
	cn5.gridx++;
	//yawr.setToolTipText("Right wing yaw angle");
	block5.add(yawr, cn5);
	cn5.gridx++;
	block5.add(new JLabel("degrees"), cn5);

	cn5.gridx = 0;
	cn5.gridy++;
	block5.add(new JLabel("Dynamic Lift", SwingConstants.RIGHT), cn5);
	cn5.gridx++;
	dynlift.setEditable(false);
	dynlift.setHorizontalAlignment(JTextField.LEFT);
	//dynlift.setToolTipText("Lift derived from forward motion");
	block5.add(dynlift, cn5);
	cn5.gridx++;
	block5.add(new JLabel("kg"), cn5);
	cn5.gridx++;
	block5.add(new JLabel("Pitch", SwingConstants.RIGHT), cn5);
	cn5.gridx++;
	//pitch.setToolTipText("Wing pitch angle");
	block5.add(pitch, cn5);
	cn5.gridx++;
	block5.add(new JLabel("degrees"), cn5);

	cn5.gridx = 0;
	cn5.gridy++;
	block5.add(new JLabel("Dynamic Drag", SwingConstants.RIGHT), cn5);
	cn5.gridx++;
	dyndrag.setEditable(false);
	dyndrag.setHorizontalAlignment(JTextField.LEFT);
	//dyndrag.setToolTipText("Drag derived from forward motion");
	block5.add(dyndrag, cn5);
	cn5.gridx++;
	block5.add(new JLabel("kg m/s^2"), cn5);
	cn5.gridx++;
	block5.add(new JLabel("Roll", SwingConstants.RIGHT), cn5);
	cn5.gridx++;
	//roll.setToolTipText("Wing roll angle");
	roll.setEditable(false);
	block5.add(roll, cn5);
	cn5.gridx++;
	block5.add(new JLabel("degrees"), cn5);

	TextBlock.addTab("Vehicle Dynamics", null, block5, null);

	this.add(TextBlock, "North");
	//finish the vehicle panel

	//Start Chart section
	datatemp = new DefaultMeterDataset(new Double(70), new Double(300), new Double(288.15), "K");
	//datatemp.setNormalRange(new Double(180), new Double(240));
        //datatemp.setWarningRange(new Double(240), new Double(290));
        //datatemp.setCriticalRange(new Double(290), new Double(300));

	datapress = new DefaultMeterDataset(new Double(0), new Double(1020.0), new Double(1013.250), "mb");
	datapress.setNormalRange(new Double(0.0), new Double(200.0));
	datapress.setWarningRange(new Double(200.0), new Double(500.0));
	datapress.setCriticalRange(new Double(500.0), new Double(1020.0));

	datadens = new DefaultMeterDataset(new Double(0), new Double(1.3), new Double(1.225), "kg/m^3");
	datadens.setNormalRange(new Double(0), new Double(1.0));
	datadens.setWarningRange(new Double(1.0), new Double(1.225));
	datadens.setCriticalRange(new Double(1.225), new Double(1.30));

	datadpress = new DefaultMeterDataset(new Double(0), new Double(BallonetBurst), new Double(0), "mb");
	datadpress.setNormalRange(new Double(0.0), new Double(BallonetBurst*0.5));
	datadpress.setWarningRange(new Double(BallonetBurst*0.5), new Double(BallonetBurst*0.9));
	datadpress.setCriticalRange(new Double(BallonetBurst*0.9), new Double(BallonetBurst));

	dataliftcell = new DefaultMeterDataset(new Double(0), new Double(100.0), new Double(0), "% Used");
	dataliftcell.setNormalRange(new Double(0), new Double(80.0));
	dataliftcell.setWarningRange(new Double(80.0), new Double(90.0));
	dataliftcell.setCriticalRange(new Double(90.0), new Double(100.0));


	ThermometerPlot plot = new ThermometerPlot(datatemp);
	plot.setInsets(new Insets(5, 5, 5, 5));
	plot.setThermometerStroke(new BasicStroke(1.0f));
        plot.setThermometerPaint(Color.blue);
	plot.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
	plot.setUnits(ThermometerPlot.UNITS_KELVIN);
	plot.setUpperBound(300.0d);
	plot.setLowerBound(90.0d);

        chart = new JFreeChart("Air Temp", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
	chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
	ChartPanel chartp=new ChartPanel(chart);

	MeterPlot plot2 = new MeterPlot(datapress);
	plot2.setDialType(2);
	plot2.setNeedlePaint(Color.white);
        plot2.setTickLabelFont(new Font("SansSerif", Font.BOLD, 9));
	plot2.setInsets(new Insets(5, 5, 5, 5));
	chart2 = new JFreeChart("Air Pressure", JFreeChart.DEFAULT_TITLE_FONT, plot2, false);
	chart2.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
	ChartPanel chartp2=new ChartPanel(chart2);

	MeterPlot plot3 = new MeterPlot(datadens);
	plot3.setDialType(2);
	plot3.setNeedlePaint(Color.white);
        plot3.setTickLabelFont(new Font("SansSerif", Font.BOLD, 9));
	plot3.setInsets(new Insets(5, 5, 5, 5));
	chart3 = new JFreeChart("Air Density", JFreeChart.DEFAULT_TITLE_FONT, plot3, false);
	chart3.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
	ChartPanel chartp3=new ChartPanel(chart3);

	MeterPlot plot4 = new MeterPlot(datadpress);
	plot4.setDialType(2);
	plot4.setNeedlePaint(Color.white);
        plot4.setTickLabelFont(new Font("SansSerif", Font.BOLD, 9));
	plot4.setInsets(new Insets(5, 5, 5, 5));
	chart4 = new JFreeChart("Burst Pressure", JFreeChart.DEFAULT_TITLE_FONT, plot4, false);
	chart4.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
	ChartPanel chartp4=new ChartPanel(chart4);

	MeterPlot plot5 = new MeterPlot(dataliftcell);
	plot5.setDialType(2);
	plot5.setNeedlePaint(Color.white);
        plot5.setTickLabelFont(new Font("SansSerif", Font.BOLD, 9));
	plot5.setInsets(new Insets(5, 5, 5, 5));
	chart5 = new JFreeChart("Lift Cell % In Use", JFreeChart.DEFAULT_TITLE_FONT, plot5, false);
	chart5.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
	ChartPanel chartp5=new ChartPanel(chart5);

	JTabbedPane block3 = new JTabbedPane(JTabbedPane.RIGHT);
	block3.setBackground(new Color(64, 64, 255, 32));
	//block3.setBorder(BorderFactory.createEtchedBorder());
	block3.addTab("Temperature", null, chartp, null);
	block3.addTab("Pressure", null, chartp2, null);
	block3.addTab("Density", null, chartp3, null);
	block3.addTab("Lift Cell Used", null, chartp5, null);
	block3.addTab("dPressure", null, chartp4, null);
	//block3.addTab("Ambient Air", null, AirBlock, null);
	//block3.addTab("Lift Cell Used", null, LiftCellBlock, null);
	block3.setMaximumSize(new Dimension(300, 100));

	this.add(block3, "Center");
	//Finish Chart section

	//takeAction();
    }

/**
 *
 */
    public	void	takeSnapshot(int pFirst)
    {
	    //write out the content string and then send it to the GUI for
	    //writing to the output file.

	    StringBuffer content = new StringBuffer();
	    if (pFirst==0)
	    {
	    content.append(vname);
	    content.append(", ");
	    content.append(alt.getText());
	    content.append(", ");
	    content.append(isa.getText());
	    content.append(", ");
	    content.append(temp.getText());
	    content.append(", ");
	    content.append(pres.getText());
	    content.append(", ");
	    content.append(dens.getText());
	    content.append(", ");
	    content.append(liftgasmass.getText());
	    content.append(", ");
	    content.append(liftgascuft.getText());
	    content.append(", ");
	    content.append(ballonetgasmass.getText());
	    content.append(", ");
	    content.append(liftcellavail.getText());
	    content.append(", ");
	    content.append(liftcellpct.getText());
	    content.append(", ");
	    content.append(ballonetcellpct.getText());
	    content.append(", ");
	    content.append(ballonetcellpress.getText());
	    content.append(", ");
	    content.append(vmass.getText());
	    content.append(", ");
	    content.append(grosslift.getText());
	    content.append(", ");
	    content.append(netlift.getText());
	    content.append(", ");
	    content.append(vlength.getText());
	    content.append(", ");
	    content.append(vdiameterw.getText());
	    content.append(", ");
	    content.append(vdiameterh.getText());
	    content.append(", ");
	    content.append(vspeed.getText());
	    content.append(", ");
	    content.append(dynlift.getText());
	    content.append(", ");
	    content.append(dyndrag.getText());
	    content.append(", ");
	    content.append(yawl.getText());
	    content.append(", ");
	    content.append(yawr.getText());
	    content.append(", ");
	    content.append(pitch.getText());
	    content.append(", ");
	    content.append(roll.getText());
	    }
	    else
	    {
	    content.append("name, alt, isa, temp, pres, dens, ");
	    content.append("liftgasmass, liftgascuft, ballonetgasmass, ");
	    content.append("liftcellavail, liftcellpct, ballonetcellpct, ");
	    content.append("ballonetcellpress, ");
	    content.append("vmass, grosslift, netlift, length, diameter, ");
	    content.append("speed, dynamic lift, dynamic drag, left yaw, ");
	    content.append("right yaw, pitch, roll");
	    }

	    String contentstring = new String(content);
	    try
	    {
		    TheGUI.saveSnapshot(contentstring);
	    }
	    catch (IOException e)
	    {
		    System.exit(0);
	    }
    }

/**
 * This is the method to call when an action event on a button or menu calls
 * for fields in the panel to be recalculated.  At present, any changes to the
 * altitude and ISA Offset can trigger a recalculation.  Later, changes to the
 * lifting gas or ballonet gas masses will trigger recalculations.
 */
    public void takeAction()
    {
	this.findAlt();
	this.findISAOffset();
	this.calcTemp();
	this.calcPres();
	this.calcDens();

	this.findVehicleMass();
	this.findLiftGasMass();
	this.findBallonetGasMass();

	this.calcAreas();
	this.findLiftCellVolume();

	this.calcCellPct();
	this.calcGrossLift();
	this.calcNetLift();

	this.setStatus("Recalculated atmosphere and lifting cell values.");
    }

    public	void	getIniProps()
    {
	String vName = TheGUI.IniProps.getProperty("Vehicle.Name");
	String tempDHeZero = TheGUI.IniProps.getProperty("Atmosphere.SeaLevel.DensityHe");

	String tempVELength = TheGUI.IniProps.getProperty("Vehicle.Envelope.Length");
	String tempVEDiamW = TheGUI.IniProps.getProperty("Vehicle.Envelope.DiameterW");
	String tempVEDiamH = TheGUI.IniProps.getProperty("Vehicle.Envelope.DiameterH");
	String tempDivCount = TheGUI.IniProps.getProperty("Vehicle.Divider.Count");
	String tempVCLength = TheGUI.IniProps.getProperty("Vehicle.Cell.Length");
	String tempVCDiam = TheGUI.IniProps.getProperty("Vehicle.Cell.Diameter");

	String tempVMass = TheGUI.IniProps.getProperty("Vehicle.GrossMass");
	String tERo= TheGUI.IniProps.getProperty("Vehicle.Envelope.Density");
	String tLCRo= TheGUI.IniProps.getProperty("Vehicle.LiftCell.Density");
	String tCDRo= TheGUI.IniProps.getProperty("Vehicle.CellDivider.Density");
	//String tMotorMass= TheGUI.IniProps.getProperty("Vehicle.Motor.Mass");
	String tPropMass= TheGUI.IniProps.getProperty("Vehicle.Propeller.Mass");
	String tAvMass= TheGUI.IniProps.getProperty("Vehicle.Avionics.Mass");
	String tFrMass= TheGUI.IniProps.getProperty("Vehicle.Truss.Mass.Density");
	String tPSMass= TheGUI.IniProps.getProperty("Vehicle.PowerSupply.Mass");
	String tWireMass= TheGUI.IniProps.getProperty("Vehicle.Wiring.Mass.Density");
	String tWetMass= TheGUI.IniProps.getProperty("Vehicle.Wet.Mass");
	String tBallastMass= TheGUI.IniProps.getProperty("Vehicle.Ballast.Mass");

	String tempVyawl = TheGUI.IniProps.getProperty("Vehicle.Initial.YawL");
	String tempVyawr = TheGUI.IniProps.getProperty("Vehicle.Initial.YawR");
	String tempVpitch = TheGUI.IniProps.getProperty("Vehicle.Initial.Pitch");
	String tempVroll = TheGUI.IniProps.getProperty("Vehicle.Initial.Roll");
	String tempBBurst = TheGUI.IniProps.getProperty("Ballonet.BurstPressure");

	this.DensHeZero = new Double(tempDHeZero).doubleValue();

	this.VehicleLength = new Double(tempVELength).doubleValue();
	this.vlength.setText(tempVELength);
	this.VehicleDiameterW = new Double(tempVEDiamW).doubleValue();
	this.VehicleDiameterH = new Double(tempVEDiamH).doubleValue();
	this.vdiameterw.setText(tempVEDiamW);
	this.vdiameterh.setText(tempVEDiamH);
	this.DividerCount = new Integer(tempDivCount).intValue();
	this.CellLength = new Double(tempVCLength).doubleValue();
	this.clength.setText(tempVCLength);
	this.CellDiameter = new Double(tempVCDiam).doubleValue();
	this.cdiameter.setText(tempVCDiam);
	this.calcAreas();

	this.VehicleMass = new Double(tempVMass).doubleValue();
	this.vmass.setText(tempVMass);
	//this.MotorMass = new Double(tMotorMass).doubleValue();
	//this.vmotormass.setText(tMotorMass);
	this.PropMass = new Double(tPropMass).doubleValue();
	this.vpropmass.setText(tPropMass);
	this.AvionicsMass = new Double(tAvMass).doubleValue();
	this.vavmass.setText(tAvMass);
	
	this.TrussMass = new Double(tFrMass).doubleValue();
	this.TrussMass*=this.VehicleLength*2.4;
	this.vtrussmass.setText(new Double(this.TrussMass).toString());
	
	this.PowerSupplyMass = new Double(tPSMass).doubleValue();
	this.vpsmass.setText(tPSMass);
	
	this.WiringMass = new Double(tWireMass).doubleValue();
	this.WiringMass *= this.VehicleLength*1.4;
	this.vwiremass.setText(new Double(this.WiringMass).toString());
	
	this.WetMass = new Double(tWetMass).doubleValue();
	this.vwetmass.setText(tWetMass);
	this.BallastMass = new Double(tBallastMass).doubleValue();
	this.vballastmass.setText(tBallastMass);

	this.LiftEnvelopeDensity = new Double(tERo).doubleValue();
	this.setEnvMass();
	this.CellDividerDensity = new Double(tCDRo).doubleValue();
	this.setDivMass();
	this.LiftCellDensity = new Double(tLCRo).doubleValue();
	this.setCellMass();

	this.VehicleYawLeft = new Double(tempVyawl).doubleValue();
	this.VehicleYawRight = new Double(tempVyawr).doubleValue();
	this.VehiclePitch = new Double(tempVpitch).doubleValue();
	this.VehicleRoll = new Double(tempVroll).doubleValue();
	this.BallonetBurst = new Double(tempBBurst).doubleValue();
    }

    public void setEnvMass()
    {
	    double tenvmass1=LiftEnvelopeDensity*EnvSurfaceArea;
	    this.venvmass.setText(new Double(tenvmass1).toString());
    }

    public void setDivMass()
    {
	    double tdivmass1=CellDividerDensity*DivSurfaceArea;
	    this.vdividermass.setText(new Double(tdivmass1).toString());
    }

    public void setCellMass()
    {
	    double tcellmass1=LiftCellDensity*CellSurfaceArea;
	    this.vliftcellmass.setText(new Double(tcellmass1).toString());
    }

    public void getEnvMass()
    {
	    double tempmass = new Double(this.venvmass.getText()).doubleValue();
	    double tenvro1=tempmass/EnvSurfaceArea;
	    LiftEnvelopeDensity=tenvro1;
    }

    public void getDivMass()
    {
	    double tempmass = new Double(this.vdividermass.getText()).doubleValue();
	    double tdivro1=tempmass/DivSurfaceArea;
	    CellDividerDensity=tdivro1;
    }

    public void getCellMass()
    {
	    double tempmass = new Double(this.vliftcellmass.getText()).doubleValue();
	    double tcellro1=tempmass/CellSurfaceArea;
	    LiftCellDensity=tcellro1;
    }

    public void findAlt()
    {
	TheAir.setGeometricAltitude(new Double(this.alt.getText()).doubleValue());
	//TheAir.setAltitude(new Double(this.alt.getText()).doubleValue());
    }

    public void findISAOffset()
    {
	TheAir.setTemperatureOffset(new Double(this.isa.getText()).doubleValue());
    }

    public void calcTemp()
    {
	TheAir.calcTemperature();

	this.temp.setText(new Double(TheAir.getTemperature() + TheAir.getTemperatureOffset()).toString());
	datatemp.setValue(TheAir.getTemperature()+TheAir.getTemperatureOffset());
    }

    public void calcPres()
    {
	TheAir.calcPressure();

	this.pres.setText(new Double(TheAir.getPressure()/100).toString());
	datapress.setValue(TheAir.getPressure()/100);
    }

    public void calcDens()
    {
	TheAir.calcDensity();

	this.dens.setText(new Double(TheAir.getDensity()).toString());
	datadens.setValue(TheAir.getDensity());
    }


    public void findVehicleMass()
    {
	double tempVehicleMass=new Double(this.vmass.getText()).doubleValue();
	double tothers[]=new double[11];
	tothers[0]=new Double(this.venvmass.getText()).doubleValue();
	tothers[1]=new Double(this.vdividermass.getText()).doubleValue();
	tothers[2]=new Double(this.vliftcellmass.getText()).doubleValue();
	//tothers[3]=new Double(this.vmotormass.getText()).doubleValue();
	tothers[4]=new Double(this.vpropmass.getText()).doubleValue();
	tothers[5]=new Double(this.vavmass.getText()).doubleValue();
	tothers[6]=new Double(this.vtrussmass.getText()).doubleValue();
	tothers[7]=new Double(this.vpsmass.getText()).doubleValue();
	tothers[8]=new Double(this.vwiremass.getText()).doubleValue();
	tothers[9]=new Double(this.vwetmass.getText()).doubleValue();
	tothers[10]=new Double(this.vballastmass.getText()).doubleValue();

	double tsum=0.0;
	for (int i=0; i<11; i++)
	{
		tsum+=tothers[i];
	}
	if (tsum > tempVehicleMass) //component masses weight more than vehicle
	{
		VehicleMass=tsum;
		this.vmass.setText(new Double(VehicleMass).toString());
	}
	else	//components weight less than vehicle so padding is occuring
	{
		VehicleMass=tempVehicleMass;
	}

    }

    public void findLiftGasMass()
    {
	double tempLiftGasMass=new Double(this.liftgasmass.getText()).doubleValue();
	if (tempLiftGasMass!=LiftGasMass)	LiftGasMass=tempLiftGasMass;

	String tempcuft=this.liftgascuft.getText();
	double tempLiftGasCUFt=new Double(tempcuft).doubleValue();
	//if (tempLiftGasCUFt>0.00d)
	//{
	//	if (tempLiftGasCUFt!=LiftGasCUFt)	LiftGasCUFt=tempLiftGasCUFt;
	//	tempLiftGasMass = LiftGasCUFt * DensHeZero*JPAUtility.MetricConversionVol;
	//	LiftGasMass=tempLiftGasMass;
	//	this.liftgasmass.setText(new Double(LiftGasMass).toString());
	//}
	//else
	//{
		LiftGasCUFt=(LiftGasMass/DensHeZero)/JPAUtility.MetricConversionVol;
		this.liftgascuft.setText(new Double(LiftGasCUFt).toString());
	//}

    }

    public void findLiftCellVolume()
    {
	double tempVEnvLength=new Double(this.vlength.getText()).doubleValue();
	if (tempVEnvLength!=VehicleLength)	VehicleLength=tempVEnvLength;
	double tempVEnvDiam=new Double(this.vdiameterw.getText()).doubleValue();
	if (tempVEnvDiam!=VehicleDiameterW)	VehicleDiameterW=tempVEnvDiam;
	double tempVEnvDiamH=new Double(this.vdiameterh.getText()).doubleValue();
	if (tempVEnvDiamH!=VehicleDiameterH)	VehicleDiameterH=tempVEnvDiamH;

	double tempLiftCellVolume=2.0*VehicleLength*Math.PI*
				(VehicleDiameterW/2.0)*(VehicleDiameterH/2.0);

	this.LiftCellVolume=tempLiftCellVolume;
	this.liftcellavail.setText(new Double(tempLiftCellVolume).toString());

    }

    public void findBallonetGasMass()
    {
	double tempBallonetGasMass=new Double(this.ballonetgasmass.getText()).doubleValue();
	if (tempBallonetGasMass!=BallonetGasMass)	BallonetGasMass=tempBallonetGasMass;
    }

    public void findVehicleSpeed()
    {
	double tempVehicleSpeed=new Double(this.vspeed.getText()).doubleValue();
	if (tempVehicleSpeed!=VehicleSpeed)	VehicleSpeed=tempVehicleSpeed;
    }

    public void findYawLeft()
    {
	double tempVehicleYawLeft=new Double(this.yawl.getText()).doubleValue();
	if (tempVehicleYawLeft!=VehicleYawLeft)	VehicleYawLeft=tempVehicleYawLeft;
    }

    public void findYawRight()
    {
	double tempVehicleYawRight=new Double(this.yawr.getText()).doubleValue();
	if (tempVehicleYawRight!=VehicleYawRight)	VehicleYawRight=tempVehicleYawRight;
    }

    public void findPitch()
    {
	double tempVehiclePitch=new Double(this.pitch.getText()).doubleValue();
	if (tempVehiclePitch!=VehiclePitch)	VehiclePitch=tempVehiclePitch;
    }

    public void findRoll()
    {
	double tempVehicleRoll=new Double(this.roll.getText()).doubleValue();
	if (tempVehicleRoll!=VehicleRoll)	VehicleRoll=tempVehicleRoll;
    }

/**
 * This method is responsible for calculating the percentage of the available
 * ballonet cell volume that is actually occupied by the ballonet gas.  It
 * does so by assuming the ballonet uses air and has the same density as the
 * outside atmosphere.
 */
    public	void	calcCellPct()
    {
	double tempBDensity=TheAir.getDensity();
	double tempLCDensity=TheAir.getDensity()*DensHeZero/TheAir.getBaseDensity();

	BallonetCellVolUsed=BallonetGasMass/tempBDensity;  //Volume occupied by Ballonet gas at altitude and ambient pressure
	LiftCellVolUsed=LiftGasMass/tempLCDensity;//Volume occupied by LC gas at altitude and ambient pressure

	//String op="";
	if (BallonetCellVolUsed+LiftCellVolUsed>LiftCellVolume)
	{	//One cell is overpressurized and will push against the other.
		tempLCDensity=tempLCDensity*(BallonetCellVolUsed+LiftCellVolUsed)/LiftCellVolume;
		tempBDensity=tempBDensity*(BallonetCellVolUsed+LiftCellVolUsed)/LiftCellVolume;

		BallonetCellVolUsed=BallonetCellVolUsed*LiftCellVolume/(BallonetCellVolUsed+LiftCellVolUsed);
		LiftCellVolUsed=LiftCellVolUsed*LiftCellVolume/(BallonetCellVolUsed+LiftCellVolUsed);
		//Both cells have been scaled proportionally.  This should keep
		//them at equal pressure.
		BallonetCellPressure=(BallonetGasMass/BallonetCellVolUsed)*GasR*(TheAir.getTemperature()+TheAir.getTemperatureOffset());
		if (BallonetGasMass==0.0d)
		{
			BallonetCellPressure=(TheAir.getBaseDensity()/DensHeZero)*(LiftGasMass/LiftCellVolume)*GasR*(TheAir.getTemperature()+TheAir.getTemperatureOffset());
		}
		//op=" :op";
	}
	else
	{
		BallonetCellPressure=TheAir.getPressure();
		//op=" :up";
	}
	//No check has been made yet to see if that much cell volume is actually
	//available for both cells.  Do we need to?  Not if the Ballonet can
	//completely displace the lift cell volume.  That would make them equal.

	ballonetcellpct.setText(new Double(BallonetCellVolUsed).toString());
	liftcellpct.setText(new Double(LiftCellVolUsed).toString());
	if (LiftCellVolUsed/(LiftCellVolume-BallonetCellVolUsed)<1)
	{
		dataliftcell.setValue(100.0*LiftCellVolUsed/(LiftCellVolume-BallonetCellVolUsed));
	}
	else dataliftcell.setValue(100.0);

	ballonetcellpress.setText(new Double(BallonetCellPressure-TheAir.getPressure()).toString());
	if (BallonetCellPressure-TheAir.getPressure()<BallonetBurst)
	{
		datadpress.setValue(BallonetCellPressure-TheAir.getPressure());
	}
	else datadpress.setValue(BallonetBurst);
    }

/**
 * This method is responsible for calculating the gross lift available due to
 * the displaced air volume.  Take the volume being used by the lift cell and
 * multiply by the density of the air outside.
 */
    public	void	calcGrossLift()
    {
	this.grosslift.setText(new Double(LiftCellVolUsed*TheAir.getDensity()).toString());
    }

/**
 * This method is responsible for calculating the net lift available due to
 * the displaced air volume and the vehicle mass.  Take the volume being
 * used by the lift cell, multiply by the density of the air outside, and then
 * subtract the vehicle mass.
 */
    public	void	calcNetLift()
    {
	this.netlift.setText(new Double(LiftCellVolUsed*TheAir.getDensity()-VehicleMass).toString());
    }

/**
 *
 */
    public	void	calcAreas()
    {
	    double tempFront=VehicleLength*VehicleDiameterW;
	    double tempEnvPerimeter=2.0*Math.PI*Math.sqrt((VehicleDiameterH*VehicleDiameterH+VehicleDiameterW*VehicleDiameterW)/2.0);
	    EnvSurfaceArea=2.0*VehicleLength*tempEnvPerimeter;
	    DivSurfaceArea=2.0*DividerCount*VehicleDiameterW/2.0*VehicleDiameterH/2.0*Math.PI;
	    CellSurfaceArea=2.0*(DividerCount+1)*CellLength*CellDiameter*Math.PI;

	    FrontArea=tempFront*Math.cos(VehicleYawLeft*Math.PI/180.0);
	    FrontArea+=tempFront*Math.cos(VehicleYawRight*Math.PI/180.0);
	    vfarea.setText(new Double(FrontArea).toString());

	    double tempSide1=tempFront*Math.sin(VehicleYawLeft*Math.PI/180.0);
	    double tempSide2=tempFront*Math.sin(VehicleYawRight*Math.PI/180.0);
	    if (tempSide1>tempSide2) SideArea=tempSide1;
	    else SideArea=tempSide2;
	    vsarea.setText(new Double(SideArea).toString());

	    PlanArea=2.0*tempFront*Math.cos(VehiclePitch*Math.PI/180.0);
	    vbarea.setText(new Double(PlanArea).toString());

    }

/**
 * This method resets the status bar with new information telling the user what
 * just happened.
 */
    public	void	setStatus(String pInfo)
    {
	TheGUI.StatusLine.setStatusMsg(pInfo);
	if (TheAir.getTemperatureOffset()<0.0d)	TheGUI.StatusLine.setWhere("ISA"+ this.isa.getText());
	else TheGUI.StatusLine.setWhere("ISA"+"+"+ this.isa.getText());
    }

}//End of LiftCellPanel class
