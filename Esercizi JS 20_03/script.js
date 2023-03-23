// function bubbleSort(arr) {
// 	let sorted

// 	while (!sorted) {
// 		sorted = true
// 		for (let i = 0; i < arr.length; i++) {
// 			if (arr[i] > arr[i + 1]) {
// 				let temp;
// 				temp = arr[i];
// 				arr[i] = arr[i + 1]
// 				arr[i + 1] = temp
// 				sorted = false
// 			}
// 		}
// 	}
// 	return arr
// }

// let arr = [10, 2, 15, 7, 9, 20];
// console.log(bubbleSort(arr))

// Esercizio 1 - Calcolare l'ipotenusa di un triangolo rettangolo di cateti 3 e 4. Potete usare Math

// function ipotenusa(a, b) {

// 	a = Math.pow(a, 2)
// 	b = Math.pow(b, 2)

// 	return Math.sqrt(a + b)

// }

// console.log(ipotenusa(3, 4));


// Esercizio 2 - Scrivere una funzione che trasformi un nome nelle sue iniziali "Tizio Caio" => T.C.

// function initials(name) {

// 	let initials = ""
// 	initials += name[0].toUpperCase() + ". "
// 	for (let i = 1; i < name.length; i++) {

// 		if (name[i - 1] == ' ') {
// 			initials += name[i].toUpperCase() + ". "
// 		}

// 	}

// 	return initials

// }

// function containsNumbers(str) {
// 	return /\d/.test(str);
// }

// while (true) {

// 	let name = prompt('Inserire nome completo')

// 	if (containsNumbers(name)) alert("Riscrivi")
// 	else {
// 		console.log(initials(name))
// 		break
// 	}

// }


//----------

// function iniziali(string) {

//     let result = string.split(' ')
//                     .map(el => el[0]+'.')
//                     .join('')
//     return result
    
// }

// console.log(iniziali('Tizio Caio'));


// Esercizio 3 - Scrivere una funzione che , dati 3 numeri, ritorni true se questi 3 numeri possono formare un triangolo. False altrimenti

// function canBeTriangle(a,b,c) {

// 	if (a < b+c && b < c+a && c < a+b && a > Math.abs(b-c) && b > Math.abs(a-c) && c > Math.abs(a-b)) return true
// 	else return false

// }

// console.log(canBeTriangle(5,2,3));


// Esercizio 4 - Congettura di Collatz: preso un numero maggiore di 1, se questo è pari dividerlo per due, se dispari moltiplicarlo per 3 e aggiungere 1. Ripetere. Qualunque sia il numero di partenza, l'algoritmo termina sempre ad uno. Scrivere una funzione che implementi l'algoritmo e ritorni un array con il valore calcolato ad ogni iterazione

// function collatz(num) {

// 	let array = []

// 	while (true) {

// 		array[array.length] = num

// 		if(num % 2 == 0){
// 			num = num / 2
// 		} 
// 		else {
// 			num = (num * 3) + 1 
// 		}

// 		if (num == 1) {
// 			array[array.length] = num
// 			return array
// 		}
// 	}
// }

// console.log(collatz(18));


// Esercizio 5 - Scrivere una funzione che, assegnato un numero n,  ritorni la successione di fibonacci fino al numero n sottoforma di array.
// Ad esempio 3 => [1,1,2], 9 => [1,1,2,3,5,8,13,21,34]

// function fibonacci(num) {

// 	let a = 0
// 	let b = 1
// 	let c
// 	let array = [1]

// 	for (let i = 1; i < num; i++) {

// 		c = a + b
// 		a = b
// 		b = c

// 		array[array.length] = c
// 	}

// 	return array
// }

// console.log(fibonacci(9))


// Esercizio 6 - Scrivere una funzione che, assegnato un numero n, ritorni se è primo

// function primeNumber(num) {

// 	let check;

// 	for(let i = 2; i < num; i++){

// 		if(num % i == 0) {
// 			console.log('Non è un numero primo')
// 			check = true
// 			break
// 		}
// 	}

// 	if(!check) console.log('E\' un numero primo')

