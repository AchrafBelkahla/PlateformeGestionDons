<%@ include file="__header.jsp"%>
<%@ include file="menu_etablissement.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${photos.size() >0}">
<section class="slider rs-slider-full" id="home">
    <div class="tp-banner-container">
        <div class="tp-banner-new responsive">
            <ul>
  			<c:forEach var="photo" items="${photos}">
                              
                <li data-slotamount="6" data-masterspeed="1200" data-delay="6000" data-title="Association">
                    <img src="uploads/images/besoins/${photo.getIdP()}" alt="Photo du besoin" title="Association" data-bgposition="center top" data-kenburns="on" data-duration="16000" data-ease="Linear.easeNone" data-bgfit="110" data-bgfitend="100" data-bgpositionend="center center" />
                </li>
                </c:forEach>
                            </ul>
            <div class="tp-bannertimer"></div>
        </div>
    </div>
</section>
</c:if>
<section class="page-section">
	<div class="container">
  		<div id="${besoin.getIdBesoin()}">
  			<a href="besoins" class="btn btn-default" role="button">Retour</a>
  		    <a href="editBesoin?idBesoin=${besoin.getIdBesoin()}" class="btn btn-warning " role="button" id="editbesoin">Editer</a>
	  		<button class="btn btn-danger" id="deletebesoin">Supprimer </button>
  		</div>
		<div class="row">
			<div class="vcenter col-md-12 text-center">
				<div class="visible-sm-block visible-xs-block top-margin-10">
					<div class="form-box-cha9a9a widget bottom-pad-0"
						style="padding-top: 0px;"></div>
				</div>

				<div class="form-box-cha9a9a top-margin-20"
					style="padding: 10px !important;">
					<div class="container">
						<h1>Besoin : ${besoin.getProduit().getLibelle()}</h1>
						<div class="row">
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Produit</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Date Besoin</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité demandée</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Quantité restante</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Motif</span></strong>
							</div>
							<div
								class="col-xs-2 col-sm-2 text-center fund-bottom-border lr-pad-10">
								<strong><span class="text-color">Priorité</span></strong>
							</div>
						</div>
						<hr class="margin-20">
								<div class="row">
									<div class="col-xs-2 col-sm-2 text-center">
										<h5><a href="produit?idProduit=${besoin.getProduit().getIdProduit()}">${besoin.getProduit().getLibelle()} </a></h5>
									</div>

									<div class="col-xs-2 col-sm-2 text-center">
										<h5><fmt:formatDate type = "both"  value = "${besoin.getDateBesoin()}"/></h5>

									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${besoin.getQuantiteRestante()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${besoin.getQuantiteInitiale()}}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${besoin.getMotif()}</h5>
									</div>
									<div class="col-xs-2 col-sm-2 text-center">
										<h5>${besoin.getPriorite()}	</h5>
									</div>
								</div>
						<div class="row">
							<a href="#" class="btn btn-default btn-menu"><i
								class="fa icon-plus2"></i>Voir plus</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
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
					url:"besoins",
					data:data,
					method:method
			})
			.done(
					function(data){
						console.log(data);
						if(data){
							location.href="besoins"
						}
					}
			);
		}

		})	
</script>
<%@ include file="__footer.jsp"%>
