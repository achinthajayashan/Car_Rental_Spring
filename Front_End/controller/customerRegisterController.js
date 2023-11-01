let BASE_URL="http://localhost:8080/Car_rent/Back_End_war/"

uploadDirectory="../uploads/"

generateCustomerID();
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
        // enctype:"multipart/form-data",
        // contentType: false,
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

                let row = "<tr><td>" + customerID + "</td><td>" + name + "</td><td>" + address + "</td><td>" + contactNo + "</td><td>" + email + "</td><td><img src=' "+"/"+forntImage+" ' width='100px'></td><td><img src=' "+"/"+backImage+" ' width='100px'></td></tr>";
                $("#tblCustomers").append(row);

                console.log(forntImage);
            }
            console.log(res.message);
        }, error: function (error) {
            // alert(error.responseJSON.message);
        }
    });
}

function generateCustomerID() {
    $("#txtCusID").val("C00-001");
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/customer/IdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#txtCusID").val("C00-00" + tempId);
            } else if (tempId <= 99) {
                $("#txtCusID").val("C00-0" + tempId);
            } else {
                $("#txtCusID").val("C00-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
        }
    });
}
