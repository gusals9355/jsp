let frmElem = document.querySelector('#frm');
let uidElem = frmElem.uid;
let upwElem = frmElem.upw;
let chkUpwElem = frmElem.chkUpw;
let unmElem = frmElem.unm;

let chkUidResultElem = document.querySelector('#chkUidResult');
let btnChkIdElem = frmElem.btnChkId;

function goBack(){
    history.back();
}

btnChkIdElem.addEventListener('click',function (){
    idChkAjax(uidElem.value);
});



function idChkAjax(uid){
    const param = {uid}
    const init = {
        method: 'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body: JSON.stringify(param)
    }
    fetch('/user/idChk',init)
        .then(res => res.json())
        .then(myJson => {
            if(myJson == 0){
                chkUidResultElem.innerText = '이 아이디는 사용 가능합니다';
            }else if(myJson == 1){
                chkUidResultElem.innerText = '이미 사용중인 아이디입니다.';
            }
        })

}

function frmChk(){

    let uidVal = uidElem.value;
    if(uidVal.length < 3) {
        if(uidVal.length == 0)
            alert('아이디를 작성해주세요.');
        else
            alert('아이디 3글자 이상작성');
        return false;
    }

    let upwVal = upwElem.value;
    let chkUpwVal = chkUpwElem.value;

    if(upwVal.length <=3 || chkUpwVal <=3){
        if(upwVal.length == 0 || chkUpwVal == 0){
            alert('비밀번호를 작성해주세요');
        }else{
            alert('3글자 이상 작성해주세요');
        }
        return false;
    }else if(upwVal !== chkUpwVal){
        alert('비밀번호 확인해주세요');
        return false;
    }

    if(unmElem.value.length < 2){
        alert('2자 이상 작성해주세요');
        return false;
    }

}