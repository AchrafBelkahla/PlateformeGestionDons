
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
<section class="page-section light-bg">
	<div class="container">
	<div class="row">
  		<div class="col-sm-8"><h1>Besoin : ${besoin.getProduit().getLibelle()}</h1></div>
  		<div class="col-sm-4" id="${besoin.getIdBesoin()}">
  			<a href="besoins" class="btn btn-default" role="button">Retour</a>
  		    <a href="editBesoin?idBesoin=${besoin.getIdBesoin()}" class="btn btn-warning " role="button" id="editbesoin">Editer</a>
	  		<button class="btn btn-danger" id="deletebesoin">Supprimer </button>
  		</div>
</div>
		
		<br>
		<table class="table table-hover" border = "1">
				<tr>
					<td>Produit </td>
					<td>Date Besoin  </td>					
					<td>Quantité demandée</td>
					<td>Quantité restante</td>
					<td>Motif</td>
					<td>Priorité</td>
				</tr>
				<tr>
				<td><a href="produit?idProduit=${besoin.getProduit().getIdProduit()}">${besoin.getProduit().getLibelle()  } </a> </td>
					<td><fmt:formatDate type = "both"  value = "${besoin.getDateBesoin()}"/></td>					
					<td>${besoin.getQuantiteInitiale()}</td>
					<td>${besoin.getQuantiteRestante()}</td>
					<td>${besoin.getMotif()}</td>
					<td>${besoin.getPriorite()}</td>					
		</table>

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
	</section>
<%@ include file="__footer.jsp"%>