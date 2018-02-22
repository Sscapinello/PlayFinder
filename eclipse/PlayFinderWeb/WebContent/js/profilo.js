$(function() {
	$.ajax({
		url: 'profilo',
		method: 'get'
	})
	.done(function(utente) {
		$('#imgProfilo').attr('src', utente.profilePicturePath);
	});
});