

<%@ include file="__header.jsp"%>
<%@ include file="menu_donnateur.jsp"%>
<section class="page-section light-bg">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 form-box-cha9a9a">
				<h3 class="title">Créer un don spontanné</h3>
						<hr>
				<form name="new_fund" method="post" class="form-group"
					action="${pageContext.request.contextPath}/don_en_nature_spontanne"
					enctype="multipart/form-data">
					
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Nom
							Bénéficiaire</label> <span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<div class="cha9a9a-title text-center pad-5">
							<select id="nom_etablissement" name="nom_etablissement" class="form-control" disabled>
								<option value="Ministère de la santé" selected>Ministère de la santé</option>
							</select>
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Unité de mesure de produit</label>
						<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
						<div class="cha9a9a-title text-center pad-5">
							<select id="unite_de_mesure" name="unite_de_mesure" class="form-control">
								<c:forEach var="udm" items="${udms}">
		     						<option value="${udm.getIdUnite()}">${udm.getIdUnite()}</option>
		   						</c:forEach>
							</select>
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Catégorie de produit</label>
						<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
						<div class="cha9a9a-title text-center pad-5">
							<select id="categorie" name="categorie" class="form-control">
								<c:forEach var="categorie" items="${categories}">
		      						<option value="${categorie.getIdC()}">${categorie.getLibelle()}</option>
		   						</c:forEach> 
							</select>
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Nom produit </label> 
						<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
						<div class="cha9a9a-title text-center pad-5">
							<input type="text" name="nom_produit" required/>	
						</div>
					</div>

					<div class="form-group">
						<label class="control-label required" for="descriptionTechnique">Description technique</label>
   						<textarea name="descriptionTechnique" rows="6" cols="40" class="form-control" placeholder="Vous pouvez saisir ici la description technique du produit"></textarea>
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
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Quantité</label><span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<input type="number" id="quantite" name="quantite" value="0" min="0" class="form-control" required="required"/>
					</div>
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Prix unitaire min (DT)</label><span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<input type="number" id="prix_min" name="prix_min" value="0" min="0" class="form-control" required="required"/>
					</div>
					
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Prix unitaire max (DT)</label><span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<input type="number" id="prix_max" name="prix_max" value="0" min="0" class="form-control" required="required"/>
					</div>
					<div class="form-group">
						<label class="control-label required" for="new_fund_name">Prix Totale du produit (DT)</label><span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<input type="number" id="prixTotal" name="prixTotal" value="0" min="0" class="form-control" required="required"/>
					</div>

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




