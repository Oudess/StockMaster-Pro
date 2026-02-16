<c:set var="cookieConsent" value="${cookie.cookieConsent.value}" />
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>StockMaster Pro</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- CSS personnalisé -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow p-4 text-center home-card">
        <h1 class="mb-3">StockMaster Pro</h1>
        <p class="text-muted">Application de gestion de stock</p>

        <a href="${pageContext.response.encodeURL('login.jsp')}" class="btn btn-primary w-100 mb-2">Se connecter</a>
        <a href="${pageContext.response.encodeURL('catalogue')}" class="btn btn-outline-secondary w-100">Accéder au catalogue</a>
    </div>
</div>
<c:if test="${empty cookieConsent}">
    <div class="cookie-banner">
        <p>
            Ce site utilise des cookies pour améliorer votre expérience.
        </p>

        <a href="${pageContext.response.encodeURL('cookie?action=accept')}"
           class="btn btn-success btn-sm">
            Accepter
        </a>

        <a href="${pageContext.response.encodeURL('cookie?action=decline')}"
           class="btn btn-danger btn-sm">
            Refuser
        </a>
    </div>
</c:if>

</body>
</html>
