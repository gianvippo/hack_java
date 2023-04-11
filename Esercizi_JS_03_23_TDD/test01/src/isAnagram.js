function charSort(string) {

     return string.toLowerCase().split('').sort().join()

}

export default function isAnagram(string1, string2) {

    if(string1.length != string2.length) return false
    if(string1 == string2) return true

    // splitto le stringhe per ottenere i singoli caratteri, ordino i singoli caratteri, joino e se sono uguali ritorna true

    return charSort(string1) == charSort(string2)

}