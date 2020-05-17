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
						<h1>Liste des Intermédiaires</h1>
						<div class="row">
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom établissement</span></strong>
							</div>
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Adresse</span></strong>
							</div>
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Nom & prénom
										responsable</span></strong>
							</div>
							<div
								class="col-xs-3 col-sm-3 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Contact
										responsable</span></strong>
							</div>
						</div>
						<hr class="margin-20">
						<c:forEach items="${etablissements}"  var="etab">
							<c:if test="${etab.getIntermediaire() == true}">
								<div class="row">
									<div class="col-xs-3 col-sm-3">
										<h6>${b.getNomEtablissement()}</h6>
									</div>
									<div class="col-xs-3 col-sm-3">
										<h6>${b.getAdresse().getAdresse()}, ${b.getAdresse().getGouvernorat()}, ${b.getAdresse().getCodePostale()}</h6>
									</div>
									<div class="col-xs-3 col-sm-3">
										<c:forEach items="${b.getUtilisateurs()}" var="utilisateur">
											<h6>${utilisateur.getNom()}, ${utilisateur.getPrenom()}</h6><br>
										</c:forEach>
									</div>
									<div class="col-xs-3 col-sm-3">
										<c:forEach items="${b.getUtilisateurs()}" var="utilisateur">
											<c:forEach items="${utilisateur.getTelephone()}" var="tel">
												${tel.getNumero()}, 
											</c:forEach>
										</c:forEach>
									</div>
									
								</div>
							</c:if>
						</c:forEach>
						
					</div>
				</div>
			</div>
			<jsp:include page="../pagination.jsp">
					        <jsp:param name="currentPage" value="${currentPage}"/>
					        <jsp:param name="noOfPages" value="${noOfPages}"/>
					        <jsp:param name="link" value="Liste_Intermediaire_Drs"/>
					    </jsp:include>
		</div>
	</div>
</section>
<%@ include file="__footer.jsp"%>