import React from "react";

const styles = {
    wrapper : {
        margin: 8,
        padding: 8,
        display: 'flex',
        flexDirection: 'row',
        border: '1px solid gray',
        borderRadius: 16
    },
    messageText : {
        color: 'blue',
        fontSize: '24'
    }
}

class Notification extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {checked : false};
    }

    componentDidMount() {
        const checkedVal = this.state.checked;
        console.log('componentDidMount() call !!', checkedVal);
        this.setState({checked : true}) // 세팅했으므로 재 렌더링이 발생한다!!!
    }

    componentDidUpdate() { // 재 렌더링 되면 이 메소드가 실행된다.
        const checkedVal = this.state.checked;
        console.log('componentDidUpdate() call !!', checkedVal);
    }

    componentWillUnmount() {
        const checkedVal = this.state.checked;
        console.log('componentWillUnmount() call !!', checkedVal);
    }

    render() {
        return (
            <div style={styles.wrapper}>
                <span style={styles.messageText}>{this.props.message}</span>
            </div>
        )
    }
}

export default Notification;