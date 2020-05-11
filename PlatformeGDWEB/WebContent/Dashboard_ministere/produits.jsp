
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
	<div class="container">
	<a href="ajoutProduitMinistere" class="btn btn-success">Ajouter un
			produit</a>
		<div class="row">
			<div class="vcenter col-md-12 text-center">
				<div class="visible-sm-block visible-xs-block top-margin-10">
					<div class="form-box-cha9a9a widget bottom-pad-0"
						style="padding-top: 0px;"></div>
				</div>

				<div class="form-box-cha9a9a top-margin-20"
					style="padding: 10px !important;">
					<div class="container">
						<h1>Liste des produits</h1>
						<div class="row">
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Produit</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Description technique</span></strong>
							</div>
							<div
								class="col-xs-1 col-sm-1 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Prix min</span></strong>
							</div>
							<div
								class="col-xs-1 col-sm-1 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Prix max</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Catégorie</span></strong>
								
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Fournisseurs</span></strong>
								
							</div>
							<div class="col-xs-1 col-sm-1 text-center lr-pad-10"></div>
							<div class="col-xs-1 col-sm-1 text-center lr-pad-10"></div>
						</div>
						<hr class="margin-20">
						<c:forEach var="produit" items="${ListProduits}">
							<div class="row" id="${produit.getIdProduit()}">
							<div class="col-xs-2 col-sm-2 text-center">
							<a href="produitMinistere?idProduit=${produit.getIdProduit()}">${produit.getLibelle() } </a>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${produit.getDescriptionTechnique()}</h6>
								</div>
								<div class="col-xs-1 col-sm-1 text-center">
									<h6>${produit.getPrixMin()}</h6>
								</div>
								<div class="col-xs-1 col-sm-1 text-center">
									<h6>${produit.getPrixMax()}</h6>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${produit.getCategorie().getLibelle()}</h6>
								</div>
								<div class="col-xs-2 col-sm-2">
									<c:forEach items="${produit.getFournisseurs()}" var="a">
										<p>${a.getLibelle()} / <p>
									</c:forEach>
								</div>
								<div class="col-xs-1 col-sm-1">
									<a href="editProduitMinistere?idProduit=${produit.getIdProduit()}" class="btn btn-warning btn-sm" role="button" id="editproduit">Editer</a>
								</div>
								<div class="col-xs-1 col-sm-1" id="${produit.getIdProduit()}">
									<button class="btn btn-danger btn-sm" id="deleteproduct">
					Supprimer </button>
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