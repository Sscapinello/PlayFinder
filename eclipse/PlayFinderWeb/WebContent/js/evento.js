$(function() {
	$.ajax({
 	})
	.done(function(sports) {
		$('#evento').empty();
		var select = '<option> Seleziona Sport </option>' ;
		$('#sport').append(select);
		$.each(sports, function(i, sport) {
			var option = '<option value ="' + sport + '">' + sport + '</option>';
			$('#sport').append(option);
		});
	});
});