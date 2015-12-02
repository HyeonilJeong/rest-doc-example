package xyz.nuti.rest.common;

import java.util.HashMap;
import java.util.Map;

public class RestfulResponseBody {
	private String message;
	private Map<String, Object> data;
	
	public RestfulResponseBody() {
		this.message = "";
		this.data = new HashMap<String, Object>();
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void put(String key, Object value) {
		data.put(key, value);
	}
	
	public String getMessage() {
		return message;
	}
	
	public Map<String, Object> getData() {
		return data;
	}
}
