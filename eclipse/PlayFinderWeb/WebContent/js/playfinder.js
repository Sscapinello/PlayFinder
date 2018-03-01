var utente = localStorage.getItem('utente');
if (utente) {
	utente = JSON.parse(utente);
	var option = '<li><form id="frmLogin" class="form-inline"><a id = "btnLogin" href= "profilo.html"><label class="lbl" for="email" id= "username" name = "username" style="margin-top: 7px; font-size: 16px;"></label></a></form><li><a href = "relog.html" id = "btnLogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>'
	$('#nav').append(option);
	$('#username').html(utente.username);
	$('#hdUsername').val(utente.username);
	$('#btnLogout').click(function() {
		localStorage.removeItem('utente');
	});

} else {
   var option = '<li><form id="frmLogin" class="form-inline"><div class="form-group" id = "usr"><label class="lbl" for="email">Username:</label><input type="text" class="form-control" id="email" placeholder="Enter username" name="username"></div><div class="form-group" id = "pass"><label class="lbl" for="pwd">Password:</label><input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password"></div></li><li><a id = "btnLogin" href = "home.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>'
   $('#nav').append(option);
   $('#btnLogin').click(function(e) {
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
				location.href ='home.html';
			} else {
				$('#pnlErrLogin').show('fast').delay(2000).hide('fast');
			}
		})
		.fail(function() {
			console.error('qualcosa è andato storto.')
		});
		
	});
}