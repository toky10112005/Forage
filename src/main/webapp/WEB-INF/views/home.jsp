<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ma Vue Spring MVC</title>
</head>
<body>
    <h1>Bienvenue ${username}</h1>
    <form action="/demande" method="get">
        <label for="dateDemande">Date de demande:</label>
        <input type="date" name="dateDemande" placeholder="Date de la demande" />

        <label for="Region">Region:</label>
        <input type="text" name="Region" placeholder="Region" />

        <label for="District">District:</label>
        <input type="text" name="District" placeholder="District" />

        <label for="Commune">Commune:</label>
        <input type="text" name="Commune" placeholder="Commune" />

        <label for="Personne">Personne:</label>
        <input type="text" name="Personne" placeholder="Personne">

        <button type="submit">OK</button>
    </form>
</body>
</html>