$(function() {
	$.ajax({
		url: 'home',
		method: 'get'
	})
	.done(function(eventi) {
		console.log(eventi);
		$.each(eventi, function(i, evento) {
			var option = '<div class="form-group"><label class="col-md-1 control-label" ></label><div class="col-md-10 inputGroupContainer"><div class="row input-group margine"><span class="input-group-addon"><i class="fas fa-futbol"></i></span><a id="evento" class="col-md-5 evento nEvento" href="evento.html">' 
				                 + evento.nome + '</a><p align = "right" class="col-md-7 evento">' + evento.squadraCasa.nome + '-' + evento.squadraTrasferta.nome +
				                '</p><p class="col-md-5 evento">' + evento.sport.nomeSport + 
								'&nbsp&nbsp&nbsp&nbspDurata:' + evento.durata + '\'' + 
								'</p><p align = "right" class="col-md-5 evento">' + evento.campo.regione + 
								',' + evento.campo.citta + ',' + evento.campo.via + ',' + 
								evento.campo.nCivico +
								'</p><p class="col-md-2 evento">' + evento.dataStringa + '</p></div></div></div>';
            $('#listaEventi').append(option);
		});
	});
});
