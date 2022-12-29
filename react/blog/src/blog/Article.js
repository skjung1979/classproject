import React from 'react';

function Article({articleDatas}) {

    const list = [
        articleDatas.map(item => {
            return (
                <div key={item.ano}>
                    <h2>{item.title}</h2>
                    <p>{item.date}</p>
                    <img src={item.img} height="100"/>
                    <p className="lh-180">{item.body}</p>
                </div>
            )
        })
    ]


    return (
        <article>
            {list}
        </article>
    );
}

export default Article;