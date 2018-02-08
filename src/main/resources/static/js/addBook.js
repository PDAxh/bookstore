var dropdownList = document.getElementById("InputAuthor");
var xhr = new XMLHttpRequest();
var authorObject;
console.log("RUNNING");

xhr.onload = function () {
    if (xhr.status == 200) {
        var authorObject = JSON.parse(xhr.responseText);
        popAuthorList(authorObject);
    }
};

xhr.open('GET', 'http://localhost:3300/api/authors', true);
xhr.send(null);

function popAuthorList(authorObject){
        for(var i = 0; i < authorObject.length; i++){
            var option = document.createElement('option');
            option.innerHTML = authorObject[i].name;
            option.value = authorObject[i].id;
            dropdownList.appendChild(option);
        }
    }

function addBook() {


console.log("HEJHEJEHEJEHEJEHEJ");
    var title = document.getElementById("InputTitle").value;
    var genre = document.getElementById("InputGenre").value;
    var published = document.getElementById("InputPub").value;
    var price = document.getElementById("InputPrice").value;
    var inventory = document.getElementById("InputInv").value;
    var authorId = document.getElementById("InputAuthor").value;
    var author = document.getElementById("InputAuthor").options[dropdownList.selectedIndex].innerHTML;

    var package = JSON.stringify({"title": title, "genre": genre, "publishedYear": published, "price": price, "inventory": inventory, "author": author, "rating" : 0, "authorId" :  authorId});
    var bookRequest = new XMLHttpRequest();

    bookRequest.open('POST', 'http://localhost:3300/api/addBook', true);
        bookRequest.setRequestHeader("Content-type", "application/json");
        bookRequest.onreadystatechange = function () {
        console.log("ALLT ÄR BRA");
            if( bookRequest.readyState=== 4 && bookRequest.status===200){
                var json = JSON.parse(bookRequest.responseText);
                console.log(json.name )
                location.reload;

            }
        };

        bookRequest.send(package);
}