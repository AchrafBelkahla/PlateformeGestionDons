<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">
	<div class="container">
		<div class="row text-center">

			<h1>Liste des Besoins</h1>
		</div>
	</div>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nom produit</th>
					<th scope="col">Date cr�ation</th>
					<th scope="col">B�n�ficiaire</th>
					<th scope="col">Quantit� initiale</th>
					<th scope="col">Quantit� restante</th>
					<th scope="col">Priorit�</th>
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
						<td><a href="besoinMinistere?idBesoin=${besoin.getIdBesoin()}" 
										class="btn btn-default" id="consulter">Consulter</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        	<jsp:param name="currentPage" value="${currentPage}"/>
	        	<jsp:param name="noOfPages" value="${noOfPages}"/>
	        	<jsp:param name="link" value="Liste_Besoins"/>
	    </jsp:include>
	</div>

</section>
<%@ include file="__footer.jsp"%>