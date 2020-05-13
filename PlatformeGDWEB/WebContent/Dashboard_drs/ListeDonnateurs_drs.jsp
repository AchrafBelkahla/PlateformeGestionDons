<%@ include file="__header.jsp"%>
<%@ include file="menu_drs.jsp"%>
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
						<h1>Liste des donateurs</h1>
						<div class="row">
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom donateur</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Prénom</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Adresse mail</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Numéro de télèphone</span></strong>
							</div>
							<div class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Statut</span></strong>
							</div>
							<div class="col-xs-2 col-sm-2 text-center lr-pad-10">
								<strong><span class="text-color">Région</span></strong>
							</div>
						</div>
						<hr class="margin-20">
						<c:forEach var="donnateur" items="${don_en_nature}">
							<c:if test="${donnateur.isEstAccepte() == 'true'}">
								<div class="row">
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getNom()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getPrenom()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getEmail()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getTelephone().iterator().next().getNumero()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getRole()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getAdresse().getGouvernorat()}</h5>
									</div>
								</div>
							</c:if>
						</c:forEach>
						<c:forEach var="donnateur" items="${reglement}">
							<c:if test="${donnateur.isEstAccepte() == 'true'}">
								<div class="row">
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getNom()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getPrenom()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getEmail()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getTelephone().iterator().next()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getRole()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${donnateur.getUtilisateur().getAdresse().getGouvernorat()}</h5>
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