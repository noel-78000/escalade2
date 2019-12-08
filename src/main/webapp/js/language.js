$(document).ready(function(){
    $('#refreshenglish1').click(function(){
        $.ajax({url: myContextPath + "/language?lang=en", success: function(result){
                location.reload();
            }});
    });
    $('#refreshenglish2').click(function(){
        $.ajax({url: myContextPath + "/language?lang=en", success: function(result){
                location.reload();
            }});
    });
    $('#refreshfrench1').click(function(){
        $.ajax({url: myContextPath + "/language?lang=fr", success: function(result){
                location.reload();
            }});
    });
    $('#refreshfrench2').click(function(){
        $.ajax({url: myContextPath + "/language?lang=fr", success: function(result){
                location.reload();
            }});
    });
});