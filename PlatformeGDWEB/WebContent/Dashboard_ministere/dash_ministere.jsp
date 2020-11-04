<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">
	
	
	
	<div class="container">
		<div class="row text-center">

			<h1>Liste des établissements</h1>
		</div>
		<a href="AjoutEtablissement"
			class="btn btn-success">Ajouter un établissement</a>	
			<a href="Demandes_inscrit"
			class="btn btn-default">Les demandes d'inscription</a>
						<a href="choixEtablissement"
			class="btn btn-warning">Changer responsable</a>
	</div>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nom Etablissement</th>
					<th scope="col">Type</th>
					<th scope="col">Adresse</th>
					<th scope="col">Nom & prénom responsable</th>
					<th scope="col">Contact responsable</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${etablissements}">
					<tr>
						<td><c:out value="${b.getNomEtablissement()}"></c:out></td>
									<c:choose>	
									<c:when test="${b.getDrs()==true}">
									<td>DRS</td>
									</c:when>
									</c:choose>
									<c:choose>	
									<c:when test="${b.getIntermediaire()==true}">
									<td>Intemédiaire</td>
									</c:when>
									</c:choose>
									<c:choose>	
									<c:when test="${b.getHospital()==true}">
									<td>Hopital</td>
									</c:when>
									</c:choose>																		
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
	        	<jsp:param name="link" value="Ministere"/>
	    </jsp:include>
	</div>
	
</section>
<%@ include file="__footer.jsp"%>