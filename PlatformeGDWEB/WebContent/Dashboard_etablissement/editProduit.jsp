
<%@ include file="__header.jsp"%>
<%-- <%@ include file="menu_1.jsp"%> --%>
<section class="page-section light-bg">
<div class="container">	

 <form name="formEditProduit" action="editProduit?idProduit=${produit.getIdProduit()}" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a">
	<h1>Produit : ${produit.getLibelle()}</h1>

		<div class="form-group">
			<label class="control-label required" for="libelle">Libellé</label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
			<input type="text" id="libelle" name="libelle" value="${produit.getLibelle()}"  class="form-control" required="required"/>
		</div>
		<div class="row">
		    <div class="form-group col-md-6">
		      <label for="categorie">Catégorie : ${produit.getCategorie().getLibelle()}</label>
		    </div>
		    
		    <div class="form-group col-md-6">
		      <label for="udm">Unite de mesure : ${produit.getUniteDeMesure().getIdUnite()}</label>
		    </div>
		</div>
		<div class="form-group" >
			<label id="description" class="control-label required" for="description">Description  </label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
	   		<textarea name="description" rows="6" cols="40" required="required" class="form-control">${produit.getDescriptionTechnique()}</textarea>
	  	</div> 

 	<div class="form-group">
	    <label class="control-label required" for="prixMin">Prix min</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>      
    	<input type="number" class="form-control" id="prixMin" name="prixMin" step=any min="0" required="required" value="${produit.getPrixMin()}">
 	</div>  
  	<div class="form-group">
	    <label class="control-label required" for="prixMax">Prix max</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>      
    	<input type="number" class="form-control" id="prixMax" name="prixMax" step=any  required="required" value="${produit.getPrixMin()}">
 	</div>  

  	<div class="form-group">
		 <button type="submit" class="btn btn-default btn-block">Confirmer</button>
		 <a href="produits" class="btn btn-default btn-block" role="button">Annuler</a>
 	</div>
</form>
</div>
</section>
<script>
$(document).ready(function(){
	 $("#prixMax").on('mouseup keyup', function () {
		 let value = $("#prixMin").val();
		  $(this).val(Math.max(value, $(this).val()));
		});
	});
</script>
<%@ include file="__footer.jsp"%>