
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
	<div class="container">
		<div class="row text-center">

			<h1>Liste des catégories</h1>
		</div>
		
	</div>
	<div class="container">
		<a href="ajoutCategorieMinistere" class="btn btn-success">Ajouter une
			catégorie</a>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Catégorie</th>
					<th scope="col">Produits</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="categorie" items="${categories}">
					<tr id="${categorie.getIdC()}">
						<td><c:out value="${categorie.getLibelle()}"></c:out></td>
						<td>
							<c:forEach var="produit" items="${categorie.getProduits()}">
								<li><c:out value="${produit.getLibelle()}"></c:out></li>
							</c:forEach>
						</td>
						<td><button class="btn btn-danger btn-sm" id="deletecategorie">Supprimer
									</button></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        <jsp:param name="currentPage" value="${currentPage}"/>
	        <jsp:param name="noOfPages" value="${noOfPages}"/>
	        <jsp:param name="link" value="Liste_categories"/>
	    </jsp:include>
	</div>
	<script>
		$(document).ready(function() {
			$("button").click(function() {
				let id = $(this).closest('tr').attr('id');
				switch (this.id) {
				case "deletecategorie":
					console.log("delete categorie" + id);
					async("delete", {
						id : id
					})
					break;
				}
			})
			function async(method, data) {
				console.log(data);
				$.ajax({
					url : "Liste_categories",
					data : data,
					method : method
				}).done(function(data) {
					console.log(data);
					if (data) {
						location.href = "Liste_categories?currentPage=1"
					}
				});
			}

		})
	</script>
</section>
<%@ include file="__footer.jsp"%>