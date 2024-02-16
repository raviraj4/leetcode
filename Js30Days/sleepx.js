async function sleep(millis){
    return new Promise((res, rej)=>{
        setTimeout(()=>{
            res(millis)
        }, millis)
    })
}

// we just return a new Promise which resolves millis after millis 
