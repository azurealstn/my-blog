let index = {
  init: function() {
    $('#btn-save').on('click', () => {
      this.save();
    });
    $('#btn-update').on('click', () => {
      this.update();
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
        if (response.status === 500) {
          alert('회원가입이 실패했습니다.');
        } else {
          alert('회원가입이 완료되었습니다.');
          //console.log(response);
          location.href = '/';
        }
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
  },
  update: function() {
    let data = {
      id: $('#id').val(),
      username: $('#username').val(),
      password: $('#password').val(),
      email: $('#email').val()
    };
    $.ajax({
      type: 'PUT',
      url: '/user',
      data: JSON.stringify(data),
      contentType: 'application/json; charset=utf-8',
      dataType: 'json'
    }).done(function(response) {
        alert('회원수정이 완료되었습니다.');
        location.href = '/';
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
  }


}
index.init();