// }

// primeNumber(12)


// Esercizio 7 - Scrivere una funzione che assegnata una stringa ritorni la somma delle cifre in essa presenti. Ad esempio "Sono 1 stringa di 6 parole" => 7

// function isNumber(char){
// 	return (char >= '0' && char <= '9');
// }

// let array = "Ci sono 2 coccodrilli e 1 orangotango, 2 piccoli serpenti e 5 galline"
// let sum = 0

// for (let i = 0; i < array.length; i++) {

// 	if(isNumber(array[i])) sum += Number(array[i])

// }

// console.log(sum);

//---------

// function stringNum(string) {

//     return string.split('')
//         .filter( char => Number(char) )
//         .reduce( (acc, val) => Number(acc) + Number(val) )
    
// }

// console.log(stringNum("Ci sono 2 coccodrilli e 1 orangotango, 2 piccoli serpenti e 5 galline"));


// Esercizio 8 - Scrivere una funzione che trasformi un numero in ore e minuti. Ad esempio 3014 => 50:14. Devono essere sempre presenti due cifre, sia per le ore che per i minuti

// function toHourMinutes(num) {

// 	return Math.floor(num/60) + ":" + num % 60

// }

// console.log(toHourMinutes(5100))


// Esercizio 9 - Scrivere una funzione che, assegnata una stringa, ritorni l numero di vocali presenti. gestire le maiuscole

// function vocalCount(array) {

// 	let sum = 0

// 	for (let i = 0; i < array.length; i++) {

// 		if (/[aeiouyAEIOUY]/.test(array[i])) sum++

// 	}

// 	return sum

// }

// console.log(vocalCount('Buonasera sono Massimo d\'Alema'))


// Esercizio 10 - Scrivere una funzione che accetta una stringa e restituisce la parola più lunga

// function mostLongWord(array) {

// 	let arrayWords = array.split(' ').sort((a, b) => { return b.length - a.length })
// 	return arrayWords[0]

// }

// console.log(mostLongWord('Ciao mamma guarda come mi diverto'))


// Esercizio 11 - Scrivere una funzione che accetti una stringa contenente solo caratteri x e y e ritorni true se il numero delle x è uguale al numero delle y

// function checkXY(array) {

// 	let x = 0;
// 	let y = 0;

// 	for (let i = 0; i < array.length; i++) {

// 		if (array[i] == 'x' || array[i] == 'X') x++
// 		else if (array[i] == 'y' || array[i] == 'Y') y++

// 	}

// 	if (x == y) return true
// 	else return false

    //  return x == y

// }

// while (true) {

// 	let check = true

// 	let string = prompt('Inserire stringa con sole X e Y')

// 	for (let i = 0; i < string.length; i++) {

// 		if (!/[xyXY]/.test(string[i])) {

// 			alert('Riscrivi')
// 			check = false
// 			break

// 		}

// 	}

// 	if (check) {

// 		console.log(checkXY(string))
// 		break
		
// 	}

// }


// Esercizio EXTRA - Bubble sort

// function bubbleSort(arr){
// 	let sorted
	
// 	while(!sorted){
// 		sorted = true
// 		for(let i = 0; i < arr.length; i++){
// 			if(arr[i] > arr[i+1]){
// 				let temp;
// 				temp = arr[i];
// 				arr[i] = arr[i+1]
// 				arr[i+1] = temp
// 				sorted = false
// 			}
// 		}
// 	}
// 	return arr
// }

// let array = [13,4,24,67,12,63]
// console.log(bubbleSort(array))


// Esercizio EXTRA - Reverse number

// function reverseNumber(num){
// 	let result = 0
// 	let cifra_estratta
// 	while(num > 0){
// 		// prendo l'ultima cifra
// 		cifra_estratta = num % 10

// 		// tolgo ultima cifra
// 		num = Math.floor(num / 10)

// 		// moltiplico per 10 il numero del risultato + cifra estratta
// 		result = (result * 10) + cifra_estratta
// 	}
// 	return result
// }

// console.log(reverseNumber(652))




