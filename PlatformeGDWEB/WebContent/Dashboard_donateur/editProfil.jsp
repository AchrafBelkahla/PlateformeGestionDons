
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>
<%@ include file="menu_donnateur.jsp"%>

<section class="page-section light-bg">
	<div class="image-bg content-in fixed"
		data-background="/assets/img/sections/slider/Projects.jpg"></div>
	<div class="overlay"></div>

	<div class="container">
		<div class="row">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 form-box-cha9a9a">
						<hr>
						<form name="formEditProfil" method="post"
							action="editProfil"
							class="pad-20 fos_user_registration_register" role="form">


							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="libelle">Prénom</label>
										<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
										<input type="text" id="prenom" name="prenom" value="${user.getPrenom()}"  class="form-control" required="required"/>											
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="libelle">Nom</label>
										<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
										<input type="text" id="nom" name="nom" value="${user.getNom()}"  class="form-control" required="required"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="libelle">Numéro de téléphone</label>
										<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
										<input type="tel" id="telephone" name="telephone" value="${telephone.getNumero()}"  class="form-control" required="required"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="libelle">Adresse</label>
										<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
										<input type="text" id="adresse" name="adresse" value="${user.getAdresse().getAdresse()}"  class="form-control" required="required"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label " for="gouvernorat">Gouvernorat</label>
										<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
										<div id="${user.getAdresse().getGouvernorat()}">
										<select id="gouvernorat" name="gouvernorat" class="selectpicker form-control" required="required">
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
								
							
							
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="codePostal">Code postal</label>
										<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
									   	<input type="number" name="codePostal" value="${user.getAdresse().getCodePostale()}" max="9999" min="0"  class="form-control" required="required"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label required" for="libelle">Adresse e-mail</label>
										<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
										<input type="email" id="email" name="email" value="${user.getEmail()}"  class="form-control" required="required"/>
									</div>
								</div>
							</div>



							<div class="row">
								<div class="col-md-12">
									<input type="submit"
										class="btn btn-default register pull-right"
										value="Confirmer" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
  $(document).ready(function(){
	  let value=  $("select").closest('div').attr('id');
	  $("option[value|="+value+"]" ).attr('selected', 'selected');
  });
</script>
<%@ include file="__footer.jsp"%>