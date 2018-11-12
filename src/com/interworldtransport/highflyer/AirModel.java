/*
<h2>Copyright</h2>
Copyright (c) 2003 Interworld Transport.  All rights reserved.<br>
---com.interworldtransport.highflyer.AirModel-------------------------------------------
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
---com.interworldtransport.highflyer.AirModel-------------------------------------------
 */

package com.interworldtransport.highflyer ;

import java.util.*;

/** com.interworldtransport.highflyer.AirModel
 * The AirModel class is intended to be the physical model for the atmosphere
 * through which a vehicle flies.  It holds a representation of the ISA model
 * for the Terran atmosphere.  For now, it only hooks to the LiftCell Utility
 * application
 * <p>
 * @version 0.2, $Date: 2005/06/05 07:08:59 $
 * @author Dr Alfred W Differ
 */

 public class AirModel
 {
/**
 * TheGUI holds a reference to the parent application in order to make
 * configuration information available to the AirModel.
 */
    public		LiftCell 	TheGUI;
/**
 * The Name field holds a string that supports a convenient method of referring
 * to the AirModel in case future applications ever use more than one.
 */
    public		String		Name="Terran Model Atmosphere";
//------------------------------------------------------------------------------
/**
 * AltitudeCut is an altitude array holding the points of the model where the
 * temperature profile gradient changes.
 */
    private		double[]	AltitudeCut=new double[8];
/**
 * Altitude holds the information to be used to calculate almost all other
 * aspects of the Air Model.  It is a geopotential altitude and must be
 * converted if the geometric altitude is to be found.
 */
    private		double		Altitude;

//------------------------------------------------------------------------------
/**
 * TemperatureCut is the temperature of the air at each altitude cut in the
 * model.  The zeroth element is the temperature at the bottom of the
 * atmosphere.
 */
    private		double[]	TemperatureCut=new double[8];
/**
 * Offset is the observed temperature offset between the model atmosphere an the
 * observed or expected atmosphere.
 */
    private		double		TemperatureOffset;
/**
 * TempTropoGrad holds the temperature gradient found between altitude cuts i-1
 * and i.
 */
    private		double[]	TemperatureGradient=new double[8];
/**
 * Temperature is the actual temperature of the air at a specific Altitude.
 */
    private		double		Temperature;

//------------------------------------------------------------------------------
/**
 * PressureCut is Pressure when the altitude is at a cut point in the model.
 * The zeroth element is the pressure at the bottom of the troposphere.
 */
    private		double[]	PressureCut=new double[8];
/**
 * Pressure is the actual pressure of the air at a specific Altitude.
 */
    private		double		Pressure;
//------------------------------------------------------------------------------
/**
 * DensityCut is Density of the air at altitude cut points. The zeroth element
 * is the density at the bottom of the troposphere.
 */
    private		double[]	DensityCut=new double[8];
/**
 * Density is the actual density of the air at a specific Altitude.
 */
    private		double		Density;
//------------------------------------------------------------------------------
/**
 * This constant represents the gravitational constant 'g' near the Earth's
 * surface.
 * Its units are m/s^2
 */
    private final static	double	Gravity = -9.80665d;
/**
 * This constant represents the radius of the Earth along its equator.
 * Its units are m.
 */
    private final static	double	EarthRadius = 6378145.0d;
/**
 * This constant represents the gas constant found in the ideal gas law.
 * It's units are Nm/kgK
 */
    private final static	double	GasR = 287.05287d;
/**
 * This constant is called Suderland's constant.  It gets used to figure the
 * coefficient of viscosity.
 * It's units are kelvins.
 */
    private final static 	double 	Suderlands = 110.4d;
/**
 * Beta gets used to figure the coefficient of viscosity.
 * It's units are kg/m.s.k^0.5)
 */
    private final static 	double 	Beta = 1.458E-06;
/**
 * Gamma is the ratio of the specific heats of air.
 * It is unitless.
 */
    private final static 	double 	Gamma = 1.4;


/**
 * This is the main constructor for the AirModel.  It requires only a name and a
 * link to the parent application.  It gets all its configuration information
 * from the parent application.
 */
    public AirModel(	LiftCell pGUI,
    			String pName
			)
    {
	super();
	if (pGUI!=null)
	{
		TheGUI=pGUI;
		Name=pName;

		PressureCut[0]=new Double(TheGUI.IniProps.getProperty("Atmosphere.SeaLevel.Pressure")).doubleValue();
		DensityCut[0]=new Double(TheGUI.IniProps.getProperty("Atmosphere.SeaLevel.DensityAir")).doubleValue();

		TemperatureOffset=new Double(TheGUI.IniProps.getProperty("Atmosphere.SeaLevel.Temperature.Offset")).doubleValue();

		AltitudeCut[0]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut0")).doubleValue();;
		AltitudeCut[1]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut1")).doubleValue();
		AltitudeCut[2]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut2")).doubleValue();
		AltitudeCut[3]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut3")).doubleValue();
		AltitudeCut[4]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut4")).doubleValue();
		AltitudeCut[5]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut5")).doubleValue();
		AltitudeCut[6]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut6")).doubleValue();
		AltitudeCut[7]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Altitude.Cut7")).doubleValue();

		TemperatureCut[0]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut0")).doubleValue();
		TemperatureCut[1]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut1")).doubleValue();
		TemperatureCut[2]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut2")).doubleValue();
		TemperatureCut[3]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut3")).doubleValue();
		TemperatureCut[4]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut4")).doubleValue();
		TemperatureCut[5]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut5")).doubleValue();
		TemperatureCut[6]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut6")).doubleValue();
		TemperatureCut[7]=new Double(TheGUI.IniProps.getProperty("Atmosphere.Temperature.Cut7")).doubleValue();

		this.calcTemperatureGradients();
		this.calcPressureCuts();
		this.calcDensityCuts();

	/*
		System.out.println("Cut\tAltitude\tTemperature\tGradient");
		for (int i=0; i<8; i++)
		{
			System.out.print(i+"\t");
			System.out.print(AltitudeCut[i]+"\t");
			System.out.print(TemperatureCut[i]+"\t");
			System.out.println(TemperatureGradient[i]);
		}
	 */

	}
	else
	{
		System.out.println("A GUI must be passed to the AirModel");
		System.exit(0);
	}

    }//end of constructor method


//Start of settor methods
/**
 * This method sets the Name field to support a convenient method of referring
 * to the AirModel in case future applications ever use more than one.
 */
    public void setName(String pName)
    {
	Name = pName;
    }
/**
 * This method gets the geopotential altitude using the geopotential altitude.
 */
    public void setAltitude(double pAlt)
    {
	Altitude = pAlt;
    }
/**
 * This method gets the geopotential altitude using the geometric altitude.
 */
    public void setGeometricAltitude(double pAlt)
    {
	Altitude = pAlt*EarthRadius/(EarthRadius+pAlt);
    }

    public void setTemperatureOffset(double pOff)
    {
	TemperatureOffset=pOff;
    }



//Start of gettor methods
    public String getNameAlt()
    {
	return(Name);
    }

    public double getAltitude()
    {
	return(Altitude);
    }

    public double getGeometricAltitude()
    {
	return(Altitude*EarthRadius/(EarthRadius-Altitude));
    }

    public double getTemperatureOffset()
    {
	return(TemperatureOffset);
    }

    public double getTemperature()
    {
	return(Temperature);
    }

    public double getPressure()
    {
	return(Pressure);
    }

    public double getDensity()
    {
	return(Density);
    }

    public double getBaseDensity()
    {
	return(DensityCut[0]);
    }

    public double getSpeedOfSound()
    {
	return(1.0);
    }

    public double getCoeffViscosity()
    {
	return(1.0);
    }

    public double getDynamicViscosity()
    {
	return(1.0);
    }

    public double getCoeffConductivity()
    {
	return(1.0);
    }

    public double getGravity()
    {
	return(this.Gravity);
    }

    public double getMeanFreePath()
    {
	return(1.0);
    }

//start the model calculators
/**
 * This method calculates the temperature gradients appropriate for the model
 * through the listed altitude cuts.
 */
    public void calcTemperatureGradients()
    {
	for (int i=1; i<8; i++)
	{
		TemperatureGradient[i]=(TemperatureCut[i]-TemperatureCut[i-1])
			/(AltitudeCut[i]-AltitudeCut[i-1]);
	}
    }

/**
 * This method calculates the air pressure at each altitude cut point for the
 * model.
 */
    public void calcPressureCuts()
    {
	for (int i=1; i<8; i++)
	{
		if (TemperatureGradient[i]==0.0)
		{
		    PressureCut[i]=PressureCut[i-1]*
			Math.pow(	Math.E,
					(AltitudeCut[i]-AltitudeCut[i-1])*
						Gravity/(GasR*TemperatureCut[i])
				);
		}
		else
		{
		    PressureCut[i]=PressureCut[i-1]*
			Math.pow(	TemperatureCut[i]/TemperatureCut[i-1],
					Gravity/(TemperatureGradient[i]*GasR)
				);

		}
	}
    }

/**
 * This method calculates the air density at each altitude cut point for the
 * model.
 */
    public void calcDensityCuts()
    {
	for (int i=1; i<8; i++)
	{
	    DensityCut[i]=PressureCut[i]/
	    			(GasR*(TemperatureCut[i]+TemperatureOffset));
	}
    }

/**
 * This method calculates the base temperature appropriate for the model at the
 * listed altitude.  The Offset is not tacked on since that gets added after the
 * fact by other methods that need the real temperature.
 */
    public void calcTemperature()
    {
	for (int i=1; i<8; i++)
	{
		if (Altitude<=AltitudeCut[i])
		{
			Temperature=TemperatureCut[i-1]+TemperatureGradient[i]
						*(Altitude-AltitudeCut[i-1]);
			break;
		}
		else continue;
	}

    }

/**
 * This method calculates the pressure appropriate for the model at the listed
 * altitude.  The ISA Offset is not taken in to account because it shouldn't
 * be used if one follows the model.
 */
    public void calcPressure()
    {
	for (int i=1; i<8; i++)
	{
		if (Altitude<=AltitudeCut[i])
		{
			if (TemperatureGradient[i]==0.0)
			{
			    Pressure=PressureCut[i-1]*
				Math.pow(Math.E,
					(Altitude-AltitudeCut[i-1])*
						Gravity/(GasR*Temperature));
			}
			else
			{
			    Pressure=PressureCut[i-1]*
			    	Math.pow(Temperature/TemperatureCut[i-1],
					Gravity/(TemperatureGradient[i]*GasR));
			}
			break;
		}
		else continue;

	}

    }

/**
 * This method calculates the density appropriate for the model at the listed
 * altitude.  The ISA Offset is taken in to account because it should be used
 * here if one follows the model.
 */
    public void calcDensity()
    {
	Density=Pressure/(GasR*(Temperature+TemperatureOffset));

    }

 }
