// arguments: The arguments object holds all the arguments passed to a function, regardless of their number.

var argumentsLength = function(...args) {
    return arguments.length
};

a = argumentsLength([1],[2,3])
console.log(a)