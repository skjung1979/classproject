import logo from './logo.svg';
import './App.css';
import Comment from './components/Comment';
import Notification from './components/Notification';
import Counter from './components/Counter';
import TextInputButton from './components/TextInputButton';
import Accommodate from './components/Acommodate';
import Toggle from './components/Toggle';
import MyButton from './components/MyButton';
import ConfirmButton from './components/ConfirmButton';
import Greeting from './components/Greeting';
import LoginControl from './components/LoginControl';

const comment = {
    user : {
      userName : '손흥민',
      imgUrl : 'https://w.namu.la/s/1a40140b91e2ff9631c429e3968ffa65dc8a7ef1f40518c1c9ae814d973443eee4c339f5798b7bba3f422ec3bb9c6a71cfb42f7d116c16ee540ca0f57ae2fd6515da60e81113c04f69295c00ac5b9fd7c968b6c00980c2d96dee9241f27552ee'
    },
    content : '대한민국 화이팅!',
    replydate : '2022-12-25'
}

function App() {
  return (
/*     <Comment user={comment.user} content={comment.content} replydate={comment.replydate}/> */

  //  <Greeting isLogin={true}/>
   <LoginControl/>

  );
}


{/* <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React 1234
        </a>
      </header>
    </div> */}

export default App;