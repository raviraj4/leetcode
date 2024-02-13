// Write a function createCounter. It should accept an initial integer init. It should return an object with three functions.

// The three functions are:

// increment() increases the current value by 1 and then returns it.
// decrement() reduces the current value by 1 and then returns it.
// reset() sets the current value to init and then returns it.
var createCounter = function(init) {
    let currVal = init
    return {
        increment: function(){
            currVal = ++currVal;
            console.log(currVal)
            
        },
        decrement: function(){
            currVal = --currVal;
            console.log(currVal);

        },
        reset: function(){
            currVal = init
            console.log(currVal)
        }
    }
};
const counter = createCounter(5)
counter.increment()
counter.reset()
counter.decrement()
/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */