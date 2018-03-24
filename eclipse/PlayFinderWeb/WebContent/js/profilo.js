var user = localStorage.getItem('utente');
u = JSON.parse(user);
$("#usrname").val(u.username);
$("#usrname").append(u.username);
var param = getUrlParameter("username");
var utente = {};
utente.username = param;

var username = {}
username.username = u.username;
if(u.username != param){
    document.getElementById("uploadImmagine").style.display="none";
}
if(u.username == param){
	$.ajax({
		url: 'http://localhost:8080/PlayFinderWeb/richiesteAmicizia?username=' + encodeURI(param),
		method: 'get',
	}).done(function(richieste) {
		$.each(richieste, function(i, richiesta) {
			var option = '<li class="form-group col-md-12">' +
				            '<div class="col-md-12 inputGroupContainer">' +
				                '<div class="row input-group margine">'+
				                	   '<span class="input-group-addon">'+
				                          '<img src="'+richiesta.utente1.profilePicturePath+'" id="imgProfilo" class="img-circle imgProfilo" width="100" height="100">'+
				                       '</span>'+
				                       '<p align = "left" class="campo username">'+
				                          '<a class="evento nEvento linkUtente" href="profilo.html?username='+ richiesta.utente1.username +'">'+ 
				                           richiesta.utente1.username +'</a>' + 
				                       '</p>'+
				                       '<button class="btn btn-sm btn-success accetta" accettata="si" amicizia="'+richiesta.idAmicizia+'">Accetta</button>'+
				                       '<button class="btn btn-sm btn-danger accetta" accettata="no" amicizia="'+richiesta.idAmicizia+'">Rifiuta</button>'+
				                '</div>' +
				             '</div>'+
                          '</li>';
	    $('#richieste').append(option);		 
		});		
	});
	$.ajax({
		url: 'http://localhost:8080/PlayFinderWeb/listaAmici?username=' + encodeURI(param),
		method: 'get',
	}).done(function(richieste) {
		$.each(richieste, function(i, richiesta) {
			var option = '<li class="form-group col-md-12">' +
				            '<div class="col-md-12 inputGroupContainer">' +
				                '<div class="row input-group margine" id="'+richiesta.idAmicizia+'">'+
				                	   '<span class="input-group-addon">'+
				                          '<img src="'+richiesta.utente1.profilePicturePath+'" id="imgProfilo" class="img-circle imgProfilo" width="100" height="100">'+
				                       '</span>'+
				                           '<p align = "left" class="campo username">'+
				                           '<a class="evento nEvento linkUtente" href="profilo.html?username='+ richiesta.utente1.username +'">'+
				                           richiesta.utente1.username +'</a>'+ 
				                           '</p>'+
				                       '<button class="btn btn-sm btn-danger accetta" accettata="no" amicizia="'+richiesta.idAmicizia+'">Rimuovi</button>'+
				                '</div>'+
				            '</div>'+
				          '</li>';
	    $('#listaAmici').append(option);		 
		});		
	});
	$.ajax({
		url: 'http://localhost:8080/PlayFinderWeb/amici?username=' + encodeURI(param),
		method: 'get',
	}).done(function(amici) {
		$.each(amici, function(i, amico) {
			if(amico.accettata){
			var option = '<li class="form-group col-md-12">' +
				            '<div class="col-md-12 inputGroupContainer">' +
				                '<div class="row input-group margine" id="'+amico.idAmicizia+'">'+
				                	   '<span class="input-group-addon">'+
				                          '<img src="'+amico.utente2.profilePicturePath+'" id="imgProfilo" class="img-circle imgProfilo" width="100" height="100">'+
				                       '</span>'+
				                           '<p align = "left" class="campo username">'+
				                           '<a class="evento nEvento linkUtente" href="profilo.html?username='+ amico.utente2.username +'">'+ amico.utente2.username +'</a>'+ 
				                           '</p>'+
				                       '<button class="btn btn-sm btn-danger accetta" accettata="no" amicizia="'+amico.idAmicizia+'">Rimuovi</button>'+
				                '</div>'+
				            '</div>'+
				          '</li>';
	    $('#listaAmici').append(option);
		    }
		});		
	});
	
}else{
	var rich = document.getElementById('rich');
	rich.style.display = 'none';
	$.ajax({
		url: 'http://localhost:8080/PlayFinderWeb/listaAmici?username=' + encodeURI(param),
		method: 'get',
	}).done(function(richieste) {
		$.each(richieste, function(i, richiesta) {
			var option = '<li class="form-group col-md-12">' +
				            '<div class="col-md-12 inputGroupContainer">' +
				                '<div class="row input-group margine" id="'+richiesta.idAmicizia+'">'+
				                	   '<span class="input-group-addon">'+
				                          '<img src="'+richiesta.utente1.profilePicturePath+'" id="imgProfilo" class="img-circle imgProfilo" width="100" height="100">'+
				                       '</span>'+
				                       '<p align = "left" class="campo username">'+
				                           '<a class="evento nEvento linkUtente" href="profilo.html?username='+ richiesta.utente1.username +'">'+
				                           richiesta.utente1.username +'</a>'+ 
				                       '</p>'+
				                '</div>'+
				            '</div>'+
				          '</li>';
	    $('#listaAmici').append(option);		 
		});		
	});
	$.ajax({
		url: 'http://localhost:8080/PlayFinderWeb/amici?username=' + encodeURI(param),
		method: 'get',
	}).done(function(amici) {
		$.each(amici, function(i, amico) {
			if(amico.accettata){
			var option = '<li class="form-group col-md-12">' +
				            '<div class="col-md-12 inputGroupContainer">' +
				                '<div class="row input-group margine" id="'+amico.idAmicizia+'">'+
				                	   '<span class="input-group-addon">'+
				                          '<img src="'+amico.utente2.profilePicturePath+'" id="imgProfilo" class="img-circle imgProfilo" width="100" height="100">'+
				                       '</span>'+
				                       '<p align = "left" class="campo username">'+
				                           '<a class="evento nEvento linkUtente" href="profilo.html?username='+ amico.utente2.username +'">'+ amico.utente2.username +'</a>'+ 
				                       '</p>'+
				                '</div>'+
				            '</div>'+
				          '</li>';
	    $('#listaAmici').append(option);
		    }
		});		
	});
	
}


