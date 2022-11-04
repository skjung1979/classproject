
document.addEventListener('DOMContentLoaded', () => {

    // 문서 객체 생성
    const input = document.querySelector("#newTodo");
    const addBtn = document.querySelector("#addBtn");
    const todolist = document.querySelector("#todoList");

    let cnt = 0;

    // 핸들러 함수: 할일 추가하기 누르면 발생하는 이벤트 및 관련 변수들
    const addTodo = () => {

        // 값이 없을 경우 경고창이 띄운다.
        if(input.value.trim() === ''){
            alert('할일을 입력해주세요.');
            return
        };

        // 동적으로 추가할 엘리먼트 생성
        const newDiv = document.createElement('div');
        const checkbox = document.createElement('input');
        const todo = document.createElement('span');
        const btn = document.createElement('button');

        newDiv.appendChild(checkbox);
        newDiv.appendChild(todo);
        newDiv.appendChild(btn);

        // 속성 설정
        newDiv.style.padding = '10px';
        
        const key = cnt++;
        newDiv.setAttribute('data-key', key); // 삭제할 때 식별하기 위해서

        checkbox.type = 'checkbox';
        todo.textContent = input.value;
        btn.textContent = '할일 삭제';

        // 이벤트 적용: 타켓이 변경되면 텍스트 중간선 넣기
        checkbox.addEventListener('change', (event) => {
            
            todo.style.textDecoration = event.target.checked ? 'line-through' : '';
        });

        // 삭제 버튼에 이벤트 걸기
        btn.addEventListener('click', () => {
            // 밖에서 선언한 함수 호출
            removeTodo(key);
        });

        // todolist에 새로운 div를 추가한다.
        todolist.appendChild(newDiv);

        input.value = '';

    }

    const removeTodo = function(key){

        const delElement = document.querySelector(`div[data-key="${key}"]`);
        todolist.removeChild(delElement);

    };

    // 이벤트 연결
    addBtn.addEventListener('click', addTodo);


});