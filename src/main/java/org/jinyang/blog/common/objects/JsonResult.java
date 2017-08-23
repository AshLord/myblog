package org.jinyang.blog.common.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jinyang.blog.common.enums.ErrorEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * JSON Response Basic data
 * 
 */
//@JsonIgnoreProperties(value = { "hibernateLazyInitializer","javassistLazyInitializer" })
public class JsonResult {


	private Integer code;

	private String message = "";

	private Map<Object, Object> data = new HashMap<Object, Object>();

	public JsonResult() {
		super();
	}


	public JsonResult(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public JsonResult(ErrorEnum errorCode){
		super();
		this.code = errorCode.getErrorCode();
		this.message = errorCode.getErrorMsg();
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<Object, Object> getData() {
		return data;
	}

	public void setData(Map<Object, Object> data) {
		this.data = data;
	}

	public JsonResult appendData(Object key, Object value) {
		this.data.put(key, value);
        return this;
	}

	public JsonResult appendData(Map<?, ?> map) {
		this.data.putAll(map);
        return this;
	}

}
