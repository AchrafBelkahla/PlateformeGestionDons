
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
						<form name="formEditPassword" method="post"
							action="editPassword"
							class="pad-20 fos_user_registration_register" role="form">
							<c:if test="${errorMsg==true}">
							<div class="text-center"><h5>Veuillez vérifier vos informations !</h5></div>
							</c:if>
							<c:if test="${errorMsg==false}">
							<div class="text-center"><h5>Mot de passe changé avec succés !</h5></div>
							</c:if>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label required" for="previous_password">Ancien Mot de passe</label> <span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="password"
											id="previous_password" name="previous_password" required="required"
											placeholder="Entrez votre ancien mot de passe" class="form-control" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required" for="password">Mot de passe</label> </i><span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="password"
											id="password" name="password" required="required"
											placeholder="Choisissez un nouveau mot de passe" class="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label required"
											for="confirm_password">Re-Tapez
											votre mot de passe</label> </i><span
											class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> <input type="password"
											id="confirm_password"
											name="confirm_password"
											required="required" placeholder="Re-Tapez votre nouveau mot de passe"
											class="form-control" />
									</div>
								</div>
								 
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<span  id='message'></span>
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
	  $('#password, #confirm_password').on('keyup', function () {
		  if ($('#password').val() == $('#confirm_password').val()) {
		    $('#message').html('Les mots de passe correspondent.').css('color', 'green');
		  } else 
		    $('#message').html('Les mots de passe ne correspondent pas.').css('color', 'red');
		});
  });
</script>
<%@ include file="__footer.jsp"%>