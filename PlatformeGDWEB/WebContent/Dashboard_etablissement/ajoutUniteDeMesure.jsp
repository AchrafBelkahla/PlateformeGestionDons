<%@ include file="__header.jsp"%>

<%@ include file="menu_etablissement.jsp"%>
<section class="page-section light-bg">
<div class="overlay"></div>
<div class="container">	

 <form name="formAjoutUdm" action="udms" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a">
<h1>Ajouter une unité de mesure</h1>

  <div class="form-group">
 	 <div class="form-group">
	    <label class="control-label required" for="idUnite">Unité de mesure</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
	    <input type="text" class="form-control" id="idUnite" name="idUnite" required="required">
	  </div>

  	<div class="form-group">
	 <button type="submit" class="btn btn-default btn-block">Ajouter</button>
	 <a href="udms" class="btn btn-default btn-block" role="button">Annuler</a>
	</div>
  </div>
</form>
</div>
</section>
<%@ include file="__footer.jsp"%>