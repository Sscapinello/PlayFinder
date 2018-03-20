var user = localStorage.getItem('utente');
u = JSON.parse(user);
$("#usrname").val(u.username);
$("#usrname").append(u.username);
var param = getUrlParameter("username");

console.log(u.userInEvento.length);
var utente = {};
utente.username = param;
$.ajax({
	url: 'getUser',
	method: 'post',
	data: utente
})
.done(function(utente){
var userProfilo = utente;



if(u.username != param){
    document.getElementById("uploadImmagine").style.display="none";
}
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
									'<a data-idxevento="'+i+'" class="col-md-12 evento nEvento linkEvento" align="center" href="evento.html?='+ evento.idEvento +'">' + evento.nome + '</a>'+
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
		var eventigiocati = 'Numero di eventi giocati : '+ numeroEventi
		$('#partiteGiocate').append(eventigiocati);
	});

var x  = {}
x.username = u.username
$.ajax({
	url: 'vittorie',
	method: 'post',
	data : x
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
