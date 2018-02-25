var utente = localStorage.getItem('utente');
if (utente) {
	utente = JSON.parse(utente);
	$('#username').html(utente.username);
	$('#hdUsername').val(utente.username);


} else {
   var option = '<div class="form-group" id = "usr"><label class="lbl" for="email">Username:</label><input type="text" class="form-control" id="email" placeholder="Enter username" name="username"></div><div class="form-group" id = "pass"><label class="lbl" for="pwd">Password:</label><input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password"></div>'
   $('#frmLogin').append(option);
}

$('#btnLogout').click(function() {
	localStorage.removeItem('utente');
});


