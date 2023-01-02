import React from 'react';

function Create({onCreate}) {
    return (
        <article>
            <h2>Create</h2>
            <form onSubmit={e => {
                e.preventDefault();
                const title = e.target.tt.value;
                const body = e.target.ta.value;
                onCreate(title, body)
            }}>
                <p><input type="text" name="tt" placeholder="제목을 입력하세요."/></p>
                <p><textarea name="ta" placeholder="본문을 입력하세요."></textarea></p>
                <input type="submit" value="글작성"/>
            </form>
        </article>
    )
}

export default Create;