package com.saas.provision.service;

import java.util.List;

public class ProvisionValidateException extends Exception {

    private static final long serialVersionUID = -6550715570292505782L;
    private int errCode;
    private List<String[]> messageList;

    public List<String[]> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String[]> messageList) {
		this.messageList = messageList;
	}

	public ProvisionValidateException() {

    }

    public ProvisionValidateException(String message) {
        super(message);
    }
    
    public ProvisionValidateException(List<String[]> messageList) {
    	this.messageList = messageList;
    }

    public ProvisionValidateException(Throwable cause) {
        super(cause);
    }

    public ProvisionValidateException(String message, Throwable cause) {
        super(message, cause);
    }
//
//    public ProvisionValidateException(int errCode) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""))));
//        this.errCode = errCode;
//    }
//
//    public ProvisionValidateException(int errCode, String arg) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg)));
//        this.errCode = errCode;
//    }
//
//    public ProvisionValidateException(int errCode, String arg0, String arg1) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg0, arg1)));
//        this.errCode = errCode;
//    }
//
//    public ProvisionValidateException(int errCode, Throwable cause) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), cause)));
//        this.errCode = errCode;
//    }
//
//    public ProvisionValidateException(int errCode, String arg, Throwable cause) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg)), cause);
//        this.errCode = errCode;
//    }
//
//    public ProvisionValidateException(int errCode, String arg0, String arg1, Throwable cause) {
//        super(MessageHelper.parseMessage(new Message(ConfigProperties.getInstance().getPropertyAsString(
//                IAppsConstants.SAAS_CONFIG, "error.code." + errCode, ""), arg0, arg1)), cause);
//        this.errCode = errCode;
//    }

    public int getErrCode() {
        return errCode;
    }
}
