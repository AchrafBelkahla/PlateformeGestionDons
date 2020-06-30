<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">
	<div class="container">

		<div class="row text-center">

			<h1>Liste des Dons reglement</h1>
		</div>
	</div>
	<div class="container">
			<div class="col-sm-9">
				<span class="hidden-sm-down sort-by text-xs-right">Trier par :</span>
                	<c:choose>
		                <c:when test="${order=='b.etablisement.NomEtablissement'}">
			               <c:choose>
					    	<c:when test="${direction == 'asc'}">		        	
								<button class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" >Bénéficiaire &uarr; <strong class="caret"></strong></button>
				            </c:when>
				            <c:otherwise>
								<button class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" >Bénéficiaire &darr; <strong class="caret"></strong></button>			            	
				            </c:otherwise>
				           </c:choose>
		                </c:when>
		            <c:otherwise>
			               <c:choose>
					    	<c:when test="${direction == 'asc'}">		        	
								<button class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" >Donateur &uarr; <strong class="caret"></strong></button>
				            </c:when>
				            <c:otherwise>
								<button class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" >Donateur &darr; <strong class="caret"></strong></button>			            	
				            </c:otherwise>
				           </c:choose>		            	
		           </c:otherwise>
		           </c:choose>	
                
                <ul class="dropdown-menu">
                    <li>
                        <a href="Liste_Dons_Reglement?currentPage=1&order=b.etablissement.NomEtablissement&direction=asc">Bénéficiaire &uarr;</a>
                    </li>
                    <li>
                        <a href="Liste_Dons_Reglement?currentPage=1&order=b.etablissement.NomEtablissement&direction=desc">Bénéficiaire &darr;	</a>
                    </li>
                    <li>
                        <a href="Liste_Dons_Reglement?currentPage=1&order=b.utilisateur.Nom&direction=asc">Donateur &uarr;</a>
                    </li>
                    <li>
                    	<a href="Liste_Dons_Reglement?currentPage=1&order=b.utilisateur.Nom&direction=desc">Donateur &darr;</a>
                    </li>
                </ul>
			</div>			
		<table class="table">
			<thead class="thead-dark">
				<tr>
							<th scope="col">Photo Don</th>
							<th scope="col">Montant (DT)</th>
							<th scope="col">Bénéficiaire</th>
							<th scope="col">Donateur</th>
							<th scope="col">Mode de réglement</th>
							<th scope="col">Date réglement</th>			
							<th scope="col">Approuvé</th>
							<th scope="col"></th>
							<th scope="col"></th>																	
						</tr>
			</thead>
			<tbody>
				<c:forEach items="${reglement}" var="b">
							<tr>
<%-- 								<c:choose> --%>
<%-- 								    <c:when test="${not empty b.getBesoin().getProduit()}"> --%>
										<td><c:out value="-"></c:out></td>
<%-- 								    </c:when>     --%>
<%-- 								    <c:otherwise> --%>
<!-- 								        <td> - </td>  -->
<%-- 								    </c:otherwise> --%>
<%-- 								</c:choose>					 --%>
								<c:choose>
								    <c:when test="${not empty b.getMontant()}">
								<td><c:out value="${b.getMontant()}"></c:out></td>
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>	
								<c:choose>
								    <c:when test="${not empty b.getEtablissement()}">
										<td><c:out value="${b.getEtablissement().getNomEtablissement()}"></c:out></td>
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>	
		
		
								<c:choose>
								    <c:when test="${not empty b.getUtilisateur()}">
										<td><c:out value="${b.getUtilisateur().getNom()}, ${b.getUtilisateur().getPrenom()}"></c:out></td>
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>
								<c:choose>
								    <c:when test="${not empty b.getModeReglement()}">
										<td><c:out value="${b.getModeReglement()}"></c:out></td>	
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>		
								<c:choose>
								    <c:when test="${not empty b.getDateReglement()}">
										<td><fmt:formatDate type = "both"  value = "${b.getDateReglement()}"/></td>	
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>
								<c:choose>
								    <c:when test="${not empty b.isEstAccepte()}">
										<td><c:out value = "${b.isEstAccepte()}"></c:out></td>	
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>										
									<td>
										<a href="accepter_don_reglement?code_reglement=${b.getId_don()}" class="btn btn-success btn-sm" role="button">Accepter</a>											</td>
									</td>
									<td>
										<a href="supprimer_don_reglement?code_reglement=${b.getId_don()}" class="btn btn-danger btn-sm" role="button">Supprimer</a>
									</td>																		
							</tr>
						</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        	<jsp:param name="currentPage" value="${currentPage}"/>
	        	<jsp:param name="noOfPages" value="${noOfPages}"/>
	        	<jsp:param name="order" value="${order}"/>
	        	<jsp:param name="direction" value="${direction}"/>
	        	<jsp:param name="link" value="Liste_Dons_Reglement"/>
	    </jsp:include>
	</div>

</section>

<%@ include file="__footer.jsp"%>