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

    if (localStorage.length != 0){


        for (let i = 0; i < localStorage.length; i++) {

            const key = idx++;
            newTr.setAttribute('data-key', key)
            const receiveData = JSON.parse(localStorage.getItem(key))

            const newTr = document.createElement('tr')

            let inner = `<tr data-key="${i}">
                    <td><span>${i}</span></td>
                    <td><span>${receiveData[0]}</span></td>
                    <td><span>${receiveData[1]}</span></td>
                    <td><span>${receiveData[3]}</span></td>
                    <td><button id="del_${i}">삭제</button></td>
                </tr>`;
            newTr.innerHTML = inner;

            tbodyId.append(newTr);

        };

    };


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

    // submit 버튼 기능 없애기
    inputForm.addEventListener('submit', (event) => {
        event.preventDefault();
    });

    // addMem 핸들러 함수
    const addMem = () => {

        const inputAll = [inputId.value, inputPw.value, inputRepw.value, inputUsername.value];

        const arrInput = [inputAll];

        localStorage.setItem(idx, JSON.stringify(inputAll)) 

        //console.log(JSON.stringify(inputAllobj));
        // localStorage.setItem('id', JSON.stringify(inputAllobj.id))
        // localStorage.setItem('pw', JSON.stringify(inputAllobj.pw))
        // localStorage.setItem('username', JSON.stringify(inputAllobj.username))

        // 값이 없으면 정보를 입력하라는 알림창
        if (inputId.value.trim() === '' || inputPw.value.trim() === '' || inputUsername.value.trim() === '') {
            alert('입력하지 않은 항목이 있으니 입력해 주세요.')
        };

        const newTr = document.createElement('tr')
        //const btn = document.createElement('button')

        const key = idx++;
        newTr.setAttribute('data-key', key)

        ///btn.textContent = '삭제';

        // console.log(JSON.parse(localStorage.getItem(key)))

        // const a = JSON.parse(localStorage.getItem(key));

        const receiveData = JSON.parse(localStorage.getItem(key))

    
        console.log(receiveData[0]);
        console.log(receiveData[1]);
        console.log(receiveData[3]);


        // let inner = `<tr data-key="${key}">
        //                 <td><span>${key}</span></td>
        //                 <td><span>${inputId.value}</span></td>
        //                 <td><span>${inputPw.value}</span></td>
        //                 <td><span>${inputUsername.value}</span></td>
        //                 <td><button id="del_${key}">삭제</button></td>
        //             </tr>`;

        let inner = `<tr data-key="${key}">
                    <td><span>${key}</span></td>
                    <td><span>${receiveData[0]}</span></td>
                    <td><span>${receiveData[1]}</span></td>
                    <td><span>${receiveData[3]}</span></td>
                    <td><button id="del_${key}">삭제</button></td>
                </tr>`;

        newTr.innerHTML = inner;
                    
        tbodyId.append(newTr)
        
        let delBtn = document.querySelector(`#del_${key}`)

        delBtn.addEventListener('click', () => {
            
            delList(key)

            localStorage.removeItem(key)
  
        });

        // inputId.value = '';
        // inputPw.value = '';
        // inputRepw.value = '';
        // inputUsername.value = '';

    }

    const delList = (key) => {
        const delLine = document.querySelector(`tr[data-key="${key}"]`);
        tbodyId.removeChild(delLine);
    }

    addBtn.addEventListener('click', addMem);

});


