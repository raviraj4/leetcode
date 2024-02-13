// Given an integer array nums, a reducer function fn, and an initial value init, return the final result obtained by executing the fn function on each element of the array, sequentially, passing in the return value from the calculation on the preceding element.

// this is the power of functional programming
var reduce = function(nums, fn, init) {
    let res = init
    for(const i of nums){ // wrong output if: i) let i =0; i< nums.length... or ii) i in nums
        res = fn(res, i)
    }
    return res
};


nums = [1,2,3,4]
fn1 = function sum(accum, curr) { 
    return accum + curr;
 }
 init = 0

 fn2 = function sum(accum, curr) { return accum + curr * curr; }
init2 = 100

a = reduce(nums, fn2, init2)
console.log(a)
