var u = localStorage.getItem('utente');
var selezionec = document.getElementById('squadracasa');
var bottonec = document.getElementById('btncasa');
var selezionet = document.getElementById('squadratrasferta');
var bottonet = document.getElementById('btntrasferta');
var nomeC = document.getElementById('nomeCasa');
var nomeT = document.getElementById('nomeTrasferta');

var idEvento = getUrlParameter("idEvento");

u = JSON.parse(u);


$.ajax({
	url: 'http://localhost:8080/PlayFinderWeb/getEvento?idEvento=' + encodeURI(idEvento),
	method: 'get',
}).done(function(e){
	$('#nomeEvento').append(e.nome);
	if(e.squadraCasa.modulo == null){
		selezionec.style.display = 'inline';
		bottonec.style.display = 'inline';
		nomeC.style.display = 'inline';
		$(function() {
			$.ajax({
					url: 'http://localhost:8080/PlayFinderWeb/moduli?idEvento=' + encodeURI(e.idEvento),
					method: 'get',
				}).done(function(moduli) {
					var selectbox = '<select id="moduli" name="nomeModulo" placeholder="Seleziona modulo"class = "form-control" type="text"></select>';
					$('#squadracasa').append(selectbox);
					$('#moduli').empty();
					var select = '<option> Seleziona Modulo </option>' ;
					$('#moduli').append(select);
					$.each(moduli, function(i, modulo) {
						var option = '<option value ="' + modulo + '">' + modulo + '</option>';
						$('#moduli').append(option);
					});
				});
			   $('#btncasa').append('<button class="btn btn-primary imposta ">CREA LA SQUADRA!</button>');
			   $('.imposta').click(function(j) {
				    j.preventDefault();
					var modulo = {}
					modulo.nomeModulo = $(moduli).val(),
					modulo.idEvento = e.idEvento,
					modulo.nomeSquadra = $(nomeCasa).val();
					console.log(modulo.nomeSquadra)
					if(modulo.nomeModulo == "Seleziona Modulo"){
						alert("Devi inserire un modulo!");
					}else if(modulo.nomeSquadra == ""){
						alert("Devi dare il nome alla tua squadra!");
					}else{
					 $.ajax({
						url: 'moduloCasa',
						method: 'post',
						data: modulo
					}).done(function() {
						window.location.href = 'evento.html?idEvento='+modulo.idEvento;
					});
			         }
				});
		});
	}
	if(e.squadraTrasferta.modulo == null){
		selezionet.style.display = 'inline';
		bottonet.style.display = 'inline';
		nomeT.style.display = 'inline';
		$(function() {
			$.ajax({
					url: 'http://localhost:8080/PlayFinderWeb/moduli?idEvento=' + encodeURI(e.idEvento),
					method: 'get',
				}).done(function(moduli) {
					var selectbox = '<select id="modulot" name="nomeModulo" placeholder="Seleziona modulo"class = "form-control" type="text"></select>';
					$('#squadratrasferta').append(selectbox);
					$('#modulot').empty();
					var select = '<option> Seleziona Modulo </option>' ;
					$('#modulot').append(select);
					$.each(moduli, function(i, modulo) {
						var option = '<option value ="' + modulo + '">' + modulo + '</option>';
						$('#modulot').append(option);
					});
				});
				});
		 $('#btntrasferta').append('<button class="btn btn-primary impostas">CREA LA SQUADRA!</button>');


			$('.impostas').click(function(j) {
		        j.preventDefault();	
				var modulo = {}
				modulo.nomeModulo = $(modulot).val(),
				modulo.idEvento = e.idEvento,
				modulo.nomeSquadra = $(nomeTrasferta).val();
				if(modulo.nomeModulo == "Seleziona Modulo"){
					alert("Devi inserire un modulo!");
				}else if(modulo.nomeSquadra == ""){
					alert("Devi dare il nome alla tua squadra!");
				}else{
				$.ajax({
					url: 'moduloTrasferta',
					method: 'post',
					data: modulo
				}).done(function(){
					window.location.href = 'evento.html?idEvento='+modulo.idEvento;
				});
				}
			});
	}
	if(e.squadraCasa.modulo != null){
		var id = 0;
		$('#nCasa').append(e.squadraCasa.nome);
		selezionec.style.display = 'none';
		bottonec.style.display = 'none';
		nomeC.style.display = 'none';
		var gr = e.squadraCasa.modulo.giocatoriruolo;
		for(var i = 0, len = gr.length; i < len; i++){
			var gg = gr[i];
			var ruoliPartita = e.squadraCasa.ruoli.filter(r => r && r.ruolo.nome == gg.ruolo.nome);
			console.log(ruoliPartita);
			for(var x = 0, l = gg.nGiocatori; x < l; x++) {
				var nomeRuolo = '<div style="margin-top: 10px;" align="center" class="col-lg-5" name="rp" id="'+gg.ruolo.nome +'">'+gg.ruolo.nome+'</div>'+
				                '<div style=" margin-bottom: 10px;"username = "'+(ruoliPartita[0].users.length > x ? ruoliPartita[0].users[x].username : '?')+
				                     '"idEvento="'+e.idEvento+'" idCasa ="'+ e.squadraCasa.idSquadra +'"idruolo="' + ruoliPartita[0].idRuoloPartita + '"'+
				                     'id="'+ id +'" class="col-lg-6 btn btn-primary btnSquadra">' +(ruoliPartita[0].users.length > x ? ruoliPartita[0].users[x].username : '?')+ 
				                '</div>' ;
				$('#sc').append(nomeRuolo);
				id++;
			}

		}

		$('.btnSquadra').click(function(d){
			var id = $(this).attr("id")
			var event = {}
			event.rp = ($(this).attr("idruolo"));
			event.hdIdEvento = $(this).attr("idEvento")
			event.idCasa= $(this).attr("idCasa")
			ruolo = $(this).attr("username")
			event.username = u.username
			if(ruolo == "?"){
			$.ajax({
				url: 'gioca',
				method: 'post',
				data : event,
			}).done(function(){
				location.reload();
			})
			}else{
				window.location = 'profilo.html?username='+ruolo;
			}
			});

	}
	if(e.squadraTrasferta.modulo != null){
		$('#nTrasferta').append(e.squadraTrasferta.nome);
		selezionet.style.display = 'none';
		bottonet.style.display = 'none';
		nomeT.style.display = 'none';
		var gr = e.squadraTrasferta.modulo.giocatoriruolo;
		for(var i = 0, len = gr.length; i < len; i++){
			var gg = gr[i];
			var ruoliPartita = e.squadraTrasferta.ruoli.filter(r => r && r.ruolo.nome == gg.ruolo.nome);
			for(var x = 0, l = gg.nGiocatori; x < l; x++) {
				var nomeRuolo = '<div style="margin-top: 10px;" align="center" class="col-lg-5" name="rp" id="'+gg.ruolo.nome+'">'+
				gg.ruolo.nome+'</div><div style=" margin-bottom: 10px;" username = "'+(ruoliPartita[0].users.length > x ? ruoliPartita[0].users[x].username : '?')+'"idEvento="'+e.idEvento
				+'" idCasa ="'+ e.squadraTrasferta.idSquadra +'"idruolo="' + ruoliPartita[0].idRuoloPartita + '"id="ruolo" class="col-lg-6 btn btn-primary btnS">' + 
				(ruoliPartita[0].users.length > x ? ruoliPartita[0].users[x].username : '?') + '</div>' ;
				$('#st').append(nomeRuolo);
			}

		}

		$('.btnS').click(function(d){
			var event = {}
			event.rp = ($(this).attr("idruolo"));
			event.hdIdEvento = $(this).attr("idEvento")
			event.idCasa= $(this).attr("idCasa")
			event.username= u.username
			ruolo = $(this).attr("username")
			if(ruolo == "?"){
				$.ajax({
					url: 'gioca',
					method: 'post',
					data : event,
				}).done(function(){
					location.reload();
				})
				}else{
					window.location = 'profilo.html?username='+ruolo;
				}
		});}
});





 






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

