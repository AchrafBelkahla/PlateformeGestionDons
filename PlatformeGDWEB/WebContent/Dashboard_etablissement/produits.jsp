
<%@ include file="__header.jsp"%>

<%@ include file="menu_etablissement.jsp"%>
<section class="page-section light-bg">
	<div class="container">
		<h1>Liste des produits</h1>

 <a href="ajoutProduit"
			class="btn btn-success">Ajouter un produit</a>			
			
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Produit</th>
      <th scope="col">Description technique</th>
      <th scope="col">Prix min</th>
      <th scope="col">Prix max</th>
      <th scope="col">Catégorie</th>
      <th scope="col">Unite de mesure</th> 
      <th scope="col">Fournisseurs</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="produit" items="${ListProduits}">			
    <tr id="${produit.getIdProduit()}">
      <td>${produit.getLibelle() }</td>    
      <td><c:out value="${produit.getDescriptionTechnique()}"></c:out></td>
      <td><c:out value="${produit.getPrixMin() }"></c:out></td>
      <td><c:out value="${produit.getPrixMax()}"></c:out></td>
      <td><c:out value="${produit.getCategorie().getLibelle()}"></c:out></td>
      <td><c:out value="${produit.getUniteDeMesure().getIdUnite()}"></c:out></td>
      <td>
      	<c:forEach items="${produit.getFournisseurs()}" var="a">
			<p>${a.getLibelle()} / <p>
		</c:forEach>
      </td>
<td><a href="editProduit?idProduit=${produit.getIdProduit()}" class="btn btn-warning btn-sm" role="button" id="editproduit">Editer</a> </td>
<td><button class="btn btn-danger btn-sm" id="deleteproduct">
					Supprimer </button></td>
			
    </tr>
    </c:forEach>
  </tbody>
</table>

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
					url:"produits",
					data:data,
					method:method
			})
			.done(
					function(data){
						console.log(data);
						if(data){
							location.href="produits"
						}
					}
			);
		}

		})	
</script>
</section>
<%@ include file="__footer.jsp"%>