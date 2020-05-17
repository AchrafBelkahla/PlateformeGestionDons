<%@ include file="__header.jsp"%>
<%@ include file="menu_drs.jsp"%>
<section class="page-section">
<div class="container">
<a href="ajoutBesoinDrs"
			class="btn btn-success">Ajouter besoin</a>
		<div class="row">
			<div class="vcenter col-md-12 text-center">
				<div class="visible-sm-block visible-xs-block top-margin-10">
					<div class="form-box-cha9a9a widget bottom-pad-0"
						style="padding-top: 0px;"></div>
				</div>

				<div class="form-box-cha9a9a top-margin-20"
					style="padding: 10px !important;">
					<div class="container">
						<h1>Liste des Besoins</h1>
						<div class="row">
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom produit</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Date création</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Bénéficiaire</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité initiale</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité restante
										</span></strong>
							</div>
							<div class="col-xs-1 col-sm-1 text-center fund-bottom-border  lr-pad-10">Priorité
							</div>
							<div class="col-xs-1 col-sm-1 text-center lr-pad-10"></div>
						</div>
						<hr class="margin-20">
						<c:forEach var="besoin" items="${besoins}">
							<div class="row" id="${fournisseur.getIdF()}">
								<div class="col-xs-2 col-sm-2 ">
									${besoin.getProduit().getLibelle()}
								</div>
								<div class="col-xs-2 col-sm-2 ">
									${besoin.getDateBesoin()}
								</div>
								<div class="col-xs-2 col-sm-2 ">
									${besoin.getEtablisement().getNomEtablissement()}
								</div>
								<div class="col-xs-2 col-sm-2 ">
									${besoin.getQuantiteInitiale()}
								</div>
								<div class="col-xs-2 col-sm-2">
									${besoin.getQuantiteRestante()}
								</div>
								<div class="col-xs-1 col-sm-1">
									${besoin.getPriorite()}
								</div>
								<div class="col-xs-1 col-sm-1" id="${fournisseur.getIdF()}">
									<a href="besoinDrs?idBesoin=${besoin.getIdBesoin()}" 
										class="btn btn-default btn-sm btn-menu" role="button" id="consulter">Consulter</a>
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
					        <jsp:param name="link" value="Liste_Besoins_Drs"/>
					    </jsp:include>
		</div>
	</div>

</section>
<%@ include file="__footer.jsp"%>