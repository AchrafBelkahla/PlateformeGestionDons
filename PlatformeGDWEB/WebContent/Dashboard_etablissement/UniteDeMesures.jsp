<%@ include file="__header.jsp"%>
<section class="page-section light-bg">
	<div class="container">
		<h1>Liste des unités de mesure</h1>

 <a href="ajoutUdm"
			class="btn btn-success">Ajouter une Unité de mesure</a>			
			
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Unité de mesure</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="udm" items="${udms}">			
    <tr id="${udm.getIdUnite()}">
      <td><c:out value="${udm.getIdUnite()}"></c:out></td>
		<td><button class="btn btn-danger btn-sm" id="deleteudm">
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
					case "deleteudm":
						async("delete",{id:id})
						break;
				}
			})
			function async(method,data){
				console.log(data);
				$.ajax({
					url:"udms",
					data:data,
					method:method
			})
			.done(
					function(data){
						console.log(data);
						if(data){
							location.href="udms"
						}
					}
			);
		}
		})	
</script>
</section>
<%@ include file="__footer.jsp"%>