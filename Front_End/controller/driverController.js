loadAllDrivers();

// Save Driver
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
            loadAllDrivers();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});


// get all drivers
function loadAllDrivers() {
    $("#tblDrivers").empty();
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/driver",
        method: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let driverID = i.driverID;
                let drivingLicenceNo = i.drivingLicenceNo;
                let driverName = i.driverName;
                let email = i.email;
                let contactNo = i.contactNo;
                let frontImage = i.frontImage;
                let backImage = i.backImage;
                let userName = i.user.userName;
                let password = i.user.password;
                let role = i.user.role;

                let row = "<tr><td>" + driverID + "</td><td>" + driverName + "</td><td>" + drivingLicenceNo + "</td><td>" + contactNo + "</td></tr>";
                $("#tblDrivers").append(row);
            }
            console.log(res.message);
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}