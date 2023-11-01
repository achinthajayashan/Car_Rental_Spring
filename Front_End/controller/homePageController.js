$('#loginBG').hide();

loadCarDetails();

$('#btnViewSignIn').click(function () {
    $('#loginBG').show();
});

$('#closeLogin').click(function () {
    $('#loginBG').hide();
});

$('#btnSign').click(function () {
    window.open("../pages/adminPanel.html","_self");
});

function loadCarDetails() {
    $("#carViewSection").empty();

    $.ajax({
        url: "http://localhost:8080/Car_rent/Back_End_war/car/view",
        method: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res)

            for (let i of res) {
                console.log(i);
                // let url1 = i.image.front_View;
                $("#carViewSection").append(`<div class="col-md-3 carViewDiv bg-white shadow rounded-2" >
          <div class="slideshow-container mt-3">
            <div class="slide">
              <img src="" alt="Image 1" id="loadFrontImage">
            </div>
            <div class="slide">
              <img src="" alt="Image 2" id="loadRearImage">
            </div>
            <div class="slide">
              <img src="" alt="Image 3" id="loadSideImage">
            </div>
            <div class="slide">
              <img src="" alt="Image 4" id="loadInteriorImage">
            </div>
        </div>
        <div class="d-flex align-items-center justify-content-center mt-0 btnNexxtSlide"><button class="prev btn"  onclick="changeSlide(-1)"><i class="fa-solid fa-chevron-left"></i></button>
          <button class="next btn" onclick="changeSlide(1)"><i class="fa-solid fa-chevron-right"></i></button></div>

        <div class="text-center bg-primary text-white rounded">
          <h5 id="loadCarBrand">${i.brand}</h5>
        </div>

        <div class="d-flex w-100 mb-0">

          <div class="w-50" >
            <ul>
              <li id="loadCarPassengers">${i.passenger} Passengers</li>
              <li id="loadTransmissionType">${i.transmissionType} Gear</li>
            </ul>
          </div>

          <div class="w-50 mb-0">
            <ul class="mb-0">
              <li id="loadCarColor">${i.color} Color</li>
              <li id="loadFuelType">${i.fuelType}</li>
            </ul>
          </div>

        </div>

        <p class="text-center text-secondary mt-0 mb-0" id="loadExtraMileagePrice">Rs.${i.extraMileagePrice} for Extra Km</p>


        <p class="text-center bg-secondary-subtle text-muted mt-0" id="loadwaiverAmount">Wavier Payment is Rs.${i.wavierPayment}</p>

        <div class="d-flex w-100">
          <div class="w-50 text-center bg-secondary rounded text-white me-2">
            <p class="m-0">Daily</p>
            <h5 class="m-0 bg-dark" id="loadDailyMilleagePrice">Rs.${i.freeMileageDailyPrice}</h5>
            <p class="m-0" id="loadDailyMilleage">for ${i.freeMileageDaily}km</p>
          </div>
          <div class="w-50 text-center bg-secondary rounded text-white">
            <p class="m-0">Monthly</p>
            <h5 class="m-0 bg-dark" id="loadMonthlyMilleagePrrice">Rs.${i.freeMileageMonthlyPrice}</h5>
            <p class="m-0" id="loadMonthlyMilleage">for ${i.freeMileageMonthly}km</p>
          </div>

        </div>

        <div class="d-flex w-100 mt-5">
          <button class="btn w-50 bg-primary me-2 text-white" id="btnBookNowView" onclick="btnBookNowView()"><i class="fa-solid fa-receipt me-2"></i>Book Now</button>
          <button class="btn w-50 bg-dark text-white"><i class="fa-solid fa-list me-2" onclick="btnAddToListView()"></i>Add To List</button>
        </div>

      </div>`);

            }
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
    
}



function btnBookNowView() {
    console.log("clicked")
    alert("Please Log In to System for Rent a Car")
}

function btnAddToListView() {
    console.log("clicked")
    alert("Please Log In to System for Add To List")
}