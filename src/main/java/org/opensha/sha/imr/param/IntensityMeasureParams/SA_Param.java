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

package org.opensha.sha.imr.param.IntensityMeasureParams;

import org.opensha.commons.param.Parameter;
import org.opensha.commons.param.constraint.impl.DoubleConstraint;
import org.opensha.commons.param.impl.WarningDoubleParameter;

/**
 * This constitutes is for the natural-log Spectral Acceleration intensity measure
 * parameter.  It requires being given a PeriodParam and DampingParam, as these are
 * the parameters that SA depends upon.
 * See constructors for info on editability and default values.
 * @author field
 *
 */
public class SA_Param extends WarningDoubleParameter {

	public final static String NAME = "SA";
	public final static String UNITS = "g";
	public final static String INFO = "Response Spectral Acceleration";
	protected final static Double MIN = new Double(Math.log(Double.MIN_VALUE));
	protected final static Double MAX = new Double(Double.MAX_VALUE);
	protected final static Double DEFAULT_WARN_MIN = new Double(Math.log(Double.MIN_VALUE));
	protected final static Double DEFAULT_WARN_MAX = new Double(Math.log(3.0));

	/**
	 * This uses the DEFAULT_WARN_MIN and DEFAULT_WARN_MAX fields to set the
	 * warning constraint, and sets the default as Math.log(0.5) (the natural
	 * log of 0.5). The parameter is left as non editable
	 */
	public SA_Param(PeriodParam periodParam, DampingParam dampingParam) {
		super(NAME, new DoubleConstraint(MIN, MAX), UNITS);
		getConstraint().setNonEditable();
		this.setInfo(INFO);
		DoubleConstraint warn2 = new DoubleConstraint(DEFAULT_WARN_MIN, DEFAULT_WARN_MAX);
		warn2.setNonEditable();
		setWarningConstraint(warn2);
		addIndependentParameter(periodParam);
		addIndependentParameter(dampingParam);
		setDefaultValue(0.5);
		setNonEditable();
	}
	/**
	 * This uses the supplied warning constraint and default (both in natural-log space).
	 * The parameter is left as non editable
	 * @param warningConstraint
	 * @param defaultPGA
	 */
	public SA_Param(PeriodParam periodPeram, DampingParam dampingParam, DoubleConstraint warningConstraint, double defaultPGA) {
		super(NAME, new DoubleConstraint(MIN, MAX), UNITS);
		getConstraint().setNonEditable();
		this.setInfo(INFO);
		setWarningConstraint(warningConstraint);
		addIndependentParameter(periodPeram);
		addIndependentParameter(dampingParam);
		setDefaultValue(defaultPGA);
		setNonEditable();
	}
	
	/**
	 * Helper method to quickly get the period param
	 * 
	 * @return
	 */
	public PeriodParam getPeriodParam() {
		return (PeriodParam) this.getIndependentParameter(PeriodParam.NAME);
	}
	
	/**
	 * Helper method to quickly get the damping param
	 * 
	 * @return
	 */
	public DampingParam getDampingParam() {
		return (DampingParam) this.getIndependentParameter(DampingParam.NAME);
	}
	
	public static void setPeriodInSA_Param(Parameter<?> param, double period) {
		SA_Param saParam = (SA_Param) param;
		saParam.getPeriodParam().setValue(period);
	}
	
	public static double getPeriodInSA_Param(Parameter<?> param) {
		SA_Param saParam = (SA_Param) param;
		return saParam.getPeriodParam().getValue();
	}

}
