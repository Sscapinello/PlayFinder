$(function() {
	$.ajax({
		url: 'creaEvento',
		method: 'get'
	})
	.done(function(sports) {
		$('#sport').empty();
		var select = '<option> Seleziona Sport </option>' ;
		$('#sport').append(select);
		$.each(sports, function(i, sport) {
			var option = '<option>' + sport + '</option>';
			$('#sport').append(option);
		});
	});
});