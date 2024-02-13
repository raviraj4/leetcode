// Given an array of functions [f1, f2, f3, ..., fn], return a new function fn that is the function composition of the array of functions.

// The function composition of [f(x), g(x), h(x)] is fn(x) = f(g(h(x))).

// The function composition of an empty list of functions is the identity function f(x) = x.

// You may assume each function in the array accepts one integer as input and returns one integer as output.
var compose = function(functions) {
    return function(x) {
        for(const func_elm  of functions.reverse()){
            x = func_elm(x)
        }
        return x
    }
}
var compose2 = function(functions){
    return function(x) {
        functions.forEach((fn, i) => {
            x = functions[functions.length-1-i](x);
        })
        return x;
    }
}
var compose3 = function(functions){
    //doesn't work
    return function(x) {
        const n = functions.length
        for(let i = n-1; i<=0;i--){
            x = functions[i](functions[n-1-i]())
        }    
    }
}
// more optimal solution using foreach loop
// const fn1 = x => x + 1
// const fn2 =  x => 2 * x
const fn = compose2([x => x + 1, x => 2 * x])
const a = fn(4) // 9
console.log(a)