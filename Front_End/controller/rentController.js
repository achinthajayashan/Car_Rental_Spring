getAllRents();
function getAllRents() {
    $("#tblRentRequests").empty();
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/rent",
        method: "GET",
        dataType: "json",
        // enctype:"multipart/form-data",
        // contentType: false,
        success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let rentId = i.rentID;
                let cusId = i.customerID;
                let pickupDate = i.pickupDate;
                let pickupTime = i.pickupTime;
                let duration = i.duration;
                let status = i.status;
                let declineReason = i.declineReason;

                let row = "<tr><td>" + rentId + "</td><td>" + cusId + "</td><td>" + pickupDate + "</td><td>" + pickupTime + "</td><td>" + duration + "</td><td>" + status + "</td></tr>";
                $("#tblRentRequests").append(row);

                // console.log(forntImage);
            }
            console.log(res.message);
        }, error: function (error) {
            // alert(error.responseJSON.message);
        }
    });
}