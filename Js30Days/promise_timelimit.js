var timeLimit = function(fn, t) {
    return async function(...args) {
        return new Promise((resolve, reject)=>{
            const TID = setTimeout(()=>reject("Time Limit Exceded"), t)
            fn(...args)
            .then((res)=>{
                resolve(res)
            })
            .catch((error)=>{reject(error)})
            .finally(()=>{clearTimeout(TID)})

        })
   }
};


const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
fn = async (n) => { 
    await new Promise(res => setTimeout(res, 100)); 
    return n * n; 
  }