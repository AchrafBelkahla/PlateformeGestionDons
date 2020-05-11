
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
	<div class="container">
		<a href="ajoutCategorieMinistere" class="btn btn-success">Ajouter une
			catégorie</a>
		<div class="row">
			<div class="vcenter col-md-12 text-center">
				<div class="visible-sm-block visible-xs-block top-margin-10">
					<div class="form-box-cha9a9a widget bottom-pad-0"
						style="padding-top: 0px;"></div>
				</div>

				<div class="form-box-cha9a9a top-margin-20"
					style="padding: 10px !important;">
					<div class="container">
						<h1>Liste des catégories</h1>
						<div class="row">
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Catégorie</span></strong>
							</div>
							<div
								class="col-xs-4 col-sm-4 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Produits</span></strong>
							</div>
							<div class="col-xs-2 col-sm-2 text-center lr-pad-10"></div>
						</div>
						<hr class="margin-20">
						<c:forEach var="categorie" items="${categories}">
							<div class="row" id="${categorie.getIdC()}">
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${categorie.getLibelle()}</h6>
								</div>
								<div class="col-xs-4 col-sm-4 text-center">
									<c:forEach var="produit" items="${categorie.getProduits()}">
										<li><c:out value="${produit.getLibelle()}"></c:out></li>
									</c:forEach>
								</div>
								<div class="col-xs-2 col-sm-2 text-center" id="${categorie.getIdC()}">
									<button class="btn btn-danger btn-sm" id="deletecategorie">Supprimer
									</button>
								</div>
							</div>
						</c:forEach>
						<div class="row">
							<a href="#" class="btn btn-default btn-menu"><i
								class="fa icon-plus2"></i>Voir plus</a>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>
	<script>
		$(document).ready(function() {
			$("button").click(function() {
				let id = $(this).closest('div').attr('id');
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
						location.href = "Liste_categories"
					}
				});
			}

		})
	</script>
</section>
<%@ include file="__footer.jsp"%>