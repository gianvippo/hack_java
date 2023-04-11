export default function splitString(string) {

    let arraySplitted = string.split('')
    let chars = [arraySplitted[0]]
    if(!arraySplitted.length % 2 == 0) arraySplitted.push('_')
    let finalArray = []
    for (let i = 1; i < arraySplitted.length; i++) {
        if(i % 2 == 0) {
            chars = []
            chars.push(arraySplitted[i])
        }
        else {
            chars.push(arraySplitted[i])
            finalArray.push(chars.join(''))
        }

    }

    return finalArray

}