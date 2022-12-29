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
import MailBox from './components/MailBox';
import UserStatus from './components/UserStatus';
import WarningBanner from './components/WarningBanner';
import MainPage from './components/MainPage';
import NumberList from './components/NumberList';
import TeamPlayers from './components/TeamPlayers';
import NameForm from './components/NameForm';
import RequestForm from './components/RequestForm';
import SelectForm from './components/SelectForm';
import ReservationForm from './components/ReservationForm';
import SignUp from './components/SignUp';
import WelcomeMessage from './components/WelcomeMessage';
import WelcomeDialog from './components/WelcomeDialog';
import SignUpDialog from './components/SignUpDialog';
import ProfileCard from './components/ProfileCard';
import DarkOrWhite from './components/DarkOrWhite';
import ProductView from './components/ProductView';
import ProductLeft from './components/ProductLeft';
import ProductRight from './components/ProductRight';
import Container from './components/ex1/Container';
import WordContainer from './components/ex2/WordContainer';

const comment = {
    user : {
      userName : '손흥민',
      imgUrl : 'https://w.namu.la/s/1a40140b91e2ff9631c429e3968ffa65dc8a7ef1f40518c1c9ae814d973443eee4c339f5798b7bba3f422ec3bb9c6a71cfb42f7d116c16ee540ca0f57ae2fd6515da60e81113c04f69295c00ac5b9fd7c968b6c00980c2d96dee9241f27552ee'
    },
    content : '대한민국 화이팅!',
    replydate : '2022-12-25'
}

let list = [{}, {}, {}, {}]

function App() {
  return (
/*     <Comment user={comment.user} content={comment.content} replydate={comment.replydate}/> */

  //  <Greeting isLogin={true}/>
  //  <MailBox unReadMessage={list}/>
    // <UserStatus isLogin={false}/>
      // <WarningBanner warning={true}/>
      // <MainPage isLogin={false}/>
      // <NumberList/>
      // <TeamPlayers/>
      // <NameForm/>
      // <RequestForm/>
      // <SelectForm init='banana' /> // 초기값을 넘겨줘봤다.
      // <ReservationForm/>
      // <SignUp/>
      // <WelcomeMessage/>
      // <WelcomeDialog/>
      // <SignUpDialog/>
      // <ProfileCard/>
      // <DarkOrWhite/>
      // <ProductView left={ProductLeft} right={ProductRight} />
      // <Container /> // 왼쪽 상품 리스트, 오른쪽 상품 디테일
      <WordContainer/> // 왼쪽 상품 추가, 오른쪽 상품 리스트 + 삭제 버튼

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