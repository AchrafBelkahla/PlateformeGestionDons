
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
		<div class="container">
		<div class="row text-center">

			<h1>Liste des produits</h1>
		</div>
	</div>
		<div class="container">
				<a href="ajoutProduitMinistere" class="btn btn-success">Ajouter un produit</a>
				<a href="Importer_produit" class="btn btn-default">Importer un fichier excel des produits</a>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Produit</th>
					<th scope="col">Description technique</th>
					<th scope="col">Prix min</th>
					<th scope="col">Prix max</th>
					<th scope="col">Catégorie</th>
					<th scope="col">Fournisseurs</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produit" items="${ListProduits}">
					<tr id="${produit.getIdProduit()}">
						<td><c:out value="${produit.getLibelle()}"></c:out></td>
						<td><c:out value="${produit.getDescriptionTechnique()}"></c:out></td>
						<td><c:out value="${produit.getPrixMin()}"></c:out></td>
						<td><c:out value="${produit.getPrixMax()}"></c:out></td>
						<td><c:out value="${produit.getCategorie().getLibelle()}"></c:out></td>
						<td>
							<c:forEach items="${produit.getFournisseurs()}" var="a"> 
								<p>${a.getLibelle()} / <p> 
 							</c:forEach>
						</td>
						<td><c:forEach items="${fournisseur.getProduits()}" var="p">
      							${p.getLibelle()} / 
      						</c:forEach>
      					</td>
      					<td>
      						<a href="editProduitMinistere?idProduit=${produit.getIdProduit()}" class="btn btn-warning btn-sm" role="button" id="editproduit">Editer</a>
						</td>
						<td><button class="btn btn-danger btn-sm" id="deleteproduct">Supprimer </button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        <jsp:param name="currentPage" value="${currentPage}"/>
	        <jsp:param name="noOfPages" value="${noOfPages}"/>
	        <jsp:param name="link" value="Liste_produits"/>
	    </jsp:include>
	</div>

<script>
		$(document).ready(function() {
			$("button").click(function() {
				let id = $(this).closest('tr').attr('id');
				switch (this.id) {
					case "deleteproduct":
						console.log("delete product" + id);
						async("delete",{id:id})
						break;
// 					case "editproduct":
// 						console.log("new categorie");
// 						$("#categorieform").toggle("slow");
// 						break;
				}
			})
			function async(method,data){
				console.log(data);
				$.ajax({
					url:"Liste_produits",
					data:data,
					method:method
			})
			.done(
					function(data){
						console.log(data);
						if(data){
							location.href="Liste_produits"
						}
					}
			);
		}

		})	
</script>
</section>
<%@ include file="__footer.jsp"%>