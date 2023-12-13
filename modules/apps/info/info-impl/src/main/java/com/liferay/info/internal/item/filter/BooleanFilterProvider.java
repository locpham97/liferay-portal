package com.liferay.info.internal.item.filter;

import com.liferay.info.filter.BooleanInfoFilter;
import com.liferay.info.filter.InfoFilterProvider;
import com.liferay.info.filter.KeywordsInfoFilter;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component(service = InfoFilterProvider.class)
public class BooleanFilterProvider implements
	InfoFilterProvider<BooleanInfoFilter> {

	@Override
	public BooleanInfoFilter create(Map<String, String[]> values) {
		BooleanInfoFilter booleanInfoFilter = new BooleanInfoFilter();

		booleanInfoFilter.setBoolean(_getBoolean(values));

		return booleanInfoFilter;
	}

	private Map<String, Boolean> _getBoolean(Map<String, String[]> values) {
		Map<String, Boolean> booleanSet = new HashMap<>();

		for (Map.Entry<String, String[]> entry : values.entrySet()) {
			if (!StringUtil.startsWith(
				entry.getKey(),
				BooleanInfoFilter.FILTER_TYPE_NAME +
				StringPool.UNDERLINE)) {

				continue;
			}

			String[] pairValues = entry.getValue();

			for (String pairValue: pairValues) {
				String[] filterValue = StringUtil.split(pairValue, ",");
				if(filterValue.length != 2) {
					continue;
				}

				String fieldName = filterValue[0];
				Boolean booleanValue = Boolean.valueOf(filterValue[1]);
				booleanSet.put(fieldName, booleanValue);
			}
		}

		return booleanSet;

	}

	@Override
	public String getKey() {
		return InfoFilterProvider.super.getKey();
	}
}
