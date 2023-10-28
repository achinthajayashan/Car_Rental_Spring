$('#driverDetailsPopupBg').hide();
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
            bindTrEvents();
            console.log(res.message);
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}

function bindTrEvents() {
    $('#tblDrivers>tr').click(function () {
        let id = $(this).children().eq(0).text();
        console.log("row clicked")
        console.log(id);

        $('#driverDetailsPopupBg').show();


        $.ajax({
            url: "http://localhost:8080/Car_rent/Back_End_war/driver?driverID="+id,
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function (res) {
                console.log(res);
                $("#lblDriverId").text(res.driverID);
                $("#lblDriverLicense").text(res.drivingLicenceNo);
                $("#lblDriverName").text(res.driverName);
                $("#lblDriverEmail").text(res.email);
                $("#lblDriverContact").text(res.contactNo);
                $("#back_View").prop(res.frontImage);
                $("#side_View").prop(res.backImage);
                $("#lblDriverUserName").text(res.user.userName);
                $("#lblDriverPassword").text(res.user.password);

                $('#btnEditDriverDetail').click(function () {
                    $("#txtDriverId").val(res.driverID);
                    $("#txtDriverLicenceNo").val(res.drivingLicenceNo);
                    $("#txtDriverName").val(res.driverName);
                    $("#txtDriverEmail").val(res.email);
                    $("#txtDriverContact").val(res.contactNo);
                    $("#driverFront_view").prop(res.frontImage);
                    $("#driverBack_view").prop(res.backImage);
                    $("#txtDriverUserName").val(res.user.userName);
                    $("#txtDriverPassword").val(res.user.password);

                    $('#driverDetailsPopupBg').hide();
                })

            },
            error: function (error) {
                alert(error.responseJSON.message);
            }
        })
        // $("#txtCustomerID").val(id);
        // $("#txtCustomerName").val(name);
        // $("#txtCustomerAddress").val(address);
        // $("#txtCustomerSalary").val(salary);
    })
}

$('#btnCloseDriverDetail').click(function () {
    $('#driverDetailsPopupBg').hide();
})

$('#btnUpdateDriver').click(function () {
    let formData = new FormData($("#driverRegForm")[0]);
    console.log(formData);
    $.ajax({
        url:"http://localhost:8080/Car_rent/Back_End_war/driver",
        method: "put",
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

$("#btnDeleteDriver").click(function () {
    let id = $("#txtDriverId").val();
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/driver?driverID="+id ,
        method: "delete",
        dataType: "json",
        success: function (res) {
            alert(res.message)
            loadAllDrivers();
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});