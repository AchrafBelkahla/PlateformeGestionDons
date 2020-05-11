
<%@ include file="__header.jsp"%>
<%-- <%@ include file="menu_1.jsp"%> --%>
<section class="page-section light-bg">
<div class="container">	

	<form name="formEditBesoin" action="editBesoin?idBesoin=${besoin.getIdBesoin()}" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a">
	
	<h1>${besoin.getProduit().getLibelle()}</h1>
	
	<!--   <div class="form-row"> -->
	<!--     <div class="form-group col-md-3"> -->
	<%--       <label for="produit">Produit : ${besoin.getProduit().getLibelle()}</label> --%>
	<!-- 	   <select name="produit"> -->
	<%-- 	   			<option value="${besoin.getProduit().getIdProduit()}">${besoin.getProduit().getLibelle()}</option> --%>
	<%-- 		   <c:forEach var="produit" items="${produits}"> --%>
	<%-- 		      <option value="${produit.getIdProduit()}">${produit.getLibelle()}</option> --%>
	<%-- 		   	</c:forEach> --%>
	<!--    </select> -->
	<!--     </div> -->
	<!--     <div class="form-group col-md-6"> -->
	<!-- 			<a href="ajoutProduit" class="btn btn-info" role="button">Ajouter un produit</a> -->
	<!--     </div> -->
	<!--   </div> -->
	
		<div class="form-group">
			<label class="control-label required" for="quantite">Quantité demandée</label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
			<input type="number" name="quantite" value="${besoin.getQuantiteInitiale()}" min="0" class="form-control" required="required"/>
		</div>
	
		<div id="${besoin.getPriorite()}" class="form-group" >
			<label id="priorite" class="control-label required" for="priorite">Priorité </label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
			<input type="radio" name="priorite" value="forte" required="required" /> Forte
		   <input type="radio" name="priorite" value="moyenne" /> Moyenne
		   <input type="radio" name="priorite" value="faible" /> Faible
		</div>
	
	
		<div class="form-group" >
			<label id="priorite" class="control-label required" for="motif">Motif  </label>
			<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
	   		<textarea name="motif" rows="6" cols="40" required="required" class="form-control">${besoin.getMotif()}</textarea>
	  	</div>
	  	
		<div class="form-group" >
			 <button type="submit" class="btn btn-default btn-block">Confirmer</button>
			 <a href="besoin?idBesoin=${besoin.getIdBesoin()}" class="btn btn-default btn-block" role="button">Annuler</a>
	  	</div>
	</form>
</div>
</section>
<script>
  $(document).ready(function(){
	  let value=  $("#priorite").closest('div').attr('id');
	  console.log(value);
	  $("input[type=radio][value|="+value+"]" ).prop('checked', 'checked');
  });
</script>
<%@ include file="__footer.jsp"%>