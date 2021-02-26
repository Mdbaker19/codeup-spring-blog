$(document).ready(function (){

    const request = $.ajax({'url': '/post.json'});
    request.done(function (post){
       let html = "";
       post.forEach(post => {
           console.log(post);
           html+=`<div class="col s12">
                    <div class="card darken-1 hoverable">
                        <div class="card-content">
                            <p class="right">${post.date.toString().substring(0, 11)}</p>
                            <span class="card-title center-align">${post.title}</span>
                            <div class="divider"></div>
                            <p>${post.body}"</p>
                        </div>
                        <div class="card-action">
                            <h4 class="left grey-text">${post.author}</h4>
                            <a href="/post/${post.id}"><button class="waves-effect waves-light btn moreButton">See More</button></a>
                        </div>
                    </div>
                </div>`;
       });
       $("#ajaxPost").html(html);
    });

});