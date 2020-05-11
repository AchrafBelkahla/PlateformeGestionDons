
<%@ include file="__header.jsp"%>

<%@ include file="menu_etablissement.jsp"%>
<section class="page-section light-bg">
	<div class="container">
	<div class="row">
  		<div class="col-sm-8">
			<h1>Produit : ${produit.getLibelle()}</h1>
			<br>
			<h2>Categorie : ${produit.getCategorie().getLibelle()}</h2>
			<br>
		</div>
		<div class="col-sm-2">
		<br>
		  	<a href="produits" class="btn btn-default" role="button">Retour</a>
		</div>
	</div>
		<table class="table table-hover" border = "1">
				<tr>
					<td>Libelle </td>
					<td>Description Technique  </td>					
					<td>Intervalle du prix</td>
				</tr>
				<tr>
					<td>${produit.getLibelle() } </td>
					<td>${produit.getDescriptionTechnique() } </td>					
					<td>${produit.getPrixMin() } - ${produit.getPrixMax() }</td>
		</table>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Nom et Prenom</th>
      <th scope="col">Adresse</th>
      <th scope="col">Email</th>
      <th scope="col">Numero de Télephone</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="fournisseur" items="${fournisseurs}">
    <tr>
      <td><c:out value="${fournisseur.getLibelle()}"></c:out></td>   
      <td><c:out value="${fournisseur.getAdresseF()}"></c:out></td>
      <td><c:out value="${fournisseur.getEmailF()}"></c:out></td>
      <td><c:out value="${fournisseur.getNumTelF()}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
		
	</div>
	</section>
<%@ include file="__footer.jsp"%>