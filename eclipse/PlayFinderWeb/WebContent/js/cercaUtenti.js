	$.ajax({
		url: 'RicercaUtenti',
		method: 'get'
	}).done(function(utenti) {
		$.each(utenti, function(i, utente) {
		var option = '<li class="form-group">' +
			            '<label class="col-md-1 control-label" >'+
			            '</label>'+
			            '<div class="col-md-10 inputGroupContainer">' +
		                    '<div class="row input-group margine">'+
			                       '<span class="input-group-addon">'+
			                          '<img src="'+utente.profilePicturePath+'" id="imgProfilo" class="img-circle imgProfilo" width="100" height="100">'+
			                       '</span>'+
			                       '<a class="col-md-6 evento nEvento linkEvento" href="profilo.html?username='+ utente.username +'">'+
			                           '<p align = "left" class="col-md-6 evento"style="margin-bottom: 40px;">' + utente.username + 
			                           '</p>'+
			                           '<p>'+utente.nome+' '+ utente.cognome+'</p>'+
			                           '<p>'+utente.userInEvento.length+'</p>'+
			                           ''
			                       '</a>'+
		                      '</div>'+
		                 '</div>'+
		              '</li>';
        $('#listaUtenti').append(option);
		});
		});










function myFunction() {
    var input, filter, ul, li, p, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("listaUtenti");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        p = li[i].getElementsByClassName("utente")[0];
        if (p.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";

        }
    }
}