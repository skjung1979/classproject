import React from 'react';

function Category({categoryDatas}) {

    const list = [
        categoryDatas.map(item => {
            return (
                <li key={item.cno}>{item.title}</li>
            )
        })
    ]

    return (
        <>
            <h4>카테고리</h4>
            <ul>
                {list}
            </ul>
        </>
    );
}

export default Category;