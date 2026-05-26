<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recherche</title>
</head>
<body>
    <!-- <form action="" method="get"> -->
        <label for="reference">Reference:</label>
        <input type="text" id="reference" name="reference" placeholder="Saisir reference">
        <button type="button" id="searchBtn">Rechercher</button>
        <div id="searchResult" style="margin-top:1rem;"></div>

        <script>
           const CONTEXT_PATH = '${pageContext.request.contextPath}';
        </script>

        <script src="${pageContext.request.contextPath}/ressources/js/search.js"></script>
    <!-- </form> -->
</body>
</html>