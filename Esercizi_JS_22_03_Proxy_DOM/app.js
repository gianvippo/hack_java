// let currentUserIsAdmin = true; 
// class Person {

//     #name;
//     #surname;

//     constructor(name, surname){
//         this.setName(name)
//         this.setSurname(surname)
//     }

//     getName()
//     {
//         if(currentUserIsAdmin) return this.#name;
//         return "Non puoi vedere il nome!";
//     }


//     getSurname()
//     {
//         if(currentUserIsAdmin) return this.#surname;
//         return "Non puoi vedere il cognome!";
//     }

//     setName(value)
//     {
//         if(value == "") { throw Error('Non puoi inserire stringa vuota!') }
//         this.#name = value
//     }

//     setSurname(value)
//     {
//         if(value == "") { throw Error('Non puoi inserire stringa vuota!') }
//         this.#surname = value
//     }

// }

// const person1 = new Person("Desi", "Totaro")
// /* const person2 = new Person("Luca", "Rossi")
// const person3 = new Person("Marco", "Bianchi") */
// console.log(person1.getName())


// PROXY

let gpu = {

    name: "3070",
    brand: ""

}

let loggedUser = {

    isAdmin: true

}


let proxy = {


    get(target, propertyName) {

        if (loggedUser.isAdmin) return target[propertyName]
        else throw Error('Non puoi visualizzare')
    },

    set(target, propertyName, value) {

        console.log('Stai provando a modificare la proprietà ' + propertyName + ' che contiene ' + target[propertyName]);
        if (value == '') throw Error('Stringa vuota')
        target[propertyName] = value

    }

}

let gpuProxy = new Proxy(gpu, proxy)
gpuProxy.name = "3060"
console.log(gpuProxy.name);



let btn = document.querySelector('#bottone')
btn.addEventListener('click', onClickFunction)

let list = []
let categories = new Set()

function onClickFunction() {

    fetch('./movies.json')
        .then(resp => resp.json())
        .then(data => {

            console.log('dati arrivati')

            for (let i = 0; i < 10; i++) {
                list.push(data[i]['id'])
            }

            getDetails(list)
            
        });


}

function getDetails(list) {

    let movies = []

    list.forEach(movie => {

        fetch(`http://www.omdbapi.com/?i=${movie}&apikey=13de8338`)

            .then(resp => resp.json())
            .then(data => {

                movies.push(data)

                let cardList = document.querySelector('.cardList')
                let card = document.createElement('div')
                card.classList.add('col-12', 'col-md-3', 'mb-3')
                card.innerHTML = `
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="${data['Poster']}" alt="${data['Title']}">
                    <div class="card-body">
                        <h5 class="card-title">${data['Title']}</h5>
                        <p class="card-text">${data['Plot']}</p>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><strong>Year</strong>: ${data['Year']}</li>
                            <li class="list-group-item"><strong>Runtime</strong>: ${data['Runtime']}</li>
                            <li class="list-group-item"><strong>Genre</strong>: ${data['Genre']}</li>
                        </ul>
                    </div>
                </div>`

                cardList.appendChild(card)

                let dropdown = document.querySelector('.dropdown-menu')

                data['Genre'].split(", ").forEach(el => {

                    if (!categories.has(el)) {

                        let item = document.createElement('li')
                        item.innerHTML = `<a class="dropdown-item">${el}</a>`
                        // item.addEventListener('click', showByCategories)
                        dropdown.appendChild(item)

                    }

                    categories.add(el)


                })


                // function showByCategories(el) {

                //     let cardList = document.querySelector('.cardList')
                //     cardList.innerHTML = ""
                //     movies.forEach(movie => {
    
                //         if (movie['Genre'].split(", ").includes(el)) {
    
                //             let card = document.createElement('div')
                //             card.classList.add('col-12', 'col-md-3', 'mb-3')
                //             card.innerHTML = `
                //                 <div class="card" style="width: 18rem;">
                //                     <img class="card-img-top" src="${movie['Poster']}" alt="${movie['Title']}">
                //                     <div class="card-body">
                //                         <h5 class="card-title">${movie['Title']}</h5>
                //                         <p class="card-text">${movie['Plot']}</p>
                //                         <ul class="list-group list-group-flush">
                //                             <li class="list-group-item"><strong>Year</strong>: ${movie['Year']}</li>
                //                             <li class="list-group-item"><strong>Runtime</strong>: ${movie['Runtime']}</li>
                //                             <li class="list-group-item"><strong>Genre</strong>: ${movie['Genre']}</li>
                //                         </ul>
                //                     </div>
                //                 </div>`
    
                //             cardList.appendChild(card)
    
                //         }
    
                //     })
    
                // }

            });

    });

    return movies

}

