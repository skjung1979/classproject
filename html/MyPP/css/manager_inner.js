document.addEventListener('DOMContentLoaded', () => {

    // 문서 객체 생성
    const inputForm = document.querySelector('form');
    const inputId = document.querySelector('#userID')
    const inputPw = document.querySelector('#pw')
    const inputRepw = document.querySelector('#repw')
    const inputUsername = document.querySelector('#userName')
    const addBtn = document.querySelector('#addBtn')
    const tbodyId = document.querySelector('#list')
    const editForm = document.querySelector('#editFormArea')

    // 아이디 형식 체크
    inputId.addEventListener('focusout', () => {
        if (!(/[a-zA-Z0-9]/.test(inputId.value))) {
            alert('아이디 형식에 맞춰주세요. 영문 대소문자와 숫자.')

        }
    })

    // 비번 형식 체크
    inputPw.addEventListener('focusout', () => {
        if (!(/[a-zA-Z0-9]/.test(inputPw.value))) {
            alert('비밀번호 형식에 맞춰주세요. 영문 대소문자와 숫자.')

        }
    })

    // 이름 형식 체크
    inputUsername.addEventListener('focusout', () => {
        if (!(/[a-zA-Z가-힣]/.test(inputUsername.value))) {
            alert('이름 형식에 맞춰주세요. 한글 영문 대소문자')

        }
    })

    // 암호 체크 확인
    inputRepw.addEventListener('focusout', () => {
        if (!(inputPw.value === inputRepw.value)) {
            alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.')
            inputPw.focus();
        }
    });

    let idx = 0;

    inputForm.addEventListener('submit', (event) => {
        event.preventDefault();
    });

    // addMem 핸들러 함수
    const addMem = () => {

        const inputAll = [inputId.value, inputPw.value, inputRepw.value, inputUsername.value];

        const inputAllobj = {

            id: inputId.value,
            pw: inputPw.value,
            username: inputUsername.value

        }

        //console.log(JSON.stringify(inputAllobj));

        localStorage.setItem('id', JSON.stringify(inputAllobj.id))
        localStorage.setItem('pw', JSON.stringify(inputAllobj.pw))
        localStorage.setItem('username', JSON.stringify(inputAllobj.username))

        console.log(localStorage.getItem('id'))
        console.log(localStorage.getItem('pw'))
        console.log(localStorage.getItem('username'))

        



        // 값이 없으면 정보를 입력하라는 알림창
        if (inputId.value.trim() === '' || inputPw.value.trim() === '' || inputUsername.value.trim() === '') {
            alert('입력하지 않은 항목이 있으니 입력해 주세요.')
        };

        const newTr = document.createElement('tr')
        const btn = document.createElement('button')

        const key = idx++;
        newTr.setAttribute('data-key', key)

        btn.textContent = '삭제';

        let inner = `<tr data-key="${key}">
                        <td><span>${key}</span></td>
                        <td><span>${inputId.value}</span></td>
                        <td><span>${inputPw.value}</span></td>
                        <td><span>${inputUsername.value}</span></td>
                        <td><button id="del_${key}">${btn.textContent}</button></td>
                    </tr>`;
        newTr.innerHTML = inner;
                    
        tbodyId.append(newTr)
        
        let delBtn = document.querySelector(`#del_${key}`)

        delBtn.addEventListener('click', () => {
            delList(key)

            localStorage.removeItem('id')
            localStorage.removeItem('pw')
            localStorage.removeItem('username')

        });

        inputId.value = '';
        inputPw.value = '';
        inputRepw.value = '';
        inputUsername.value = '';

    }

    const delList = (key) => {
        const delLine = document.querySelector(`tr[data-key="${key}"]`);
        tbodyId.removeChild(delLine);
    }

    addBtn.addEventListener('click', addMem);

});


