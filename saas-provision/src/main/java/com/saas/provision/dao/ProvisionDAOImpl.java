package com.saas.provision.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saas.common.IAppsConstants;
import com.saas.common.dao.SCBaseDAOImpl;
import com.saas.common.exception.SCServiceException;
import com.saas.provision.service.CustomerInfoTO;
import com.saas.provision.service.UserInfoTO;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.to.IsvServiceDefTO;
import com.saas.provision.to.IsvServiceParaDefTO;
import com.saas.provision.to.IsvServiceParaTO;
import com.saas.provision.to.IsvServiceTO;
import com.saas.provision.to.NotificationTO;
import com.saas.provision.to.ProvisionCaptureTO;
import com.saas.provision.to.ProvisionSearchTO;
import com.saas.provision.to.ProvisionTO;
import com.saas.provision.to.ServiceResDetailTO;
import com.saas.provision.to.ServiceResTO;

public class ProvisionDAOImpl extends SCBaseDAOImpl implements ProvisionDAO {
	private Logger log = LoggerFactory.getLogger(ProvisionDAOImpl.class);


	public int createProvisionRequest(ProvisionTO provisionTO) {
		int i = create(provisionTO);

		return i;
	}

	public int updateProvisionRequest(ProvisionTO provisionTO) {
		ProvisionTO oldProvisionTO = (ProvisionTO) queryForObject(provisionTO);
		int i = update(provisionTO);

		return i;
	}

