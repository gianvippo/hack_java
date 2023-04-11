export default function uniqueInOrder(string) {

    let array = []
    let stringa

    if(Array.isArray(string)) stringa = string.join('').split('')
    else stringa = string.split('')
    stringa.forEach((el, key) => {
        if(el != stringa[key-1]) {
            if(/^-?\d+$/.test(el)) array.push(Number(el))
            else array.push(el)
        }

    })
    return array
}