var bookRequest = new XMLHttpRequest();
var bookObject;
var authorRequest = new XMLHttpRequest();
var authorObject;
var id = localStorage.getItem('selectedId');
var dropdownList = document.getElementById ("InputAuthor");
console.log(id);

    bookRequest.onload = function() {
            if(bookRequest.status == 200) {
                bookObject = JSON.parse(bookRequest.responseText);
                console.log(bookObject);
                fillForm();
                getAuthorObject();
            }
        }

    bookRequest.open('GET', 'http://localhost:3300/api/getBookById/'+id, true);
    bookRequest.send(null);

function getAuthorObject() {
    authorRequest.onload = function() {
                if(authorRequest.status == 200) {
                    authorObject = JSON.parse(authorRequest.responseText);
                    console.log(authorObject);
                    popAuthorList ();
                }
            }

        authorRequest.open('GET', 'http://localhost:3300/api/authors', true);
        authorRequest.send(null);
}


function popAuthorList(){
           var authorId;
        for(var i = 0; i < authorObject.length; i++){
            var option = document.createElement('option');
            option.innerHTML =  authorObject[i].name;
            option.id = authorObject[i].id;
            console.log(authorObject[i].name + authorObject[i].id);
            dropdownList.appendChild(option);
            
            if(option.id == bookObject.authorId){
                dropdownList.selectedIndex = option.index;
            }

        }
    }


function fillForm(){
    document.getElementById("InputTitle").value = bookObject.title;
    document.getElementById("InputGenre").value = bookObject.genre;
    document.getElementById("InputPub").value = bookObject.publishedYear;
    document.getElementById("InputPrice").value = bookObject.price;
    document.getElementById("InputInv").value = bookObject.inventory;
}
