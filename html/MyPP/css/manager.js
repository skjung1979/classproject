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
        if(!(/[a-zA-Z0-9]/.test(inputId.value))){
            alert('아이디 형식에 맞춰주세요. 영문 대소문자와 숫자.')
         
        }
    })

    // 비번 형식 체크
    inputPw.addEventListener('focusout', () => {
        if(!(/[a-zA-Z0-9]/.test(inputPw.value))){
            alert('비밀번호 형식에 맞춰주세요. 영문 대소문자와 숫자.')
          
        }
    })

    // 이름 형식 체크
    inputUsername.addEventListener('focusout', () => {
        if(!(/[a-zA-Z가-힣]/.test(inputUsername.value))){
            alert('이름 형식에 맞춰주세요. 한글 영문 대소문자')
           
        }
    })



    // 암호 체크 확인
    inputRepw.addEventListener('focusout', () => {
        if (!(inputPw.value === inputRepw.value)){
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

        // 값이 없으면 정보를 입력하라는 알림창
        if (inputId.value.trim() === '' || inputPw.value.trim() === '' || inputUsername.value.trim() === '' ){
            alert('입력하지 않은 항목이 있으니 입력해 주세요.')
        };

        console.log(inputAll);

        // 동적 추가 엘리먼트 생성
        // 반복되는 것은 아래 방법 말고 innerhtml로 담거나, 객체로 만들어 놓거나, 메소드로 빼거나 하는 방법을 생각해보자!!! 
        const newTr = document.createElement('tr') 
        const newTd1 = document.createElement('td')
        const newTd2 = document.createElement('td')
        const newTd3 = document.createElement('td')
        const newTd4 = document.createElement('td')
        const newTd5 = document.createElement('td')
        const newSpan1 = document.createElement('span')
        const newSpan2 = document.createElement('span')
        const newSpan3 = document.createElement('span')
        const newSpan4 = document.createElement('span')
        const btn = document.createElement('button')

        tbodyId.appendChild(newTr)
        newTr.appendChild(newTd1) 
        newTd1.appendChild(newSpan1)
        newTr.appendChild(newTd2)
        newTd2.appendChild(newSpan2)
        newTr.appendChild(newTd3)
        newTd3.appendChild(newSpan3)
        newTr.appendChild(newTd4)
        newTd4.appendChild(newSpan4)
        newTr.appendChild(newTd5)
        newTd5.appendChild(btn)

        const key = idx++;
        newTr.setAttribute('data-key', key)

        newSpan1.textContent = key
        newSpan2.textContent = inputAll[0]
        newSpan3.textContent = inputAll[1]
        newSpan4.textContent = inputAll[3]
        btn.textContent = '삭제';

        // btn에 삭제 이벤트 걸기
        btn.addEventListener('click', () => delList(key));

    }
    
    const delList = (key) => {
        const delLine = document.querySelector(`tr[data-key="${key}"]`);
        tbodyId.removeChild(delLine);
    }

    addBtn.addEventListener('click', addMem);

});


