let cmtRemeElem = document.querySelector('#cmtFrm');
function regCmt(){
    let cmtVal = cmtRemeElem.cmt.value;

    var param = {
        iboard: cmtRemeElem.dataset.iboard,
        cmt: cmtVal
    };

    regAjax(param);
}

function regAjax(param){
    const init = {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(param)
    }

    fetch('cmtInsSel',init)
        .then(function (res){
        return res.json();
    }).then(function (myJson){
        console.log(myJson);
        switch (myJson){
            case 0:
                alert('등록 실패');
                break;
            case 1:
                alert('등록 완료!');
                break;
        }
    });
}

//서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax(){
    let iboard = cmtRemeElem.dataset.iboard;

    fetch('/board/cmtInsSel?iboard='+iboard)
        .then(function (res){
            return res.json();
        }).then(function (myJson){
           // console.log(myJson);
    })
}

getListAjax(); // 이 파일이 임포트되면 함수 1회 호출