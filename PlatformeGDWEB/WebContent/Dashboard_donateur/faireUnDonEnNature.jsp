




<%@ include file="__header.jsp"%>




<%@ include file="menu_donnateur.jsp"%>
<section class="page-section light-bg">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 form-box-cha9a9a">
				<h3 class="title">Créer un don</h3>
						<hr>
				<form name="new_fund" method="post" class="form-group"
					action="${pageContext.request.contextPath}/don_en_nature"
					enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Nom
							Bénéficiaire</label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<div class="cha9a9a-title text-center pad-5">
							<select id="nom_etablissement" name="nom_etablissement" class="form-control" disabled>
								<option value="${etablisement.getIdEtablissement()}" selected>${etablisement.getNomEtablissement()}</option>
							</select>
							<input type="hidden" name="nom_etablissement" value="${etablisement.getIdEtablissement()}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Nom
							besoin </label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
							<div class="cha9a9a-title text-center pad-5">
								<select id="nom_besoin" name="nom_besoin"
								class="form-control" disabled>
										<option value="${besoin.getIdBesoin()}" selected>${besoin.getProduit().getLibelle()}</option>
								</select>
								<input type="hidden" name="nom_besoin" value="${besoin.getIdBesoin()}" />	
							</div>
					</div>

					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Date
							de réception</label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
							<input type="date" id="date_planifiee" name="date_planifiee"
							class="form-control" required/>
					</div>
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Voulez
							vous afficher votre nom avec la liste des donnateurs ?</label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span> <select id="new_fund_type"
							name="visibilite" class="form-control" required>
							<div class="cha9a9a-title text-center pad-5">
								<option value="OUI">Oui</option>
								<option value="NON">Non</option>
							</div>
						</select>
					</div>
					<div id="${prixMoy}" class="form-group">
						<label class="control-label required" for="new_fund_name">Quantité</label><span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<input type="number" id="quantite" name="quantite" value="0" min="0" class="form-control" required="required"/>
					</div>
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Prix
							total</label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
    					<input type="number" class="form-control" id="prixTotal" name="prixTotal" step=any  readonly="readonly">
					</div>

					
					<!-- <div class="form-group">
						<label class="control-label required" for="new_fund_name">Nom
							Fournisseur</label> <select id="new_fund_type" name="nom_produit"
							class="form-control"><option value="30">
								<div class="cha9a9a-title text-center pad-5">
									<c:forEach items="${fournisseur}" var="c">
										<option value="${c.getIdF()}">${c.getLibelle()}</option>
									</c:forEach>
								</div></select>
					</div> -->
					<div class="form-group">
						<label class="control-label required" for="photos">Ajouter des photos</label>
						<span class="required text-danger form-asterisk" >(formats acceptés : jpeg/png)</span>	
						<input type="file" name="file" accept="image/*" multiple  />
					</div>
					<button class="btn btn-default btn-block" type="submit"
						name="action" value="Faire un don en nature">
						<strong>Faire un don</strong>
					</button>

				</form>

			</div>
		</div>
	</div>
</section>
<script>
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();
 if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 
today = yyyy+'-'+mm+'-'+dd;
document.getElementById("date_planifiee").setAttribute("min", today);
$(document).ready(function(){
	$("#quantite").change(function(){
		let quantite = $(this).val();
		let prixMoy=  parseFloat($("#quantite").closest('div').attr('id'));
		$("#prixTotal").val(quantite*prixMoy);
		});
	
	});
</script>
<%@ include file="__footer.jsp"%>




