var bookRequest = new XMLHttpRequest();
var bookObject;
var id = localStorage.getItem('selectedId');
console.log(id);

    bookRequest.onload = function() {
            if(bookRequest.status == 200) {
                bookObject = JSON.parse(bookRequest.responseText);
                console.log(bookObject);
                fillForm();
            }
        }

    bookRequest.open('GET', 'http://localhost:3300/api/getBookById/'+id, true);
    bookRequest.send(null);



function fillForm(){
    document.getElementById("InputTitle").value = bookObject.title;
    document.getElementById("InputGenre").value = bookObject.genre;
    document.getElementById("InputPub").value = bookObject.publishedYear;
    document.getElementById("InputPrice").value = bookObject.price;
    document.getElementById("InputInv").value = bookObject.inventory;
}
