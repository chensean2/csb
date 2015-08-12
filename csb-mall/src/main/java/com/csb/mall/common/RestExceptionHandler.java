package com.csb.mall.common;

import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.csb.common.constant.MediaTypes;
import com.csb.common.util.BeanValidators;
import com.csb.common.util.JsonMapper;

/**
 * 自定义ExceptionHandler，专门处理Restful异常.
 * 
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	private JsonMapper jsonMapper = new JsonMapper();

	/**
	 * 处理RestException.
	 */
	@ExceptionHandler(value = { Exception.class })
	public final ResponseEntity<?> handleCommonException(Exception ex, WebRequest request) {
		logger.error("", ex);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaTypes.TEXT_PLAIN_UTF_8));
		return handleExceptionInternal(ex,"{\"success\":\"false\"}" , headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	/**
	 * 处理RestException.
	 */
	@ExceptionHandler(value = { RestException.class })
	public final ResponseEntity<?> handleException(RestException ex, WebRequest request) {
		logger.error("", ex);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaTypes.TEXT_PLAIN_UTF_8));
		return handleExceptionInternal(ex, ex.getMessage(), headers, ex.status, request);
	}
	

	/**
	 * 处理JSR311 Validation异常.
	 */
	@ExceptionHandler(value = { ConstraintViolationException.class })
	public final ResponseEntity<?> handleException(ConstraintViolationException ex, WebRequest request) {
		logger.error("", ex);
		Map<String, String> errors = BeanValidators.extractPropertyAndMessage(ex.getConstraintViolations());
		String body = jsonMapper.toJson(errors);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaTypes.TEXT_PLAIN_UTF_8));
		return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
	}
}
