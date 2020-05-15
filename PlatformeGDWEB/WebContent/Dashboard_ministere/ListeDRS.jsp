<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">

	<div class="container">
		<div class="row text-center">

			<h1>Liste des DRS</h1>
		</div>
	</div>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nom DRS</th>
					<th scope="col">Adresse</th>
					<th scope="col">Nom & prénom responsable</th>
					<th scope="col">Contact responsable</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${etablissements}">
					<tr>
						<td><c:out value="${b.getNomEtablissement()}"></c:out></td>
						<td><c:out value="${b.getAdresse().getAdresse()}, ${b.getAdresse().getGouvernorat()}, ${b.getAdresse().getCodePostale()}"></c:out></td>
						<td>
							<c:forEach items="${b.getUtilisateurs()}" var="utilisateur">
											<h6>${utilisateur.getNom()}, ${utilisateur.getPrenom()}</h6><br>
										</c:forEach>
						</td>
						<td>
							<c:forEach items="${b.getUtilisateurs()}" var="utilisateur">
											<c:forEach items="${utilisateur.getTelephone()}" var="tel">
												${tel.getNumero()}, 
											</c:forEach>
										</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        	<jsp:param name="currentPage" value="${currentPage}"/>
	        	<jsp:param name="noOfPages" value="${noOfPages}"/>
	        	<jsp:param name="link" value="Liste_DRS"/>
	    </jsp:include>
	</div>
</section>
<%@ include file="__footer.jsp"%>