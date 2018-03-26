var user = localStorage.getItem('utente');
u = JSON.parse(user);

	var x  = {}
	x.name = u.username
	$.ajax({
		url: 'risultati',
		method: 'post',
		data: x
	})
	.done(function(rispostaEventi) {
		console.log(rispostaEventi);
		eventi = rispostaEventi;
		$.each(eventi, function(i, evento) {
			var option = '<li class="form-group">'+
							'<label class="col-md-1 control-label" >'+
							'</label>'+
							'<form class="col-md-10 inputGroupContainer form-evento">' +
								'<div class="row margine">' +
									'<input type="hidden" name="idEvento" value="'+evento.idEvento+'"></input>'+
									'<a data-idxevento="'+i+'" class="col-md-12 evento nEvento linkEvento" align="center" href="evento.html?idEvento='+ evento.idEvento +'">' + evento.nome + '</a>'+
									'<p align = "right" class="col-md-5 evento">' + evento.squadraCasa.nome + 
									   '<input type="text" class="risultato" name="rCasa">'+
									'</p>'+				                    
									'<p class="col-md-2 evento" align="center" style="text-align:center;margin-top: 12px;">VS</p>' +
								    '<p align = "left" class="col-md-5 evento">' +
				                           '<input type="text" class="risultato" name="rTrasferta">' + evento.squadraTrasferta.nome +
						            '</p>'+
						            '<button type="button" class="btn btn-primary btnRisultato">Aggiorna Risultato</button>'+
						            '<p class="col-md-12 evento" align="right">(' + evento.dataStringa + ')</p>'+
						          '</div>'+
						      '</form>'+
						   '</li>';
            $('#listaEventi').append(option);
		});
	});
	
$(document).on('click','.btnRisultato', function() {
	console.log($(this.form).serialize()),
	$.ajax({
			url: 'aggiornaRisultato',
			method: 'post',
			data : $(this.form).serialize(),
		}).done(function(){
			location.reload();
		})
});
