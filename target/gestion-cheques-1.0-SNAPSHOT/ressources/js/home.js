function resetSelect(selectElement, placeholderText) {
	if (!selectElement) return;
	selectElement.innerHTML = `<option value="">${placeholderText}</option>`;
}

async function loadOptions(url, selectElement, loadingText, errorText) {
	if (!selectElement) return;

	selectElement.innerHTML = `<option value="">${loadingText}</option>`;

	try {
		const response = await fetch(url, {
			method: "GET",
			headers: {
				"X-Requested-With": "XMLHttpRequest",
			},
		});

		if (!response.ok) {
			throw new Error(`HTTP ${response.status}`);
		}

		const html = await response.text();
		selectElement.innerHTML = html;
	} catch (e) {
		selectElement.innerHTML = `<option value="">${errorText}</option>`;
		// eslint-disable-next-line no-console
		console.error(e);
	}
}

document.addEventListener("DOMContentLoaded", () => {
	const contextPath = (window.APP_CONTEXT || "").replace(/\/$/, "");

	const regionSelect = document.getElementById("Region");
	const districtSelect = document.getElementById("District");
	const communeSelect = document.getElementById("Commune");

	resetSelect(districtSelect, "-- Choisir un district --");
	resetSelect(communeSelect, "-- Choisir une commune --");

	if (!regionSelect) return;

	regionSelect.addEventListener("change", async () => {
		const regionId = regionSelect.value;

		resetSelect(communeSelect, "-- Choisir une commune --");

		if (!regionId) {
			resetSelect(districtSelect, "-- Choisir un district --");
			return;
		}

		const url = `${contextPath}/home/districts?regionId=${encodeURIComponent(regionId)}`;
		await loadOptions(url, districtSelect, "Chargement...", "Erreur de chargement");
	});

	if (!districtSelect) return;

	districtSelect.addEventListener("change", async () => {
		const districtId = districtSelect.value;

		if (!districtId) {
			resetSelect(communeSelect, "-- Choisir une commune --");
			return;
		}

		const url = `${contextPath}/home/communes?districtId=${encodeURIComponent(districtId)}`;
		await loadOptions(url, communeSelect, "Chargement...", "Erreur de chargement");
	});
});

