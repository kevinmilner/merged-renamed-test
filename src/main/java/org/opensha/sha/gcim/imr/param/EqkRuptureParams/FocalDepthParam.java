/*******************************************************************************
 * Copyright 2009 OpenSHA.org in partnership with
 * the Southern California Earthquake Center (SCEC, http://www.scec.org)
 * at the University of Southern California and the UnitedStates Geological
 * Survey (USGS; http://www.usgs.gov)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package org.opensha.sha.gcim.imr.param.EqkRuptureParams;

import org.opensha.commons.param.constraint.impl.DoubleConstraint;
import org.opensha.commons.param.impl.WarningDoubleParameter;

/**
 * Magnitude parameter, reserved for representing source focal depth.
 * The warning constraint must be created and added after instantiation.
 * See constructors for info on editability and default values.
 */
public class FocalDepthParam extends WarningDoubleParameter {

	public final static String NAME = "Focal Depth";
	public final static String INFO = "Earthquake Source Focal Depth";
	protected final static Double MIN = new Double(0);
	protected final static Double MAX = new Double(500);
	// warning values are set in subclasses
	
	/**
	 * This sets the default value and warning-constraint limits
	 *  as given, and leaves the parameter as non editable.
	 */
	public FocalDepthParam(double minWarning, double maxWarning, double defaultFocalDepth) {
		super(NAME, new DoubleConstraint(MIN, MAX));
		getConstraint().setNonEditable();
		DoubleConstraint warn = new DoubleConstraint(minWarning, maxWarning);
		warn.setNonEditable();
		setWarningConstraint(warn);
	    setInfo(INFO);
	    setDefaultValue(defaultFocalDepth);
	    setNonEditable();
	    
	}

	/**
	 * This sets the default value as 50km, and applies the given warning-
	 * constraint limits. The parameter is left as non editable.
	 */
	public FocalDepthParam(double minWarning, double maxWarning) { this(minWarning, maxWarning, 50.0);}

	/**
	 * This sets the default value as given.  No warning limits are set, so
	 * this is left editable so warning constraints can be added.
	 */
	public FocalDepthParam(double defaultFocalDepth) {
		super(NAME, new DoubleConstraint(MIN, MAX));
		getConstraint().setNonEditable();
	    setInfo(INFO);
	    setDefaultValue(defaultFocalDepth);
	}

	/**
	 * This sets the default value as 50.0.  No warning limits are set, so
	 * this is left editable so warning constraints can be added.
	 */
	public FocalDepthParam() { this(50.0);}
	
	
}
