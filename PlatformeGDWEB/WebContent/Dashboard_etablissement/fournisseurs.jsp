
<%@ include file="__header.jsp"%>

<%@ include file="menu_etablissement.jsp"%>
<section class="page-section light-bg">
	<div class="container">
		<h1>Liste des fournisseurs</h1>

 <a href="ajoutFournisseur"
			class="btn btn-success">Ajouter un fournisseur</a>			
			
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Libellé</th>
      <th scope="col">Adresse</th>
      <th scope="col">Email</th>
      <th scope="col">Numero de Télèphone</th>
      <th scope="col">Produits</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="fournisseur" items="${fournisseurs}">
    <tr id="${fournisseur.getIdF()}">
      <td><c:out value="${fournisseur.getLibelle()}"></c:out></td>   
      <td><c:out value="${fournisseur.getAdresseF()}, ${fournisseur.getCodePostal()}, ${fournisseur.getGouvernorat()}"></c:out></td>
      <td><c:out value="${fournisseur.getEmailF()}"></c:out></td>
      <td><c:out value="${fournisseur.getNumTelF()}"></c:out></td>
      <td>
      	<c:forEach items="${fournisseur.getProduits()}" var="p">
      		${p.getLibelle()} / 
      	</c:forEach>
      </td>
      <td><a href="editFournisseur?idFournisseur=${fournisseur.getIdF()}" 
      	class="btn btn-warning btn-sm" role="button" id="editfournisseur">Editer</a> </td>
	  <td><button class="btn btn-danger btn-sm" id="deletefournisseur">
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
					case "deletefournisseur":
						console.log("delete product" + id);
						async("delete",{id:id})
						break;
				}
			})
			function async(method,data){
				console.log(data);
				$.ajax({
					url:"fournisseurs",
					data:data,
					method:method
			})
			.done(
					function(data){
						console.log(data);
						if(data){
							location.href="fournisseurs"
						}
					}
			);
		}

		})	
</script>
</section>
<%@ include file="__footer.jsp"%>