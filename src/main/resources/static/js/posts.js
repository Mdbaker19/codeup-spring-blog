$(document).ready(function (){

    const request = $.ajax({'url': '/post.json'});
    request.done(function (post){
       let html = "";
       post.forEach(post => {
          html+=`<div class="card">
                    <h1 class="card-title">${post.title}</h1>
                    <p class="card-content">${post.body}</p>
                </div><br>`;
       });
       $("#ajaxPost").html(html);
    });

});