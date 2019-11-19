<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
    <ul class="hideOnPhone">
        <li><a href="${pageContext.request.contextPath}/">Accueil</a> </li>
        <li><a href="${pageContext.request.contextPath}/login">Se loguer</a> </li>
        <li><a href="${pageContext.request.contextPath}/logout">Se déconnecter</a> </li>
        <li><a href="${pageContext.request.contextPath}/user/list">Liste des utilisateurs</a> </li>
        <li><a href="${pageContext.request.contextPath}/search">Rechercher & modifer</a> </li>
        <li><a href="${pageContext.request.contextPath}/search/listsites">List des sites</a> </li>
        <li><a href="${pageContext.request.contextPath}/user/registeruser">S'enregistrer</a></li>
        <li><a href="${pageContext.request.contextPath}/user/moncompte">Mon compte</a></li>
    </ul>
</nav>
