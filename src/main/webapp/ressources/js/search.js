document.addEventListener('DOMContentLoaded', function () {
  const searchBtn = document.getElementById('searchBtn');
  if (!searchBtn) return;

  searchBtn.addEventListener('click', function () {
    const refInput = document.getElementById('reference');
    const resultDiv = document.getElementById('searchResult');
    if (!refInput) return;
    const reference = refInput.value.trim();
    if (!reference) {
      alert('Veuillez entrer une référence.');
      return;
    }

    resultDiv.innerHTML = '<p>Recherche en cours...</p>';

    fetch(CONTEXT_PATH + '/home/findByReference?reference=' + encodeURIComponent(reference))
      .then(function (resp) {
        if (!resp.ok) throw new Error('Erreur réseau');
        return resp.json();
      })
      .then(function (data) {
        if (!data) {
          resultDiv.innerHTML = '<p>Aucune demande trouvée pour cette référence.</p>';
          return;
        }

        const date = data.dateDemande ? new Date(data.dateDemande).toLocaleString() : '';
        let html = '<div style="border:1px solid #ccc;padding:8px;">';
        html += '<h3>Demande #' + (data.id || '') + '</h3>';
        html += '<p><strong>Date:</strong> ' + date + '</p>';
        html += '<p><strong>Lieu:</strong> ' + (data.lieu || '') + '</p>';
        html += '<p><strong>Personne:</strong> ' + (data.personne || '') + '</p>';
        html += '<p><strong>Region:</strong> ' + (data.region || '') + '</p>';
        html += '</div>';
        resultDiv.innerHTML = html;
      })
      .catch(function (err) {
        console.error(err);
        resultDiv.innerHTML = '<p>Erreur lors de la recherche.</p>';
      });
  });
});
