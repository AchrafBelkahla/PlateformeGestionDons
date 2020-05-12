<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>
<%@ include file="menu.jsp"%>

<section class="page-section light-bg">
	<div class="image-bg content-in fixed"
		data-background="/assets/img/sections/slider/Projects.jpg"></div>
	<div class="overlay"></div>

	<div class="container">
		<div class="row">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 form-box-cha9a9a">
						<h3 class="title">S&#039;inscrire</h3>
						<hr>
						<form name="registration_form" method="post"
							action="InscriptionUtilisateur"
							class="pad-20 fos_user_registration_register" role="form">


							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_form_firstname">Prénom</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="text"
											id="registration_form_firstname" name="input21"
											required="required" placeholder="Tapez votre prénom"
											class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_form_lastname">Nom</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="text"
											id="registration_form_lastname" name="input11"
											required="required" placeholder="Tapez votre nom"
											class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_form_firstname">Numéro de téléphone</label>

										</i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="tel"
											id="registration_form_firstname" name="input61"
											required="required"
											placeholder="Tapez votre numéro de téléphone"
											class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="Adresse">Adresse</label>

										</i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="text"
											id="Adresse" name="input81" required="required"
											placeholder="Tapez votre adresse" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="Gouvernorat">Gouvernorat</label>
										</i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <select id="Gouvernorat"
											name="input71" class="form-control">
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
										<label class="control-label required" for="postal">Code
											postal</label> </i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="number"
											id="postal" name="input91" required="required"
											placeholder="Tapez votre code postal" class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_form_email">Adresse e-mail</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="email"
											id="registration_form_email" name="input31"
											required="required" placeholder="Tapez votre adresse email"
											class="form-control" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="passe">Mot
											de passe</label> </i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="password"
											id="passe" name="input41" required="required"
											placeholder="Choisissez un mot de passe" class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="registration_form_plainPassword_second">Re-Tapez
											votre mot de passe</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="password"
											id="registration_form_plainPassword_second"
											name="registration_form[plainPassword][second]"
											required="required" placeholder="Re-Tapez votre mot de passe"
											class="form-control" />
									</div>
								</div>
							</div>

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
										value="Valider l&#039;inscription" />
								</div>
							</div>
							
							<div class="clearfix"></div>

							<input type="hidden" id="registration_form__token"
								name="registration_form[_token]"
								value="2sgpUWUPlUZB6br8bJygmYe7UVpD9LEvKdd0jeglrIQ" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="__footer.jsp"%>