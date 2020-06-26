<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>

<%@ include file="menu_ministere.jsp"%>



<section class="page-section">
	<div class="container">


		<div class="row">
			<div class="section-title margin-0">
				<h2 class="title">Gérer les dons</h2>
			</div>
		</div>
		<form name="new_fund" method="post" class="form-group"
			action="${pageContext.request.contextPath}/Liste_Dons">
			<div class="row">
				<div class="col-md-3 text-center"></div>
				<div class="col-md-3 text-center">
					<input class="btn btn-default fs20 white igive-btn form-control"
						type="submit" name="action" value="Voir tous les dons en nature">
				</div>
				<div class="col-md-3 text-center">
					<input class="btn btn-default fs20 white igive-btn form-control"
						type="submit" name="action" value="Voir tous les reglements">
				</div>
			</div>
		</form>
		<div class="container">
<!-- 			<a href="Importer_Dons" class="btn btn-default">Importer des dons</a> -->
		</div>
		<form name="new_fund" method="post" class="form-group"
			action="${pageContext.request.contextPath}/Liste_Dons">
			<c:choose>
				<c:when test="${param.action=='Voir tous les dons en nature'}">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Nom Don</th>
								<th scope="col">Bénéficiaire</th>
								<th scope="col">Donateur</th>
								<th scope="col">Prix total</th>
								<th scope="col">Quantité</th>
								<th scope="col">Approuvé</th>
								<c:choose>	
								<c:when test="${d.isEstAccepte()==false}">
									<th scope="col"></th>
								</c:when>
								</c:choose>								
<!-- 								<th scope="col"></th>					 -->
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${don_en_nature}" var="d">
								<tr>
									<c:choose>
									    <c:when test="${not empty d.getBesoin().getProduit()}">
											<td><c:out value="${d.getBesoin().getProduit().getLibelle()}"></c:out></td>
									    </c:when>    
									    <c:otherwise>
									        <td> - </td> 
									    </c:otherwise>
									</c:choose>					
									<c:choose>
									    <c:when test="${not empty d.getEtablissement()}">
									<td><c:out value="${d.getEtablissement().getNomEtablissement()}"></c:out></td>
									    </c:when>    
									    <c:otherwise>
									        <td> - </td> 
									    </c:otherwise>
									</c:choose>	
									<c:choose>
									    <c:when test="${not empty d.getUtilisateur()}">
											<td><c:out value="${d.getUtilisateur().getNom()}, ${d.getUtilisateur().getPrenom()}"></c:out></td>
									    </c:when>    
									    <c:otherwise>
									        <td> - </td> 
									    </c:otherwise>
									</c:choose>	
			
			
									<c:choose>
									    <c:when test="${not empty d.getPrix_totale()}">
											<td><c:out value="${d.getPrix_totale()}"></c:out></td>
									    </c:when>    
									    <c:otherwise>
									        <td> - </td> 
									    </c:otherwise>
									</c:choose>
									<c:choose>
									    <c:when test="${not empty d.getQuantite()}">
											<td><c:out value="${d.getQuantite()}"></c:out></td>	
									    </c:when>    
									    <c:otherwise>
									        <td> - </td> 
									    </c:otherwise>
									</c:choose>		
									<c:choose>
									    <c:when test="${not empty d.isEstAccepte()}">
											<td><c:out value="${d.isEstAccepte()}"></c:out></td>	
									    </c:when>    
									    <c:otherwise>
									        <td> - </td> 
									    </c:otherwise>
									</c:choose>
									<c:choose>	
									<c:when test="${d.isEstAccepte()==false}">
									<td>
										<a href="accepter_don?code_don_en_nature=${d.getId_don()}" class="btn btn-success btn-sm" role="button">Accepter</a>
									</td>
									</c:when>
									</c:choose>
<!-- 									<td> -->
<%-- 										<a href="supprimer_don?code_don_en_nature=${d.getId_don()}" class="btn btn-danger btn-sm" role="button" >Supprimer</a> --%>
<!-- 									</td>																				 -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
<%-- 				<jsp:include page="../pagination.jsp"> --%>
<%-- 	        	<jsp:param name="currentPage" value="${currentPage}"/> --%>
<%-- 	        	<jsp:param name="noOfPages" value="${noOfPages}"/> --%>
<%-- 	        	<jsp:param name="link" value="Liste_Dons"/> --%>
<%-- 	    </jsp:include> --%>
			</c:when>

			<c:when test="${param.action=='Voir tous les reglements'}">
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
						<c:forEach items="${reglement}" var="r">
							<tr>
<%-- 								<c:choose> --%>
<%-- 								    <c:when test="${not empty d.getBesoin().getProduit()}"> --%>
										<td><c:out value="-"></c:out></td>
<%-- 								    </c:when>     --%>
<%-- 								    <c:otherwise> --%>
<!-- 								        <td> - </td>  -->
<%-- 								    </c:otherwise> --%>
<%-- 								</c:choose>					 --%>
								<c:choose>
								    <c:when test="${not empty r.getMontant()}">
								<td><c:out value="${r.getMontant()}"></c:out></td>
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>	
								<c:choose>
								    <c:when test="${not empty r.getEtablissement()}">
										<td><c:out value="${r.getEtablissement().getNomEtablissement()}"></c:out></td>
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>	
		
		
								<c:choose>
								    <c:when test="${not empty r.getUtilisateur()}">
										<td><c:out value="${r.getUtilisateur().getNom()}, ${r.getUtilisateur().getPrenom()}"></c:out></td>
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>
								<c:choose>
								    <c:when test="${not empty r.getModeReglement()}">
										<td><c:out value="${r.getModeReglement()}"></c:out></td>	
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>		
								<c:choose>
								    <c:when test="${not empty r.getDateReglement()}">
										<td><fmt:formatDate type = "both"  value = "${r.getDateReglement()}"/></td>	
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>
								<c:choose>
								    <c:when test="${not empty r.isEstAccepte()}">
										<td><c:out value = "${r.isEstAccepte()}"></c:out></td>	
								    </c:when>    
								    <c:otherwise>
								        <td> - </td> 
								    </c:otherwise>
								</c:choose>										
									<td>
										<a href="accepter_don_reglement?code_reglement=${r.getId_don()}" class="btn btn-success btn-sm" role="button">Accepter</a>											</td>
									</td>
									<td>
										<a href="supprimer_don_reglement?code_reglement=${r.getId_don()}" class="btn btn-danger btn-sm" role="button">Supprimer</a>
									</td>																		
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>			
		</c:choose>		
		</form>
	</div>
</section>
<%@ include file="__footer.jsp"%>