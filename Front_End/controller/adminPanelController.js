$('#customersSec').hide();
$('#dashboardSec').show();
$('#carsSec').hide();
$('#driversSec').hide();
$('#rentalsSec').hide();

// $('#btnSignOut').click(function () {
//     window.history.back();
// });

$('#customers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').show();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    // $('#customersSec').show();
});

$('#dashboard-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").show();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    // $('#customersSec').show();
});

$('#cars-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').show();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    // $('#customersSec').show();
});

$('#drivers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').show();
    $('#rentalsSec').hide();
    // $('#customersSec').show();
});

rentalsSec

$('#rentals-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').show();
    // $('#customersSec').show();
});

