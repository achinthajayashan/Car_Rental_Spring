$('#loginBG').hide();

$('#btnViewSignIn').click(function () {
    $('#loginBG').show();
});

$('#closeLogin').click(function () {
    $('#loginBG').hide();
});

$('#btnSign').click(function () {
    window.open("../pages/adminDashboard.html","_self");

});