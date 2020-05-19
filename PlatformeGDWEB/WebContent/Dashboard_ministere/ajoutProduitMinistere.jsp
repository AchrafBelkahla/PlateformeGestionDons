<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
<div class="overlay"></div>
<div class="container">	

 <form name="formAjoutProduit" action="Liste_produits?currentPage=1" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a">
<h1>Ajouter un produit</h1>

  <div class="form-group">
 	 <div class="form-group">
	    <label class="control-label required" for="libelle">Libellé</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
	    <input type="text" class="form-control" id="libelle" name="libelle" required="required">
    </div>
<!--   <div class="form-row"> -->
<!--     <div class="form-group col-md-3"> -->
<!--       <label for="fournisseur">Fournisseur</label> -->
<!-- 	   <select name="fournisseur"> -->
<%-- 		   <c:forEach var="fournisseur" items="${fourniseurs}"> --%>
<%-- 		      <option value="${fournisseur.getIdF()}">${fournisseur.getLibelle()}</option> --%>
<%-- 		   	</c:forEach> --%>
<!--    </select> -->
<!--     </div> -->
<!--     <div class="form-group col-md-6"> -->
<!-- 			<a href="AjoutFournisseur" class="btn btn-info" role="button">Ajouter un fournisseur</a> -->
<!--     </div> -->
 	 <div class="form-group">
	    <label class="control-label required" for="description">Description</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
		<textarea class="form-control" name="description" rows="6" cols="40" required="required"></textarea>
    </div>

 	 <div class="form-group">
	    <label class="control-label required" for="categorie">Catégorie</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>  
	    <select name="categorie" class="form-control" required="required">
		   <c:forEach var="categorie" items="${categories}">
		      <option value="${categorie.getIdC()}">${categorie.getLibelle()}</option>
		   	</c:forEach> 
   		</select>
 	</div>
 	 <div class="form-group">
	    <label class="control-label required" for="udm">Unité de mesure</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>     
	   	<select name="udm" class="form-control" required="required">
		   <c:forEach var="udm" items="${udms}">
		      <option value="${udm.getIdUnite()}">${udm.getIdUnite()}</option>
		   	</c:forEach>
  		 </select>
 	</div>  
 	<div class="form-group">
	    <label class="control-label required" for="prixMin">Prix min</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>      
    	<input type="number" class="form-control" id="prixMin" name="prixMin" step=any min="0" required="required">
 	</div>  
  	<div class="form-group">
	    <label class="control-label required" for="prixMax">Prix max</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>      
    	<input type="number" class="form-control" id="prixMax" name="prixMax" step=any  required="required">
 	</div>  


  	<div class="form-group">
	 <button type="submit" class="btn btn-default btn-block">Ajouter</button>
	 <a href="Liste_produits?currentPage=1" class="btn btn-default btn-block" role="button">Annuler</a>
	</div>
  </div>
</form>
</div>
</section>
<script>
$(document).ready(function(){
	 $("#prixMax").on('mouseup keyup', function () {
		 let value = $("#prixMin").val();
		  $(this).attr({
			  "min": value})
		});
	});
</script>
<%@ include file="__footer.jsp"%>