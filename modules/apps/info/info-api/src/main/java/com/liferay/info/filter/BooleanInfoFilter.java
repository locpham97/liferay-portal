package com.liferay.info.filter;

import java.util.Map;

public class 	BooleanInfoFilter implements InfoFilter {
	public static final String FILTER_TYPE_NAME = "boolean";

	@Override
	public String getFilterTypeName() {
		return FILTER_TYPE_NAME;
	}

	public Map<String, Boolean> getBoolean() {
		return _boolean;
	}

	public void setBoolean(Map<String, Boolean> bool) {
		_boolean = bool;
	}

	private Map<String, Boolean> _boolean;

}
