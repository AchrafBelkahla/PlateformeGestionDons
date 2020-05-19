<%@ include file="__header.jsp"%>
<%@ include file="menu_ministere.jsp"%>
<section class="page-section light-bg">
<div class="container">	
<div class="overlay"></div>
 <form name="formAjoutBesoinMinistere" action="Liste_Besoins?currentPage=1" method="post" class="col-md-6 col-md-offset-3 form-box-cha9a9a" enctype="multipart/form-data"> 
<h1>Ajouter un besoin</h1>

<div class="form-group">
					<div class="form-group">
						<label class="control-label required" for="nom_etablissement">Nom établissement</label> 
							<span
							class="required text-danger form-asterisk"
							title="Ce champ est requis">*</span>
						<div class="cha9a9a-title text-center pad-5">
							<select id="idEtab" name="idEtab" class="form-control"  required >
								<option disabled selected value=" ">--Veuillez choisir un etablissement--</option>
								<c:forEach items="${etablissements}" var="b">
									<option value="${b.getIdEtablissement()}">
									${b.getNomEtablissement()} </option>
								</c:forEach>
							</select>
						</div>
					</div>
				<div class="form-group">
					<label class="control-label required" for="produit">Produit</label>
					<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
					<select name="produit" class ="form-control" required="required">
						<c:forEach var="produit" items="${produits}">
							<option value="${produit.getIdProduit()}">${produit.getLibelle()}</option>
						</c:forEach>
					</select>
				</div>

	<div class="form-group">
		<label class="control-label required" for="quantite">Quantité demandée</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
		<input type="number" name="quantite" value="0" min="0" class="form-control" required="required"/>
	</div>

	<div class="form-group">
		<label class="control-label required" for="Priorite">Priorité</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
		   <input type="radio" name="Priorite" value="forte" required /> Forte
		   <input type="radio" name="Priorite" value="moyenne" /> Moyenne
		   <input type="radio" name="Priorite" value="faible" /> Faible
	</div>
	
	<div class="form-group">
		<label class="control-label required" for="motif">Motif</label>
		<span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>	
   		<textarea name="motif" rows="6" cols="40" class="form-control" required="required" placeholder="Vous pouvez saisir ici le motif."></textarea>
   	</div>

	<div class="form-group">
		<label class="control-label required" for="photos">Ajouter des photos</label>
		<span class="required text-danger form-asterisk" >(formats acceptés : jpeg/png)</span>
		<input type="file" id="file" name="file" accept="image/*" multiple  />
			
	</div>
		<div class="form-group">
	 <button type="submit" class="btn btn-default btn-block">Confirmer</button>
	 <a href="Liste_Besoins?currentPage=1" class="btn btn-default btn-block" role="button">Annuler</a>
	</div>
</div>
</form> 
	</div>
	
	</section>
	    <script type="text/javascript">
        $(document).ready(function () {
             var validFilesTypes = ["png", "jpg","jpeg"];
            $('#file').change(function () {
                CheckExtension(this);
//              validateFileSize(this);
            });
            function CheckExtension(e) {
                /*global document: false */
 
 
                var file = e;
                var path = file.value;
 
                var ext = path.substring(path.lastIndexOf(".") + 1, path.length).toLowerCase();
                var isValidFile = false;
                for (var i = 0; i < validFilesTypes.length; i++) {
                    if (ext == validFilesTypes[i]) {
                        isValidFile = true;
                        break;
                    }
                }
                if (!isValidFile) {
                    e.value = null;
                    alert("Fichier non valide." + 
                    "Les extensions valides sont:\n\n" + validFilesTypes.join(", ")); 
                }
                return isValidFile;
            }
 
//             function validateFileSize(e) {
//                 /*global document: false */
//                 var file = e;
//                 var fileSize = file.files[0].size;
//                 var isValidFile = false;
//                 if (fileSize !== 0 && fileSize <= 25214400) {
//                     isValidFile = true;
//                 }
//                 if (!isValidFile) {
//                     e.value = null;
//                     alert("File Size Should be Greater than 0 and less than 25 mb");
//                 }
//                 return isValidFile;
//             }
        });
    
    </script>
<%@ include file="__footer.jsp"%>