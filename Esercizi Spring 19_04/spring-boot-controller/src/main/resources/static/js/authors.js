const alertMessage = document.querySelector("#alertMessage")
const deleteButtons = document.querySelectorAll(".delete-btn")
deleteButtons.forEach((deleteButton) => {
    deleteButton.addEventListener("click", (event) => {
        const id = deleteButton.getAttribute("data-id")
        fetch(`/api/authors/${id}`, {
            method: "DELETE"
        }).then((res) => {
            if(res.status >= 200 && res.status < 400) {
                window.location.reload()
            } else {
                return res.json()   //-> converto il risultato in json e lo passo alla funzione successiva
            }
        }).then((error) => {
            const alertElement = document.createElement("div")
            alertElement.classList.add("alert", "alert-danger", "alert-dismissible")    //-> creo un div e metto l'errore col corpo
            alertElement.role = "alert"
            alertElement.innerHTML = `
                <i class="fa-solid fa-triangle-exclamation"></i>
                <span class="mx-3">Status: ${error.status}</span>
                <span class="mx-3">Error: ${error.message}</span>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>`
            alertMessage.appendChild(alertElement)
        })
    })
})