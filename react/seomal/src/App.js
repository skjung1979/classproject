import logo from './logo.svg';
import './App.css';

function Header({title, body}) {
    return (
        <header>
            <h1 style={{display: 'inline'}}><a href="/">{title}</a></h1>
            {body}
        </header>
    )
}

function Nav({navDatas}) {

    const list = [
        navDatas.map(item => {
            return <li key={item.id}><a href={'/read/'+item.id}>{item.title}</a></li>
        })
    ]

    // map으로 하거나 반복문을 돌린다.
    // for(let i=0; i<navDatas.length; i++){
    //     list.push(<li><a href={'/read/'+navDatas[i].id}>{navDatas[i].title}</a></li>)
    // }

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

const headerData = {title: 'WEB', body: 'this is Header.'}
const navDatas = [
    {id: 1, title: 'html5', body: 'html5 is...'},
    {id: 2, title: 'css', body: 'css is...'},
    {id: 3, title: 'javascript', body: 'javascript is...'}
]
const articleData = {title: 'Welcome', body: '안녕하세요. 메인페이지 입니다.'}

function App() {
    return (
        <div>
            <Header title={headerData.title} body={headerData.body}/>
            <Nav navDatas={navDatas}/>
            <Article title={articleData.title} body={articleData.body}/>
        </div>
    );
}

export default App;
