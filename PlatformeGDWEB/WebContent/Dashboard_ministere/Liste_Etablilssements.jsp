<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">
	<div class="container">
		<a href="AjoutEtablissement" class="btn btn-success">Ajouter un
			établissement</a>
		<div class="row">
			<div class="vcenter col-md-12 text-center">
				<div class="visible-sm-block visible-xs-block top-margin-10">
					<div class="form-box-cha9a9a widget bottom-pad-0"
						style="padding-top: 0px;"></div>
				</div>

				<div class="form-box-cha9a9a top-margin-20"
					style="padding: 10px !important;">
					<div class="container">
						<h1>Liste des Hôpitaux</h1>
						<div class="row">
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom
										établissement</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Libellé</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Adresse</span></strong>
							</div>
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom&Prenom responsable</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Télèphone responsable</span></strong>
							</div>
						</div>
						<hr class="margin-20">
						<c:forEach items="${etablissements}" var="etab">
							<c:if test="${etab.getHospital() == true}">
								<div class="row">
									<div class="col-xs-3 col-sm-3 text-center">
										<h5>${etab.getNomEtablissement()}</h5>
									</div>

									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${etab.getLibelle()}</h5>

									</div>

									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${etab.getAdresse().getGouvernorat()}<br>${etab.getAdresse().getAdresse()}
											, ${etab.getAdresse().getCodePostale()}
										</h5>

									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<c:forEach items="${etab.getUtilisateurs()}" var="utilisateur">
											<c:if test="${utilisateur.getAccepted() == true}">
												${utilisateur.getPrenom()},${utilisateur.getNom()}<br>
											</c:if>
										</c:forEach>
									</div>
									<div class="col-xs-3 col-sm-3 text-center">
										<c:forEach items="${etab.getUtilisateurs()}" var="utilisateur">
											<c:if test="${utilisateur.getAccepted() == true}">
												<c:forEach items="${utilisateur.getTelephone()}" var="tel">
													${tel.getNumero()}/
												</c:forEach>
												<br>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</c:if>
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