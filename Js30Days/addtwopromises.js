var addTwoPromises = async function(promise1, promise2) {
    return new Promise ((resolve, reject) =>{
    promise1.then((val)=>{
        promise2.then((val2)=> {
            resolve(val+val2)
        })
    })})
};

// so basically we return a new promise with resolve
// alternatively another approach can be:
var addTwoPromises2 = async function(promise1, promise2) {
    const result1 = await promise1
    const result2 = await promise2
    return result1 + result2 
};

 addTwoPromises2(Promise.resolve(2), Promise.resolve(2))
   .then(console.log); // 4
