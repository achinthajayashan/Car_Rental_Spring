BASE_URL="http://localhost:8080/Back_End_war/"

$('#backToSignIn').click(function () {
    window.history.back();
});


$('#btnAddCustomer').click(function () {
    saveCustomer();
});
function saveCustomer() {
    // let customerID = $("#txtCustomerID").val();

    let formData2=$('#cusRegForm').serialize();
    console.log(formData2);

        let formData = new FormData($("#cusRegForm")[0]);
        console.log(formData);
        $.ajax({
            url: BASE_URL + "customer",
            method: "post",
            data: formData,
            contentType: false,
            processData: false,
            success: function (res) {
                alert(res.message);
            },
            error: function (error) {
                alert(error.responseJSON.message);
            }
        });

}
