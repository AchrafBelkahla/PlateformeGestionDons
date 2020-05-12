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

	</div>
	<!-- 	<div class="container"> -->
	<!-- 		<a href="ajoutFournisseurMinistere" class="btn btn-success">Ajouter un -->
	<!-- 			fournisseur</a> -->
	<!-- 		<div class="row"> -->
	<!-- 			<div class="vcenter col-md-12 text-center"> -->
	<!-- 				<div class="visible-sm-block visible-xs-block top-margin-10"> -->
	<!-- 					<div class="form-box-cha9a9a widget bottom-pad-0" -->
	<!-- 						style="padding-top: 0px;"></div> -->
	<!-- 				</div> -->

	<!-- 				<div class="form-box-cha9a9a top-margin-20" -->
	<!-- 					style="padding: 10px !important;"> -->
	<!-- 					<div class="container"> -->
	<!-- 						<h1>Liste des Fournisseurs</h1> -->
	<!-- 						<div class="row"> -->

	<!-- 						</div> -->
	<!-- 						<hr class="margin-20"> -->
	<%-- 						<c:forEach var="fournisseur" items="${fournisseurs}"> --%>
	<%-- 							<div class="row" id="${fournisseur.getIdF()}"> --%>
	<!-- 								<div class="col-xs-2 col-sm-2 text-center"> -->
	<%-- 									<h6>${fournisseur.getLibelle()}</h6> --%>
	<!-- 								</div> -->
	<!-- 								<div class="col-xs-2 col-sm-2 text-center"> -->
	<%-- 									<h6>${fournisseur.getAdresseF()}, --%>
	<%-- 										${fournisseur.getCodePostal()}, --%>
	<%-- 										${fournisseur.getGouvernorat()}</h6> --%>
	<!-- 								</div> -->
	<!-- 								<div class="col-xs-2 col-sm-2 text-center"> -->
	<%-- 									<h6>${fournisseur.getEmailF()}</h6> --%>
	<!-- 								</div> -->
	<!-- 								<div class="col-xs-2 col-sm-2 text-center"> -->
	<%-- 									<h6>${fournisseur.getNumTelF()}</h6> --%>
	<!-- 								</div> -->
	<!-- 								<div class="col-xs-2 col-sm-2 text-center"> -->
	<%-- 									<c:forEach items="${fournisseur.getProduits()}" var="p"> --%>
	<%-- 										${p.getLibelle()} /  --%>
	<%-- 									</c:forEach> --%>
	<!-- 								</div> -->
	<!-- 								<div class="col-xs-1 col-sm-1 text-center"> -->
	<%-- 									<a href="editFournisseur?idFournisseur=${fournisseur.getIdF()}" --%>
	<!-- 										class="btn btn-warning btn-sm" -->
	<!-- 										id="editfournisseur">Editer</a> -->
	<!-- 								</div> -->
	<%-- 								<div class="col-xs-1 col-sm-1 text-center" id="${fournisseur.getIdF()}"> --%>
	<!-- 									<button class="btn btn-danger btn-sm" id="deletefournisseur"> -->
	<!-- 										Supprimer</button> -->
	<!-- 								</div> -->
	<!-- 							</div> -->
	<%-- 						</c:forEach> --%>
	<!-- 						<div class="row"> -->
	<!-- 							<a href="#" class="btn btn-default btn-menu"><i -->
	<!-- 								class="fa icon-plus2"></i>Voir plus</a> -->
	<!-- 						</div> -->
	<!-- 					</div> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->





















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