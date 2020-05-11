<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">

	<div class="container">
	<a href="AjoutEtablissement"
			class="btn btn-success">Ajouter un établissement</a>	
		<div class="row">
			<div class="section-title margin-0">
				<h2 class="title">Les demandes d'inscription</h2>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Nom établissement</th>
					<th>Type</th>
					<th>Libellé</th>
					<th>Adresse</th>
					<th>Nom&prénom responsable</th>
					<th>Email</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${etablissements}" var="etab">
					<c:forEach items="${etab.getUtilisateurs()}" var="utilisateur">
						<c:if test="${utilisateur.getAccepted() == false}">
							<tr>
								<td>${etab.getNomEtablissement()}</td>
								<td></td>
								<td>${etab.getLibelle()}</td>
								<td>${etab.getAdresse().getAdresse()}<br>${etab.getAdresse().getGouvernorat()},
									${etab.getAdresse().getCodePostale()}
								</td>
								<td>${utilisateur.getNom()}${utilisateur.getPrenom()}</td>
								<td>${utilisateur.getEmail()}</td>

								<td>
									<a href="accepter_inscrit?code=${utilisateur.getIdut()}" class="btn btn-success">Accepter</a>
								</td>
								<td><a href="supprimer_inscrit?code=${utilisateur.getIdut()}" class="btn btn-danger">Supprimer</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
			</tbody>

		</table>

	</div>
</section>

<%@ include file="__footer.jsp"%>