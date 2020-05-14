<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">
	<div class="container">
		<div class="row text-center">

			<h1>Liste des fournisseurs</h1>
		</div>
	</div>
	<div class="container">
		<a href="ajoutFournisseurMinistere" class="btn btn-success">Ajouter
			un fournisseur</a>
		<a href="Importer_fournisseur" class="btn btn-default">Importer un fichier des fournisseurs</a>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nom fournisseur</th>
					<th scope="col">Adresse</th>
					<th scope="col">Adresse mail</th>
					<th scope="col">Télèphone</th>
					<th scope="col">Produits</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fournisseur" items="${fournisseurs}">
					<tr id="${fournisseur.getIdF()}">
						<td><c:out value="${fournisseur.getLibelle()}"></c:out></td>
						<td><c:out
								value="${fournisseur.getAdresseF()},${fournisseur.getCodePostal()},${fournisseur.getGouvernorat()}"></c:out></td>
						<td><c:out value="${fournisseur.getEmailF()}"></c:out></td>
						<td><c:out value="${fournisseur.getNumTelF()}"></c:out></td>
						<td><c:forEach items="${fournisseur.getProduits()}" var="p">
      							${p.getLibelle()} / 
      						</c:forEach></td>
						<td><a
							href="editFournisseur?idFournisseur=${fournisseur.getIdF()}"
							class="btn btn-warning btn-sm" role="button" id="editfournisseur">Editer</a>
						</td>
						<td><button class="btn btn-danger btn-sm"
								id="deletefournisseur">Supprimer</button></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        <jsp:param name="currentPage" value="${currentPage}"/>
	        <jsp:param name="noOfPages" value="${noOfPages}"/>
	        <jsp:param name="link" value="Liste_Fournisseurs"/>
	    </jsp:include>
	</div>

	<script>
		$(document).ready(function() {
			$("button").click(function() {
				let id = $(this).closest('tr').attr('id');
				switch (this.id) {
				case "deletefournisseur":
					console.log("delete product" + id);
					async("delete", {
						id : id
					})
					break;
				}
			})
			function async(method, data) {
				console.log(data);
				$.ajax({
					url : "Liste_Fournisseurs",
					data : data,
					method : method
				}).done(function(data) {
					console.log(data);
					if (data) {
						location.href = "Liste_Fournisseurs"
					}
				});
			}

		})
	</script>
</section>
<%@ include file="__footer.jsp"%>