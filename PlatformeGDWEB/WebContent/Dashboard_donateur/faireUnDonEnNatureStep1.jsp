<%@ include file="__header.jsp"%>

<%@ include file="menu_donnateur.jsp"%>
<section class="page-section light-bg">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 form-box-cha9a9a">
				<h3 class="title">Créer un don</h3>
						<hr>
				<form name="new_fund" method="post" class="form-group"action="faire_un_don_step1">
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Nom
							Bénéficiaire</label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<div class="cha9a9a-title text-center pad-5">
							<select id="nom_etablissement" name="nom_etablissement" class="form-control" disabled required >
								<option value="${beneficiaire.getIdEtablissement()}" selected="selected">${beneficiaire.getNomEtablissement()} </option>
							</select>
							<input type="hidden" name="nom_etablissement" value="${beneficiaire.getIdEtablissement()}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Nom
							besoin </label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
							<select id="nom_besoin" name="nom_besoin" class="form-control" required>
								<div class="cha9a9a-title text-center pad-5">
									<c:forEach items="${besoin_etab}" var="b">
										<option value="${b.getIdBesoin()}">${b.getProduit().getLibelle()}</option>
									</c:forEach>
								</div></select>
								
					</div>
					<button class="btn btn-default btn-block" type="submit"
						name="action" value="Suivant">
						<strong>Suivant</strong>
					</button>

				</form>

			</div>
		</div>
	</div>
</section>
<script>
$(document).ready(function(){
	$("#nom_besoin").change(function(){
		console.log($(this).val());
		});
	
	});
</script>
<%@ include file="__footer.jsp"%>