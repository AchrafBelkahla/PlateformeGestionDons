<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
    
    		<nav aria-label="Navigation for page">
		    <ul class="pagination">
		        <c:if test="${currentPage != 1}">

		            <c:choose>
		                <c:when test="${order == null}">		        	
				            <li class="page-item"><a class="page-link" 
				                href="${link}?currentPage=${currentPage-1}">Previous</a>
				            </li>
			            </c:when>
			            <c:otherwise>
				            <li class="page-item"><a class="page-link" 
				                href="${link}?currentPage=${currentPage-1}&order=${order}&direction=${direction}">Previous</a>
				            </li>			            	
			            </c:otherwise>
			           </c:choose>

		        </c:if>
		<c:if test="${noOfPages < 10}">
		        <c:forEach begin="1" end="${noOfPages}" var="i">
		            <c:choose>
		                <c:when test="${currentPage eq i}">
		                    <li class="page-item active"><a class="page-link">
		                            ${i} <span class="sr-only">(current)</span></a>
		                    </li>
		                </c:when>
		                <c:otherwise>
		                <c:choose>
			                <c:when test="${order == null}">		        	
			                    <li class="page-item"><a class="page-link" 
			                        href="${link}?currentPage=${i}">${i}</a>
			                    </li>
				            </c:when>
				            <c:otherwise>
					            <li class="page-item"><a class="page-link" 
					                href="${link}?currentPage=${i}&order=${order}&direction=${direction}">${i}</a>
					            </li>			            	
				            </c:otherwise>
				           </c:choose>		                
		                

		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
		</c:if>
				<c:if test="${noOfPages >= 10}">
		        <c:forEach begin="1" end="3" var="i">
		            <c:choose>
		                <c:when test="${currentPage eq i}">
		                    <li class="page-item active"><a class="page-link">
		                            ${i} <span class="sr-only">(current)</span></a>
		                    </li>
		                </c:when>
		                <c:otherwise>
		                 <c:choose>
			                <c:when test="${order == null}">		        	
			                    <li class="page-item"><a class="page-link" 
			                        href="${link}?currentPage=${i}">${i}</a>
			                    </li>
				            </c:when>
				            <c:otherwise>
					            <li class="page-item"><a class="page-link" 
					                href="${link}?currentPage=${i}&order=${order}&direction=${direction}">${i}</a>
					            </li>			            	
				            </c:otherwise>
				           </c:choose>	
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
        		   <li class="page-item"><a class="page-link" 
		                        href="#">...</a>
		        <c:forEach begin="${noOfPages-3}" end="${noOfPages}" var="i">
		            <c:choose>
		                <c:when test="${currentPage eq i}">
		                    <li class="page-item active"><a class="page-link">
		                            ${i} <span class="sr-only">(current)</span></a>
		                    </li>
		                </c:when>
		                <c:otherwise>
							<c:choose>
				                <c:when test="${order == null}">		        	
				                    <li class="page-item"><a class="page-link" 
				                        href="${link}?currentPage=${i}">${i}</a>
				                    </li>
					            </c:when>
					            <c:otherwise>
						            <li class="page-item"><a class="page-link" 
						                href="${link}?currentPage=${i}&order=${order}&direction=${direction}">${i}</a>
						            </li>			            	
					            </c:otherwise>
				           </c:choose>	
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
		</c:if>   
		        <c:if test="${currentPage lt noOfPages}">
		        	<c:choose>
		                <c:when test="${order == null}">		        	
				            <li class="page-item"><a class="page-link" 
				                href="${link}?currentPage=${currentPage+1}">Next</a>
				            </li>
			            </c:when>
			            <c:otherwise>
				            <li class="page-item"><a class="page-link" 
				                href="${link}?currentPage=${currentPage+1}&order=${order}&direction=${direction}">Next</a>
				            </li>			            	
			            </c:otherwise>
			           </c:choose>
		        </c:if>              
		    </ul>
		</nav>