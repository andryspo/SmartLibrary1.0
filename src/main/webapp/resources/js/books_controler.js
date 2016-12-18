$(function () {
   load();
});

function addBook() {
    $.ajax({
        url: 'saveOrUpdate',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            title: $('#title').val(),
            author: $('#author').val(),
            pages: $('#pages').val(),
            genre: $('#genre').val()
        }),
        success: function (response) {
            load();
        }
    })
}

remove = function (id) {
    $.ajax({
        url: 'delete',
        type: 'post',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(id),
        success: function (response) {
            load();
        }
    })
};

update = function (id_, title_, author_, pages_, genre) {

    $("#openM")[0].click();
    initUpdateWindow(id_, title_, author_, pages_, genre);
    $('#save').click(function () {

        var id_ = $('#bookId').html();
        var title_ = $('input[name = title]').val();
        var author_ = $('input[name = author]').val();
        var pages_ = $('input[name = pages]').val();
        var genre_ = $('input[name = genre]').val();

        $.ajax({
            url: 'saveOrUpdate',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify({
                id: id_,
                title: title_,
                author: author_,
                pages: pages_,
                genre: genre_
            }),
            success: function (response) {
                load();
            }
        });
        $("#close")[0].click();
    });
};

function initUpdateWindow(id, title, author, pages, genre) {
    $('#bookId').html(id);
    $('input[name = title]').val(title);
    $('input[name = author]').val(author);
    $('input[name = pages]').val(pages);
    $('input[name = genre]').val(genre);
}

load = function () {
    $.ajax({
        url: 'list',
        type: 'post',
        success: function (response) {
            $('.tr').remove();
            for (var i = 0; i < response.data.length; i++) {
                $('#table').append('<tr class = "tr">' +
                    ' <td>' + response.data[i].id + '</td>' +
                    ' <td>' + response.data[i].title + '</td>' +
                    ' <td>' + response.data[i].author + '</td>' +
                    ' <td>' + response.data[i].pages + '</td>' +
                    ' <td>' + response.data[i].genre + '</td>' +
                    '<td><button  class="funcBtn" onclick="update(\'' + response.data[i].id + '\',\''
                    + response.data[i].title + '\',\''
                    + response.data[i].author + '\',\''
                    + response.data[i].pages + '\',\''
                    + response.data[i].genre
                    + '\')">update</button></td> ' +
                    '<td><button class="funcBtn" onclick="remove(' + response.data[i].id + ')">delete</button></td></tr>'
                )
            }
        }
    })
};

