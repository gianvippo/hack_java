export default function negativeConnotatio(string) {

    let positive = 0
    let negative = 0
    string.toLowerCase().split(' ').forEach(el => {
        if(/[a-m]/.test(el.charAt(0))) positive++
        if(/[n-z]/.test(el.charAt(0))) negative++
    })

    return positive >= negative

}