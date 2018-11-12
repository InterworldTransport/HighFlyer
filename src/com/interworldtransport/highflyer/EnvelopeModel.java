/*
<h2>Copyright</h2>
Copyright (c) 2003 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.EnvelopeModel--------------------------------------
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
---com.interworldtransport.highflyer.EnvelopeModel--------------------------------------
 */

package com.interworldtransport.highflyer ;

import java.util.*;

/** com.interworldtransport.highflyer.EnvelopeModel
 * The EnvelopeModel class is intended to be the physical model for a container
 * of lift cells.
 * <p>
 * @version 0.2, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */

 public class EnvelopeModel
 {
    public		LiftCell 	TheGUI;
    public		AirModel	TheAir;
    public		String		Name;

    private		double		Length;
    private		double		Diameter;

    private		double		BallonetGasMass;
    private		double		EnvelopeDensity;
    private		double		EnvelopeMass;
    private		double		EnvelopeVolume;
    private		double		EnvelopeVolUsed;
    private		double		EnvelopePressure;

    private		boolean		OverPressurized;

/**
 * The EnvelopeModel class is intended to be the physical model for a container
 * of lift cells that provides buoyant lift for the vehicle.  It makes no
 * assumption about the atmosphere in which it flies because it relies upon the
 * AirModel to provide all of that information.  It does assume that the
 * ballonet gas is the same as the ambient air.
 * For now, it only hooks to the LiftCell Utility application
 */
    public EnvelopeModel(	LiftCell pGUI,
    				AirModel pAir,
				String pName,
				double pLength,
				double pDiameter,
				double pDensity
				)
    {
	super();
	if (pGUI!=null)
	{
		this.TheGUI=pGUI;
		this.TheAir=pAir;
		this.Name=pName;
		this.Length=pLength;
		this.Diameter=pDiameter;
		this.EnvelopeDensity=pDensity;

		setEnvelopeMass();

	}
	else
	{
		System.out.println("A GUI must be passed to the EnvelopeModel");
		System.exit(0);
	}
    }

//Start of settor methods

    public void setName(String pName)
    {
	Name=pName;
    }

    public void setAirModel(AirModel pAir)
    {
	TheAir=pAir;
    }

    public void setLength(double pL)
    {
	Length=pL;
    }

    public void setDiameter(double pD)
    {
	Diameter=pD;
    }

    public void setDensity(double pDensity)
    {
	EnvelopeDensity=pDensity;
    }

    public void setBallonetGasMass(double pBGas)
    {
	BallonetGasMass=pBGas;
    }

    public void setEnvelopeMass()
    {
	EnvelopeMass=EnvelopeDensity*Length*Diameter*Math.PI;
    }

    public void setEnvelopeVolume()
    {
	EnvelopeVolume=Length*Math.PI*Math.pow(Diameter/2.0, 2.0);
    }

//Start of gettor methods

    public String getName()
    {
	return(Name);
    }

    public AirModel getAirModel()
    {
	return(TheAir);
    }

    public double getLength()
    {
	return(Length);
    }

    public double getCellDiameter()
    {
	return(Diameter);
    }

    public double getDensity()
    {
	return(EnvelopeDensity);
    }

    public double getBallonetGasMass()
    {
	return(BallonetGasMass);
    }

    public double getEnvelopeMass()
    {
	return(EnvelopeMass);
    }

    public double getLiftGasDensity()
    {
	return(DensHeZero);
    }

    public double getLiftCellVolume()
    {
	return(LiftCellVolume);
    }

    public void calcCellDemand()
    {
	double tempLCDensity=TheAir.getDensity()*DensHeZero/TheAir.getBaseDensity();
	LiftCellVolUsed=LiftGasMass/tempLCDensity;
    }

    public boolean isCellVolumeAvailable(double BallonetVolumeUsed)
    {
	this.calcCellDemand();
	if (LiftCellVolUsed+BallonetVolumeUsed<=LiftCellVolume)
	{
		OverPressurized=false;
		return true;
	}
	else
	{
		OverPressurized=true;
		return false;
	}

    }




 }//end of EnvelopeModel class