	public int deleteProvisionRequest(ProvisionTO provisionTO) {
		ProvisionTO oldProvisionTO = (ProvisionTO) queryForObject(provisionTO);
		if (null == oldProvisionTO) {
			throw new SCServiceException(
					IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
		}
		int i = delete(provisionTO);

		return i;
	}

	public List<ProvisionTO> getProvisionReqIdListByJobType(String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		// if (status == IAppsConstants.PROVISION_JOB_TYPE_PROVISION) {
		// return pfwClient.queryForList(ProvisionTO.class,
		// "/provision/queryProvReqIdOfPV", map);
		// } else if (status == IAppsConstants.PROVISION_JOB_TYPE_ROLLBACK) {
		// return pfwClient.queryForList(ProvisionTO.class,
		// "/provision/queryProvReqIdOfRB", map);
		// } else if (status == IAppsConstants.PROVISION_JOB_TYPE_RESPONSE) {
		// return pfwClient.queryForList(ProvisionTO.class,
		// "/provision/queryProvReqIdOfRM", map);
		// } else {
		// return pfwClient.queryForList(ProvisionTO.class,
		// "/provision/queryProvReqIdOfSN", map);
		// }
		return new ArrayList<ProvisionTO>();
	}

	public ProvisionTO getProvisionRequest(String reqId) {
		ProvisionTO provisionTO = new ProvisionTO();
		provisionTO.setReqId(reqId);
		// return (ProvisionTO) pfwClient.materializeWith(provisionTO);
		return new ProvisionTO();
	}

	public int createIsvService(IsvServiceTO isvServiceTO) {
		int i = create(isvServiceTO);

		return i;
	}

	public int createIsvServicePara(IsvServiceParaTO isvServiceParaTO) {
		int i = create(isvServiceParaTO);

		return i;
	}

	public int deleteIsvService(IsvServiceTO isvServiceTO) {
		IsvServiceTO oldIsvServiceTO = (IsvServiceTO) queryForObject(isvServiceTO);
		if (null == oldIsvServiceTO) {
			throw new SCServiceException(
					IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
		}
		int i = delete(isvServiceTO);

		return i;
	}

	public int deleteIsvServicePataAll(IsvServiceParaTO isvServiceParaTO) {
		IsvServiceParaTO oldIsvServiceParaTO = (IsvServiceParaTO) queryForObject(isvServiceParaTO);
		if (null == oldIsvServiceParaTO) {
			throw new SCServiceException(
					IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
		}
		int i = delete(isvServiceParaTO);

		return i;
	}

	public IsvServiceTO getIsvService(String isvServiceId) {
		IsvServiceTO isvServiceTO = new IsvServiceTO();
		isvServiceTO.setIsvServiceId(isvServiceId);
		// return (IsvServiceTO) pfwClient.materializeWith(isvServiceTO);
		return null;
	}

	public List<IsvServiceTO> getIsvServiceList(String reqId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reqId", reqId);
		return null;
		// return pfwClient.queryForList(IsvServiceTO.class,
		// "/provision/queryIsvServiceListByReqId", map);
	}

	public IsvServiceParaTO getIsvServicePara(String isvServiceParaId) {
		IsvServiceParaTO isvServiceParaTO = new IsvServiceParaTO();
		isvServiceParaTO.setIsvServiceParaId(isvServiceParaId);
		return (IsvServiceParaTO) queryForObject(isvServiceParaTO);
	}

	public List<IsvServiceParaTO> getIsvServiceParaList(String isvServiceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceId", isvServiceId);
		return null;
		// return pfwClient.queryForList(IsvServiceParaTO.class,
		// "/provision/queryIsvServiceParaList", map);
	}

	public int updateIsvService(IsvServiceTO isvServiceTO) {
		IsvServiceTO oldIsvServiceTO = (IsvServiceTO) queryForObject(isvServiceTO);
		int i = update(isvServiceTO);

		return i;
	}

	public IsvServiceDefTO getIsvServiceDef(String isvServiceDefId) {
		IsvServiceDefTO isvServiceDefTO = new IsvServiceDefTO();
		isvServiceDefTO.setIsvServiceDefId(isvServiceDefId);
		// return (IsvServiceDefTO) pfwClient.materializeWith(isvServiceDefTO);
		return null;
	}

	public List<IsvServiceDefTO> getIsvServiceDefList(String isvServiceDefName,
			String isvServiceDefCategory, String isvServiceDefOperation,
			String serviceDefVersion) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceDefName", isvServiceDefName);
		map.put("isvServiceDefCategory", isvServiceDefCategory);
		map.put("isvServiceDefOperation", isvServiceDefOperation);
		map.put("serviceDefVersion", serviceDefVersion);
		// return pfwClient.queryForList(IsvServiceDefTO.class,
		// "/provision/getIsvServiceDefList", map);
		return null;
	}

	public IsvAdaptorTO getIsvAdaptor(String isvAdaptorId) {
		IsvAdaptorTO isvAdaptorTO = new IsvAdaptorTO();
		isvAdaptorTO.setIsvAdaptorId(isvAdaptorId);
		// return (IsvAdaptorTO) pfwClient.materializeWith(isvAdaptorTO);
		return null;
	}

	public List<ServiceResTO> getServiceResList(String isvServiceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceId", isvServiceId);
//		return pfwClient.queryForList(ServiceResTO.class,
//				"/provision/getIsvServiceResList", map);
		return null;
	}

	public int createNotification(NotificationTO notificationTO) {
		int i = create(notificationTO);
		

		return i;
	}

	/**
	 * select record from isv service para def table
	 * 
	 * @param isvServiceDefId
	 * @return List<IsvServiceParaDefTO>
	 * @author huajian
	 */
	public List<IsvServiceParaDefTO> getIsvServiceParaDefList(
			String isvServiceDefId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceDefId", isvServiceDefId);
//		return pfwClient.queryForList(IsvServiceParaDefTO.class,
//				"/provision/getIsvServiceParaDefList", map);
		return null;
	}

	public int createServiceResDetail(ServiceResDetailTO servResDetailTO) {
		int i = create(servResDetailTO);
//		ServiceResDetailTO newServResDetailTO = (ServiceResDetailTO) queryForObject(servResDetailTO);
//		XStream xstream = new XStream();
//		String newValue = xstream.toXML(newServResDetailTO);
//		try {
//			auditTrailService.createAuditTrail(
//					"CREATE_PROVISION_SERVICE_RES_DETAIL",
//					servResDetailTO.getServResDetailId(),
//					"TBL_SS_PROVISION_SERVICE_RES_DETAIL", "CREATE",
//					servResDetailTO.getLastUpdatedBy(), "", newValue);
//		} catch (Exception e) {
//			log.error("auditTrail for create service res detail failed", e);
//			log.error("CREATE_PROVISION_SERVICE_RES-New Value" + newValue);
//		}
		return i;
	}

	public List<NotificationTO> getNotification(String reqId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reqId", reqId);
//		return pfwClient.queryForList(NotificationTO.class,
//				"/provision/getNotificationList", map);
		return null;
	}

	public int updateNotification(NotificationTO notificationTO) {
		NotificationTO oldNotificationTO = (NotificationTO) queryForObject(notificationTO);
		int i = update(notificationTO);
		
		return i;
	}

	public void deleteServiceResDetailAll(String servResId) {
		Map<String, Object> map = new HashMap<String, Object>();
		ServiceResDetailTO servResDetailTO = new ServiceResDetailTO();
		servResDetailTO.setServResId(servResId);
		map.put("servResId", servResDetailTO);
		// return pfwClient.delete(servResDetailTO);
//		pfwClient.delete("/provision/deleteServiceDetail", map);
		//return null;
	}

	public int updateServiceRes(ServiceResTO serviceResTO) {
		ServiceResTO oldServiceResTO = (ServiceResTO) queryForObject(serviceResTO);
		int i = update(serviceResTO);
		
		return i;
	}

	public int createServiceRes(ServiceResTO serviceResTO) {
		int i = create(serviceResTO);
		
		return i;
	}

	public List<ProvisionTO> getProvision(ProvisionSearchTO provisionSearchTO) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("reqNo", provisionSearchTO.getReqNo());
		paraMap.put("customerId", provisionSearchTO.getCustomerId());
		paraMap.put("domainName", provisionSearchTO.getDomainName());
		paraMap.put("proviStatus", provisionSearchTO.getProviStatus());
//		return PaginationEnabler.queryForList(ProvisionTO.class, pfwClient,
//				"/provision/searchProvisionList", paraMap);
		return null;
	}

	public List<ProvisionTO> getProvisionList(ProvisionTO provisionTO) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("customerId", provisionTO.getCustomerId());
//		return pfwClient.queryForList(ProvisionTO.class,
//				"/provision/queryProvReqByDomainId", paraMap);
		return null;
	}

