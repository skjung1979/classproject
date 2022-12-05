<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>

    <%-- bootstrap v5.2 --%>
    <link  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


</head>
<body>

<%--nav include--%>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>


<main class="p-2">

    <div class="card">
        <div class="card-header">
            <h3 class="title">Basic Board Article Read</h3>
        </div>
        <div class="card-body">


            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title" value="${board.title}" readonly>
                <%--<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control" id="content" name="content" rows="3"  readonly>${board.content}</textarea>
            </div>
            <div class="mb-3">
                <label for="writer" class="form-label">작성자</label>
                <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}"  readonly>
            </div>
            <div class="mb-3">
                <label for="regdate" class="form-label">등록일</label>
                <input type="text" class="form-control" id="regdate" name="regdate" value="${board.regdate}"  readonly>
            </div>
            <div class="mb-3">
                <label for="updatedate" class="form-label">수정일</label>
                <input type="text" class="form-control" id="updatedate" name="updatedate" value="${board.updatedate}"  readonly>
            </div>

            <div class="text-end m-3">
                <a href="/board/edit?bno=${board.bno}" class="btn btn-warning" role="button">수정</a>
                <a href="/board/delete?bno=${board.bno}" class="btn btn-danger" role="button">삭제</a>
                <a href="/board/list" class="btn btn-primary" role="button">리스트</a>
            </div>

        </div>

        <div class="card m-3">
            <div class="card-header">
                <h3 class="title">Article Reply</h3>
            </div>
            <div class="border-bottom p-3">
                <h5 class="title my-2">댓글 작성</h5>
                <div class="mb-3">
                    <label for="replyer" class="form-label">작성자</label>
                    <input type="text" class="form-control" id="replyer" name="replyer">
                </div>
                <div class="mb-3">
                    <label for="reply" class="form-label">내용</label>
                    <textarea class="form-control" id="reply" name="reply" rows="3"></textarea>
                </div>
                <div>
                    <input type="reset" value="등록" id="btn_reply" class="form-control btn btn-primary">
                </div>
            </div>
            <div class="card-body">
                <table class="table ">
                    <tbody id="replyList">

                    </tbody>
                </table>
            </div>
        </div>

    </div>



</main>

<div class="modal fade" id="replyEditModal" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalToggleLabel">댓글 수정</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="mb-3">
                    <label for="replyer" class="form-label">작성자</label>
                    <input type="text" class="form-control" id="editreplyer" name="replyer" readonly>
                    <input type="hidden" id="erno">
                    <input type="hidden" id="editreplydate">
                </div>
                <div class="mb-3">
                    <label for="reply" class="form-label">내용</label>
                    <textarea class="form-control" id="editreply" name="reply" rows="3"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" id="btn_editreply" >등록</button>
            </div>
        </div>
    </div>
</div>

