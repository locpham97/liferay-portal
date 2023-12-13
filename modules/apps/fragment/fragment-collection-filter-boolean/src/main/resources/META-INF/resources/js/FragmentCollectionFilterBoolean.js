/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {
	getCollectionFilterValue,
	setCollectionFilterValue,
} from '@liferay/fragment-renderer-collection-filter-impl';

const ENTER_KEY = 'Enter';

export default function FragmentCollectionFilterBoolean({
	fragmentEntryLinkId,
	fragmentEntryLinkNamespace,
	isDisabled,
}) {
	const booleanInput = document.getElementById(
		`${fragmentEntryLinkNamespace}booleanInput`
	);

	if (booleanInput) {
		booleanInput.value = getCollectionFilterValue(
			'boolean',
			fragmentEntryLinkId
		);

		if (isDisabled) {
			booleanInput.disabled = true;

			if (booleanInput.parentElement && Liferay.Browser.isFirefox()) {
				import('../css/main.scss');

				booleanInput.parentElement.classList.add(
					'input-group-item--disabled'
				);
			}
		}
	}

	const booleanButton = document.getElementById(
		`${fragmentEntryLinkNamespace}booleanButton`
	);

	const handleSearch = () => {
		setCollectionFilterValue(
			'boolean',
			fragmentEntryLinkId,
			booleanInput.value
		);
	};

	const handleKeyDown = (event) => {
		if (event.key === ENTER_KEY) {
			handleSearch();
		}
	};

	booleanButton?.addEventListener('click', handleSearch);
	booleanInput?.addEventListener('keydown', handleKeyDown);

	return {
		dispose() {
			booleanButton?.removeEventListener('click', handleSearch);
			booleanInput?.removeEventListener('keydown', handleKeyDown);
		},
	};
}
