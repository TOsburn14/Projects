const audio = new Audio('assets/sounds/duck.wav');


document.addEventListener('DOMContentLoaded',() => {
    const toggle = document.getElementById('switch').querySelector("input[type=checkbox]");

    toggle.addEventListener('change',(event) => {
       if (event.target.checked) {
           startAnnoying();
       } else {
           stopAnnoying();
       }
    });

});

    



function startAnnoying() {
    document.querySelector('body').addEventListener('keydown',doAnnoy);
}

function stopAnnoying() {
    document.querySelector('body').removeEventListener('keydown',doAnnoy);
}

function doAnnoy() {
    audio.play();
    console.log("key")
}