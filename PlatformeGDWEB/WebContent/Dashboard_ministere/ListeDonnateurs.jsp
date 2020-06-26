<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section">

	<div class="container">
		<div class="row text-center">
			<h1>Liste des donateurs</h1>
		</div>
<!-- 		<a href="Importer_Donateurs" class="btn btn-default">Importer des donateurs</a> -->
	</div>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">Email</th>
					<th scope="col">Numéro de télèphone</th>
					<th scope="col">Région</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="donnateur" items="${donateurs}">
					<tr>
						<c:choose>
						    <c:when test="${not empty donnateur.getNom()}">
								<td><c:out value="${donnateur.getNom()}"></c:out></td>
						    </c:when>    
						    <c:otherwise>
						        <td> - </td> 
						    </c:otherwise>
						</c:choose>					
						<c:choose>
						    <c:when test="${not empty donnateur.getPrenom()}">
						<td><c:out value="${donnateur.getPrenom()}"></c:out></td>
						    </c:when>    
						    <c:otherwise>
						        <td> - </td> 
						    </c:otherwise>
						</c:choose>	
						<c:choose>
						    <c:when test="${not empty donnateur.getEmail()}">
								<td><c:out value="${donnateur.getEmail()}"></c:out></td>
						    </c:when>    
						    <c:otherwise>
						        <td> - </td> 
						    </c:otherwise>
						</c:choose>	


						<c:choose>
						    <c:when test="${not empty donnateur.getTelephone()}">
								<td><c:out value="${donnateur.getTelephone().iterator().next().getNumero()}"></c:out></td>
						    </c:when>    
						    <c:otherwise>
						        <td> - </td> 
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${not empty donnateur.getAdresse()}">
								<td><c:out value="${donnateur.getAdresse().getGouvernorat()}"></c:out></td>	
						    </c:when>    
						    <c:otherwise>
						        <td> - </td> 
						    </c:otherwise>
						</c:choose>															
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../pagination.jsp">
	        	<jsp:param name="currentPage" value="${currentPage}"/>
	        	<jsp:param name="noOfPages" value="${noOfPages}"/>
	        	<jsp:param name="link" value="Liste_Donateurs"/>
	    </jsp:include>
	</div>

</section>
<%@ include file="__footer.jsp"%>