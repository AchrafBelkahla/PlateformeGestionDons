<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">

	<div class="container">
		<div class="row text-center">
			<h1>Liste des hôpitaux</h1>
		</div>
		<a href="AjoutEtablissement" class="btn btn-success">Ajouter un
			établissement</a>
			<a href="Importer_Etablissement" class="btn btn-default">Importer un fichier excel des établissements</a>
	</div>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nom établissement</th>
					<th scope="col">Libellé</th>
					<th scope="col">Adresse</th>
					<th scope="col">Nom&Prenom responsable</th>
					<th scope="col">Télèphone responsable</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="etab" items="${etablissements}">
					<tr>
						<td><c:out value="${etab.getNomEtablissement()}"></c:out></td>
						<td><c:out value="${etab.getLibelle()}"></c:out></td>
						<td>
							<h5>${etab.getAdresse().getGouvernorat()}<br>${etab.getAdresse().getAdresse()}
											, ${etab.getAdresse().getCodePostale()}
										</h5>
						</td>
						<td>
							<c:forEach items="${etab.getUtilisateurs()}" var="utilisateur">
											<c:if test="${utilisateur.getAccepted() == true}">
												${utilisateur.getPrenom()},${utilisateur.getNom()}<br>
											</c:if>
										</c:forEach>
						</td>
						<td>
							<c:forEach items="${etab.getUtilisateurs()}" var="utilisateur">
											<c:if test="${utilisateur.getAccepted() == true}">
												<c:forEach items="${utilisateur.getTelephone()}" var="tel">
													${tel.getNumero()}/
												</c:forEach>
												<br>
											</c:if>
										</c:forEach>
						</td>
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
	        	<jsp:param name="link" value="Liste_Etablissements"/>
	    </jsp:include>
	</div>

</section>
<%@ include file="__footer.jsp"%>