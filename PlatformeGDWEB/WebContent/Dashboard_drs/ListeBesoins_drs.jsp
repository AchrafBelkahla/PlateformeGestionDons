<%@ include file="__header.jsp"%>
<%@ include file="menu_drs.jsp"%>
<section class="page-section">
	<div class="container">
		<div class="row text-center">
			<h1>Liste des Besoins</h1>
		</div>
		<a href="ajoutBesoinDrs"
			class="btn btn-success">Ajouter besoin</a>
	</div>
	
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nom produit</th>
					<th scope="col">Date création</th>
					<th scope="col">Bénéficiaire</th>
					<th scope="col">Quantité initiale</th>
					<th scope="col">Quantité restante</th>
					<th scope="col">Priorité</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="besoin" items="${besoins}">
					<tr>
						<td><c:out value="${besoin.getProduit().getLibelle()}"></c:out></td>
						<td><c:out value="${besoin.getDateBesoin()}"></c:out></td>
						<td><c:out value="${besoin.getEtablisement().getNomEtablissement()}"></c:out></td>
						<td><c:out value="${besoin.getQuantiteInitiale()}"></c:out></td>
						<td><c:out value="${besoin.getQuantiteRestante()}"></c:out></td>
						<td><c:out value="${besoin.getPriorite()}"></c:out></td>
						<td><a href="besoinDrs?idBesoin=${besoin.getIdBesoin()}" 
										class="btn btn-default btn-sm btn-menu" role="button" id="consulter">Consulter</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        	<jsp:param name="currentPage" value="${currentPage}"/>
	        	<jsp:param name="noOfPages" value="${noOfPages}"/>
	        	<jsp:param name="link" value="Liste_Besoins_Drs"/>
	    </jsp:include>
	</div>
</section>
<%@ include file="__footer.jsp"%>