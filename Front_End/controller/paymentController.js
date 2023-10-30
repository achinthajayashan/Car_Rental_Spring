getAllPayments();
function getAllPayments() {
    $("#tblPayments").empty();
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/payment",
        method: "GET",
        dataType: "json",
        // enctype:"multipart/form-data",
        // contentType: false,
        success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let paymentID = i.paymentID;
                const waiverDeductions = String(i.waiverDeductions);
                let paymentSlip = i.paymentSlip;
                let extraMilleagePayment = String(i.extraMileagePayment);

                let row = "<tr><td>" + paymentID + "</td><td>" + "" + "</td><td>" + waiverDeductions + "</td><td>" + extraMilleagePayment + "</td><td>" + "" + "</td></tr>";
                $("#tblPayments").append(row);

                // console.log(forntImage);
            }
            console.log(res.message);
        }, error: function (error) {
            // alert(error.responseJSON.message);
        }
    });
}