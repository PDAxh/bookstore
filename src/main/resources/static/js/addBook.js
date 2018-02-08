var xhr = new XMLHttpRequest();
console.log("RUNNING");

xhr.onload = function () {
    if (xhr.status == 200) {
        var responseObject = JSON.parse(xhr.responseText);
        console.log(responseObject);
    }
};

xhr.open('GET', 'http://localhost:3300/api/authors', true);
xhr.send(null);

function addBook() {
    var title = document.getElementById("InputTitle").value;
    var genre = document.getElementById("InputGenre").value;
    var published = document.getElementById("InputPub").value;
    var price = document.getElementById("InputPrice").value;
    var inventory = document.getElementById("InputInv").value;
    var author = document.getElementById("InputAuthor").value;

    var data = JSON.stringify({"title": title, "genre": genre, "published": published, "price": price, "inventory": inventory, "author": author });

    xhr.open('POST', 'http://localhost:3300/api/addAuthor', true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = function () {
        if( xhr.readyState=== 4 && xhr.status===200){
            var json = JSON.parse(xhr.responseText);
            console.log(json.name )

        }

    };
    xhr.send(data);
}