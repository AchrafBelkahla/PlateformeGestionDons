<%@ include file="__header.jsp"%>
<%@ include file="menu_donnateur.jsp"%>
<section class="page-section">
	<div class="container">
		<div class="row">
			
			<div class="vcenter col-md-12">
				<a href="besoinsByEtablissement?currentPage=1" class="btn btn-default text-right">Retour</a>
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
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Libellé
										Fournisseur</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Adresse</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Gouvernorat</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Numéro de Tel</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Produits</span></strong>
							</div>
						</div>
						<hr class="margin-20">
						<c:forEach items="${fournisseurs}" var="b">
							<div class="row">
								<div class="col-xs-2 col-sm-2 fund-bottom-border">
									${b.getLibelle()}
								</div>
								<div class="col-xs-2 col-sm-2 fund-bottom-border">
									${b.getAdresseF()}
								</div>
								<div class="col-xs-2 col-sm-2 fund-bottom-border">
									${b.getGouvernorat()}
								</div>
								<div class="col-xs-2 col-sm-2 fund-bottom-border">
									${b.getNumTelF()}
								</div>
								<div class="col-xs-4 col-sm-4 fund-bottom-border">
									<c:forEach items="${b.getProduits()}" var="p">
      										${p.getLibelle()} / 
      								</c:forEach>
								</div>
							</div>
						</c:forEach> 
						<hr class="margin-20">
					</div>
					<jsp:include page="../pagination.jsp">
	        			<jsp:param name="currentPage" value="${currentPage}"/>
	        			<jsp:param name="noOfPages" value="${noOfPages}"/>
	        			<jsp:param name="link" value="Liste_Fournisseurs_donateur"/>
	    			</jsp:include>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="__footer.jsp"%>