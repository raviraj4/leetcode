// Write a function expect that helps developers test their code. It should take in any value val and return an object with the following two functions.

// solution --> 
var expect = function(val) {
    return {
        toBe: (val2)=>{
            if (val === val2) {
        return true;  
      } else {
        throw 'Not Equal'; // throw -> {"error":"Not Equal"}✅  ||    return -> {"value":"Not Equal"}
      }
        },
        notToBe: (val2)=>{
            if (val !== val2) {
                return true ;  
              } else {
                throw 'Equal';  
              }
        }
    }
  };
a = expect(5).toBe(5)
console.log(a)
// expect(5).toBe(5) // true

/**
 * expect(5).notToBe(5); // throws "Equal"
 */

