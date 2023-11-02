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

                        var currentDateTime = new Date().toLocaleString();
                        console.log(currentDateTime);

                        let loginId=resp.userName+currentDateTime;
                        let loggedUserName =resp.userName;
                        let localDateandTime=currentDateTime;


                        console.log(loginId)
                        let userOb={
                            userName: resp.userName,
                            password:resp.password,
                            role:resp.role
                        }

                        let loggedUser={
                            loginId: loginId,
                            userName:userOb,
                            dateTime:currentDateTime
                        }


                        $.ajax({
                            url: "http://localhost:8080/Car_rent/Back_End_war/loginDetail",
                            data:JSON.stringify(loggedUser),
                            dataType: "JSON",
                            method:"POST",
                        success: function (resp) {
                            alert("loginDetails saved")
                        },

                        error: function (error){
                                alert("Login not saved");
                        }
                        });

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


