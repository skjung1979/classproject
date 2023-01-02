import logo from './logo.svg';
import './App.css';
import {useState} from "react";
import styled from 'styled-components';

function Header({title, body, onChangeMode}) {
    return (
        <header>
            <h1 style={{display: 'inline'}}><a href="/" onClick={(e) => {
                e.preventDefault()
                onChangeMode()
            }}>{title}</a></h1>
            {body}
        </header>
    )
}

function Nav({navDatas, onChangeMode}) {

    const list = []
    for (let i = 0; i < navDatas.length; i++) {
        let t = navDatas[i];
        list.push(<li key={t.id}>
                <a id={t.id} href={'/read/' + t.id} onClick={e => {
                    e.preventDefault();
                    onChangeMode(Number(e.target.id));
                }}>{t.title}</a>
            </li>
        );
    }

    return (
        <nav>
            <ol>
                {list}
            </ol>
        </nav>
    )
}

function Article({title, body}) {
    return (
        <article>
            <h2>{title}</h2>
            {body}
        </article>
    )
}

function Create(props) {
    return (
        <article>
            <h2>Create</h2>
            <form onSubmit={e => {
                e.preventDefault();
                const title = e.target.title.value;
                const body = e.target.body.value;
                props.onCreate(title, body);
            }}>
                <p><input type="text" name="title" placeholder="제목을 입력하세요."/></p>
                <p><textarea name="body" placeholder="본문을 입력하세요." rows="5" cols="22"/></p>
                <p><input type="submit" value="Create"/></p>
            </form>
        </article>
    )
}

const headerData = {title: 'WEB', body: 'this is Header.'}
const articleData = {title: 'Welcome', body: '안녕하세요. 메인페이지 입니다.'}
const articleData2 = {title: 'Read', body: '안녕하세요. Read!!!!'}

function App() {

    const [mode, setMode] = useState('WELCOME')
    const [idx, setIdx] = useState(null) /*현재 값이 선택된게 없으니깐 null*/
    const [nextIdx, setNextIdx] = useState(4)
    const [navDatas, setNavDatas] = useState([
            {id: 1, title: 'html5', body: 'html5 is...'},
            {id: 2, title: 'css', body: 'css is...'},
            {id: 3, title: 'javascript', body: 'javascript is...'}
        ]
    )

    let content = null;

    if (mode === 'WELCOME') {
        content = <Article title={articleData.title} body={articleData.body}/>
    } else if (mode === 'READ') {
        let title, body = null
        for (let i = 0; i < navDatas.length; i++) {
            if (navDatas[i].id === idx) {
                title = navDatas[i].title
                body = navDatas[i].body
                console.log('id / idx => ', navDatas[i].id, idx)
            }
        }
        console.log('title => ', title)
        console.log('body => ', body)

        content = <Article title={title} body={body}/>
    } else if (mode === 'CREATE') {
        content = <Create onCreate={(_title, _body) => {
            const newNavData = {id: nextIdx, title: _title, body: _body}
            const newNavDatas = [...navDatas] /*오리지널 데이터를 복제한다.*/
            newNavDatas.push(newNavData) /*오리지널 데이터에 새로운 입력받은 데이터를 넣는다.*/
            setNavDatas(newNavDatas)
            setMode('READ')
            setIdx(nextIdx)
            setNextIdx(nextIdx + 1)
        }}></Create>
    }

    return (
        <div>
            <Header title={headerData.title} body={headerData.body} onChangeMode={() => {
                // alert('Header!!!');
                // mode = 'WELCOME';
                setMode('WELCOME')
            }}/>
            <Nav navDatas={navDatas} onChangeMode={(id) => {
                // alert(id)
                // mode = 'READ';
                setMode('READ');
                setIdx(id);
                console.log('idx', idx)
            }}/>
            {content}
            <br/>
            <a href="/create" onClick={e => {
                e.preventDefault();
                setMode('CREATE');
                console.log('mode => ', mode)
            }}>create</a>
        </div>
    );
}

export default App;
