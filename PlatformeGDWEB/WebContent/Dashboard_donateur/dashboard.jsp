<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="__header.jsp"%>
<%@ include file="menu_donnateur.jsp"%>
<!-- Load Facebook SDK for JavaScript -->
<div id="fb-root"></div>
<script>
    window.fbAsyncInit = function() {
        FB.init({
            xfbml            : true,
            version          : 'v3.2'
        });
    };
    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = '../connect.facebook.net/fr_FR/sdk/xfbml.customerchat.js';
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>



<!-- facebook page -->
<script>(function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = '../connect.facebook.net/fr_FR/sdk.js#xfbml=1&version=v3.0&appId=1669069353118459&autoLogAppEvents=1';
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>


    <!-- Page Loader -->
    <div id="pageloader">
        <div class="loader-item fa fa-spin text-color"></div>
    </div>




                                                                                                    
    <!-- Sticky Navbar -->
    <section class="page-section light-bg">

        <div class="container">
            <div class="row">

                <div class="col-md-12 col-sm-12">




    <div class="container">
<!--         <div class="row -bottom-margin-20"> -->
            
                <div class="form-box-cha9a9a" style="padding-bottom: 20px; margin-bottom: 20px;">
                    <div class="row section-title margin-0">
                        <h2 class="title" style="margin-bottom: 0px!important;"> Mes coordonnées </h2>
                    </div>

                    <div class="row lr-margin-30 top-margin-10">
                    <div class="col-sm-6 col-md-6" >
                        <div class="table-responsive">
                            <table class="table table-borderless">
                                <tr>
                                    <td><strong>Nom : </strong></td>
                                    <td>${user.getNom()}</td>
                                </tr>
                                <tr>
                                    <td><strong>Prénom : </strong></td>
                                    <td>${user.getPrenom()}</td>
                                </tr>
                                <tr>
                                    <td><strong>Email : </strong></td>
                                    <td>${user.getEmail()}</td>
                                </tr>
                                <tr>
                                    <td><strong>Téléphone : </strong></td>
                                    <td>${telephone.getNumero()}</td>
                                </tr>
                            </table>
                        </div>

                        </div>
                       <div class="col-sm-6 col-md-6" >
                        <div class="table-responsive">
                            <table class="table table-borderless">
                                <tr>
                                    <td><strong>Adresse : </strong></td>
                                    <td>${user.getAdresse().getAdresse()}</td>
                                </tr>
                                <tr>
                                    <td><strong>Gouvernorat : </strong></td>
                                    <td>${user.getAdresse().getGouvernorat()}</td>
                                </tr>
                                <tr>
                                    <td><strong>Code Postal : </strong></td>
                                    <td>${user.getAdresse().getCodePostale()}</td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
                        </div>

                        </div>

                                    
                    
                </div>
                <div class="row lr-margin-30 top-margin-10">
                	<div class="col-sm-6 col-md-6" >
						<a href="editProfil"><span class="text-color"><i
                     	class="icon-chevron-right5"></i> Modifier</span></a>  
                     </div>    
                     <div class="col-sm-6 col-md-6" >          
               			<a href="editPassword"><span class="text-color"><i class="icon-chevron-right5"></i> 
               			Changer le mot de passe</span></a>   
               		</div>                 
                 </div>
            </div>

<!--         </div> -->
    </div>

    <div class="container">
                <div class="form-box-cha9a9a" style="padding-bottom: 20px; margin-bottom: 20px;">
                    <div class="row section-title margin-0">
                        <h2 class="title" style="margin-bottom: 0px!important;"> Mes dons en nature </h2>
                    </div>
                    <div class="row lr-margin-30 top-margin-10">
								<table class="table">
									<thead>
									<tr>
										<!--<th scope="col">
											<strong><span class="text-color">Photo Don</span></strong>
										</th>-->
										<th scope="col">
											<strong><span class="text-color">Nom Don</span></strong>
										</th>
										<th scope="col">
											<strong><span class="text-color">Bénéficiaire</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Prix total </span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Quantité</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Approuvé</span></strong>
										</th scope="col">
										<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${donsEnNature}" var="d">
											<c:if test="${d.isEstSupprime() == false}">
											<tr>
											<!--<td>
											</td>-->
											<td>
											<h5>${d.getBesoin().getProduit().getLibelle()}</h5>
											</td>
											<td>
											<h5>${d.getEtablissement().getNomEtablissement()}</h5>
											</td>
											<td>
											<h5>${d.getPrix_totale()}</h5>
											</td>
											<td>
											<h5>${d.getQuantite()}</h5>
											</td>
											<td>
												<c:choose>
												    <c:when test="${d.isEstAccepte() == false}">
														<h5>Non</h5>
												    </c:when>
												    <c:otherwise>    
														<h5>Oui</h5>												    
												    </c:otherwise>
												</c:choose>
											</td>
												<td>
													<div id="${d.getId_don()}">
														<button class="btn btn-danger btn-sm" id="deletenature">Supprimer </button>
													</div>											
												</td>
											</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
						  </div>	
        </div>
    </div>
    <div class="container">
                <div class="form-box-cha9a9a" style="padding-bottom: 20px; margin-bottom: 20px;">
                    <div class="row section-title margin-0">
                        <h2 class="title" style="margin-bottom: 0px!important;"> Mes réglements </h2>
                    </div>
                    <div class="row lr-margin-30 top-margin-10">
									<table class="table">
									<thead>
									<tr>
										<th scope="col">
											<strong><span class="text-color">Photo Don</span></strong>
										</th>
										<th scope="col">
											<strong><span class="text-color">Montant (DT)</span></strong>
										</th>
										<th scope="col">
											<strong><span class="text-color">Bénéficiaire</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Mode de réglement</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Date réglement</span></strong>
										</th scope="col">
										<th>
											<strong><span class="text-color">Approuvé</span></strong>
										</th scope="col">
										<th scope="col"></th>
										<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${reglements}" var="r">
										<c:if test="${r.isEstSupprime() == false}">
											<tr>
											<td>
											</td>
											<td>
											<h5>${r.getMontant()}</h5>
											</td>
											<td>
											<h5>${r.getEtablissement().getNomEtablissement()}</h5>
											</td>
											<td>
											<h5>${r.getModeReglement()}</h5>
											</td>
											<td>
											<h5>${r.getDateReglement()}</h5>
											</td>
											<td>
												<c:choose>
												    <c:when test="${r.isEstAccepte() == false}">
														<h5>Non</h5>
												    </c:when>
												    <c:otherwise>    
														<h5>Oui</h5>												    
												    </c:otherwise>
												</c:choose>
											</td>
											<td>
												<div id="${r.getId_don()}">
												<button class="btn btn-danger btn-sm" id="deletereglement">Supprimer </button>
												</div>
											</td>
											</tr>
											</c:if>
										</c:forEach>
									</tbody>
									</table>
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
				case "deletenature":
					async("delete",{id:id, type:"n"})
					break;
				case "deletereglement":
					async("delete",{id:id, type:"r"})
					break;

				}
			})
			function async(method,data){
				$.ajax({
					url:"profilDonateur",
					data:data,
					method:method
			})
			.done(
					function(data){
						if(data){
							location.href="profilDonateur"
						}
					}
			);
		}

		})	
</script>
	<%@ include file="__footer.jsp"%>