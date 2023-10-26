let BASE_URL="http://localhost:8080/Car_rent/Back_End_war/"

loadAllCustomers();
$('#backToSignIn').click(function () {
    window.history.back();
});


$("#btnAddCustomer").click(function () {
    let formData = new FormData($("#cusRegForm")[0]);
    console.log(formData);
    $.ajax({
        url:"http://localhost:8080/Car_rent/Back_End_war/customer",
        method: "post",
        data: formData,
        async:true,
        contentType: false,
        processData: false,
        success: function (res) {
            alert(res.message);
            loadAllCustomers();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});

function loadAllCustomers() {
    $("#tblCustomers").empty();
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/customer",
        method: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let customerID = i.customerID;
                let name = i.name;
                let address = i.address;
                let email = i.email;
                let contactNo = i.contactNo;
                let licenseNo = i.licenseNo;
                let forntImage = i.frontImage;
                let backImage = i.backImage;
                let userName = i.user.userName;
                let password = i.user.password;
                let role = i.user.role;

                let row = "<tr><td>" + customerID + "</td><td>" + name + "</td><td>" + address + "</td><td>" + contactNo + "</td><td>" + email + "</td></tr>";
                $("#tblCustomers").append(row);
            }
            console.log(res.message);
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}
