 var eventi;
var evento = localStorage.getItem('evento');
if (evento) {
	localStorage.removeItem('evento');
}
$(function() {
	$.ajax({
		url: 'home',
		method: 'get'
	})
	.done(function(rispostaEventi) {
		console.log(rispostaEventi);
		eventi = rispostaEventi;
		$.each(eventi, function(i, evento) {
			var sport = evento.sport.nomeSport;
			var icona;
			if(sport =="Calcio a 11" || sport == "Calcio a 5" || sport == "Calcio a 7"){
				icona = "fas fa-futbol"
			}else if(sport =="Tennis"){
				icona = "fab fa-forumbee"
			}else if(sport =="Basket"){
				icona = "fas fa-basketball-ball"
			}else if(sport == "Palavolo"){
				icona = "fas fa-volleyball-ball"
			}
			var option = '<li class="form-group"><label class="col-md-1 control-label" ></label><div class="col-md-10 inputGroupContainer">' +
			'<div class="row input-group margine"><span class="input-group-addon"><i class="' +icona +'"style="font-size:40px;"></i></span>' + 
			'<a data-idxevento="' + i + '" class="col-md-6 evento nEvento linkEvento" href="evento.html?idEvento='+evento.idEvento+'">' + 
				                evento.nome + '</a><p align = "right" class="col-md-6 evento squad"style="margin-bottom: 40px;">' + evento.squadraCasa.nome + '-' + evento.squadraTrasferta.nome +
				                '</p><p class="col-md-5 evento">' + evento.sport.nomeSport + 
								'&nbsp&nbsp&nbsp&nbspDurata:' + evento.durata + '\'' + 
								'</p><p align = "right" class="col-md-5 evento localita">' + evento.campo.regione + 
								',' + evento.campo.citta + ',' + evento.campo.via + ',' + 
								evento.campo.nCivico +
								'</p><p class="col-md-2 evento">' + evento.dataStringa + '</p></div></div></li>';
            $('#listaEventi').append(option);
		});
		$('.linkEvento').click(function(e) {localStorage.setItem('evento', JSON.stringify(eventi[$(this).data('idxevento')]));});
	});

});

function myFunction() {
    var input, filter, ul, li, p, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("listaEventi");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        p = li[i].getElementsByClassName("localita")[0];
        t = li[i].getElementsByClassName("squad")[0];
        if (p.innerHTML.toUpperCase().indexOf(filter) > -1 || t.innerHTML.toUpperCase().indexOf(filter) > -1 ) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";

        }
    
    }
}


