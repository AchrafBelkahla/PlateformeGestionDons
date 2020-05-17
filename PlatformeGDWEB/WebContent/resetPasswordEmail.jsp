
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
						<hr>
						<form name="formResetPwdEmail" method="post"
							action="resetPwdEmail"
							class="pad-20 fos_user_registration_register" role="form">
							                            <hr class="margin-20">
							<div class="text-center"><h5>${message}</h5></div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label required" for="email">Adresse e-mail</label> 
										<span class="required text-danger form-asterisk"
											title="Ce champ est requis">*</span> 
											<input type="email" id="email" name="email" 
											required="required" placeholder="Entrez votre ancien mot de passe" 
											class="form-control" />
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
<%@ include file="__footer.jsp"%>