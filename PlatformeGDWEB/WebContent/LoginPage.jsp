
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="__header.jsp"%>
<%@ include file="menu.jsp"%>



        <section class="page-section light-bg">
        <div class="image-bg content-in fixed" data-background="/assets/img/sections/slider/Projects.jpg"></div>
        <div class="overlay"></div>

        <div class="container">
            <div class="row">

                                    <div class="col-md-5 col-md-offset-3 col-sm-8 col-sm-offset-2  form-box-cha9a9a">

                        <form  method="POST" action="LoginPage" class="form-group form-horizontal -pad-20" role="form">
                            <h3 class="title">Déjà inscrit ?</h3>
                            Les champs (*) sont obligatoires

                            <hr class="margin-20">
<div class="text-center"><h5>${errur1}</h5></div>
                            <input type="hidden" name="_csrf_token" value="IIiFHgrXbZ7M04pETE7JixbloTm8lLGvXPin38Dh3Oo"/>

                            <div class="form-group">
                                <div class="col-md-10 col-md-offset-1">
                                    <label for="inputEmail3" class="control-label">Adresse e-mail(numéro de télèphone) </label>
                                    </i><span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
                                    <input type="Email" id="username" name="username" value="" required="required" class="form-control bg-white" placeholder="Email"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-10 col-md-offset-1">
                                    <a class="pull-right control-label" href="resetting/request.html">Mot de passe oublié ? </a>
                                    <label for="inputPassword3" class="control-label">Mot de passe </label>
                                    </i><span class="required text-danger form-asterisk" title="Ce champ est requis">*</span>
                                    <input type="password" id="password" name="password" required="required" class="form-control bg-white" placeholder="Password"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-10 col-md-offset-1">
                                    <input type="checkbox" id="remember_me" name="_remember_me" value="on"/> Se souvenir de moi
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-10 col-md-offset-1">
                                    <input type="submit" id="_submit" class="btn btn-block btn-default" name="_submit" value="S&#039;identifier "/>
                                </div>
                            </div>

                            <hr>
                            <div class="col-md-10 col-md-offset-1 pad-0">
                                <div class="row">
                                    <div class="text-center"><h3>Pas encore de compte ?</h3></div>
                                </div>
                                <div class="row">
                                    <div class="text-center"><h6>Je suis :</h6></div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 pad-5"><a href="InscriptionUtilisateur" class="btn btn-block btn-default">Un donnateur</a></div>
                                    <div class="col-xs-6 col-sm-6 col-md-6 pad-5"><a href="InscriptionEtablissement" class="btn btn-block btn-default">Un Etablissement</a></div>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="col-md-4 col-md-4">
                    </div>
                            </div>
        </div>
    </section>

<%@ include file="__footer.jsp"%> 