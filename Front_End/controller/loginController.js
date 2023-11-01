$('#btnSign').click(function () {
    getallusers();
})

function getallusers() {

    let userName=$('#txtUserName').val();
    let password=$('#txtPassword').val();
    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/user?userName="+userName,
        dataType: 'json',
        success: function (resp) {
                    if (resp.password === password) {

                        switch (resp.role) {
                            case "admin":
                                window.open("../pages/adminPanel.html","_self");
                                break;

                            case "customer":
                                window.open("../pages/logedInCustomer.html","_self");
                                break;

                            case "driver":
                                window.open("#","_self");
                                break;

                            default:
                                alert("Check Your User Name ");
                                break;
                        }

                    }else{
                        alert("Check Your Password");
                    }
        },
        error: function (err) {
            console.log(err.message);
        }
    });
}