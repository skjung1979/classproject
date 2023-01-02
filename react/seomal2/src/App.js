import './App.css';
import {useState} from "react";
import styled from "styled-components";
import Create from "react";

// const Create = styled.button`
//     margin: 10px;
// `

function Header({title, body, onChangeMode}) {
    return (
        <header>
            <h1 style={{display: 'inline'}}>
                <a href="/" onClick={e => {
                    e.preventDefault();
                    onChangeMode()
                }}>{title}</a>
            </h1>
            {body}
        </header>
    )
}

function Nav({navDatas, onChangeMode}) {
    const list = [];

    navDatas.map(item => {
        list.push(
            <li key={item.id}>
                <a id={item.id}
                   href={'/read/' + item.id}
                   onClick={e => {
                       e.preventDefault();
                       onChangeMode(Number(e.target.id));
                   }}>
                    {item.title}
                </a>
            </li>
        )
    })

    /*for (let i = 0; i < navDatas.length; i++) {
        let n = navDatas[i];
        list.push(
            <li key={n.id}>
                <a id={n.id}
                   href={'/read/' + n.id} onClick={e => {
                    e.preventDefault();
                    onChangeMode(Number(e.target.id)); // a태그를 클릭하면 id속성의 값을 onChanedMode함수에 매개변수로 담아 호출한다!
                }}>
                    {n.title}
                </a>
            </li>
        )
    }*/


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



const headerData = {title: 'WEBSITE', body: ' this is header'}
const welcomeData = {title: 'Welcome', body: '안녕하세요. 메인 페이지 입니다.'}

function App() {

    const [mode, setMode] = useState('HOME');
    const [navDatas, setNavDatas] = useState([
        {id: 1, title: 'html5', body: 'html5 is ............'},
        {id: 2, title: 'css', body: 'css is ............'},
        {id: 3, title: 'javascript', body: 'javascript is ............'}
    ])
    const [idx, setIdx] = useState(null);
    const [nextIdx, setNextIdx] = useState(4)

    let content = null;

    if (mode === 'HOME') {
        content = <Article title={welcomeData.title} body={welcomeData.body}/>
    } else if (mode === 'READ') {
        // 분기
        let title, body = null;

        navDatas.map(item => {
            if (item.id === idx) {
                title = item.title;
                body = item.body;
            }
        })

        content = <Article title={title} body={body}/>
    } else if (mode === 'CREATE'){
        content = <Create onCreate={(tt, ta) => {
            const newNavData = {id: nextIdx, title: tt, body: ta}
            const newNavDatas = [...navDatas]
            newNavDatas.push(newNavData)
            setNavDatas(newNavDatas)
            setMode('READ')
            setIdx(nextIdx)
            setNextIdx(nextIdx + 1)
        }
        }></Create>
    }

    return (
        <div>
            <Header title={headerData.title} body={headerData.body} onChangeMode={() => {
                setMode('HOME')
            }}></Header>
            <Nav navDatas={navDatas} onChangeMode={(id) => {
                setMode('READ');
                setIdx(id);
            }}/>
            {content}
            <br/>
            <a
                href="/create" onClick={e => {
                    e.preventDefault();
                    setMode('CREATE');
            }}
            >create</a>
        </div>
    ); // app returen close
}

export default App;
