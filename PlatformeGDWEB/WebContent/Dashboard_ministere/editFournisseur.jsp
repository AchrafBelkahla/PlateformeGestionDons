
<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
<div class="container">	

 <form name="formEditFournisseur" action="editFournisseur?idFournisseur=${fournisseur.getIdF()}" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a">
	<h1>Fournisseur : ${fournisseur.getLibelle()}</h1>


		<div class="form-group">
			<label class="control-label required" for="libelle">Libellé</label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
			<input type="text" id="libelle" name="libelle" value="${fournisseur.getLibelle()}"  class="form-control" required="required"/>
		</div>

		<div class="form-group">
			<label class="control-label required" for="email">Email</label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
   			<input type="email" name="email" value="${fournisseur.getEmailF()}"  class="form-control" required="required"/>
		</div>
		
		<div class="form-group">
			<label class="control-label required" for="adresse">Adresse</label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
   		    <input type="text" name="adresse" value="${fournisseur.getAdresseF()}"  class="form-control" required="required"/>
		</div>

		<div class="row">
		  <div class="col-sm-6">
		  	<div class="form-group">
				<label class="control-label " for="gouvernorat">Gouvernorat</label>
				<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
				<div id="${fournisseur.getGouvernorat()}">
				<select id="gouvernorat" name="gouvernorat" class="selectpicker form-control" required="required">
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
					<option value="Sousse">Sousse</option>
					<option value="Sidi Bouzid">Sidi Bouzid</option>
					<option value="Tataouine">Tataouine</option>
					<option value="Tozeur">Tozeur</option>
					<option value="Tunis">Tunis</option>
					<option value="Zaghouan">Zaghouan</option>
				</select>
				</div>
		   	</div>
		   </div>
		   <div class="col-sm-6">
		  	<div class="form-group">
				<label class="control-label required" for="codePostal">Code postal</label>
				<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
			   <input type="number" name="codePostal" value="${fournisseur.getCodePostal()}" max="9999" min="0"  class="form-control" required="required"/>
		   	</div>
		   </div>
		</div>
  	<div class="form-group">
		<label class="control-label required" for="telephone">Télèphone</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
	   <input type="tel" name="telephone" value="${fournisseur.getNumTelF()}" class="form-control" required="required"/>
   	</div>
  	<div class="form-group">
	 <button type="submit" class="btn btn-default btn-block">Confirmer</button>
	 <a href="Liste_Fournisseurs?currentPage=1" class="btn btn-default btn-block" role="button">Annuler</a>
   	</div>
</form>
</div>
</section>
<script type='text/javascript'>
  $(document).ready(function(){
	  let value=  $("select").closest('div').attr('id');
	  $("option[value|="+value+"]" ).attr('selected', 'selected');
  });
</script>
<%@ include file="__footer.jsp"%>