export default function fizzbuzz(x) {

    if(x % 15 == 0) return "fizzbuzz"
    if(x % 5 == 0) return "buzz"
    if(x % 3 == 0) return "fizz"
    return x

}