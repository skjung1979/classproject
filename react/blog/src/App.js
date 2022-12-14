import Header from "./blog/Header";
import Nav from "./blog/Nav";
import Footer from "./blog/Footer";
import Wrapper from "./blog/Wrapper";
import {useState} from "react";

const blogData = {
    header : {
        title : '리액트로 만드는 블로그',
        description : 'React Component BlogMain '
    },
    nav : {
        menus : [
            {name : 'HTML5', linkUrl : '#'},
            {name : 'Javascript', linkUrl : '#'},
            {name : 'React.js', linkUrl : '#'},
        ]
    },
    aside : {
        ctgy : [
            {name : '카테고리1', linkUrl : '#'},
            {name : '카테고리2', linkUrl : '#'},
            {name : '카테고리3', linkUrl : '#'},
            {name : '카테고리4', linkUrl : '#'},
            {name : '카테고리5', linkUrl : '#'},
        ],
        recentPost : [
            {name : '최신글1', linkUrl : '#'},
            {name : '최신글2', linkUrl : '#'},
            {name : '최신글3', linkUrl : '#'},
            {name : '최신글4', linkUrl : '#'},
            {name : '최신글5', linkUrl : '#'},
        ]
    },
    posts : [
        {title : 'HTML5', date: '2022.12.25', imgUrl: '#', content:'메타는 서비스 장애 약 1시간 뒤인 오후 11시15분(한국시간) 공식 트위터를 통해 "일부 인스타그램 계정 접속에 문제가 있다는 것을 알고 있다. 원인을 파악 중이며 불편을 끼쳐 죄송하다"는 메시지를 띄웠다.'},
        {title : 'CSS3', date: '2022.12.25', imgUrl: '#', content:'메타는 서비스 장애 약 1시간 뒤인 오후 11시15분(한국시간) 공식 트위터를 통해 "일부 인스타그램 계정 접속에 문제가 있다는 것을 알고 있다. 원인을 파악 중이며 불편을 끼쳐 죄송하다"는 메시지를 띄웠다.'},
        {title : 'Javascript', date: '2022.12.25', imgUrl: '#', content:'메타는 서비스 장애 약 1시간 뒤인 오후 11시15분(한국시간) 공식 트위터를 통해 "일부 인스타그램 계정 접속에 문제가 있다는 것을 알고 있다. 원인을 파악 중이며 불편을 끼쳐 죄송하다"는 메시지를 띄웠다.'},
        {title : 'React.js', date: '2022.12.25', imgUrl: '#', content:'메타는 서비스 장애 약 1시간 뒤인 오후 11시15분(한국시간) 공식 트위터를 통해 "일부 인스타그램 계정 접속에 문제가 있다는 것을 알고 있다. 원인을 파악 중이며 불편을 끼쳐 죄송하다"는 메시지를 띄웠다.'},
    ]
}

const headerData = {title: 'Seong-Kyun\'s Blog', body: '웹을 공부하는 블로그'}

const navDatas = [
    {nid: 1, title: 'html5', body: 'html5 is ...............................'},
    {nid: 2, title: 'css', body: 'css is ....................................'},
    {nid: 3, title: 'javascript', body: 'javascript is .........................'},
    {nid: 4, title: 'react', body: 'body is ....................................'}
]

const articleDatas = [
    {
        ano: 1,
        title: 'facebook',
        date: '2022.11.23.',
        img: 'data:image/jpeg;base64,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',
        body: 'facebook is .........................................'
    },
    {
        ano: 2,
        title: 'kakao',
        date: '2022.12.23.',
        img: 'data:image/png;base64,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',
        body: 'kakao is ..........................................'
    },
    {
        ano: 3,
        title: 'instar',
        date: '2022.12.29',
        img: 'https://blog.kakaocdn.net/dn/CHb0U/btqxrW04Y5b/mzimBHhLuGMBYvCS33uyh0/img.jpg',
        body: 'instar is ............................................'
    }
]

const categoryDatas = [
    {cno: 1, title: 'FRONT'},
    {cno: 2, title: 'BACK'},
    {cno: 3, title: 'DB'}
]

function App() {

    const [mode, setMode] = useState('WELCOME');
    const [id, setId] = useState();

    let content = null;

    if (mode === 'WELCOME') {
        content = <Wrapper articleDatas={articleDatas} categoryDatas={categoryDatas} mode="WELCOME"/>
    } else  if (mode === 'READ') {
        content = <Wrapper navDatas={navDatas} categoryDatas={categoryDatas} mode="READ"/>
    }

    return (
        <>
            <Header title={headerData.title} body={headerData.body} onChangeMode={() => {
                // alert('환영합니다!!!')
                setMode('WELCOME')
            }}/>
            <Nav datas={navDatas} onChangeMode={(id) => {
                // alert(id)
                setMode('READ')
                setId(id)
            }}/>
            {content}
            <Footer/>
        </>
    );
}

export default App;
