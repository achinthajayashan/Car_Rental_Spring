$('#customersSec').hide();
$('#dashboardSec').show();
$('#carsSec').hide();
$('#driversSec').hide();
$('#rentalsSec').hide();
$('#paymentsSec').hide();

$('#btnSignOut').click(function () {
    window.history.back();
});

$('#customers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').show();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});

$('#dashboard-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").show();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});

$('#cars-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').show();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});

$('#drivers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').show();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});

rentalsSec

$('#rentals-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').show();
    $('#paymentsSec').hide();
});

$('#Payments-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').show();
});


// ----------------------------------
// driver swction


$('#btnSaveDriver').click(function () {
    let formData = new FormData($("#driverRegForm")[0]);
    console.log(formData);
    $.ajax({
        url:"http://localhost:8080/Car_rent/Back_End_war/driver",
        method: "post",
        data: formData,
        async:true,
        contentType: false,
        processData: false,
        success: function (res) {
            alert(res.message);
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});

// -------------------------------------------------

$('#btnAddCar').click(function () {
    let formData = new FormData($("#carRegForm")[0]);
    console.log(formData);
    $.ajax({
        url:"http://localhost:8080/Car_rent/Back_End_war/car",
        method: "post",
        data: formData,
        async:true,
        contentType: false,
        processData: false,
        success: function (res) {
            alert(res.message);
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});

