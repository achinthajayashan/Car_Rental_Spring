$('#customersSec').hide();
$('#dashboardSec').show();
$('#carsSec').hide();
$('#driversSec').hide();


// $('#btnSignOut').click(function () {
//     window.history.back();
// });

$('#customers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').show();
    $('#carsSec').hide();
    $('#driversSec').hide();

    // $('#customersSec').show();
});

$('#dashboard-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").show();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    // $('#customersSec').show();
});

$('#cars-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').show();
    $('#driversSec').hide();
    // $('#customersSec').show();
});

$('#drivers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').show();
    // $('#customersSec').show();
});

