/* ---------------------
	CUSTOM JS DOCUMENT 
--------------------- */
var appMaster = {
	/* ---------------------
		Page Loader 
	--------------------- */
	pageLoader: function(){
		$(".loader-item").delay(700).fadeOut();
		$("#pageloader").delay(800).fadeOut("slow");
	},
	/* ---------------------
		Navigation Menu 
	--------------------- */
	navBar: function(){	
		/* ---------------------
			Sticky 
		--------------------- */
		 if ($('#sticker').length) {
			$("#sticker").sticky({topSpacing:0, zIndex:3});
		 }
		/* --------------------------
		Home Background Super Slider 
		-------------------------- */
			 if ($('#slides').length) {
			$('#slides').superslides({
			});
		 }		 
		
	},
	
	/* --------------------------
	HeaderSearch, Phone & Social Icons Toggle
	-------------------------- */
	toggleNav: function(){
		
		/* header Contact (Phone) */
	   $( ".header-contact" ).click(function() {
		$( ".header-contact-content" ).show( "fast", function() {});
		$('.transparent-header .navbar').fadeIn().addClass('top-search-open');
		$(".close").click(function() {
		  $(".header-contact-content").hide("fast", function() {});
		  $('.transparent-header .navbar').fadeIn().removeClass('top-search-open');
		})
	   });
	   
	   
	   /* header Search (Search Form) */
	   $( ".header-search" ).click(function() {
		$( ".header-search-content" ).show( "fast", function() {});
		$('.transparent-header .navbar').fadeIn().addClass('top-search-open');
		
		$(".close").click(function() {
		  $(".header-search-content").hide("fast", function() {});
		  $('.transparent-header .navbar').fadeIn().removeClass('top-search-open');
		})
	   });
	   
	   
		/* header Share (Search Form) */
	   $( ".header-share" ).click(function() {
		$( ".header-share-content" ).show( "fast", function() {});
		$('.transparent-header .navbar').fadeIn().addClass('top-search-open');
		
		$(".close").click(function() {
		  $(".header-share-content").hide("fast", function() {});
		  $('.transparent-header .navbar').fadeIn().removeClass('top-search-open');
		})
	   });
	},
	/* ---------------------	
		Owl Slider
	/* --------------------- */
	owlCarousel: function(){	
		(function($) {
			"use strict";
			if ($('.owl-carousel').length) {		    
				  $(".owl-carousel").each(function (index) {
					var effect_mode = $(this).data('effect');
					var autoplay = $(this).data('autoplay');
					var navigation = $(this).data('navigation');
					var pagination = $(this).data('pagination');
					var singleitem = $(this).data('singleitem');
					var items = $(this).data('items');
					var itemsdesktop = $(this).data('desktop');
					var itemsdesktopsmall = $(this).data('desktopsmall');
					var itemstablet = $(this).data('tablet');
					var itemsmobile = $(this).data('mobile');
					if( itemsdesktop > 0 )
					{
						itemsdesktop = [1199, itemsdesktop];
					}
					if( itemsdesktopsmall > 0 )
					{
						itemsdesktopsmall = [979, itemsdesktopsmall];
					}
					if( itemstablet > 0 )
					{
						itemstablet = [479, itemstablet];
					}
					if( itemsmobile > 0 )
					{
						itemsmobile = [479, itemsmobile];
					}
					$(this).owlCarousel({ 
						transitionStyle: effect_mode,
						autoPlay : autoplay,
						navigation : navigation,
						pagination : pagination, 
						singleItem : singleitem,
						items : items,
						itemsDesktop : itemsdesktop,
						itemsDesktopSmall : itemsdesktopsmall,
						itemsTablet : itemstablet,
						itemsMobile : itemsmobile,
						navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]						
					});
				});
			}  
		 })(jQuery);
	},
	/* ---------------------	
		Animation
	/* --------------------- */	
	dataAnimations: function() {
	  $('[data-animation]').each(function() {
			var element = $(this);
			element.addClass('animated');
			element.appear(function() {
				
				var delay = ( element.data('delay') ? element.data('delay') : 1 );
				if( delay > 1 ) element.css('animation-delay', delay + 'ms');				
				element.addClass( element.data('animation') );
				setTimeout(function() {
					element.addClass('visible');
				}, delay);
				
			});
	  });
	},
	/* ---------------------	
		Owl Slider
	/* --------------------- */
	progressBar: function(){
		if ($('.progress-bar').length) {
		 $('.progress-bar').each(function() {
			// $(this).appear(function(){
			 var datavl = $(this).attr('data-percentage');
			 $(this).animate({ "width" : datavl + "%"}, 'slow');
			});
		  // });
		}
	},
	/* ---------------------	
		Background Image Attribute
	/* --------------------- */
	bgImage: function(){		
		var pageSection = $(".image-bg, .parallax-bg");
		pageSection.each(function(indx){
			if ($(this).attr("data-background")){
				$(this).css("background-image", "url(" + $(this).data("background") + ")");
			}
		});
	},
	/* ---------------------	
		Fun Factor / Counter
	/* --------------------- */
	funFactor: function(){	
		(function($){			
			$(".count-number").appear(function(){
				$(this).each(function(){
					datacount = $(this).attr('data-count');
					$(this).find('.counter').delay(6000).countTo({
						from: 10,
						to: datacount,
						speed: 3000,
						refreshInterval: 50,
					});
				});
			});
		})(jQuery);
	},
	/* ---------------------	
		Parallax BG
	/* --------------------- */
	parallaxBg: function(){	
		if($('.image-bg').length != 0 && !navigator.userAgent.match(/iPad|iPhone|Android/i)){	
			$.stellar({
			horizontalScrolling: false,
			verticalOffset: 0,
			horizontalOffset: 0,
			responsive: true,
			scrollProperty: 'scroll',
			parallaxElements: false,
		  });
		}
    },
	/* ---------------------	
		Portfolio
	/* --------------------- */
	portfolioFilter: function(){	
	if($('#mix-container').length != 0){
		$('#mix-container').mixItUp();
	}
	},
	/* ---------------------	
		Image Popup
	/* --------------------- */
	prettyPhoto: function(){
		(function($) {
			"use strict";
			if( $("a[rel^='prettyPhoto'], a[data-rel^='prettyPhoto']").length != 0 ) { 
			 $("a[rel^='prettyPhoto'], a[data-rel^='prettyPhoto']").prettyPhoto({hook: 'data-rel', theme: "dark_square", social_tools: false, deeplinking: false});
			}
		 })(jQuery);
	},
	/* ---------------------	
		Background Video 
	/* --------------------- */
	backgroundVideo: function(){
        if (typeof $.fn.mb_YTPlayer != 'undefined' && $.isFunction($.fn
            .mb_YTPlayer)) {
            var m = false;
            if (/Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(
                navigator.userAgent)) {
                m = true
            }
            var v = $('.player');
            if (m == false) {
                v.mb_YTPlayer();
                $('#video-controls a')
                    .each(function() {
                        var t = $(this);
                        t.on('click', (function(e) {
                            e.preventDefault();
                            if (t.hasClass(
                                'fa-volume-off')) {
                                t.removeClass(
                                        'fa-volume-off'
                                    )
                                    .addClass(
                                        'fa-volume-down'
                                    );
                                v.unmuteYTPVolume();
                                return false
                            }
                            if (t.hasClass(
                                'fa-volume-down')) {
                                t.removeClass(
                                        'fa-volume-down'
                                    )
                                    .addClass(
                                        'fa-volume-off'
                                    );
                                v.muteYTPVolume();
                                return false
                            }
                            if (t.hasClass('fa-pause')) {
                                t.removeClass(
                                        'fa-pause')
                                    .addClass('fa-play');
                                v.pauseYTP();
                                return false
                            }
                            if (t.hasClass('fa-play')) {
                                t.removeClass('fa-play')
                                    .addClass(
                                        'fa-pause');
                                v.playYTP();
                                return false
                            }
                        }));
                    });
                $('#video-controls')
                    .show();
            }
        }
    },

	/* ---------------------	
		Subscribe Form  
	/* --------------------- */
	subscribeForm: function(){	 
		if ( $( "#form-newsletter" ).length !== 0 ) {
		$('#form-newsletter').bootstrapValidator({
				container: 'tooltip',
				feedbackIcons: {
					valid: 'fa fa-check',
					warning: 'fa fa-user',
					invalid: 'fa fa-times',
					validating: 'fa fa-refresh'
				},
				fields: { 
					subscribe_email: {
						validators: {
							notEmpty: {
								message: $('#form-newsletter').attr('MReq')
							},
							emailAddress: {
								message: $('#form-newsletter').attr('MCor')
							}
						}
					},	
				}
			})	
			.on('success.form.bv', function(e) {
				e.preventDefault();
				var $form        = $(e.target),
				validator    = $form.data('bootstrapValidator'),
				submitButton = validator.getSubmitButton();
				var form_data = $('#form-newsletter').serialize();
				$.ajax({
						type: "POST",
						dataType: 'json',
						url: $form.attr('action'),
						data: form_data,
						success: function(msg){						
							$('.form-message1').html(msg.data);
							$('.form-message1').show().delay(5000).fadeOut( "slow" );
							submitButton.removeAttr("disabled");
							resetForm($('#form-newsletter'));
						},
						error: function(msg){}
				 });
				return false;
			});
		}
		function resetForm($form) {

            $form.find(
                    'input:text, input:password, input, input:file, select, textarea'
                )
                .val('');

            $form.find('input:radio, input:checkbox')
                .removeAttr('checked')
                .removeAttr('selected');
			$form.find('button[type=submit]')
                .attr("disabled", "disabled");

        }
	},
	/* --------------------------------------------
	 Scroll Navigation
	-------------------------------------------- */	
	navMenu: function(){	 
	// 	jQuery('.scroll').bind('click', function(event) {
	// 	var $anchor = jQuery(this);
	// 	var headerH = jQuery('#navigation').outerHeight();
	// 		jQuery('html, body').stop().animate({
	// 			scrollTop : jQuery($anchor.attr('href')).offset().top  - 60 + "px"
	// 		}, 1200, 'easeInOutExpo');
	// 	event.preventDefault();
	// });
	// 	/* Active When Scroll */
	// 	jQuery('body').scrollspy({
	// 		target: '#topnav',
	// 		offset: 95
	// 	})
	// 	/* Responsive Auto Close */
	// 	$('.one-page .nav li a').click(function () {
	// 		 $('.navbar-collapse').removeClass('in');
	// 	});
	// 	/* Smooth Scroll Links */
	// 	jQuery('.page-scroll a')
     //        .bind('click', function(event) {
     //            var $anchor = jQuery(this);
     //            jQuery('html, body')
     //                .stop()
     //                .animate({
     //                    scrollTop: jQuery($anchor.attr('href'))
     //                        .offset()
     //                        .top
     //                }, 1500, 'easeInOutExpo');
     //            event.preventDefault();
     //        });
	},
	/* --------------------------------------------
	 Scroll Navigation
	-------------------------------------------- */	
	/* Text Tying Slider */
	typedSlider: function() {
		jQuery(".element").each(function(){
			var $this = jQuery(this);
			$this.typed({
			strings: $this.attr('data-elements').split(','),
			typeSpeed: 100, 
			backDelay: 3000 
			});
		});
	},
	/* --------------------------------------------
	 Video Slider 
	-------------------------------------------- */	
	videotextSlider: function() {
		$(function() {
			"use strict";
			if ( jQuery( ".video-slider-text" ).length !== 0 ) {
				jQuery('.video-slider-text').easyTicker({
					direction: 'up',
					speed: 'slow',
					interval: 4000,
					height: 'auto',
					visible: 1,
					mousePause: 0,
				});
			}
		});
	},
	/* --------------------------------------------
	 Day Counter
	-------------------------------------------- */	
	countDown: function() {
	  $('.daycounter').each(function(){
	   var counter_id = $(this).attr('id');
	   var counter_type = $(this).data('counter');
	   var year = $(this).data('year');
	   var month = $(this).data('month');
	   var date = $(this).data('date');
	   var countDay = new Date();
	   countDay = new Date(year, month - 1, date);
	   if( counter_type == "down" ) {
		$("#"+counter_id).countdown({
		 labels: ['Years', 'Months', 'Weeks', 'Days', 'Hours', 'Mins', 'Secs'],
		 labels1: ['Year', 'Month', 'Week', 'Day', 'Hour', 'Min', 'Sec'],
		 until: countDay
		});
	   } else if( counter_type == "up" ) {
		$("#"+counter_id).countdown({
		 labels: ['Years', 'Months', 'Weeks', 'Days', 'Hours', 'Mins', 'Secs'],
		 labels1: ['Year', 'Month', 'Week', 'Day', 'Hour', 'Min', 'Sec'],
		 since: countDay
		});
	   }
	  });
	 },
	 

	/*==========Navigation Menu============*/
	sideNav: function() {	
		$("#navigation-menu").click(function(e) {
			e.preventDefault();		
			$("#wrapper .toggle-menu").animate({ right: '0px' }, "slow");		
			return false;
		});					   
		$("#navigation-close").click(function(e) {
			e.preventDefault();		
			$("#wrapper .toggle-menu").animate({ right: '-50%' }, "slow");		
			return false;
		});	
		
		/* ----------- Menus hide after click -- mobile devices ----------- */	
	
		$('#wrapper .nav li a').click(function () {
			$("#wrapper .toggle-menu").animate({ right: '-50%' }, "slow");		
			return false;
		});
		
		$('.scroll-2').bind('click', function(event) {
			var $anchor = $(this);
			var headerH = $('#navigation-menu').outerHeight();
				$('html, body').stop().animate({					
					scrollTop : $($anchor.attr('href')).offset().top  + 1 + "px"
				}, 1200, 'easeInOutExpo');		
			event.preventDefault();
		});
	},	
	
	/*  Background image height equal to the browser height. */
	fullScreen: function() {
		$('.full-screen').css({ 'height': $(window).height() });
			 $(window).on('resize', function() {
				$('.full-screen').css({ 'height': $(window).height() });
		   });
	},
		
	fancySelect: function() {
		"use strict";
		if ( $( ".fancy-select" ).length !== 0 ) {
			$('.fancy-select').fancySelect();
		}
	},	
	
	
	hiddenFooter: function() {
		var footer_height = $(".hidden-footer").height();
		$('#page').css({ 'margin-bottom': footer_height + "px" });
		$('.hidden-footer').css({ 'height': footer_height + "px" });
		$('.hidden-footer').css({ 'max-height': footer_height + "px" });
		$(window).on('resize', function() {
			$('#page').css({ 'margin-bottom': footer_height + "px" });
			$('.hidden-footer').css({ 'height': footer_height + "px" });
			$('.hidden-footer').css({ 'max-height': footer_height + "px" });
		});
	},

	select2Menu: function () {
        function formatState (state) {
            if (!state.id) {
                return state.text;
            }
            var $state = $(
                '<span><i class="fa ' + $(state.element).data('icon') + '"></i> ' + state.text + '</span>'
            );
            return $state;
        };
        $('.select2menu').select2({
            minimumResultsForSearch:-1,
            templateResult: formatState,
            width: 'resolve'
        });

        $('.select2menu').on('select2:select', function (e) {
            var data = e.params.data;
            window.location.href = data.id;
        });

    },

	/* --------------------------------------------
	Local Hosted Video Player
	-------------------------------------------- */
	hostedVideo: function(){
		if ( $( ".video-section" ).length !== 0 ) {
			var player = videojs('really-cool-video', { /* Options */ }, function() {
			  console.log('Good to go!');

			  this.play(); 
			 
			  this.on('ended', function() {
				console.log('awww...over so soon?');
			  });
			});
		}
	},	
	
	/* --------------------------------------------
	Local Hosted Video Player
	-------------------------------------------- */	
	gridRotator: function(){
		if ( $( "#ri-grid" ).length !== 0 ) {
			$( '#ri-grid' ).gridrotator( {
				   rows : 3,
				   columns : 8,
				   interval : 2000,
				   animType : 'random',
				   animSpeed : 1000,
				   step  : 2,
				   w1024 : { rows : 4, columns : 6 },
				   w768 : {rows : 4,columns : 5 },
				   w480 : {rows : 4,columns : 3 },
				   w320 : {rows : 4,columns : 2 },
				   w240 : {rows : 4,columns : 2 },
			});
		}
	},
	
	/* --------------------------------------------
	Local Hosted Video Player
	-------------------------------------------- */
	datePicker: function(){
		if ( $( ".date-picker" ).length !== 0 ) {
			$('.date-picker').datetimepicker({
				format:"DD-MM-YYYY",
				showClear: true,
				showClose: true,
                minDate: moment(),
                keepInvalid: true,
                locale: 'fr',
                widgetPositioning : {
                    horizontal: 'auto',
                    vertical: 'top'
				}
			});
		}
	},

	/* --------------------------------------------
	 Sticky Sidebar
	-------------------------------------------- */	
	
	sidebarSticky: function(){
		if( $("#sidebar").length != 0 ) { 
			$('#sidebar').stickit();
		}
	},

	/* --------------------------------------------
	 Disable google chrom webkit for field type date
	 -------------------------------------------- */
	disableChromWebkit: function() {
		if (document.getElementById("dateInput")) {
			dateInput.addEventListener('keydown', function(event) {
				if (event.keyIdentifier == "Down" || event.keyIdentifier == "Up") {
					event.preventDefault()
				}
			}, false);
		}
	},

	/* --------------------------------------------
	 Social icons share
	 -------------------------------------------- */
	rrssb: function() {
        var popupCenter = function(url, title, w, h) {
            // Fixes dual-screen position                         Most browsers      Firefox
            var dualScreenLeft = window.screenLeft !== undefined ? window.screenLeft : screen.left;
            var dualScreenTop = window.screenTop !== undefined ? window.screenTop : screen.top;

            var width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
            var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

            var left = ((width / 2) - (w / 2)) + dualScreenLeft;
            var top = ((height / 3) - (h / 3)) + dualScreenTop;

            var newWindow = window.open(url, title, 'scrollbars=yes, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);

            // Puts focus on the newWindow
            if (newWindow && newWindow.focus) {
                newWindow.focus();
            }
        };

        try {
            $(document).on('click', '*[class^="rrssb-"] a.popup', {}, function popUp(e) {
                var self = $(this);
                popupCenter(self.attr('href'), self.find('.rrssb-text').html(), 580, 470);
                e.preventDefault();
            });
        }
        catch (e) { // catching this adds partial support for jQuery 1.3
        }

	},

	enableTooltip: function () {
		$(function () {
			$('[data-toggle="tooltip"]').tooltip()
		})
	},

    fundSetting: function () {
		// Editor in Media
		if ($('#editor').length) {
            var toolbarOptions = [
                ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
                ['blockquote', 'code-block'],

                [{ 'header': 1 }, { 'header': 2 }],               // custom button values
                [{ 'list': 'ordered'}, { 'list': 'bullet' }],
                [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
                [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
                [{ 'direction': 'rtl' }],                         // text direction

                [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
                [{ 'header': [1, 2, 3, 4, 5, 6, false] }],

                [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
                [{ 'font': [] }],
                [{ 'align': [] }],

                ['clean'],                                         // remove formatting button
                ['image'],                                         // remove formatting button
                ['video'],                                         // show html code
                ['preview'],
                ['showHtml']
            ];

            // Remove image, video & html from thanks message
            if ($("#form-amount").length) {
            	toolbarOptions.splice(13, 2);
                toolbarOptions.splice(14, 1);
            }

            // Remove preview
            if ($("#form-media").length > 0 || $("#form-association").length > 0) {
                toolbarOptions.splice(15, 1);
			}

            var quill = new Quill('#editor', {
                modules: {
                    toolbar: toolbarOptions,
                    imageUpload: {
                        url: $('#editor').data('upload'), // server url
                        method: "POST", // change query method, default 'POST'
                        headers: {}, // add custom headers, example { token: 'your-token'}
                        // personalize successful callback and call next function to insert new url to the editor
                        callbackOK: (serverResponse, next) => {
                            next(serverResponse);
                        },
                        // personalize failed callback
                        callbackKO: (serverError) => {
                            alert(serverError);
                        }
                    }
                },
                theme: 'snow'
            });

            var txtArea = document.createElement('textarea');
            txtArea.style.cssText = "width: 100%;margin: 0px;background: rgb(29, 29, 29);box-sizing: border-box;color: rgb(204, 204, 204);font-size: 15px;outline: none;padding: 20px;line-height: 24px;font-family: Consolas, Menlo, Monaco, &quot;Courier New&quot;, monospace;position: absolute;top: 0;bottom: 0;border: none;display:none"

            var htmlEditor = quill.addContainer('ql-custom')
            htmlEditor.appendChild(txtArea)

			// Set default content
            txtArea.value = quill.root.innerHTML;

            var myEditor = document.querySelector('#editor')
            quill.on('text-change', (delta, oldDelta, source) => {
                var html = myEditor.children[0].innerHTML
                txtArea.value = html
            })

            // Custom btn Show source
			if ($('.ql-showHtml').length > 0) {
				var showSource = document.querySelector('.ql-showHtml');
				showSource.addEventListener('click', function() {
					if (txtArea.style.display === '') {
						var html = txtArea.value
						quill.pasteHTML(html)
					}
					txtArea.style.display = txtArea.style.display === 'none' ? '' : 'none'
				});
            }

            // Custom btn Preview
            var preview = document.querySelector('.ql-preview');
            preview.addEventListener('click', function() {
				$.fancybox({
					href				: $('#editor').data('preview') + '?body=' + txtArea.value,
					width				: '50%',
					height				: '70%',
					fitToView     		: false,
					autoSize			: false,
					transitionIn		: 'fade',
					transitionOut		: 'fade',
					type				: 'iframe'
				});

                return false;


            });

            $("#form-media").submit(function( event ) {
                $("#fund_media_description").val(quill.root.innerHTML);
            });

            $("#form-association").submit(function( event ) {
                $("#association_description").val(quill.root.innerHTML);
            });

            $("#form-amount").submit(function( event ) {
                $("#fund_amount_remerciement_content").val(quill.root.innerHTML);
            });
		}

		// Share
		if ($("#form_invitation_emails").length) {
			var tokenCounter = {
				getValue: function() {
					return parseInt($("#tokenCounter").text());
				},
				add: function() {
					var newVal = this.getValue() + 1;
                    if (newVal >= 100) {
                        newVal = 100
                    }
                    $("#tokenCounter").text(newVal)
				},
				sub: function() {
					var newVal = this.getValue() - 1;
					if (newVal <= 0) {
						newVal = 0
                    }
                    $("#tokenCounter").text(newVal)
				}
			};

            $('#form_invitation_emails')
                .on('tokenfield:createtoken', function (e) {
                    var data = e.attrs.value.split('|')
                    e.attrs.value = data[1] || data[0]
                    e.attrs.label = data[1] ? data[0] + ' (' + data[1] + ')' : data[0]
                })

                .on('tokenfield:createdtoken', function (e) {
                    // Über-simplistic e-mail validation
                    var re = /\S+@\S+\.\S+/
                    var valid = re.test(e.attrs.value)
                    if (!valid) {
                        $(e.relatedTarget).addClass('invalid')
                    }
                    tokenCounter.sub();
                })

                .on('tokenfield:edittoken', function (e) {
                    if (e.attrs.label !== e.attrs.value) {
                        var label = e.attrs.label.split(' (')
                        e.attrs.value = label[0] + '|' + e.attrs.value
                    }
                })

                .on('tokenfield:removedtoken', function (e) {
                    tokenCounter.add();
                })

                .tokenfield({
                    limit: $('#form_invitation_emails').data('limit'),
                    createTokensOnBlur: true,
                    delimiter: [',', ';', ' ', '\t', '\n']
				})
		}

		// Activity
        var toolbarOptionsLight = [
            ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
            ['blockquote', 'code-block'],

            [{ 'header': 1 }, { 'header': 2 }],               // custom button values
            [{ 'list': 'ordered'}, { 'list': 'bullet' }],


            [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
            [{ 'font': [] }],
            [{ 'align': [] }],

            ['clean'],                                         // remove formatting button
            ['image'],                                         // remove formatting button
        ];

        /* EditAction */
		if ($('[id^=edit_activity]').length ) {

            $('[id^=edit_activity]').click(function() {

				if ($(this).hasClass('disabled')) {
					return false;
				}
                var id = $(this).data('row');

				$(this).addClass('disabled');
                $('#save_activity' + id).removeClass('disabled');
                $('#undo_activity' + id).removeClass('disabled');

            	var quill = new Quill('#editor' + id, {
                    modules: {
                        toolbar: toolbarOptions
                    },
                    theme: 'snow'
                });

			});
		}

		/* SaveAction */
        if ($('[id^=save_activity]').length ) {
            $('[id^=save_activity]').click(function() {
			});
		};

        /* DeleteAction */
        if ($('[id^=delete_activity]').length ) {
            $('[id^=delete_activity]').click(function() {
			});
		};

        // html integration
        $('input[type=radio][name=embedded_mode]').on('ifChecked', function(event){
        	var template = '<iframe src="'+ this.value +'" width="390" height="510" style="border:1px;overflow:hidden" scrolling="no" frameborder="0" allowTransparency="true" allow="encrypted-media"></iframe>';
            $('#fund-url-plugins').val(template);
            $('#fund-url-plugins-preview').attr('src', this.value);
        });

        $('input[type=radio][name=embedded_mode]:checked').trigger('ifChecked');
    },

    eyePassword: function () {
        if ($('#registration_form_plainPassword_first, #registration_association_form_plainPassword_first').length > 0) {
            $('#registration_form_plainPassword_first, #registration_association_form_plainPassword_first').password({
                showPercent: false,
                showText: true,
                animate: true,
                animateSpeed: 'slow',
                username: false,
                usernamePartialMatch: true,
                minimumLength: 8
            });
        }

        $('input:password').each(function(){
            $(this).after($('<i>').attr({'toggle': '#'+$(this).attr('id')}).addClass('fa icon-eye4 eye toggle-password'));
        });

        $(".toggle-password").click(function() {

            $(this).toggleClass("icon-eye4 icon-eye-blocked");
            var input = $($(this).attr("toggle"));
            if (input.attr("type") == "password") {
                input.attr("type", "text");
            } else {
                input.attr("type", "password");
            }
        });


    },

	fundAction: function () {
        $(document).delegate(".myFundAction", "click", function() {
            var hash   = $(this).data('value');
            var action = $(this).data('action');

            $(this).button('loading');

            $("#form_action").val(action);
            $("#form_hash").val(hash);

            $("form[name='form']").submit();
            event.stopPropagation();
            return false;
        });

        $(document).delegate(".redirect-btn", "click", function() {
            var url   = $(this).data('href');
            $(this).button('loading');
            window.location.href = url;
            event.stopPropagation();
            return false;
        });
	},

    loadGivers: function(url) {
		$('.div-giver-show-more').html('<div class="loader-item fa fa-spin text-color" style="position: relative; left:0px"></div>');
		$.ajax({
			type: 'post',
			url: url,
			success: function (content) {
				$('.div-giver-show-more').remove();
				$('.giversList').append(content);
			}
		});
	},

	privacy: function() {
        if ( self !== top ) {
			// you're in an iframe
			return false;
        }
        window.addEventListener("load", function(){
            window.cookieconsent.initialise({
                "palette": {
                    "popup": {
                        "background": "#efefef",
                        "text": "#404040"
                    },
                    "button": {
                        "background": "#ffc400",
                        "text": "#000000"
                    }
                },
                "theme": "classic",
                "compliance": {
                    'info': '<div class="cc-compliance">{{allow}}</div>',
                },
                "content": {
                    "message": "En utilisant Cha9a9a.tn, vous acceptez l'utilisation de cookies afin d'améliorer votre expérience utilisateur et vous offrir des contenus personnalisés.",
                    "allow": "J'accepte",
                    "link": "En savoir plus",
                    "href": "http://www.cha9a9a.tn/cookies"
                }
            })});
	},

    amountTip: function() {
        // $('.btn-tip').on('click', function(event) {
        //     $('.btn-tip').addClass('btn-unselect');
        //     $(this).removeClass('btn-unselect').addClass('btn-default');
        //
        //     if ($('#giver_tip').length > 0) {
        //         $('#giver_tip').val($(this).data('value'));
        //     }
        // });
        //
        // $("input[name='giver[give_tip]").on('ifChanged', function(event){
        //     if (event.target.checked) {
        //         $('.btn-tip').addClass('disbled');
        //     } else {
        //         $('.btn-tip').removeClass('disbled');
        //     }
        // });
    },

	init: function() {
		// check box
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-yellow',
            radioClass: 'iradio_square-yellow',
			increaseArea: '20%' // optional
        });

        var clipboard = new Clipboard('.btnCopy');

        $('.share-link').click(function() {
        	$('.share-link-input').slideDown("slow");
			$('.btnCopy').trigger('click');
        	return false;
		});

        // Hide alerts after 2s
        setTimeout(function() {
            $(".alert").fadeOut("slow");
        }, 5000);

        // Check CGU ACCEPTATION
		if ($('meta[name=CGU]')) {

			if ($('meta[name=CGU]').data("cgu") == false) {
                $('#myCGUConsent').modal({
                    backdrop: 'static',
                    keyboard: false
                });

                $("input[name='cgu_accepted']").on('ifChanged', function(event){
                    $('#btn_cgu_accepted').prop('disabled', !event.target.checked);
                });

                $('#myCGUConsent').on('hide.bs.modal', function(e){

                	$.ajax({
                        type: "GET",
                        dataType: 'json',
                        url: $('meta[name=CGU]').data('action'),
                    });

					// e.preventDefault();
					// e.stopImmediatePropagation();
					// return false;
                });

            }
		}
    }

}; 

$(document).ready(function() {
	appMaster.init();
	appMaster.pageLoader();
	appMaster.navBar();
	appMaster.toggleNav();
	appMaster.owlCarousel();
	appMaster.progressBar();
	appMaster.dataAnimations();
	appMaster.bgImage();
	appMaster.funFactor();
	appMaster.parallaxBg();
	appMaster.portfolioFilter();
	appMaster.prettyPhoto();
	appMaster.backgroundVideo();
	appMaster.subscribeForm();
	appMaster.navMenu();
	appMaster.typedSlider();
	appMaster.videotextSlider();
	appMaster.countDown();
	appMaster.sideNav();
	appMaster.fullScreen();
	appMaster.fancySelect();
	appMaster.hostedVideo();
	appMaster.gridRotator();

	appMaster.sidebarSticky();
	appMaster.enableTooltip();
	appMaster.rrssb();
	appMaster.disableChromWebkit();
	appMaster.fundSetting();
	appMaster.eyePassword();
	appMaster.fundAction();
	appMaster.select2Menu();
	appMaster.privacy();
    appMaster.amountTip();

    $("#giver_amount, #giver_amount_tip").inputmask({
        alias: 'numeric',
        rightAlign: false,
        allowMinus: false,
        digits: 3,
        max: 9999.999
    });

	$('.btn-loading-state').on('click', function (event) {
        var form = $(this).closest('form').get(0);
		var f, field, formvalid = true;

        // loop all fields
        for (f = 0; f < form.elements.length; f++) {

            // get field
            field = form.elements[f];

            // ignore buttons, fieldsets, etc.
            if (field.nodeName !== "INPUT" && field.nodeName !== "TEXTAREA" && field.nodeName !== "SELECT") continue;

            // is native browser validation available?
            if (typeof field.willValidate !== "undefined") {
                // native validation available
                // if (field.nodeName === "INPUT" && field.type !== field.getAttribute("type")) {
                //
                //     // input type not supported! Use legacy JavaScript validation
                //     field.setCustomValidity(LegacyValidation(field) ? "" : "error");
                //
                // }

                // native browser check
                field.checkValidity();
            }
            else {
                // native validation not available
                // field.validity = field.validity || {};
                //
                // // set to result of validation function
                // field.validity.valid = LegacyValidation(field);

                // if "invalid" events are required, trigger it here
            }

            if (field.validity.valid) {
                // remove error styles and messages
            }
            else {
                // style field, show error, etc.
                // form is invalid
                formvalid = false;
            }
        }

        // cancel form submit if validation fails
        if (!formvalid) {
           //if (event.preventDefault) event.preventDefault();
        } else {
            $(this).button('loading');
		}
    });

	/**/
	// $('.my-selector').collection({
	// 	'add': '<a href="#" class="btn btn-default">Add</a>',
	// 	// remove: '<a href="#" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a>',
	// 	'add_at_the_end': true
    //
	// });

    /* Preview Fund */
    $(".btn-preview").fancybox({
        width				: '60%',
        height				: '80%',
        fitToView     		: false,
        autoSize			: false,
        transitionIn		: 'fade',
        transitionOut		: 'fade',
        type				: 'iframe'
    });

    /* CGU */
	$("#cgu-content").fancybox({
		width				: '60%',
		height				: '50%',
		fitToView     		: false,
		autoSize			: false,
		transitionIn		: 'fade',
		transitionOut		: 'fade',
		type				: 'iframe'
	});

	$('#fund_transfer_amount').bind('change paste keyup', function (event) {
        var valid = ($(this).val().match(/^-?\d*(\.\d+)?$/));
        var final_amount = '-';
		if (valid) {
            var amount = parseFloat($(this).val());
			if (amount > 0) {
                final_amount = ((100-6) * amount / 100) - 0.25;
            }
		}

		$("#fund_transfer_amount_reciever").html(final_amount);
    });

    if ($('.select_pay_mode').length > 0) {

		$('.select_pay_mode').click(function() {
            $(this).find("input").iCheck('check');
		});

        $("input[name='giver[pay_mode]']").on('ifChecked', function(event){
            $('.select_pay_mode').removeClass('pay_active').addClass('pay_mode');
            $(this).parent().parent().addClass('pay_active').removeClass('pay_mode');
        });
	}

	/*$('.btn-loading-state').bind('click', function () {
		$(this).button('loading');
    });*/

    $(".social-sharing-wdg").each(function() {
        var rs = ["facebook", "twitter", "linkedin"];
		// device detection
        if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent)
            || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) {
            rs.push("whatsapp");
		}

        $(this).jsSocials({
            url: $(this).data('url'),
            text: $(this).data('text'),
            showLabel: false,
            showCount: "inside",
            shareIn: "popup",
            shares: rs
        });
    });

});

/* --------------------------------------------
	Placeholder for Image
	-------------------------------------------- */	
// $(window).load(function(){
//
// 	$('img:not(".site_logo")').each(function() {
// 		if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)){
// 			var ieversion=new Number(RegExp.$1)
// 			if (ieversion>=9)
// 			if (typeof this.naturalWidth === "undefined" || this.naturalWidth === 0) {
// 			  this.src = "http://placehold.it/" + ($(this).attr('width') || this.width || $(this).naturalWidth()) + "x" + (this.naturalHeight || $(this).attr('height') || $(this).height());
// 			}
// 		} else {
// 			if (!this.complete || typeof this.naturalWidth === "undefined" || this.naturalWidth === 0) {
// 				this.src = "http://placehold.it/" + ($(this).attr('width') || this.width) + "x" + ($(this).attr('height') || $(this).height());
// 			}
// 		}
// 	});
//
// 	$('.image-bg').each(function() {
// 		var imageSrc = $(this).data('background');
// 		if( imageSrc !== undefined ) {
// 			var newSrc = imageSrc.replace(/url\((['"])?(.*?)\1\)/gi, '$2').split(',')[0];
// 		}
//
// 		/*  I just broke it up on newlines for readability        */
// 		var image = new Image();
// 		image.src = newSrc;
//
// 		var width = image.width,
// 			height = image.height;
//
// 		if( width === 0 || height === 0 ) {
// 			$(this).attr('data-background', "http://placehold.it/" + ('1900') + "x" + ('700') + "/2e2e2e/666.jpg" );
//
// 			$(this).removeAttr('style');
// 			$(this).css("background-image", "url(" + "http://placehold.it/1900x700/2e2e2e/666.jpg" + ")");
// 		}
// 	});
// });

/* --------------------------------------------
Google Map
-------------------------------------------- */	
window.onload = MapLoadScript;
function GmapInit() {
	  Gmap = $('.map-canvas');
	  Gmap.each(function() {
		var $this           = $(this),
			lat             = -35.2835,
			lng             = 149.128,
			zoom            = 12,
			scrollwheel     = false,
			zoomcontrol 	= true,
			draggable       = true,
			mapType         = google.maps.MapTypeId.ROADMAP,
			title           = '',
			contentString   = '',
			dataLat         = $this.data('lat'),
			dataLng         = $this.data('lng'),
			dataZoom        = $this.data('zoom'),
			dataType        = $this.data('type'),
			dataScrollwheel = $this.data('scrollwheel'),
			dataZoomcontrol = $this.data('zoomcontrol'),
			dataHue         = $this.data('hue'),
			dataTitle       = $this.data('title'),
			dataContent     = $this.data('content');
			
		if( dataZoom !== undefined && dataZoom !== false ) {
			zoom = parseFloat(dataZoom);
		}
		if( dataLat !== undefined && dataLat !== false ) {
			lat = parseFloat(dataLat);
		}
		if( dataLng !== undefined && dataLng !== false ) {
			lng = parseFloat(dataLng);
		}
		if( dataScrollwheel !== undefined && dataScrollwheel !== null ) {
			scrollwheel = dataScrollwheel;
		}
		if( dataZoomcontrol !== undefined && dataZoomcontrol !== null ) {
			zoomcontrol = dataZoomcontrol;
		}
		if( dataType !== undefined && dataType !== false ) {
			if( dataType == 'satellite' ) {
				mapType = google.maps.MapTypeId.SATELLITE;
			} else if( dataType == 'hybrid' ) {
				mapType = google.maps.MapTypeId.HYBRID;
			} else if( dataType == 'terrain' ) {
				mapType = google.maps.MapTypeId.TERRAIN;
			}		  	
		}
		if( dataTitle !== undefined && dataTitle !== false ) {
			title = dataTitle;
		}
		if( navigator.userAgent.match(/iPad|iPhone|Android/i) ) {
			draggable = false;
		}
		
		var mapOptions = {
		  zoom        : zoom,
		  scrollwheel : scrollwheel,
		  zoomControl : zoomcontrol,
		  draggable   : draggable,
		  center      : new google.maps.LatLng(lat, lng),
		  mapTypeId   : mapType
		};		
		var map = new google.maps.Map($this[0], mapOptions);
		
		var image = '../assets/img/map-marker.png';
		if( dataContent !== undefined && dataContent !== false ) {
			contentString = '<div class="map-data">' + '<h6>' + title + '</h6>' + '<div class="map-content">' + dataContent + '</div>' + '</div>';
		}
		var infowindow = new google.maps.InfoWindow({
			content: contentString
		});
		
		var marker = new google.maps.Marker({
		  position : new google.maps.LatLng(lat, lng),
		  map      : map,
		  icon     : image,
		  title    : title
		});
		if( dataContent !== undefined && dataContent !== false ) {
			google.maps.event.addListener(marker, 'click', function() {
				infowindow.open(map,marker);
			});
		}
		
		if( dataHue !== undefined && dataHue !== false ) {
		  var styles = [
			{
			  stylers : [
				{ hue : dataHue },
				{ saturation: 80 },
				{ lightness: -10 }
			  ]
			}
		  ];
		  map.setOptions({styles: styles});
		}
	 });
}
	
function MapLoadScript() {
	if ($(".map-section").length) {
		var script = document.createElement('script');
		script.type = 'text/javascript';
		script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCz3DnPa9UjtJOPi4leFZ7k9i-CZy9eicU&sensor=false&' + 'callback=GmapInit';
		document.body.appendChild(script);
    }
}

/*---------------STICKY NAVIGATION------------------*/
var header = jQuery('#slider-section'),
	headerPos = header.offset();
        
  $(window).scroll(function() {
	  if( $(".side-nav").length != 0 ) {
		  if( $(this).scrollTop() > headerPos.top+header.height() ) {
			  $('#sticky').addClass('nav-fixed').fadeIn('medium');
		  } else {
			  $('#sticky').removeClass('nav-fixed').fadeIn('medium');
		  }
      }
});

$(window).load(function() {
    appMaster.datePicker();
	appMaster.hiddenFooter();	
});