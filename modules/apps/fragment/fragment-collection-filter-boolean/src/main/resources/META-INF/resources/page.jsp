<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<div class="form-group form-group-sm">
	<label class="control-label <%= fragmentCollectionFilterBooleanDisplayContext.isShowLabel() ? "" : "sr-only" %>" for="<%= fragmentCollectionFilterBooleanDisplayContext.getFragmentEntryLinkNamespace() %>keywordsInput">
		<%= fragmentCollectionFilterBooleanDisplayContext.getLabel() %>
	</label>

	<div class="input-group">
		<div class="input-group-item">
			<input class="form-control form-control-sm input-group-inset input-group-inset-after" id="<%= fragmentCollectionFilterBooleanDisplayContext.getFragmentEntryLinkNamespace() %>booleanInput" placeholder="<%= LanguageUtil.get(request, "search") %>" type="checkbox" value="" />

			<div class="input-group-inset-item input-group-inset-item-after">
				<clay:button
					aria-label='<%= LanguageUtil.get(request, "submit") %>'
					disabled="<%= fragmentCollectionFilterBooleanDisplayContext.isDisabled() %>"
					displayType="unstyled"
					icon="search"
					id='<%= fragmentCollectionFilterBooleanDisplayContext.getFragmentEntryLinkNamespace() + "booleanButton" %>'
				/>
			</div>
		</div>
	</div>

	<liferay-frontend:component
		context="<%= fragmentCollectionFilterBooleanDisplayContext.getProps() %>"
		module="js/FragmentCollectionFilterBoolean"
	/>
</div>