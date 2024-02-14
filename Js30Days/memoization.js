// Given a function fn, return a memoized version of that function.

// A memoized function is a function that will never be called twice with the same inputs. Instead it will return a cached value.

// You can assume there are 3 possible input functions: sum, fib, and factorial.

// sum accepts two integers a and b and returns a + b.
// fib accepts a single integer n and returns 1 if n <= 1 or fib(n - 1) + fib(n - 2) otherwise.
// factorial accepts a single integer n and returns 1 if n <= 1 or factorial(n - 1) * n otherwise.

// memoization process applied in DP
// memoize(fn) is a wrapper function which adds functionality to inner function we pass in, in this case it cache the results for every unique key
function memoize(fn) {
    // we need some state to keep track     
    const cache = {}
  return function (...args) {
    const key = JSON.stringify(args)
    if(key in cache ){
        return cache[key]
    }  
    cache[key] = fn(...args)
    return cache[key]  
  };
}
// similar to decorators in python
// caching makes sense for pure functions
let callCount = 0;
const memoizedFn = memoize(function (a, b) {
  callCount += 1;
  return a + b;
});
memoizedFn(2, 3); // 5
memoizedFn(2, 3); // 5 cached value
console.log(callCount); // 1
// 2, 3
// next time we enter the same args it will check and if it has already been called more than once then it will give the cached value

// we stringify the args array object and see if key is in the cache if it is we return it else we add the args as key and value as the keys value

// Illustration of JSON.stringify()
function demodemo(...args){
    args.forEach(()=> {
        at = JSON.stringify(args)
        // console.log(typeof(at)) -- string
    })
}
a = demodemo(1,2,3)