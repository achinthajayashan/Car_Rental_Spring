loadAllCars();


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




                let row = "<tr><td>" + carID + "</td><td>" + type + "</td><td>" + brand + "</td><td>" + availability + "</td></tr>";
                $("#tblCars").append(row);
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
