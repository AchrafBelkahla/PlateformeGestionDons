<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="__header.jsp" %>

<%@ include file="menu_etablissement.jsp"%>
<section class="page-section light-bg">
<div class="container">	
	<h1>Liste des besoins</h1>
 <a href="ajoutBesoin"
			class="btn btn-success">Ajouter besoin</a>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Besoin</th>
      <th scope="col">Quantité totale</th>
      <th scope="col">Quantité restante</th>
      <th scope="col">Etat</th>
      <th scope="col">Date création</th>
      <th scope="col">Priorité</th> 
      <th scope="col">Motif</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="besoin" items="${ListBesoins}">			
    <tr >
    <c:if test="${besoin.getReaffected() == false }">
      <td><c:out value="${besoin.getProduit().getLibelle()}"></c:out></td>    
      <td><c:out value="${besoin.getQuantiteInitiale()} ${besoin.getProduit().getUniteDeMesure().getIdUnite()}"></c:out></td>
      <td><c:out value="${besoin.getQuantiteRestante()} ${besoin.getProduit().getUniteDeMesure().getIdUnite()}"></c:out></td>
      <td><c:out value="${besoin.getEtat()}"></c:out></td>
      <td><fmt:formatDate type = "both"  value = "${besoin.getDateBesoin()}"/></td>
      <td><c:out value="${besoin.getPriorite()}"></c:out></td>
      <td><c:out value="${besoin.getMotif()}"></c:out></td>
      <td><a href="besoin?idBesoin=${besoin.getIdBesoin()}" class="btn btn-default btn-sm" role="button" id="consulter">Consulter</a> </td>
    </c:if>
    <c:if test="${besoin.getReaffected() == true }">
      <td><c:out value="${besoin.getProduit().getLibelle()}"></c:out></td>    
      <td><c:out value="${besoin.getQuantiteInitiale()} ${besoin.getProduit().getUniteDeMesure().getIdUnite()}"></c:out></td>
      <td><c:out value="${besoin.getQuantiteRestante()} ${besoin.getProduit().getUniteDeMesure().getIdUnite()}"></c:out></td>
      <td><c:out value="${besoin.getEtat()}"></c:out></td>
      <td><fmt:formatDate type = "both"  value = "${besoin.getDateBesoin()}"/></td>
      <td><c:out value="${besoin.getPriorite()}"></c:out></td>
      <td><c:out value="${besoin.getMotif()}"></c:out></td>
      <td style="color: red;">Réaffecter par le ministere</td>
    </c:if>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>

</section>
<%@ include file="__footer.jsp"%>