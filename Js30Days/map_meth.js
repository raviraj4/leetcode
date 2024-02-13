const someArr = [1,2,3]
const newArr = someArr.map(doubleIt)

function doubleIt(n){
    return n * 2    
}
console.log(newArr)