<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des demandes</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Liste des demandes</h1>
    
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <% if (request.getAttribute("demandeStatusList") != null) { %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Personne</th>
                    <th>Région</th>
                    <th>Lieu</th>
                    <th>Date Demande</th>
                    <th>Statut</th>
                    <th>Date Mutation</th>
                </tr>
            </thead>
            <tbody>
                <%
                    java.util.ArrayList<model.DemandeStatus> demandeStatusList = 
                        (java.util.ArrayList<model.DemandeStatus>) request.getAttribute("demandeStatusList");
                    if (demandeStatusList != null && !demandeStatusList.isEmpty()) {
                        for (model.DemandeStatus ds : demandeStatusList) {
                            model.Demande demande = ds.getDemande();
                            model.Status status = ds.getStatus();
                %>
                <tr>
                    <td><%= demande.getId() %></td>
                    <td><%= demande.getPersonne() %></td>
                    <td><%= demande.getRegion() %></td>
                    <td><%= demande.getLieu() %></td>
                    <td><%= demande.getDateDemande() %></td>
                    <td><%= status != null ? status.getNom() : "N/A" %></td>
                    <td><%= ds.getDatemutation() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="7">Aucune demande trouvée</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p>Aucune demande disponible.</p>
    <% } %>

    <br>
    <a href="${pageContext.request.contextPath}/">Retour à l'accueil</a>
</body>
</html>