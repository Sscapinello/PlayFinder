var user = localStorage.getItem('utente');
u = JSON.parse(user);
	$.ajax({
		url: 'RicercaUtenti',
		method: 'get'
	}).done(function(utenti) {
		$.each(utenti, function(i, utente) {
		if(utente.username != u.username){
		var option = '<li class="form-group">' +
			            '<label class="col-md-1 control-label" >'+
			            '</label>'+
			            '<div class="col-md-10 inputGroupContainer">' +
		                    '<div class="row input-group margine">'+
		                    	   '<span class="input-group-addon">'+
			                          '<img src="'+utente.profilePicturePath+'" id="imgProfilo" class="img-circle imgProfilo" width="100" height="100">'+
			                       '</span>'+
			                       '<a class="col-md-12 evento nEvento linkUtente" href="profilo.html?username='+ utente.username +'">'+
			                           '<p align = "left" class="col-md-6 campo username">' + utente.username + 
			                           '</p>'+
			                       '</a>'+
			                       '<div class="col-md-12 campo bottom"><b>Nome e Cognome:</b><p class="nomeCog"> '+utente.nome+' '+ utente.cognome+'</p></div>'+
			                       '<p class="col-md-12 campo"><b>Et&agrave:</b> '+utente.eta+'</p>'+
			                       '<p class="col-md-12 campo"><b>Citt&agrave;:</b> '+utente.citta+'</p>'+
			                       '<p class="col-md-12 campo"><b>Numero Eventi Giocati:</b> '+utente.userInEvento.length+'</p>'+
			                '</div>'+
		                 '</div>'+
		              '</li>';
        $('#listaUtenti').append(option);
		}
		});
		});

	function myFunction() {
	    var input, filter, ul, li, p, i;
	    input = document.getElementById("myInput");
	    filter = input.value.toUpperCase();
	    ul = document.getElementById("listaUtenti");
	    li = ul.getElementsByTagName("li");
	    for (i = 0; i < li.length; i++) {
	        p = li[i].getElementsByClassName("nomeCog")[0];
	        t = li[i].getElementsByClassName("username")[0];
	        if (p.innerHTML.toUpperCase().indexOf(filter) > -1 || t.innerHTML.toUpperCase().indexOf(filter) > -1 ) {
	            li[i].style.display = "";
	        } else {
	            li[i].style.display = "none";

	        }
	    
	    }
	}