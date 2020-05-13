<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>

<%@ include file="menu_ministere.jsp"%>



<section class="page-section">
	<div class="container">


		<div class="row">
			<div class="section-title margin-0">
				<h2 class="title">Gérer les dons</h2>
			</div>
		</div>
		<form name="new_fund" method="post" class="form-group"
			action="${pageContext.request.contextPath}/Liste_Dons">
			<div class="row">
				<div class="col-md-3 text-center"></div>
				<div class="col-md-3 text-center">
					<input class="btn btn-default fs20 white igive-btn form-control"
						type="submit" name="action" value="Voir tous les dons en nature">
				</div>
				<div class="col-md-3 text-center">
					<input class="btn btn-default fs20 white igive-btn form-control"
						type="submit" name="action" value="Voir tous les reglements">
				</div>
			</div>
		</form>
		<form name="new_fund" method="post" class="form-group"
			action="${pageContext.request.contextPath}/Liste_Dons">
			<c:choose>
				<c:when test="${param.action=='Voir tous les dons en nature'}">
					<div class="row">
						<div class="vcenter col-md-12 text-center">
							<div class="visible-sm-block visible-xs-block top-margin-10">
								<div class="form-box-cha9a9a widget bottom-pad-0"
									style="padding-top: 0px;"></div>
							</div>
							<div class="form-box-cha9a9a top-margin-20"
								style="padding: 10px !important;">
								<table class="table">
									<thead>
									<tr>
										<!--<th scope="col">
											<strong><span class="text-color">Photo Don</span></strong>
										</th>-->
										<th scope="col">
											<strong><span class="text-color">Nom Don</span></strong>
										</th>
										<th scope="col">
											<strong><span class="text-color">Bénéficiaire</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Donateur</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Prix total </span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Quantité</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Approuvé</span></strong>
										</th scope="col">
										<th scope="col"></th>
										<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${don_en_nature}" var="d">
											<c:if test="${d.isEstSupprime() == false}">
											<tr>
											<!--<td>
											</td>-->
											<td>
											<h5>${d.getBesoin().getProduit().getLibelle()}</h5>
											</td>
											<td>
											<h5>${d.getEtablissement().getNomEtablissement()}</h5>
											</td>
											<td>
											<h5>Donateur</h5>
											</td>
											<td>
											<h5>${d.getPrix_totale()}</h5>
											</td>
											<td>
											<h5>${d.getQuantite()}</h5>
											</td>
											<td>
												<h5>${d.isEstAccepte()}</h5>
											</td>
											<td>
												<a href="accepter_don?code_don_en_nature=${d.getId_don()}" class="btn btn-success btn-sm" role="button">Accepter</a>
											</td>
											<td>
												<a href="supprimer_don?code_don_en_nature=${d.getId_don()}" class="btn btn-danger btn-sm" role="button" >Supprimer</a>
											</td>
											</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</c:when>
				<c:when test="${param.action=='Voir tous les reglements'}">
					<div class="row">
						<div class="vcenter col-md-12 text-center">
							<div class="visible-sm-block visible-xs-block top-margin-10">
								<div class="form-box-cha9a9a widget bottom-pad-0"
									style="padding-top: 0px;"></div>
							</div>
							<div class="form-box-cha9a9a top-margin-20"
								style="padding: 10px !important;">
									<table class="table">
									<thead>
									<tr>
										<th scope="col">
											<strong><span class="text-color">Photo Don</span></strong>
										</th>
										<th scope="col">
											<strong><span class="text-color">Montant (DT)</span></strong>
										</th>
										<th scope="col">
											<strong><span class="text-color">Bénéficiaire</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Donateur</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Mode de réglement</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Date réglement</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Approuvé</span></strong>
										</th scope="col">
										<th scope="col"></th>
										<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${reglement}" var="r">
										<c:if test="${r.isEstSupprime() == false}">
											<tr>
											<td>
											</td>
											<td>
											<h5>${r.getMontant()}</h5>
											</td>
											<td>
											<h5>${r.getEtablissement().getNomEtablissement()}</h5>
											</td>
											<td>
											<h5>Donateur</h5>
											</td>
											<td>
											<h5>${r.getModeReglement()}</h5>
											</td>
											<td>
											<h5><fmt:formatDate type = "both"  value = "${r.getDateReglement()}"/></h5>
											</td>
											<td>
												<h5>${r.isEstAccepte()}</h5>
											</td>
											<td>
												
												<a href="accepter_don?code_reglement=${r.getId_don()}" class="btn btn-success btn-sm" role="button">Accepter</a>
											</td>
											<td>
												<a href="supprimer_don?code_reglement=${r.getId_don()}" class="btn btn-danger btn-sm" role="button">Supprimer</a>
											</td>
											</tr>
											</c:if>
										</c:forEach>
									</tbody>
									</table>
							</div>
						</div>
					</div>
				</c:when>
			</c:choose>
		</form>
	</div>
</section>
<%@ include file="__footer.jsp"%>