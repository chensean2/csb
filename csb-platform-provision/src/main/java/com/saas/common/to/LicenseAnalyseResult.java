package com.saas.common.to;

import java.util.ArrayList;
import java.util.List;

import com.saas.product.to.UserDeviceTO;

public class LicenseAnalyseResult {
	
	private List<UserDeviceTO> newDeviceList = new ArrayList<UserDeviceTO>();

	public List<UserDeviceTO> getNewDeviceList() {
		return newDeviceList;
	}

	public void setNewDeviceList(List<UserDeviceTO> newDeviceList) {
		this.newDeviceList = newDeviceList;
	}

}
