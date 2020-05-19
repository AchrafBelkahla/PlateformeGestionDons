
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
<div class="overlay"></div>
<div class="container">	

 <form name="formAjoutFournisseur" action="ajoutFournisseurMinistere?currentPage=1" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a"> 
<h1>Ajouter un Fournisseur</h1>

<div class="form-group">
<div class="form-group">      
	<label class="control-label required" for="produit">Produit</label>
	<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
<select name="produit" class="selectpicker form-control" multiple data-live-search="true" required="required">
  
  <c:forEach var="categorie" items="${categories}">
	<optgroup label="${categorie.getLibelle()}">
			   <c:forEach var="produit" items="${categorie.getProduits()}">
			      <option value="${produit.getIdProduit()}">${produit.getLibelle()}</option>
			   	</c:forEach>
	    </optgroup>
	</c:forEach>
</select>
</div>

<div class="form-group">    
 	
	<label class="control-label required" for="libelle">Libellé</label>
	<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
   <input type="text" name="libelle" required="required" placeholder="Tapez votre libelle"  class="form-control"/>
</div>

<div class="form-group">
	<label class="control-label required" for="email">Email</label>
	<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
   <input type="email" name="email" required="required" placeholder="Tapez votre email"  class="form-control"/>
</div>

<div class="form-group">
	<label class="control-label required" for="adresse">Adresse</label>
	<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
   <input type="text" name="adresse" required="required" placeholder="Tapez votre adresse"  class="form-control"/>
</div>


<div class="row">
  <div class="col-sm-6">
  	<div class="form-group">
		<label class="control-label required" for="gouvernorat">Gouvernorat</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
		<select name="gouvernorat" class="selectpicker form-control" required="required">
			<option value="Ariana">Ariana</option>
			<option value="Béja">Béja</option>
			<option value="Ben Arous">Ben Arous</option>
			<option value="Bizerte">Bizerte</option>
			<option value="Gabes">Gabes</option>
			<option value="Gafsa">Gafsa</option>
			<option value="Jendouba">Jendouba</option>
			<option value="Kairouan">Kairouan</option>
			<option value="Kasserine">Kasserine</option>
			<option value="Kébili">Kébili</option>
			<option value="Le Kef">Le Kef</option>
			<option value="Mahdia">Mahdia</option>
			<option value="La Manouba">La Manouba</option>
			<option value="Médenine">Médenine</option>
			<option value="Monastir">Monastir</option>
			<option value="Nabeul">Nabeul</option>
			<option value="Sfax">Sfax</option>
			<option value="Sidi Bouzid">Sidi Bouzid</option>
			<option value="Tataouine">Tataouine</option>
			<option value="Tozeur">Tozeur</option>
			<option value="Tunis">Tunis</option>
			<option value="Zaghouan">Zaghouan</option>
		</select>
   	</div>
   </div>
   <div class="col-sm-6">
  	<div class="form-group">
		<label class="control-label required" for="codePostal">Code postal</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
	   <input type="number" name="codePostal" required="required" placeholder="Tapez votre code postal" max="9999" min="0"  class="form-control"/>
   	</div>
   </div>
</div>
  	<div class="form-group">
		<label class="control-label required" for="telephone">Téléphone</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
	   <input type="tel" name="telephone" required="required" placeholder="Tapez votre telephone"   class="form-control"/>
   	</div>



	 <button type="submit" class="btn btn-default btn-block">Ajouter</button>
	 <a href="Liste_Fournisseurs?currentPage=1" class="btn btn-default btn-block" role="button">Annuler</a>

</div>
</form> 
	</div>
	
	</section>

<%@ include file="__footer.jsp"%>