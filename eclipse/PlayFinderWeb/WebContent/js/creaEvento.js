$(function() {
	$.ajax({
 	})
	.done(function(sports) {
		$('#sport').empty();
		var select = '<option> Seleziona Sport </option>' ;
		$('#sport').append(select);
		$.each(sports, function(i, sport) {
			var option = '<option value ="' + sport + '">' + sport + '</option>';
			$('#sport').append(option);
		});
	});
	
	$('#btnRegistrati').click(function() {
		$.ajax({
			url: 'creaEvento',
			method: 'post',
			data: $('#event_form').serialize()
		})
		.done(function() {
			console.log('done.');
		});
		
	});
});



$('#defaultCheck1').click(function() {
	if(this.checked){
		$('#password').prop('disabled', false);
	} else {
		$('#password').prop('disabled', true);
	}
});