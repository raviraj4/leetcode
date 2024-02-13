// Given an integer array arr and a mapping function fn, return a new array with a transformation applied to each element.
// The returned array should be created such that returnedArray[i] = fn(arr[i], i).
// Please solve it without the built-in Array.map method.

var map = function(arr, fn) {
    let returnedArray = [];
    for(let i=0;i<=arr.length;i++){
        returnedArray = arr.map(fn);
    }
    return returnedArray;

};
let arr1 = [1,2,3]

let fn1 = function plusone(n){
    return n+1
} 
let fn2 = function plusI(n,i){
    return n + i; 
}   
a = map(arr1, fn2);

console.log(a);