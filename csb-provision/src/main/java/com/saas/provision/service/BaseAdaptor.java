package com.saas.provision.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.csb.common.ConfigProperties;
import com.csb.common.IAppsConstants;
import com.csb.common.SequenceUUID;
import com.csb.common.exception.SCServiceException;
import com.saas.product.service.ProductOrderService;
import com.saas.product.service.UserAssignmentService;
import com.saas.product.service.UserProductService;
import com.saas.product.to.UserProductTO;
import com.saas.webservices.data.ResponseObject;
import com.saas.webservices.data.ResponseResult;
import com.saas.webservices.util.IsvXmlParser;

public class BaseAdaptor {
	protected ProvisionService provisionService;
	protected ProductOrderService productOrderService;
	protected UserProductService userProductService;
	protected UserAssignmentService userAssignmentService;
	protected ApplicationContext appContext;
	protected ConfigProperties config;
		
	public ApplicationContext getAppContext() {
		return appContext;
	}

	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}

	public UserAssignmentService getUserAssignmentService() {
		return userAssignmentService;
	}

	public void setUserAssignmentService(UserAssignmentService userAssignmentService) {
		this.userAssignmentService = userAssignmentService;
	}

	public CustomerInfoTO getCustomerInfo(String isvServiceId){
		return provisionService.getCustomerInfo(isvServiceId);
	}
	
	public UserInfoTO getUserInfo(String isvServiceId){
		return provisionService.getUserInfo(isvServiceId);
	}
	
	
	public void updateProductOrderStatus(String proTxId,String productOrderStatus){
		productOrderService.updateProductOrderStatusByProTxId(proTxId, productOrderStatus);
	}
	
	public void updateUserProductStatus(String proTxId,String userProductStatus){
		userProductService.updateUserProductStatusByProTxId(proTxId, userProductStatus);
	}
	
	/**
	 * this method is used to update user assign status
	 * @param proTxId
	 * @param status
	 */
	public void updateUserAssignStatus(String proTxId, String status) {
		// get the user product record according the proTxId
		UserProductTO userProduct = new UserProductTO();
		userProduct.setProTxId(proTxId);
		List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProduct);
		
		if (null == userProductList || userProductList.isEmpty()) {
			throw new SCServiceException(IAppsConstants.MSG_RECORD_DELETE_ELSEWHERE);
		}
		
		userProduct = userProductList.get(0);
		
		// set the fields according the status
		if (IAppsConstants.PROVISION_REQUEST_PROVISION_SUCCESS.equalsIgnoreCase(status)) {
			userProduct.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_ACTIVE);
			userProduct.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_NO);
			userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_SUCCESS);
		} else if (IAppsConstants.PROVISION_REQUEST_PROVISION_FAILED.equalsIgnoreCase(status)) {
			userProduct.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_INACTIVE);
			userProduct.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_YES);
			userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_FAIL);
		} else {
			 throw new SCServiceException();
		}
		
		// update the user product
		userProductService.updateUserProduct(userProduct);
		userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProduct);
	}
	
	/**
	 * this method is used to update user unassign status
	 * @param proTxId
	 * @param status
	 */
	public void updateUserUnAssignStatus(String proTxId, String status) {
		// get the user product record according the proTxId
		UserProductTO userProduct = new UserProductTO();
		userProduct.setProTxId(proTxId);
		List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProduct);
		
		if (null == userProductList || userProductList.isEmpty()) {
			throw new SCServiceException(IAppsConstants.MSG_RECORD_DELETE_ELSEWHERE);
		}
		
		userProduct = userProductList.get(0);
		
		// set the fields according the status
		if (IAppsConstants.PROVISION_REQUEST_PROVISION_SUCCESS.equalsIgnoreCase(status)) {
			userProduct.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_TERMINATED);
			userProduct.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_YES);
			userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_SUCCESS);
		} else if (IAppsConstants.PROVISION_REQUEST_PROVISION_FAILED.equalsIgnoreCase(status)) {
			userProduct.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_ACTIVE);
			userProduct.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_YES);
			userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_FAIL);
		} else {
			 throw new SCServiceException();
		}
		
		// update the user product
		userProductService.updateUserProduct(userProduct);
		userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProduct);
		
		//update latest product term of condition
		//set ignore indicator = Y 
		//userProductService.updateLatestUserTermsLog(userProduct);
	}
	
	/**
	 * this method is used to update user ref id and key
	 */
	public void updateUserRefIdAndKey(String proTxId, String refId, String refKey) {
		// get the user product record according the proTxId
		UserProductTO userProduct = new UserProductTO();
		userProduct.setProTxId(proTxId);
		List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProduct);
		
		if (null == userProductList || userProductList.isEmpty()) {
			throw new SCServiceException(IAppsConstants.MSG_RECORD_DELETE_ELSEWHERE);
		}
		
		userProduct = userProductList.get(0);
		userProduct.setServiceRefId(refId);
		userProduct.setServiceRefKey(refKey);
		
		// update the user product
		userProductService.updateUserProduct(userProduct);
	}
//	
//	public List<ResponseResult> sendProvisioningRequest(String requestUrl, String requestStr){
//	    List<ResponseResult> responseList = null;
//	    try{
//	       saasSoapBindingStub provisionStub = new saasSoapBindingStub(requestUrl);
//               ProvisioningRequest request = new ProvisioningRequest();
//               request.setXmlStr(requestStr);
//               ProvisioningRequestResponse provisionResponse = provisionStub.provisioningRequest(request);
//               String response = provisionResponse.get_return();
//               ResponseObject responseObject = IsvXmlParser.parseResponse(response);
//               responseList = responseObject.getResponseResults();
//	    }catch(Exception e){
//	        throw new SCServiceException("[SaaSconnect] Error occured when send provision request, requestUrl is: " + requestUrl +", requestStr is: " + requestStr ,e);
//	    }
//	    return responseList;
//	}
	
	public ProductOrderService getProductOrderService() {
		return productOrderService;
	}

	public void setProductOrderService(ProductOrderService productOrderService) {
		this.productOrderService = productOrderService;
	}

	public UserProductService getUserProductService() {
		return userProductService;
	}

	public void setUserProductService(UserProductService userProductService) {
		this.userProductService = userProductService;
	}
	
	public ProvisionService getProvisionService() {
		return provisionService;
	}

	public void setProvisionService(ProvisionService provisionService) {
		this.provisionService = provisionService;
	}

	
}
