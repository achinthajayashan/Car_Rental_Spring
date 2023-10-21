$('#customersSec').hide();
$('#dashboardSec').show();
$('#carsSec').hide();

// $('#btnSignOut').click(function () {
//     window.history.back();
// });

$('#customers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").toggle();
    $('#customersSec').toggle();
    $('#carsSec').hide();
    // $('#customersSec').show();
});

$('#dashboard-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").show();
    $('#customersSec').hide();
    $('#carsSec').hide();
    // $('#customersSec').show();
});

$('#cars-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').show();
    // $('#customersSec').show();
});

