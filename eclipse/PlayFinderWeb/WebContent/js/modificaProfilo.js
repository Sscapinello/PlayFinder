var user = localStorage.getItem('utente');
u = JSON.parse(user);
$("#usrname").val(u.username);
$("#usrname").append(u.username);
$(document).on('click','#btnPirla', function() {
$.ajax({
	url: 'UploadImage',
	method: 'post',
	data : $('#uploadImmagine').serialize()
}).done(function(){
})
});