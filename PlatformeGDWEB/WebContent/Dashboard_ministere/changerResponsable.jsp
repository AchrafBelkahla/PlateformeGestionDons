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
						<div class="text-center">
							<h5>${message}</h5>
						</div>
						<hr>
						<c:choose>
						    <c:when test="${message == null}">						
								<form name="registration_association_form" method="post"
									action="changerResponsable"
									class="pad-20 fos_user_registration_register" role="form">
		
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label required" for="new_fund_name">Nom
													Etablissement</label> <span class="required text-danger form-asterisk"
													title="Ce champ est requis">*</span>
												<input type="text" disabled name="nom_etablissement" value="${etablissement.getNomEtablissement()}" />
												<input type="hidden" name="id_etablissement" value="${etablissement.getIdEtablissement()}" />
											</div>
										</div>
									</div>
									
									<c:choose>
									    <c:when test="${utilisateur != null}">
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_firstname">Prénom
																de responsable</label> </i><span
																class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> 
																<input type="text"
																id="registration_association_form_firstname" name="input2"
																required="required" placeholder="Tapez votre prénom"
																class="form-control" value="${utilisateur.getPrenom()}"/>
																<input type="hidden" name="type" value="0"/>														
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_lastname">Nom de
																responsable</label> </i><span class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="text"
																id="registration_association_form_lastname" name="input1"
																required="required" placeholder="Tapez votre nom"
																class="form-control" value="${utilisateur.getNom()}"/>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_email">Numéro de
																Télèphone</label> </i><span class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="tel"
																id="registration_association_form_email" name="input6"
																required="required"
																placeholder="Tapez votre numero de télèphone"
																class="form-control" value="${tel.getNumero()}"/>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_email">Fax</label> </i><span
																class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="tel"
																id="registration_association_form_email" name="input10"
																required="required" placeholder="Tapez votre numero de fax"
																class="form-control" value="${fax.getNumero()}"/>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_email">Adresse
																e-mail de responsable</label> </i><span
																class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="email"
																id="registration_association_form_email" name="input3"
																required="required" placeholder="Tapez votre adresse email"
																class="form-control" value="${utilisateur.getEmail()}"/>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_plainPassword_first">Mot
																de passe</label> </i><span class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="password"
																id="registration_association_form_plainPassword_first"
																name="input4" required="required"
																placeholder="Choisissez un mot de passe" class="form-control" />
														</div>
													</div>
												</div>
		
									    </c:when>    
									    <c:otherwise>
		
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_firstname">Prénom
																de responsable</label> </i><span
																class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> 
																<input type="text"
																id="registration_association_form_firstname" name="input2"
																required="required" placeholder="Tapez votre prénom"
																class="form-control"/>
																<input type="hidden" name="type" value="1"/>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_lastname">Nom de
																responsable</label> </i><span class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="text"
																id="registration_association_form_lastname" name="input1"
																required="required" placeholder="Tapez votre nom"
																class="form-control" />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_email">Numéro de
																Télèphone</label> </i><span class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="tel"
																id="registration_association_form_email" name="input6"
																required="required"
																placeholder="Tapez votre numero de télèphone"
																class="form-control" />
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_email">Fax</label> </i><span
																class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="tel"
																id="registration_association_form_email" name="input10"
																required="required" placeholder="Tapez votre numero de fax"
																class="form-control" />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_email">Adresse
																e-mail de responsable</label> </i><span
																class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="email"
																id="registration_association_form_email" name="input3"
																required="required" placeholder="Tapez votre adresse email"
																class="form-control" />
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label required"
																for="registration_association_form_plainPassword_first">Mot
																de passe</label> </i><span class="required text-danger form-asterisk"
																title="Ce champ est requis">*</span> <input type="password"
																id="registration_association_form_plainPassword_first"
																name="input4" required="required"
																placeholder="Choisissez un mot de passe" class="form-control" />
														</div>
													</div>
												</div>
		
									    </c:otherwise>
									</c:choose>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<div class="checkbox">
													<label class="required"><input type="checkbox"
														id="registration_form_cgu_accepted"
														name="registration_form[cgu_accepted]" required="required"
														class="form-group-lg" value="1" /> J'accepte <a
														href="./cgu/iframe.html" class="iframe"
														style="text-decoration: underline;" id="cgu-content">les
															conditions générales d'utilisation</a></label>
												</div>
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
												value="Valider le changement" />
										</div>
									</div>
									
									<div class="clearfix"></div>
								</form>
							</c:when> 
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="__footer.jsp"%>