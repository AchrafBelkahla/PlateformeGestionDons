<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
	<div class="image-bg content-in fixed"
		data-background="/assets/img/sections/slider/Projects.jpg"></div>
	<div class="overlay"></div>

	<div class="container">
		<div class="row">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 form-box-cha9a9a">
						<h3 class="title">Changer responsable</h3>
						<hr>
						<form name="choixEtablissement_form" method="post"
							action="choixEtablissement"
							class="pad-20 fos_user_registration_register" role="form">

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="new_fund_name">Nom
											Etablissement</label> <span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span><select
											id="nom_etablissement" name="nom_etab" class="form-control">
											<div class="cha9a9a-title text-center pad-5">
												<c:forEach items="${etablissements}" var="etab">
													<c:if test="${etab.getMinistraire() == false}">
													<option value="${etab.getIdEtablissement()}">${etab.getNomEtablissement()}</option>
													</c:if>
												</c:forEach>
											</div>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 text-right"></div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<div class="g-recaptcha"
										data-sitekey="6Lcu-YIUAAAAACuHkoALk0xEiwvKng3khyAr-PBm"></div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<input type="submit"
										class="btn btn-default register pull-right"
										value="Valider" />
								</div>
							</div>
							
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="__footer.jsp"%>