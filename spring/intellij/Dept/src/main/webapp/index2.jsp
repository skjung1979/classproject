<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="/dept/list">dept list</a>
<br/>
<a href="/emp/list">emp list</a>

<%--<script>
    console.log(1)
    console.log(2)
    setTimeout(() => console.log(3), 1000) /* 1초 후에 실행된다. */
    console.log(4)
</script>--%>

<%--<script>
    const xhr = new XMLHttpRequest(); // 생성
    //xhr.open('get', 'https://jsonplaceholder.typicode.com/todos/1'); // 오픈
    xhr.open('get', '/api/v1/depts/50'); // 오픈
    xhr.send();

    xhr.onreadystatechange = () => {
        if (xhr.readyState !== XMLHttpRequest.DONE){ // 완료되지 않았다면
            return; // 아무것도 처리하지 않는다.
        }

        if (xhr.status === 200){ // 정상 응답이 들어왔으면
            console.log(JSON.parse(xhr.response)) // 콘솔에 출력함
        } else {
            console.log("error", xhr.status, xhr.statusText)
        }
    }

    // callback 함수로
    // get -> put -> get -> post 통신들을 한다고 가정한다.

    // 예를 들어 get()메소드에 put()함수를 넣는다. -> get(put())
    // put()도 마찬가지로 put()안에 get()이 들어가야 한다. -> put(get())
    // get()도 마찬가지로 get()안에 put()이 들어가야 한다. -> get(put())
    // post()도 마찬가지로 post()안에 get()이 들어가야 한다. -> post(get()
    // ==> 이것이 콜백함수인데,,,
    // 이러한 콜백의 단점을 보완하기 위해서 프로미스 개념이 나타났다.


</script>--%>

<script>
    const request = {
        get(url){
            return fetch(url)
        },
        post(url, payload){
            return fetch(url, {
                method : 'POST',
                headers : {'content-Type' : 'application/json'},
                body : JSON.stringify(payload)
            })
        },
        put(url, payload){
            return fetch(url, {
                method : 'PUT',
                headers : {'content-Type' : 'application/json'},
                body : JSON.stringify(payload)
            })
        },
        delete(url){
            return fetch(url, {method: 'DELETE'})
        }
    }

    // 자바스크립트 문에서 페이지를 오픈하기 위함이다. 이것이 비동기 식이다.
  /*  request.get('/api/v1/depts/50')
        .then(response => {
            if (!response.ok){ // 정상 응담이 아니라면
                throw new Error(response.statusText);
            }
            // 정상 응답이라면
            return response.json(); // list를 반환
        })
        .then(list => console.log(list))
        .catch(err => console.log(err))*/

    request.get('/api/v1/depts/50')
        .then(response => {
            if (!response.ok){ // 정상 응담이 아니라면
                throw new Error(response.statusText);
            }
            // 정상 응답이라면
            return request.get('/api/v1/depts/10');
        })
        .then(list => console.log(list))
        .catch(err => console.log(err))


    request.post('/api/v1/depts', {deptno: 23, dname: 'test23', loc: 'testloc'})
        .then(response => {
            if (!response.ok){
                return new Error(response.statusText)
            }
            console.log(response)
        })
        .catch(err => console.log(err))

    request.put('/api/v1/depts/22', {deptno: 22, dname: '기획팀', loc: '부산'}) // 업데이트 이므로 성공하면 따로 처리 안해도 됨.
        .catch(err => console.log(err))

    request.delete('/api/v1/depts/23')
        .then(res => { /*res는 뭘로해도 상관 없다.*/
            console.log("삭제 완료! => " + res)
        })

</script>

</body>
</html>