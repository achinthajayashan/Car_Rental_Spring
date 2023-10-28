loadAllCars();
$('#carDetailsPopupBg').hide();


function loadAllCars() {
    $("#tblDrivers").empty();
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/car",
        method: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let carID = i.carID;
                let regNo = i.regNo;
                let brand = i.brand;
                let type = i.type;
                let passenger = i.passenger;
                let color = i.color;
                let transmissionType = i.transmissionType;
                let fuelType = i.fuelType;
                let extraMileagePrice = i.extraMileagePrice;
                let currentMileage = i.currentMileage;
                let wavierPayment = i.wavierPayment;
                let availability = i.availability;
                let freeMileageDaily = i.freeMileageDaily;
                let freeMileageDailyPrice = i.freeMileageDailyPrice;
                let freeMileageMonthly = i.freeMileageMonthly;
                let freeMileageMonthlyPrice = i.freeMileageMonthlyPrice;
                let frontImage = i.frontImage;
                let rearImage = i.RearImage;
                let sideImage = i.sideImage;
                let interiorImage = i.interiorImage;


                console.log(frontImage);

                let row = "<tr><td>" + carID + "</td><td>" + type + "</td><td>" + brand + "</td><td>" + availability + "</td></tr>";
                $("#tblCars").append(row);
                bindTrEvents();

            }
            console.log(res.message);
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}

// save car
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


function bindTrEvents() {
    $('#tblCars>tr').click(function () {
        let id = $(this).children().eq(0).text();
        console.log("row clicked")
        console.log(id);

        $('#carDetailsPopupBg').show();


        $.ajax({
            url: "http://localhost:8080/Car_rent/Back_End_war/car?car_id="+id,
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function (res) {
                console.log(res);
                $("#lblCarId").text(res.carID);
                $("#lblregNo").text(res.regNo);
                $("#lblbrand").text(res.brand);
                $("#lbltype").text(res.type);
                $("#lblPassenger").text(res.passenger);
                $("#frontImage").prop(res.frontImage);
                $("#RearImage").prop(res.RearImage);
                $("#sideImage").prop(res.sideImage);
                $("#interiorImage").prop(res.interiorImage);
                // $("#lblPassenger").text(res.passenger);
                $("#lblcolor").text(res.color);
                $("#lbltransmissionType").text(res.transmissionType);
                $("#lblfuelType").text(res.fuelType);
                $("#lblextraMileagePrice").text(res.extraMileagePrice);
                $("#lblCurrentMileage").text(res.currentMileage);
                $("#lblWaiverPayment").text(res.wavierPayment);
                $("#lblAvailability").text(res.availability);
                $("#lblfreeMileageDaily").text(res.freeMileageDaily);
                $("#lblfreeMileageDailyPrice").text(res.freeMileageDailyPrice);
                $("#lblfreeMileageMonthly").text(res.freeMileageMonthly);
                $("#lblfreeMileageMonthlyPrice").text(res.freeMileageMonthlyPrice);

                // $('#btnEditCarDetail').click(function () {
                //     $("#txt").val(res.driverID);
                //     $("#txtDriverLicenceNo").val(res.drivingLicenceNo);
                //     $("#txtDriverName").val(res.driverName);
                //     $("#txtDriverEmail").val(res.email);
                //     $("#txtDriverContact").val(res.contactNo);
                //     $("#driverFront_view").prop(res.frontImage);
                //     $("#driverBack_view").prop(res.backImage);
                //     $("#txtDriverUserName").val(res.user.userName);
                //     $("#txtDriverPassword").val(res.user.password);
                //
                //     $('#driverDetailsPopupBg').hide();
                // })

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
