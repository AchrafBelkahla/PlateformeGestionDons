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
						<h3 class="title">Ajouter un etablissement</h3>
						<hr>
						<form name="registration_association_form" method="post"
							action="AjoutEtablissement"
							class="pad-20 fos_user_registration_register" role="form">

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_association_form_association_name">Nom
											de l&#039;établissement</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="text"
											id="registration_association_form_association_name"
											name="input11" required="required"
											placeholder="Tapez le nom de l&#039;établissement"
											class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_association_form_association_name">Type
											de l&#039;établissement</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <select
											id="new_fund_type" name="input12" class="form-control">
											<option value=" "><div
													class="cha9a9a-title text-center pad-5">
													<h5>--Veuillez choisir une option--</h5>
											</option>
											<option value="intermediaire">intermediaire</option>
											<option value="drs">drs</option>
											<option value="Hospital">Hospital</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_association_form_association_name">Libellé</label>

										</i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <select
											id="new_fund_type" name="input13" class="form-control">
											<option value=" "><div
													class="cha9a9a-title text-center pad-5">
													<h5>--Veuillez choisir une option--</h5>
											</option>
											<option value="HR">Hôpital régional</option>
											<option value="HM">Défense et intérieur</option>
											<option value="EPS">EPS</option>
											<option value="autres">autres</option>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="Gouvernorat">Gouvernorat</label>
										</i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <select id="Gouvernorat"
											name="input7" class="form-control">
											<option value="Ariana">Ariana</option>
											<option value="Béja">Béja</option>
											<option value="Ben Arous">Ben Arous</option>
											<option value="Bizerte">Bizerte</option>
											<option value="Gabes">Gabes</option>
											<option value="Gafsa">Gafsa</option>
											<option value="Jendouba">Jendouba</option>
											<option value="Kairouan">Kairouan</option>
											<option value="Kasserine">Kasserine</option>
											<option value="Kébili">Kébili</option>
											<option value="Le Kef">Le Kef</option>
											<option value="Mahdia">Mahdia</option>
											<option value="La Manouba">La Manouba</option>
											<option value="Médenine">Médenine</option>
											<option value="Monastir">Monastir</option>
											<option value="Nabeul">Nabeul</option>
											<option value="Sfax">Sfax</option>
											<option value="Sousse">Sousse</option>
											<option value="Sidi Bouzid">Sidi Bouzid</option>
											<option value="Tataouine">Tataouine</option>
											<option value="Tozeur">Tozeur</option>
											<option value="Tunis">Tunis</option>
											<option value="Zaghouan">Zaghouan</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_form_lastname">Adresse</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="text"
											id="registration_form_lastname" name="input8"
											required="required" placeholder="Tapez votre adresse"
											class="form-control" />
									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_form_lastname">Code postal</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="number"
											id="registration_form_lastname" name="input9"
											required="required" placeholder="Tapez votre code postal"
											class="form-control" />
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
									 <button type="submit" class="btn btn-default btn-block">Valider l'inscription</button>
<!-- 									<input type="submit" -->
<!-- 										class="btn btn-default register pull-right" -->
<!-- 										value="Valider l&#039;inscription" /> -->
									 <a href="Liste_Etablissements?currentPage=1" 
									 class="btn btn-default btn-block" role="button">Annuler</a>
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