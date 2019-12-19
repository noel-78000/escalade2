$(document).ready(function () {
    $("#userlistnumpage").keyup(function (e) {
        if (e.keyCode === 13) {
            if (isNaN($("#userlistnumpage").val())) {return;}
            let numpage = $("#userlistnumpage").val() - 1;
            if(numpage >= $("#userpagetotalpages").val()) {
                numpage = $("#userpagetotalpages").val() -1;
            }
            if (numpage < 0) {
                numpage = 0;
            }
            let url = myContextPath + "/user/listpage?num=" + numpage;
            window.location = url;
        }
    });
});