
var filter = function(arr, fn) {
    let filteredArr = arr.filter(fn)
    return filteredArr
};
fn = function greaterThan10(n) { return n > 10; }
let arr = [0,10,20,30]
let a = filter(arr, fn)
console.log(a)

