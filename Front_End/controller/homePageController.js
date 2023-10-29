$('#loginBG').hide();

$('#btnViewSignIn').click(function () {
    $('#loginBG').show();
});

$('#closeLogin').click(function () {
    $('#loginBG').hide();
});

$('#btnSign').click(function () {
    window.open("../pages/adminPanel.html","_self");
});

let currentSlide = 0;
const slides = document.querySelectorAll('.slide');

function showSlide(index) {
    if (index < 0) {
        index = slides.length - 1;
    } else if (index >= slides.length) {
        index = 0;
    }

    slides[currentSlide].style.display = 'none';
    slides[index].style.display = 'block';

    currentSlide = index;
}

function changeSlide(offset) {
    showSlide(currentSlide + offset);
}

// Initial display of the first slide
showSlide(currentSlide);
