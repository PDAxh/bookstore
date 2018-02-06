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
    var bookTable = '<table class="table"><thead><tr><th scope="col">Title</th><th scope="col">Genre</th><th scope="col">Author</th><th scope="col">Published</th><th scope="col">Price</th><th>Rating</th><th scope="col">Inventory<th scope="col"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></th><tr></thead><tbody>';

    $.each(data, function(key, item){

        bookTable += '<tr><td scope="row"><p>' + item.title + '</p></td><td scope="row"><p>' + item.genre + '</p></td><td scope="row"><p>' + item.author + '</p></td><td scope="row"><p>' + item.publishedYear + '</p></td><td scope="row"><p>' + item.price + '</p></td><td scope="row"><p>' + item.rating + '</p></td><td scope="row"><p>' + item.inventory + '</p></td><td scope="row">   <button type="button" class="btn btn-default" value="'+ item.id +'" onclick="addInv(this.value)"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button><button type="button" class="btn btn-default" value="'+ item.id +'" onclick="removeInv(this.value)"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button><a href="editBook.html"><button type="button" class="btn btn-primary" aria-label="Left Align" value="'+item.id+'" onclick="transferId(this.value)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></a><button type="button" class="btn btn-danger" aria-label="Left Align" value="' + item.id +'" onclick="deleteBook(this.value)"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button><button type="button" class="btn btn-warning" aria-label="Left Align" data-toggle="modal" href="#myModal" value="' + item.id +'" onclick="setBookToRate(this.value)"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Rate</button><a href="ratingStatistics.html"><button type="button" class="btn btn-info" aria-label="Left Align"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span></button></a></td></tr>';

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
            bookToPut = {"title" : responseObject[i].title, "author" : responseObject[i].author, "genre" : responseObject[i].genre, "publishedYear" : responseObject[i].publishedYear, "rating" : rating, "price" : responseObject[i].price, "inventory" : responseObject[i].inventory };
            console.log(bookToPut);
          }
         }

                     $.ajax({
                         url: 'http://localhost:3300/api/updateBook/' + bookToRate,
                         type: 'PUT',
                         dataType: 'json',
                         contentType : 'application/json',
                         data: JSON.stringify(bookToPut),
                         success: function (data, textStatus, xhr) {
                            console.log("Entity successfully saved");
                            console.log(data);
                         },
                         error: function (xhr, textStatus, errorThrown) {
                             console.log('Error in Operation');
                         }
                     });
}

function addInv(id) {
    updateInv(id, "add");
}

function removeInv(id) {
    updateInv(id, "remove");
}

function deleteBook(id) {
    var deleteBookWarning = confirm("Are you sure you want to delete?");
    if (deleteBookWarning)
    $.ajax({
        url: 'http://localhost:3300/api/deleteBooks/' + id,
        type: 'DELETE',
        success: function(result) {
            console.log("Book has been deleted");
            location.reload();
        }
    });
}

function updateInv(id, type){

console.log(type);

    var bookToPut = new Object;

            for (var i = 0; i < responseObject.length; i++){
              if (responseObject[i].id == id){
                bookToPut = {"title" : responseObject[i].title, "author" : responseObject[i].author, "genre" : responseObject[i].genre, "publishedYear" : responseObject[i].publishedYear, "rating" : responseObject[i].rating, "price" : responseObject[i].price, "inventory" : responseObject[i].inventory };
                if(type == "add"){
                    bookToPut.inventory++;
                    console.log(bookToPut);
                } else if (type == "remove") {
                    bookToPut.inventory--;
                    if (bookToPut.inventory < 0)
                        bookToPut.inventory = 0;
                    console.log(bookToPut);
                } else {
                console.log("Something went wrong!");
                }
              }
             }

                         $.ajax({
                             url: 'http://localhost:3300/api/updateBook/' + id,
                             type: 'PUT',
                             dataType: 'json',
                             contentType : 'application/json',
                             data: JSON.stringify(bookToPut),
                             success: function (data, textStatus, xhr) {
                                console.log("Entity successfully saved");
                                console.log(data);
                                location.reload();
                             },
                             error: function (xhr, textStatus, errorThrown) {
                                 console.log('Error in Operation');
                             }
                         });
}

function transferId(id){
localStorage.setItem('selectedId', id);
}