$(document).on('click','.accetta', function() {
	var amicizia = {}
	amicizia.accettata = $(this).attr('accettata');
	amicizia.amicizia = $(this).attr('amicizia');
$.ajax({
	url: 'accettaAmicizia',
	method: 'post',
	data : amicizia
}).done(function(){
		location.reload();
})
});

$.ajax({
	url: 'http://localhost:8080/PlayFinderWeb/getUser?username=' + encodeURI(param),
	method: 'get',
	data: utente
}).done(function(utente){
var userProfilo = utente;

var nomecognome = userProfilo.nome + ' ' + userProfilo.cognome
$('#nome').append(nomecognome)
	var x  = {}
	x.name = userProfilo.username
	$.ajax({
		url: 'storico',
		method: 'post',
		data : x
	})
	.done(function(storico) {
		var eventi = storico;
		if(userProfilo.profilePicturePath != null){
		repl = (userProfilo.profilePicturePath);
		$("#imgProfilo").attr('src', repl);
	    }
		$.each(eventi, function(i, evento) {
			var option = '<li class="form-group">'+
							'<div class="col-md-12 inputGroupContainer form-evento">' +
									'<input type="hidden" name="idEvento" value="'+evento.idEvento+'"></input>'+
									'<a data-idxevento="'+i+'" class="col-md-12 evento nEvento linkEvento" align="center" href="evento.html?idEvento='+ evento.idEvento +'">'+
									evento.nome + '</a>'+
									'<div align = "right" class="col-md-6 evento">' +
									   '<div class="col-md-10 evento">' + evento.squadraCasa.nome +'</div>'+ 
									   '<div type="text" class="col-md-1" name="rCasa">'+evento.rCasa+'</div>'+
									'</div>'+				                    
								    '<div align = "left" class="col-md-6 evento">' +
				                           '<div type="text" class="col-md-1" name="rTrasferta">'+evento.rTrasferta+'</div>' +
				                           '<div class="col-md-10 evento">'+ evento.squadraTrasferta.nome + '</div>' +
						            '</div>'+
						            '<p class="col-md-12 data" align="right">(' + evento.dataStringa + ')</p>'+
						      '</div>'+
						   '</li>';
		    $('#lista').append(option);
		});
		$('.linkEvento').click(function(e) {localStorage.setItem('evento', JSON.stringify(eventi[$(this).data('idxevento')]));});
		var numeroEventi = eventi.length;
		if(numeroEventi==0){
			var niente = "<h3>Nessuna partita da visualizzare</h3>"
		    $('#lista').append(niente);
		}
		var eventigiocati = 'Numero di eventi giocati : '+ numeroEventi
		$('#partiteGiocate').append(eventigiocati);
	});

$.ajax({
	url: 'http://localhost:8080/PlayFinderWeb/vittorie?username=' + encodeURI(param),
	method: 'get',
})
.done(function(vittorie) {
	var percentuale ='Percentuale vittoria: '+ vittorie + '%'
	$('#profilo').append(percentuale);
})
})

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};



