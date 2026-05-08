<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Forage</title>
</head>
<body>
    <h1>Bienvenue ${username}</h1>
    <form action="/demande" method="get">
        <label for="dateDemande">Date de demande:</label>
        <input type="date" name="dateDemande" placeholder="Date de la demande" />

        <select name="Region" id="Region">
            <option value="">-- Choisir une région --</option>
           <%
               java.util.List<model.Region> regions = (java.util.List<model.Region>) request.getAttribute("listRegion");
               if (regions != null) {
                   for (model.Region region : regions) {
           %>
                <option value="<%= region.getId() %>"><%= region.getNom() %></option>
           <%
                   }
               }
           %>
        </select>

        <label for="District">District:</label>
       <select name="District" id="District">
        <option value=""></option>
       </select>

        <label for="Commune">Commune:</label>
        <select name="Commune" id="Commune">
            <option value=""></option>
        </select>

        <label for="Personne">Personne:</label>
        <input type="text" name="Personne" placeholder="Personne">

        <button type="submit">OK</button>
    </form>

    <script>
        window.APP_CONTEXT = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/ressources/js/home.js"></script>
</body>
</html>