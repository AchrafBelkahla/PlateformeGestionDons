<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>
<%@ include file="menu_donnateur.jsp"%>
<section class="page-section">
	<div class="container">
			<div class="row">
				<div class="section-title" data-animation="fadeInUp">
					<!-- Heading -->
					<h2 class="title">
						<strong>${etablissement.getNomEtablissement()}<span class="text-color"> </span></strong>
					</h2>
				</div>
			</div>
		<div class="row">
			<div class="col-md-12">
			
<!-- 				<div class="form-box-cha9a9a top-margin-20" -->
<!-- 					style="padding: 10px !important;"> -->
					<div class="container">

							<div class="pull-right btn-box">
								<a href="faire_un_don_step1?id_etablissement=${etablissement.getIdEtablissement()}" class="btn btn-default fs20 white igive-btn form-control" 
								role="button">Faire un don en nature</a>
							</div>
							<div class="pull-left btn-box">
								<a href="don_reglement?id_etablissement=${etablissement.getIdEtablissement()}" class="btn btn-default fs20 white igive-btn form-control" 
								role="button">Faire un don reglement</a>
							</div>
<!-- 						<form name="new_fund" method="post" class="form-group" -->
<%-- 							action="${pageContext.request.contextPath}/faire_un_don"> --%>
<!-- 							<div class="pull-right btn-box"> -->
<!-- 								<input class="btn btn-default fs20 white igive-btn form-control" -->
<!-- 									type="submit" name="action" value="Faire un don en nature"> -->
<!-- 							</div> -->
<!-- 							<div class="pull-left btn-box"> -->
<!-- 								<input class="btn btn-default fs20 white igive-btn form-control" -->
<!-- 									type="submit" name="action" value="Faire un don réglement"> -->
<!-- 							</div> -->
<!-- 						</form> -->
					</div>
<!-- 				</div> -->
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
								<strong><span class="text-color"></span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Besoin</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Date besoin</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité
										Initiale</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité
										Restante</span></strong>
							</div>
							<div
								class="col-xs-1 col-sm-1 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Motif</span></strong>
							</div>
							<div
								class="col-xs-1 col-sm-1 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Priorité</span></strong>
							</div>
						</div>
						<hr class="margin-20">
						<c:forEach items="${besoin_etab}" var="b">
						<c:if test="${b.getReaffected() == false }">
							<div class="row">
								<div class="col-xs-2 col-sm-2 text-center">
									<img src="uploads/images/bavette.jpg"
										alt="Makers Against Corona (Masques pour l&#039;équipe medicale)"
										title="Makers Against Corona (Masques pour l&#039;équipe medicale)">
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h5>${b.getProduit().getLibelle()}
									</h5>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h5>${b.getDateBesoin()}</h5>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h5>${b.getQuantiteInitiale()}</h5>
								</div>
								<div class="col-xs-2 col-sm-2 text-center">
									<h5>${b.getQuantiteRestante()}</h5>
								</div>
								<div class="col-xs-1 col-sm-1 text-center">
									<h5>${b.getEtat()}</h5>
								</div>
								<div class="col-xs-1 col-sm-1 text-center">
									<h5>${b.getPriorite()}</h5>
								</div>
							</div>
							<hr class="margin-20">
							</c:if>
						</c:forEach>
						<div class="row">
							<div class="col-md-12 text-center top-pad-10">
								<div>
									<a href="#"
										class="btn btn-box btn-default fs20 pad-10 animated fadeInDown visible"
										style="min-width: 100px;" data-animation="fadeInDown">Voir
										plus</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="form-box-cha9a9a top-margin-20"
					style="padding: 10px !important;">
					<div class="container">
						<h1>Liste des donateurs</h1>
						<div class="row">
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom Donnateur</span></strong>
							</div>
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Don</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité donnée</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Montant</span></strong>
							</div>
							<div class="col-xs-2 col-sm-2 text-center lr-pad-10">
								<strong><span class="text-color">Date</span></strong>
							</div>
						</div>
						<hr class="margin-20">
						
						<div class="row">
							<c:forEach items="${dons_en_nature}" var="d">
								<c:if test="${d.isEstAccepte() == true && d.getEtablissement().getIdEtablissement() == etablissement.getIdEtablissement()}">
									<div class="col-xs-3 col-sm-3 fund-bottom-border text-center lr-pad-10">
										<c:if test="${d.getVisibilite() == 'OUI'}">
											<h6>${d.getUtilisateur().getNom()}</h6>
										</c:if>
										<c:if test="${d.getVisibilite() == 'NON'}">
											<h6>Anonyme</h6>
										</c:if>
									</div>
									<div
										class="col-xs-3 col-sm-3 fund-bottom-border text-center lr-pad-10">
										<h6><strong>Besoin : </strong>${d.getBesoin().getProduit().getLibelle()}</h6>
									</div>
									<div
										class="col-xs-2 col-sm-2 fund-bottom-border text-center lr-pad-10">
										<h6>${d.getQuantite()}</h6>
									</div>
									<div class="col-xs-2 col-sm-2 fund-bottom-border text-center lr-pad-10">
										<h6>${d.getPrix_totale()}</h6>
									</div>
									<div class="col-xs-2 col-sm-2 fund-bottom-border text-center lr-pad-10">
										<h6>${d.getDatePlanifiee()}</h6>
									</div>
								</c:if>
							</c:forEach>
							<c:forEach items="${don_reglements}" var="r">
								<c:if test="${r.isEstAccepte() == true && r.getEtablissement().getIdEtablissement() == etablissement.getIdEtablissement()}">
									<div class="col-xs-3 col-sm-3 fund-bottom-border text-center lr-pad-10">
										<c:if test="${r.getVisibilite() == 'OUI'}">
											<h6>${r.getUtilisateur().getNom()}</h6>
										</c:if>
										<c:if test="${r.getVisibilite() == 'NON'}">
											<h6>Anonyme</h6>
										</c:if>
									</div>
									<div
										class="col-xs-3 col-sm-3 fund-bottom-border text-center lr-pad-10">
										<h6><strong>${r.getModeReglement()}</strong></h6>
									</div>
									<div
										class="col-xs-2 col-sm-2 fund-bottom-border text-center lr-pad-10">
										<h6>-</h6>
									</div>
									<div class="col-xs-2 col-sm-2 fund-bottom-border text-center lr-pad-10">
										<h6>${r.getMontant()}</h6>
									</div>
									<div class="col-xs-2 col-sm-2 fund-bottom-border text-center lr-pad-10">
										<h6>${r.getDatePlanifiee()}</h6>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<hr class="margin-20">
						<div class="row">
							<div class="col-md-12 text-center top-pad-10">
								<div>
									<a href="#"
										class="btn btn-box btn-default fs20 pad-10 animated fadeInDown visible"
										style="min-width: 100px;" data-animation="fadeInDown">Voir
										plus</a>
								</div>
							</div>
						</div>
					</div>
				</div>