<%--<a class="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle" role="button">Open first modal</a>--%>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
    let replyList;
    let myModal;
    document.addEventListener('DOMContentLoaded', () => {
        myModal = new bootstrap.Modal('#replyEditModal', {
            keyboard: false
        })
        replyList = document.querySelector('#replyList')
        const btn_reply = document.querySelector('#btn_reply')
        const btn_editreply = document.querySelector('#btn_editreply')
        btn_editreply.addEventListener('click', () => {
            editReply()
        })
        // 리스트 SET
        setList()
        ////////////////////////////////////
        btn_reply.addEventListener('click', ()=>{
            insertReply()
        })
    })
    function insertReply(){
        const payload = {
            bno : ${param.bno},
            reply : document.querySelector("#reply").value,
            replyer : document.querySelector("#replyer").value,
        }
        console.log(payload)
        // 비동기 통신 : 댓글 등록
        axios.post('/reply', payload)
            .then(res => {
                console.log('res', res.data)
                const newReply = res.data
                //const tr_length = document.querySelectorAll('#replyList>tr').length
                //const trIndex = Number(document.querySelectorAll('#replyList>tr')[tr_length-1].getAttribute('tr-index'))+1
                const newTR = document.createElement('tr')
                let str = '' // '<td class="col-1">'+newReply.rno+'</td>'
                str += '<td class="col-2">'+newReply.replyer+'</td>'
                str += '<td class="col">'+newReply.reply+'</td>'
                str += '<td class="col-2">'+newReply.replydate+'</td>'
                str += '<td class="col-2">' +
                    '<a href="javascript: showEditModal('+newReply.rno+')" class="badge bg-warning text-decoration-none">edit</a> ' +
                    '<a href="javascript: delTR('+newReply.rno+')" class="badge bg-danger text-decoration-none">delete</a>' +
                    '</td>'
                newTR.innerHTML = str
                newTR.setAttribute('class', 'fs-6 text-center')
                newTR.setAttribute('tr-index', newReply.rno)
                replyList.appendChild(newTR)
                document.querySelector("#reply").value = ''
                document.querySelector("#replyer").value = ''
            })
            .catch(err => console.log(err))
    }
    function editReply(){
        const payload = {
            bno : ${param.bno},
            rno :  document.querySelector("#erno").value,
            reply : document.querySelector("#editreply").value,
            replyer : document.querySelector("#editreplyer").value,
            replydate : document.querySelector("#editreplydate").value,
        }
        console.log(payload)
        // 비동기 통신 : 댓글 등록
        axios.put('/reply/'+payload.bno, payload)
            .then(res => {
                console.log('res', res.data)
                const newReply = res.data
                const editTR = document.querySelector('tr[tr-index="'+payload.rno+'"]')
                let str = '' // '<td class="col-1">'+newReply.rno+'</td>'
                str += '<td class="col-2">'+newReply.replyer+'</td>'
                str += '<td class="col">'+newReply.reply+'</td>'
                str += '<td class="col-2">'+newReply.replydate+'</td>'
                str += '<td class="col-2">' +
                    '<a href="javascript: showEditModal('+newReply.rno+')" class="badge bg-warning text-decoration-none">edit</a> ' +
                    '<a href="javascript: delTR('+newReply.rno+')" class="badge bg-danger text-decoration-none">delete</a>' +
                    '</td>'
                editTR.innerHTML = str
                /*editTR.setAttribute('class', 'fs-6 text-center')
                editTR.setAttribute('tr-index', newReply.rno)
                replyList.appendChild(newTR)*/
                document.querySelector("#editreply").value = ''
                document.querySelector("#editreplyer").value = ''
                myModal.hide()
            })
            .catch(err => console.log(err))
    }
    function setList(){
        // 비동기 통신 : 댓글 리스트 가져오기
        axios.get('/reply')
            .then(res => {
                console.log('res', res.data)
                // 태그 캐스팅 -> 데이터 변경
                addReplyRow(res.data)
            })
            .catch(err => console.log(err))
    }
    function showEditModal(rno){
        myModal.show();
        const selectedTD = document.querySelectorAll('tr[tr-index="'+rno+'"] > td')
        console.log(selectedTD[0].textContent)
        console.log(selectedTD[1].textContent)
        console.log(selectedTD[2].textContent)
        document.querySelector('#erno').value = rno
        document.querySelector('#editreplyer').value = selectedTD[0].textContent
        document.querySelector('#editreply').value = selectedTD[1].textContent
        document.querySelector('#editreplydate').value = selectedTD[2].textContent
    }
    function addReplyRow(list){
        console.log(`결과가 ${list}`)
        list.forEach((reply, index) => {
            const newTR = document.createElement('tr')
            let str = '' // <td class="col-1">'+reply.rno+'</td>'
            str += '<td class="col-2">'+reply.replyer+'</td>'
            str += '<td class="col">'+reply.reply+'</td>'
            str += '<td class="col-2">'+reply.replydate+'</td>'
            str += '<td class="col-2">' +
                '<a href="javascript: showEditModal('+reply.rno+')" class="badge bg-warning text-decoration-none">edit</a> ' +
                '<a href="javascript: delTR('+reply.rno+')" class="badge bg-danger text-decoration-none">delete</a>' +
                '</td>'
            newTR.innerHTML = str
            newTR.setAttribute('class', 'fs-6 text-center')
            newTR.setAttribute('tr-index', reply.rno)
            replyList.appendChild(newTR)
        });
    }
    function delTR(index){
        console.log('index', index)
        if(!confirm('댓글을 삭제하시겠습니까?')){
            return;
        }
        // 비동기 통신 : 데이터 삭제
        axios.delete('/reply/'+index)
            .then(res => {
                console.log('res', res.data)
                // 화면에서 행 삭제
                const delTR = document.querySelector('tr[tr-index="'+index+'"]')
                replyList.removeChild(delTR)
            })
            .catch(err => console.log(err))
    }
</script>

</body>
</html>
