import React from 'react';

function Latest({articleDatas}) {

    const list = []

    for (let i=articleDatas.length-1; i >= 0; i--) {
        list.push(<li key={articleDatas[i].ano}>{articleDatas[i].title}</li>)
    }

    return (
        <>
            <h4>최근 글</h4>
            <ul>
                {list}
            </ul>
        </>
    );
}

export default Latest;