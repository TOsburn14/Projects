function doubleTheSums(x, y) {
    return (x + y) * 2;
}

// The same function as an anonymous function
const doubleTheSumsInAVar = function (x, y) {
    return (x + y) * 2;
}

// Once assigned to a variable can call the function with the variable name
console.log( doubleTheSumsInAVar(4,4) );

// Can also assign it to another variable
const anotherVarWithTheSameFunction = doubleTheSumsInAVar;

console.log( anotherVarWithTheSameFunction(2,2) );

// Can use the arrow operator to create function
const doubleTheSumUsingTheArrow =  (x, y) => {
    return (x + y) * 2;
}


const nums = [1,2,3,4,5,6,7,8,9,10];

/*
***  FOREACH ***
*/
nums.forEach( (value) => {
    console.log(value);
} );

// This commented code is equivalent to the above forEach()
// for (let i = 0; i < nums.length; i++) {
//     const value = nums[i];
//     ourFunction(value);
// }

// function ourFunction (value) {
//     console.log(value);
// }

let sum = 0;
nums.forEach( value => {
    sum += value;
});

console.log("Sum: " + sum);

/*
***  REDUCE ***
*/
let reducedSum = nums.reduce( (currentSum, currentValue) => {
    return currentSum + currentValue;
} );

console.log("Reduced: " + reducedSum);

const stringArr = ['A', 'B', 'C', 'D'];

let reducedString = stringArr.reduce( (newStr, currentValue) => {
    return newStr + '_' + currentValue + '_';
}, '' );

console.log(reducedString);

/*
***  FILTER  ***
The anonymous function is a test that returns true if you want
the value kept and false if you want it removed
*/

let arrayWithoutOddNumbers = nums.filter( currentValue => {
    if (currentValue % 2 == 1) {
        return false;
    } 
    return true;
});

console.log(arrayWithoutOddNumbers);

// Can be rewritten to take of the truthy nature of JavaScript
// currentValue % 2 return 1 when odd and 1 is truthy, so negating
// returns false when the value is 1.
// let arrayWithoutOddNumbers2 = nums.filter( currentValue => {
//     return !(currentValue % 2);
// });

// console.log(arrayWithoutOddNumbers2);

const products = [
    {
        name: 'book',
        price: 10
    },
    {
        name: 'laptop',
        price: 100
    },
    {
        name: 'milk',
        price: 5
    },
    {
        name: 'cd',
        price: 22
    },
    {
        name: 'shirt',
        price: 25
    }
];

const maxPrice = 24;

const filteredProducts = products.filter( product => {
    return product.price <= maxPrice;
});

console.table(filteredProducts);

/*
***  MAP  ***
The anonymous function returns a changed value for each element in the array.
That value when then be stored in the same index in the new array as the index of
the original element in the old array.
*/
const numsAllMultipliedBy10 = nums.map( value => {
    return value * 10;
});

console.log(numsAllMultipliedBy10);

/*
*** FIND ***
*/
const foundObj = products.find( product => product.name === 'shirt' );

console.log(foundObj);

/*
 FizzBuzz with Map
*/
const arr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];

function fizzBuzzIt() {
    let fizzArr = arr.map( value => {
        if (!(value % 3) && !(value % 5)) {
            return 'FizzBuzz';
        }
        if (!(value % 3)) {
            return 'Fizz';
        }
        if (!(value % 5)) {
            return 'Buzz';
        }
        return value;
    });
    console.table(fizzArr);
}

// Here assign the anonymous function to a variable first,
// then pass that variable
function fizzBuzzItVersion2() {

    const ourFizzBuzzFunc = (value) => {
        if (!(value % 3) && !(value % 5)) {
            return 'FizzBuzz';
        }
        if (!(value % 3)) {
            return 'Fizz';
        }
        if (!(value % 5)) {
            return 'Buzz';
        }
        return value;
    };

    let fizzArr = arr.map( ourFizzBuzzFunc );
    console.table(fizzArr);
}


const ourFizzBuzzFunc = value => {
    if (!(value % 3) && !(value % 5)) {
        return 'FizzBuzz';
    }
    if (!(value % 3)) {
        return 'Fizz';
    }
    if (!(value % 5)) {
        return 'Buzz';
    }
    return value;
};

fizzBuzzItVersion3(ourFizzBuzzFunc);

function fizzBuzzItVersion3(fizzBuzzFunc) {
    let fizzArr = arr.map( fizzBuzzFunc );
    console.table(fizzArr);
}



/*
    Taking a function as a parameter in our own function
*/
function calculate( func, x, y) {
    return "The result is " + func(x, y);
}

let result = calculate( (val1, val2) => {
    return val1 + val2;
}, 2, 4);

result = calculate( (val1, val2) => {
    return val1 * 10 +  val2 * 10;
}, 2, 4);

console.log(result);

/*
    For an of numbers, find the sum of all numbers in the array
    multplied by 10, but only for numbers that are not multiples of 3
*/
const finalSum = arr.filter( currentValue => {
    return currentValue % 3;
}).map( currentValue => { 
    return currentValue * 10; 
}).reduce ( (sum, currentValue) => { 
    return sum + currentValue; 
}, 0);

console.log(finalSum);