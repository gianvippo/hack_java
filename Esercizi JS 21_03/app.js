// function expression

function sayHi() {
    console.log('hello');
}

let fun = sayHi
fun()   // Richiamo la variabile fun che possiede sia il corpo della funzione che il suo scope


//-------------------
// Passiamo a una funzione due funzioni qualsiasi

// function ask(question, yes, no) {
//     confirm(question) ? yes() : no()
// }

// function ifYes() {
//     console.log('Confirmed');
// }  

// function ifNo() {
//     console.log('Not Confirmed');
// }

// ask('Are you sure?', ifYes, ifNo)   // anche senza parentesi!!!




let doubleAndLog = (num) => num * 2

let halfAndLog = (num) => num * 2

function sumThreeAndLog(num) {
    const summed = num * 2
    console.log(`il nuovo numero è ${summed}`);
}


function changeAndLog(num, istruzioni) {
    const changed = istruzioni(num)
    console.log(`il nuovo numero è ${changed}`);
}

changeAndLog(10, doubleAndLog)




let incrementatore = function (incremento) {
    return function (valore) {
        return incremento + valore
    }
}

let incrementadicinque = incrementatore(5)      // Assegnamo a incrementadicinque IL CORPO DELLA FUNZIONE contenuto in incrementatore
console.log(incrementadicinque(4));             // Ora incrementadicinque avrà il return incremento + valore, quindi anche lo scope e
                                                // quindi il valore 5 passato prima RIMANE all'interno della variabile



function outer() {

    let counter = 1                             // Nonostante il counter++ stia nella funzione della funzione, incrementa la prima
                                                // variabile che trova che si chiama counter, risalendo la pila e gli scope
    function incrementCounter() {
        console.log(counter)
        return counter++
    }
    return incrementCounter
}

const newFunction = outer()
newFunction()
newFunction()
newFunction()




// let saluto = "buongiorno"

// function saluta(persona) {
//     let fullname = persona.nome + " " + persona.cognome
//     function visualizzasaluto() {
//         console.log(saluto + " " + fullname);
//     }
//     visualizzasaluto()                                      // visualizzaSaluto() NON esce dallo scope della funzione saluta()
// }

// saluta({nome: "Pippo", cognome: "Franco"})



let saluto = "buongiorno"

function saluta(persona) {
    let fullname = persona.nome + " " + persona.cognome

    return function() {                                         // Ritorniamo alla funzione saluta() un'altra funzione, quindi possiamo
        console.log(saluto + " " + fullname);                   // assegnare saluta() a una variabile e di conseguenza la funzione ritornata e il suo scope
    }

}

let visualizzaSaluto = saluta({nome: "Pippo", cognome: "Franco"})
visualizzaSaluto()




// REDUCE
// funzionamento
function reduce(arr) {
    let acc = 0
    for(const number of arr) { acc = acc + number }
    return acc
}

let arr = [1,2,3,4,5,6,7,8]
const summed = arr.reduce ( (acc, el) => { return [...acc, el] }, [] )    // [] VALORE DI DEFAULT, ricordarsi il return
console.log(summed);



// INIZIALI
function iniziali(string) {
    return string.split(' ').map(el => el[0]+'.').join('')      // concatenazione dei metodi degli array
}

console.log(iniziali('Tizio Caio')); 


// SOMMA DEI NUMERI IN STRINGA
function sumString(string) {
    return string.split('').filter( char => Number(char) ).reduce( (acc, val) => Number(acc) + Number(val) )
}

console.log(sumString('Ci sono 2 coccodrilli e 1orango tango 2 serpenti e 5 galline'));    



// MAP

