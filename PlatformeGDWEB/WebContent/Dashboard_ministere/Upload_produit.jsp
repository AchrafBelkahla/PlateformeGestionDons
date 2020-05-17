<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
<div class="container">	
<div class="overlay"></div>
 <form name="formAjoutBesoin" action="Importer_produit" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a" enctype="multipart/form-data"> 
<h1>importer Produit</h1>
<p style="color: red;">Le fichier excel doit avoir les colonnes suivantes:</p>
<p>Libellé | Description | Fournisseur</p>
<div class="form-group">
	
	<div class="form-group">
		<label class="control-label required" for="photos">sélectionner un fichier</label>
<!-- 		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>	 -->
		<input type="file" name="file" multiple />
	</div>
	<div class="form-group">
	 <button type="submit" class="btn btn-default btn-block">Confirmer</button>
	 <a href="Ministere" class="btn btn-default btn-block" role="button">Annuler</a>
	</div>
</div>
</form> 
	</div>
	
	</section>
<%@ include file="__footer.jsp"%>