	public List<IsvServiceTO> getProvisionDetail(String reqId) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("reqId", reqId);
//		return PaginationEnabler.queryForList(IsvServiceTO.class, pfwClient,
//				"/provision/queryIsvServiceListByReqId", paraMap);
		return null;
	}

	public List<IsvServiceTO> searchProvisionDetail(String reqId) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("reqId", reqId);
//
//		return pfwClient.queryForList(IsvServiceTO.class,
//				"/provision/queryIsvServiceListByReqId", paraMap);
		return null;
	}

	public ProvisionTO getProvision(String reqId) {
		ProvisionTO provisionTO = new ProvisionTO();
		provisionTO.setReqId(reqId);
//		return (ProvisionTO) pfwClient.materializeWith(provisionTO);
		return null;
	}

	public List<IsvServiceParaTO> getIsvServiceDetail(String isvServiceId) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("isvServiceId", isvServiceId);
//		return PaginationEnabler.queryForList(IsvServiceParaTO.class,
//				pfwClient, "firstTable", "/provision/IsvServiceParaList",
//				paraMap);
		return null;
	}

	public List<ServiceResTO> getServiceResponseList(String isvServiceId) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("isvServiceId", isvServiceId);
//		return PaginationEnabler.queryForList(ServiceResTO.class, pfwClient,
//				"secondTable", "/provision/getIsvServiceResList", paraMap);
		return null;
	}

	public List<ServiceResDetailTO> getResponseDetailList(String servResId) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("servResId", servResId);
//		return PaginationEnabler.queryForList(ServiceResDetailTO.class,
//				pfwClient, "/provision/getResponseDetailList", paraMap);
		return null;
	}

	public ServiceResTO getServiceResInfo(String servResId) {
		ServiceResTO serviceResTO = new ServiceResTO();
		serviceResTO.setServResId(servResId);
//		return (ServiceResTO) pfwClient.materializeWith(serviceResTO);
		return null;
	}

	public IsvServiceTO getIsvServiceInfo(String isvServiceId) {
		IsvServiceTO isvServiceTO = new IsvServiceTO();
		isvServiceTO.setIsvServiceId(isvServiceId);
//		return (IsvServiceTO) pfwClient.materializeWith(isvServiceTO);
		return null;
	}

	public String getSvcAdaptor(String svcDefName, String svcDefCategory,
			String svcDefOperation) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("svcDefName", svcDefName);
		paraMap.put("svcDefCategory", svcDefCategory);
		paraMap.put("svcDefOperation", svcDefOperation);
