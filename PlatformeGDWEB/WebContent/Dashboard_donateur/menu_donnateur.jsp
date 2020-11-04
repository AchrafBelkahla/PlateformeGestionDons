
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="fixed-header">
	<!-- navbar -->
	<div id="navigation"
		class="navbar navbar-default navbar-bg-light navbar-fixed-top"
		role="navigation">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="navbar-header">
						<!-- Button For Responsive toggle -->
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">&nbsp;</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
                       <ul class="nav navbar-nav">     
                            
                                <li  class="current" >
                        <a class="navbar-brand scroll" href="/PlatformeGDWEB">
                            <img src="images/Logo/Capture.PNG" style="width: 70px ; height: 60px;">
                        </a>
                        </li>
                         <li >
                        <h3 class="tp-caption white text-shadow tp-resizeme sft skewtotop title customin customout rs-parallaxlevel-1 text-color" data-hoffset="0" data-voffset="0" data-x="right" data-y="60" data-customin="x:0;y:0;z:0;rotationX:90;rotationY:0;rotationZ:0;scaleX:1;scaleY:1;skewX:0;skewY:0;opacity:0;transformPerspective:200;transformOrigin:50% 0%;" data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;" data-speed="800" data-start="800" data-startslide="1" data-easing="Power4.easeOut" data-endspeed="500" data-endeasing="Power4.easeIn">
                            SantéDon-TN
                        </h3>
                        </li>
                        </ul>
					</div>
					<!-- Navbar Collapse -->
					<div class="navbar-collapse collapse">
						<!-- nav -->
						<ul class="nav navbar-nav">
							<li>
								<select name="S'inscrire" onchange="location = this.value;">
                                	<option value="">Faire un don spontanné</option>
                                    <option value="don_en_nature_spontanne">Don en nature spontanné</option>
                                    <option value="reglement_spontanne">Réglement spontanné</option>
                                </select>
                            </li>
							<li><a href="besoinsByEtablissement?currentPage=1">Consulter les besoins</a></li>
							<li><a href="profilDonateur">Profil</a></li>
							<li><a href="LogOut">Deconnexion</a></li>
						</ul>
						<!-- Right nav -->
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.col-md-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- navbar -->
</header>