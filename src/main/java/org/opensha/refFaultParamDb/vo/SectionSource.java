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

package org.opensha.refFaultParamDb.vo;

/**
 * <p>Title: SectionSource.java </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SectionSource {
	private int sourceId;
	private String sectionSourceName;
	public SectionSource() {
	}
	public SectionSource(int sourceId, String sourceName) {
		this.sourceId = sourceId;
		this.sectionSourceName = sourceName;
	}
	public String getSectionSourceName() {
		return sectionSourceName;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSectionSourceName(String sectionSourceName) {
		this.sectionSourceName = sectionSourceName;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

}
