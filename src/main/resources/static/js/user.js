let index = {
  init: function() {
    $('#btn-save').on('click', () => {
      this.save();
    });

  },

  save: function() {
    let data = {
      username: $('#username').val(),
      password: $('#password').val(),
      email: $('#email').val()
    };
    console.log(data);
    //ajax 호출시 default가 비동기 호출
    $.ajax({
      type: 'POST',
      url: '/auth/joinProc',
      data: JSON.stringify(data), //http body 데이터
      contentType: 'application/json; charset=utf-8', //body 데이터의 타입(MIME)
      dataType: 'json' //응답이 string이 아닌 json
    }).done(function(response) {
        alert('회원가입이 완료되었습니다.');
        //console.log(response);
        location.href = '/';
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
  }

}
index.init();