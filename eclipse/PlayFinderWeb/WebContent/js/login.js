$('#btnLogin').click(function(e) {
	// 1. impedire al form HTML di fare submit
	e.preventDefault();
	$.ajax({
		url: 'login',
		method: 'post',
		data: $('#frmLogin').serialize()
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			localStorage.setItem('utente', JSON.stringify(esito.oggettoRisultante));
			location.href ='https://www.google.it/';
		} else {
			$('#pnlErrLogin').show('fast').delay(2000).hide('fast');
		}
	})
	.fail(function() {
		console.error('qualcosa è andato storto.')
	});
	
});