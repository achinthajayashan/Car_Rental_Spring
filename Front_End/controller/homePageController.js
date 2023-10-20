$('#loginBG').hide();

$('#btnViewSignIn').click(function () {
    $('#loginBG').show();
});

$('#closeLogin').click(function () {
    $('#loginBG').hide();
});

$('#btnSign').click(function () {
    window.open("../pages/adminPanel.html","_self");

});