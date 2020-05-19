<%@ include file="__header.jsp"%>
<%@ include file="menu_drs.jsp"%>
<section class="page-section">
	<div class="container">
<!-- 		<a href="ajoutFournisseurMinistere" class="btn btn-success" >Ajouter un -->
<!-- 			fournisseur</a> -->
		<div class="row">
			<div class="vcenter col-md-12 text-center">
				<div class="visible-sm-block visible-xs-block top-margin-10">
					<div class="form-box-cha9a9a widget bottom-pad-0"
						style="padding-top: 0px;"></div>
				</div>

				<div class="form-box-cha9a9a top-margin-20"
					style="padding: 10px !important;">
					<div class="container">
						<h1>Liste des Fournisseurs</h1>
						<div class="row">
							<div
								class="col-xs-4 col-sm-4 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom fournisseur</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Adresse</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Adresse mail</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Numéro de
										télèphone</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Produits
										</span></strong>
							</div>
<!-- 							<div -->
<!-- 								class="col-xs-1 col-sm-1 text-center  lr-pad-10"> -->
<!-- 							</div> -->
<!-- 							<div class="col-xs-1 col-sm-1 text-center lr-pad-10"></div> -->
						</div>
						<hr class="margin-20">
						<c:forEach var="fournisseur" items="${fournisseurs}">
							<div class="row" id="${fournisseur.getIdF()}">
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${fournisseur.getLibelle()}</h6>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${fournisseur.getAdresseF()},
										${fournisseur.getCodePostal()},
										${fournisseur.getGouvernorat()}</h6>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${fournisseur.getEmailF()}</h6>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${fournisseur.getNumTelF()}</h6>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<c:forEach items="${fournisseur.getProduits()}" var="p">
										${p.getLibelle()} / 
									</c:forEach>
								</div>
<!-- 								<div class="col-xs-1 col-sm-1 text-center"> -->
<%-- 									<a href="editFournisseur?idFournisseur=${fournisseur.getIdF()}" --%>
<!-- 										class="btn btn-warning btn-sm" -->
<!-- 										id="editfournisseur">Editer</a> -->
<!-- 								</div> -->
<%-- 								<div class="col-xs-1 col-sm-1 text-center" id="${fournisseur.getIdF()}"> --%>
<!-- 									<button class="btn btn-danger btn-sm" id="deletefournisseur"> -->
<!-- 										Supprimer</button> -->
<!-- 								</div> -->
							</div>
							<hr class="margin-20">
						</c:forEach>
						
					</div>
					
				</div>
			</div>
			<jsp:include page="../pagination.jsp">
					        <jsp:param name="currentPage" value="${currentPage}"/>
					        <jsp:param name="noOfPages" value="${noOfPages}"/>
					        <jsp:param name="link" value="Liste_Fournisseurs"/>
					    </jsp:include>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("button").click(function() {
				let id = $(this).closest('div').attr('id');
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