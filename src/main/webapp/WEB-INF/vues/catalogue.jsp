<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Catalogue</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4">
    <span class="navbar-brand">StockMaster Pro</span>

    <div class="ms-auto d-flex align-items-center">
        <span class="text-white me-3">
            Utilisateur : ${sessionScope.user}
        </span>

        <form action="logout" method="post">
            <button type="submit" class="logout-btn">Déconnexion</button>
        </form>
    </div>
</nav>

<div class="container catalogue-container">
    <h3 class="mb-4">Catalogue des produits</h3>

    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prix</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listeProduits}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.prix} DT</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <p class="text-muted">
        Dernière visite : ${lastVisit}
    </p>
</div>

</body>
</html>
