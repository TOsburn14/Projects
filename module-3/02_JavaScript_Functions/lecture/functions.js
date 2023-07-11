function doubleTheSums(x,y) {
    return (x+y) * 2
}

// The same function as an anonymous function
const doubleTheSumsInAVar = function (x,y) {
    return (x+y) * 2;
}

//Once Assigned to a variable can call the function with the variable name
console.log(doubleTheSumsInAVar(4,4));


//Can also asign it to another variable
const anotherVarWithTheSameFunction = doubleTheSumsInAVar;

console.log(anotherVarWithTheSameFunction(2,2));


//Can use the => operator to create function
const doubleTheSumUsingTheArrow = (x,y) => {
    return (x,y) * 2;
}



const nums = [1,2,3,4,5,6,7,8,9,10];

nums.forEach((value) => {
    console.log(value);
});