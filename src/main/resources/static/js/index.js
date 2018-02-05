var xhr = new XMLHttpRequest();
var bookToRate;
var responseObject;

    xhr.onload = function() {
            if(xhr.status == 200) {
                responseObject = JSON.parse(xhr.responseText);
                console.log(responseObject);
                createBookTable(responseObject);
            }
        }

    xhr.open('GET', 'http://localhost:3300/api/books', true);
    xhr.send(null);

function createBookTable(data) {
console.log(data);
    var bookTable = '<table class="table"><thead><tr><th scope="col">Title</th><th scope="col">Genre</th><th scope="col">Author</th><th scope="col">Published</th><th scope="col">Price</th><th>Rating</th><th scope="col">Invetory><th scope="col"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></th><tr></thead><tbody>';

    $.each(data, function(key, item){
        bookTable += '<tr><td scope="row"><p>' + item.title + '</p></td><td scope="row"><p>' + item.genre + '</p></td><td scope="row"><p>' + item.author + '</p></td><td scope="row"><p>' + item.publishedYear + '</p></td><td scope="row"><p>' + item.price + '</p></td><td scope="row"><p>' + item.rating + '</p></td><td scope="row"><p>' + item.inventory + '</p></td><td scope="row">   <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button><a href="editBook.html"><button type="button" class="btn btn-primary" aria-label="Left Align"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></a><button type="button" class="btn btn-danger" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button><button type="button" class="btn btn-warning" aria-label="Left Align" data-toggle="modal" href="#myModal" value="' + item.id +'" onclick="setBookToRate(this.value)"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Rate</button></td></tr>';
    });
    console.log(bookTable);
    bookTable += '</tbody></table>';
    $('#bookTableContainer').html(bookTable);
}

function setBookToRate(value) {
    bookToRate = value;
    console.log(value);
}

function rateBook(rating) {

    var bookToPut = new Object;

        for (var i = 0; i < responseObject.length; i++){
          if (responseObject[i].id == bookToRate){
            bookToPut = responseObject[i];
            bookToPut.rating = parseInt(rating);
            console.log(bookToPut);
          }
         }

         var jsonTest = {"title" : "test title", "author" : "test author", "genre" : "Test genre", "publishedYear" : 1900, "rating" : 1, "price" : 10, "inventory" : 10 }


                     $.ajax({
                         url: 'http://localhost:3300/api/updateBook/' + bookToRate,
                         type: 'PUT',
                         dataType: 'json',
                         data: jsonTest,
                         success: function (data, textStatus, xhr) {
                            console.log("Entity successfully saved");
                            console.log(data);
                         },
                         error: function (xhr, textStatus, errorThrown) {
                             console.log('Error in Operation');
                         }
                     });
}

/*
ADD BOOK
- get authors
- add book

EDIT BOOK

ADD AUTHOR X

EDIT AUTHOR
- Get authors
- put author

INDEX
- get books
- rate
- change inventory



*/