<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">
	<div class="container">
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
							<div class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité restante</span></strong>
							</div>
							<div class="col-xs-1 col-sm-1 text-center lr-pad-10">
								<strong><span class="text-color">Priorité</span></strong>
							</div>
							<div class="col-xs-1 col-sm-1 text-center lr-pad-10">
								<strong><span class="text-color"></span></strong>
							</div>
						</div>
						<hr class="margin-20">
						<c:forEach var="besoin" items="${besoins}">
								<div class="row">
									<div class="col-xs-2 col-sm-2">
										<h6>${besoin.getProduit().getLibelle()}</h6>
									</div>
									<div class="col-xs-2 col-sm-2">
										<h6>${besoin.getDateBesoin()}</h6>
									</div>
									<div class="col-xs-2 col-sm-2 ">
										<h6>${besoin.getEtablisement().getNomEtablissement()}</h6>
									</div>
									<div class="col-xs-2 col-sm-2 ">
										<h5>${besoin.getQuantiteInitiale()}</h6>
									</div>
									<div class="col-xs-2 col-sm-2 ">
										<h5>${besoin.getQuantiteRestante()}</h6>
									</div>
									<div class="col-xs-1 col-sm-1">
										<h6>${besoin.getPriorite()}</h6>
									</div>
									<div class="col-xs-1 col-sm-1">
										<a href="besoinMinistere?idBesoin=${besoin.getIdBesoin()}" 
										class="btn btn-default btn-sm btn-menu" role="button" id="consulter">Consulter</a>
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
</section>
<%@ include file="__footer.jsp"%>