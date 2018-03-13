var user = localStorage.getItem('utente');
u = JSON.parse(user);

$(function() {
	var x  = {}
	x.name = u.username
	$.ajax({
		url: 'storico',
		method: 'post',
		data : x
	})
	.done(function(storico) {
		eventi = storico;
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
						            '<p class="col-md-12 evento" align="right">(' + evento.dataStringa + ')</p>'+
						      '</div>'+
						   '</li>';
				     $('#lista').append(option);
		});
		$('.linkEvento').click(function(e) {localStorage.setItem('evento', JSON.stringify(eventi[$(this).data('idxevento')]));});
	});
});