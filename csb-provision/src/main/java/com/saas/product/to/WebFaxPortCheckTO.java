/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.WebFaxPortCheckTO
 *
 * Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 * This software is confidential and proprietary to saas Pte. Ltd. You shall
 * use this software only in accordance with the terms of the license
 * agreement you entered into with saas.  No aspect or part or all of this
 * software may be reproduced, modified or disclosed without full and
 * direct written authorisation from saas.
 *
 * saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 * REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 * SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 * FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.3.0     - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.product.to;

import com.saas.common.to.SCBaseTO;

public class WebFaxPortCheckTO extends SCBaseTO {

	private static final long serialVersionUID = -5690798593116069905L;

	private String faxNumber;
	private String carrier;
	private String rebilled;
	private String services;
	private String rotary;
	private String shared;
	private String stored;
	private String adsl;
	private String equipment;
	private String eftpos;
	private String alarm;

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getRebilled() {
		return rebilled;
	}

	public void setRebilled(String rebilled) {
		this.rebilled = rebilled;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getRotary() {
		return rotary;
	}

	public void setRotary(String rotary) {
		this.rotary = rotary;
	}

	public String getShared() {
		return shared;
	}

	public void setShared(String shared) {
		this.shared = shared;
	}


	public String getStored() {
		return stored;
	}

	public void setStored(String stored) {
		this.stored = stored;
	}

	public String getAdsl() {
		return adsl;
	}

	public void setAdsl(String adsl) {
		this.adsl = adsl;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getEftpos() {
		return eftpos;
	}

	public void setEftpos(String eftpos) {
		this.eftpos = eftpos;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

}
