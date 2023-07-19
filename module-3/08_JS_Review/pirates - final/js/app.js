/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {

    createGrid();

    document.querySelector('body').addEventListener('keyup', (event) => {

        if (event.key.toLowerCase() === 'a') {
            moveShipLeft();
        }
        if (event.key.toLowerCase() === 'd') {
            moveShipRight();
        }
        if (event.key.toLowerCase() === 's') {
            moveShipDown();
        }
        if (event.key.toLowerCase() === 'w') {
            moveShipUp();
        }
    });

});



/*
  Move the Ship 
*/
function moveShipRight() {
    const currentShip = getShipLocation();
    const newLocation = currentShip.nextElementSibling;
    moveShip(currentShip, newLocation);
}

function moveShipLeft() {
    const currentShip = getShipLocation();
    const newLocation = currentShip.previousElementSibling;
    moveShip(currentShip, newLocation);
}

function moveShipDown() {
    const currentShip = getShipLocation();
    const newLocation = getElementAtSameIndex(currentShip, currentShip.parentElement.nextElementSibling);
    moveShip(currentShip, newLocation);
}

function moveShipUp() {
    const currentShip = getShipLocation();
    const newLocation = getElementAtSameIndex(currentShip, currentShip.parentElement.previousElementSibling);
    moveShip(currentShip, newLocation);

}

function getElementAtSameIndex(currentLocation, newParent) {
    let elementAtIndex = null;

    if (newParent != null) {
        const index = Array.from(currentLocation.parentNode.children).indexOf(currentLocation);
        elementAtIndex = newParent.childNodes[index];
    }

    return elementAtIndex;
}

function moveShip(currentLocation, newLocation) {
    currentLocation.classList.remove('boat');
    newLocation.classList.add('boat');
}


function getShipLocation() {
    // Get the return the current location of the ship
    return document.getElementById('frame').querySelector('.boat');
}





/*
  Win Conditions
*/





/*
    Loss Conditions
*/




/**
 * Reset the Game
 */
function resetGame() {

    document.querySelector('.announce').innerText = "Play!";

    createObstacles();

    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
    
}


/*
    Setup the Game
*/
/**
 * Creates the game grid
 */
function createGrid() {

    // Get a Reference to the game board 
    const frame = document.getElementById('frame');

    
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    // Create a Div to be the row
    const row = document.createElement('div');
    // Add the row class to the row div
    row.classList.add('row');
    // Append the row div to the game board (frame)
    frame.appendChild(row);
    
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Create a Div for the game board square
   const square = document.createElement('div');
   // Add the square class to the div
   square.classList.add('square');
   // Insert the square at the end of the row
   row.insertAdjacentElement('beforeend', square);
  
}

function createObstacles() {

    const rows = document.getElementById('frame').children;
    const rowsArray = Array.from(rows);

    rowsArray.forEach( (row, rowIndex) => {
        const cells = row.children;
        Array.from(cells).forEach( (cell, cellIndex) => {
            if ( !(rowIndex === 0 && cellIndex === 0) &&
                !(rowIndex === rows.length - 1 && cellIndex === rows.length - 1) ) {
                    addObstacles(cell);
                }
        });
    });
}


/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
        cell.classList.add('iceberg');
 
    } else if (rand > 80) {
        // Add pirates here
        cell.classList.add('pirate');
    } 
}


/*
  Move the Pirates
*/



function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
