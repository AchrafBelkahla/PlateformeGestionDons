
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<c:if test="${photos.size() >0}">
	<section class="slider rs-slider-full" id="home">
		<div class="tp-banner-container">
			<div class="tp-banner-new responsive">
				<ul>
					<c:forEach var="photo" items="${photos}">

						<li data-slotamount="6" data-masterspeed="1200" data-delay="6000"
							data-title="Association"><img
							src="uploads/images/besoins/${photo.getIdP()}"
							alt="Photo du besoin" title="Association"
							data-bgposition="center top" data-kenburns="on"
							data-duration="16000" data-ease="Linear.easeNone"
							data-bgfit="110" data-bgfitend="100"
							data-bgpositionend="center center" /></li>
					</c:forEach>
				</ul>
				<div class="tp-bannertimer"></div>
			</div>
		</div>
	</section>
</c:if>
<section class="page-section light-bg">
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<h1>Besoin : ${besoin.getProduit().getLibelle()}</h1>
			</div>
			<div class="col-sm-5" id="${besoin.getIdBesoin()}">
				<a href="Liste_Besoins" class="btn btn-default" role="button">Retour</a>
				<a href="editBesoin?idBesoin=${besoin.getIdBesoin()}"
					class="btn btn-warning " role="button" id="editbesoin">Editer</a> 
				<button type="button" class="btn btn-success" onclick="document.getElementById('forma').style.display = 'block'">Réaffecter</button>
				<button class="btn btn-danger" id="deletebesoin">Supprimer</button>
			</div>
		</div>

		<br>
		<table class="table table-hover" border="1">
			<tr>
				<td><strong>Produit</strong></td>
				<td><strong>Date Besoin</strong></td>
				<td><strong>Quantité demandée</strong></td>
				<td><strong>Quantité restante</strong></td>
				<td><strong>Motif</strong></td>
				<td><strong>Priorité</strong></td>
				<td><strong>Bénéficiaire</strong></td>
			</tr>
			<tr>
				<td>${besoin.getProduit().getLibelle()}</td>
				<td>${besoin.getDateBesoin() }</td>
				<td>${besoin.getQuantiteInitiale()}</td>
				<td>${besoin.getQuantiteRestante()}</td>
				<td>${besoin.getMotif()}</td>
				<td>${besoin.getPriorite()}</td>
				<td>${besoin.getEtablisement().getNomEtablissement()}</td>
			</tr>
		</table>
	</div>
		<div class="container" style="display: none;" id="forma"> 
		<form name="besoinMinistere" action="besoinMinistere" method="post"> 
			<div class="row" >
			<h3>Réaffecter ce besoin vers un autre etablissement</h3>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label required" for="new_fund_name">Nom produit</label> <span class="required text-danger form-asterisk"
						title="Ce champ est requis">*</span><select id="id_besoin"
						name="id_besoin" class="form-control">
						<div class="cha9a9a-title text-center pad-5">
								<option value="${besoin.getIdBesoin()}">${besoin.getProduit().getLibelle()}</option>
						</div>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label required" for="new_fund_name">Nom
						Etablissement</label> <span class="required text-danger form-asterisk"
						title="Ce champ est requis">*</span><select id="nometablissement"
						name="nometablissement" class="form-control">
						<div class="cha9a9a-title text-center pad-5">
							<c:forEach items="${etablissements}" var="etab">
								<c:if test="${etab.getHospital() == true}">
									<option value="${etab.getIdEtablissement()}">${etab.getNomEtablissement()}</option>
								</c:if>
							</c:forEach>
						</div>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label required" for="new_fund_name">Motif</label> <span class="required text-danger form-asterisk"
						title="Ce champ est requis">*</span><select id="motif"
						name="motif" class="form-control">
						<div class="cha9a9a-title text-center pad-5">
								<option value="motif 1">motif 1</option>
								<option value="motif 2">motif 2</option>
								<option value="motif 3">motif 3</option>
								<option value="motif 4">motif 4</option>
						</div>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<button type="submit" class="btn btn-success">Confirmer</button>
			</div>
		</div>
		</form>
	</div>

	<script>
		$(document).ready(function() {
			$("button").click(function() {
				let id = $(this).closest('div').attr('id');
				switch (this.id) {
					case "deletebesoin":
						console.log("delete besoin" + id);
						async("delete",{id:id})
						break;
// 					case "editproduct":
// 						console.log("new categorie");
// 						$("#categorieform").toggle("slow");
// 						break;
				}
			})
			function async(method,data){
				console.log(data);
				$.ajax({
					url:"Liste_Besoins",
					data:data,
					method:method
			})
			.done(
					function(data){
						console.log(data);
						if(data){
							location.href="Liste_Besoins"
						}
					}
			);
		}

		})	
</script>
</section>
<%@ include file="__footer.jsp"%>