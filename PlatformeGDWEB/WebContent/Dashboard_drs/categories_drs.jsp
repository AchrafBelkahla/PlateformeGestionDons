
<%@ include file="__header.jsp"%>
<%@ include file="menu_drs.jsp"%>
<section class="page-section light-bg">

<div class="container">

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
								class="col-xs-6 col-sm-6 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Produits</span></strong>
							</div>
						</div>
						<hr class="margin-20">
						<c:forEach var="categorie" items="${categories}">
							<div class="row" id="${categorie.getIdC()}">
								<div class="col-xs-2 col-sm-2 text-center">
									<h6>${categorie.getLibelle()}</h6>
								</div>
								<div class="col-xs-6 col-sm-6 text-center">
									<c:forEach var="produit" items="${categorie.getProduits()}">
										${produit.getLibelle()} / 
									</c:forEach>
								</div>
							</div>
							<hr class="margin-20">
						</c:forEach>
						
					</div>
				</div>
			</div>
			<jsp:include page="../pagination.jsp">
					        <jsp:param name="currentPage" value="${currentPage}"/>
					        <jsp:param name="noOfPages" value="${noOfPages}"/>
					        <jsp:param name="link" value="Liste_categories_Drs"/>
					    </jsp:include>
		</div>

		
	</div>
</section>
<%@ include file="__footer.jsp"%>