<!-- 				<div class="form-box-cha9a9a top-margin-20" -->
<!-- 					style="padding: 10px !important;"> -->
<!-- 					<div class="container"> -->
<!-- 						<h1>Liste des Fournisseurs</h1> -->
<!-- 						<div class="row"> -->
<!-- 							<div -->
<!-- 								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10"> -->
<!-- 								<strong><span class="text-color">Libellé -->
<!-- 										Fournisseur</span></strong> -->
<!-- 							</div> -->
<!-- 							<div -->
<!-- 								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10"> -->
<!-- 								<strong><span class="text-color">Adresse</span></strong> -->
<!-- 							</div> -->
<!-- 							<div -->
<!-- 								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10"> -->
<!-- 								<strong><span class="text-color">Code Postal</span></strong> -->
<!-- 							</div> -->
<!-- 							<div -->
<!-- 								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10"> -->
<!-- 								<strong><span class="text-color">E mail</span></strong> -->
<!-- 							</div> -->
<!-- 							<div -->
<!-- 								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10"> -->
<!-- 								<strong><span class="text-color">Gouvernorat</span></strong> -->
<!-- 							</div> -->
<!-- 							<div -->
<!-- 								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10"> -->
<!-- 								<strong><span class="text-color">Numéro de Tel</span></strong> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<hr class="margin-20"> -->
<%-- 						<c:forEach items="${fournisseur}" var="b"> --%>
<!-- 							<div class="row"> -->
<!-- 								<div class="col-xs-2 col-sm-2 fund-bottom-border text-center"> -->
<%-- 									<h5>${b.getLibelle()}</h5> --%>
<!-- 								</div> -->
<!-- 								<div class="col-xs-2 col-sm-2 fund-bottom-border text-center"> -->
<%-- 									<h5>${b.getAdresseF()}</h5> --%>
<!-- 								</div> -->
<!-- 								<div class="col-xs-2 col-sm-2 fund-bottom-border text-center"> -->
<%-- 									<h5>${b.getCodePostal()}</h5> --%>
<!-- 								</div> -->
<!-- 								<div class="col-xs-2 col-sm-2 fund-bottom-border text-center"> -->
<%-- 									<h5>${b.getEmailF()}</h5> --%>
<!-- 								</div> -->
<!-- 								<div class="col-xs-2 col-sm-2 fund-bottom-border text-center"> -->
<%-- 									<h5>${b.getGouvernorat()}</h5> --%>
<!-- 								</div> -->
<!-- 								<div class="col-xs-2 col-sm-2 fund-bottom-border text-center"> -->
<%-- 									<h5>${b.getNumTelF()}</h5> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<%-- 						</c:forEach>  --%>
<!-- 						<hr class="margin-20"> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-12 text-center top-pad-10"> -->
<!-- 								<div> -->
<!-- 									<a href="#" -->
<!-- 										class="btn btn-box btn-default fs20 pad-10 animated fadeInDown visible" -->
<!-- 										style="min-width: 100px;" data-animation="fadeInDown">Voir -->
<!-- 										plus</a> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->


			</div>
		</div>
	</div>
</section>
<%@ include file="__footer.jsp"%>