//		List<IsvServiceDefTO> list = pfwClient.queryForList(
//				IsvServiceDefTO.class, "/provision/queryIsvServiceDefTOList",
//				paraMap);
		List<IsvServiceDefTO> list = new ArrayList<IsvServiceDefTO>();
		IsvServiceDefTO isvServiceDefTO = null;
		if (null != list && list.size() > 0) {
			isvServiceDefTO = list.get(0);
		}
		IsvAdaptorTO isvAdaptorto = new IsvAdaptorTO();
		if (null != isvServiceDefTO) {
			isvAdaptorto.setIsvAdaptorId(isvServiceDefTO.getIsvProvAdaptorId());
			IsvAdaptorTO isvAdaptorTO = (IsvAdaptorTO) queryForObject(isvAdaptorto);
			return isvAdaptorTO.getIsvAdaptorEndpoint();
		} else {
			return null;
		}

	}

	public CustomerInfoTO getCustomerInfo(String isvServiceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceId", isvServiceId);
		List<CustomerInfoTO> list = new ArrayList<CustomerInfoTO>();
//		List<CustomerInfoTO> list = pfwClient.queryForList(
//				CustomerInfoTO.class, "/provision/getCustomerInfo", map);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public CustomerInfoTO getCustomerInfoByDomainProductId(
			String domainProductId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("domainProductId", domainProductId);
		List<CustomerInfoTO> list = new ArrayList<CustomerInfoTO>();
//		List<CustomerInfoTO> list = pfwClient.queryForList(
//				CustomerInfoTO.class,
//				"/provision/getCustomerInfoByDomainProductId", map);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public CustomerInfoTO getCustomerInfoFromOldPackage(String isvServiceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceId", isvServiceId);
//		List<CustomerInfoTO> list = pfwClient.queryForList(
//				CustomerInfoTO.class,
//				"/provision/getCustomerInfoFromOldPackage", map);
		List<CustomerInfoTO> list = new ArrayList<CustomerInfoTO>();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public CustomerInfoTO getOldDomainPackage(String isvServiceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceId", isvServiceId);
		List<CustomerInfoTO> list = new ArrayList<CustomerInfoTO>();
//		List<CustomerInfoTO> list = pfwClient.queryForList(
//				CustomerInfoTO.class, "/provision/getOldDomainPackage", map);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public UserInfoTO getUserInfo(String isvServiceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isvServiceId", isvServiceId);
		List<UserInfoTO> list = new ArrayList<UserInfoTO>();
//		List<UserInfoTO> list = pfwClient.queryForList(UserInfoTO.class,
//				"/provision/getUserInfo", map);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public int updateIsvServicePara(IsvServiceParaTO isvServiceParaTO) {
		IsvServiceParaTO oldIsvServiceParaTO = (IsvServiceParaTO) queryForObject(isvServiceParaTO);
		int i = update(isvServiceParaTO);
		
		return i;
	}

	@Override
	public int createCapture(ProvisionCaptureTO provisionCaptureTO) {
		int i = create(provisionCaptureTO);
		
		return i;
	}

	@Override
	public List<ProvisionCaptureTO> getCapture(String captureId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("captureId", captureId);
		//return pfwClient.queryForList(ProvisionCaptureTO.class,
//				"/provision/getCaptureList", map);
		return null;
	}

	@Override
	public List<ProvisionCaptureTO> getCaptureByTransactionId(
			String transactionId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("transactionId", transactionId);
//		return pfwClient.queryForList(ProvisionCaptureTO.class,
//				"/provision/getCaptureListByTransactionId", map);
		return null;
	}

	@Override
	public int updateCapture(ProvisionCaptureTO provisionCaptureTO) {
		ProvisionCaptureTO oldProvisionCaptureTO = (ProvisionCaptureTO) queryForObject(provisionCaptureTO);
		int i = update(provisionCaptureTO);
		
		return i;
	}

	@Override
	public List<ProvisionCaptureTO> searchCaptureList(
			ProvisionCaptureTO provisionCaptureTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("captureId", provisionCaptureTO.getCaptureId());
		map.put("transactionId", provisionCaptureTO.getTransactionId());
		map.put("serviceId", provisionCaptureTO.getServiceId());
		map.put("ext1", provisionCaptureTO.getExt1());
		map.put("ext2", provisionCaptureTO.getExt2());
//		return PaginationEnabler.queryForList(ProvisionCaptureTO.class,
//				pfwClient, "/provision/getCaptureList", map);
		return null;
	}
}
