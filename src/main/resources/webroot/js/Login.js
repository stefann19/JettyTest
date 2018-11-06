function doSHIT(){
    var Account  = {
        id:0,
        name:$('#name').val(),
        email:$('#email').val()};
    var url = window.location.toString().replace('/Test.html','/') + "Login/";
    $.ajax({
        url:url,
        type:'POST',
        dataType:'json',
        data:JSON.stringify(Account),
        contentType: 'application/json',
        mimeType: 'application/json',
        success:function (data) {
            $('#status').text= data.id;
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    })
}
