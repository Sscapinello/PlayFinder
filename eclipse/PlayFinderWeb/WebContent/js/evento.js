var e = localStorage.getItem('evento');
var u = localStorage.getItem('utente');
u = JSON.parse(u);
e = JSON.parse(e);
$('#hdIdEvento').html(e.idEvento);
$('#nomeEvento').html(e.nome);
if(e.squadraCasa.modulo == null){
	$(function() {
		$.ajax({
				url: 'moduli',
				method: 'get',
			})

		.done(function(moduli) {
			var selectbox = '<select id="moduli" name="nomeSport" placeholder="Seleziona modulo" class="form-control" type="text">p<button id = "imposta" type="submit" class="btn btn-warning" href = "home.html">';
			$('#squadracasa').append(selectbox);
			$('#moduli').empty();
			var select = '<option> Seleziona Modulo </option>' ;
			$('#moduli').append(select);
			$.each(moduli, function(i, modulo) {
				var option = '<option value ="' + modulo + '">' + modulo + '</option>';
				$('#moduli').append(option);
			});
		});
		});

		$('#imposta').click(function() {
			$.ajax({
				url: 'moduli',
				method: 'post',
				data: $('#squadracasa').serialize()
			})
			.done(function() {
				console.log('done.');
			});
			
		});


} if(e.squadraCasa.modulo != null){
	var gr = e.squadraCasa.modulo.giocatoriruolo;
	var ruolop = e.ruolo;
	for(var i = 0, len = gr.length; i < len; i++){
		var gg = gr[i];
		var ruoliPartita = e.squadraCasa.ruoli.filter(r => r && r.ruolo.nome == gg.ruolo.nome);
		for(var x = 0, l = gg.nGiocatori; x < l; x++) {
			var nomeRuolo = '<p name="rp" id="'+gg.ruolo.nome+'">'+gg.ruolo.nome+'<button id="ruolo" class="btnSquadra">' + 
			(ruoliPartita[0].users.length > x ? ruoliPartita[0].users[x].username : '?') + '</button></p>' ;
			$('#squadracasa').append(nomeRuolo);
		}
	}
}
if(e.squadraTrasferta.modulo != null){
	var gr = e.squadraTrasferta.modulo.giocatoriruolo;
	var ruolop = e.ruolo;
	
	for(var i = 0, len = gr.length; i < len; i++){
		var gg = gr[i];
		console.log(gg);
		var ruoliPartita = e.squadraTrasferta.ruoli.filter(r => r && r.ruolo.nome == gg.ruolo.nome);
		console.log('ruoliPartita', ruoliPartita);		
		for(var x = 0, l = gg.nGiocatori; x < l; x++) {
			var nomeRuolo = '<p name ="rp" id="'+gg.ruolo.nome+'">'+gg.ruolo.nome+'<button id="ruolo" class="btnSquadra">' + 
			(ruoliPartita[0].users.length > x ? ruoliPartita[0].users[x].username : '?') + '</button></p>' ;
			$('#squadratrasferta').append(nomeRuolo);
		}
	}
}