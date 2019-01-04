/**
 * 
 */

$(document).ready(function(){
	$(".cartItemQty").on('change', function(){
		var id=this.id;
		
		console.log("test");
		$('#update-item-'+id).css('display', 'inline-block');
	});
});