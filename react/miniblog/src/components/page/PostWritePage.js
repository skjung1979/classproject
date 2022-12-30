import React, {useState} from 'react';
import {useNavigate} from "react-router-dom";
import TextInput from "../ui/TextInput";
import Button from "../ui/Button";
import PageLayout from "./PageLayout";

function PostWritePage(props) {

    const navigate = useNavigate();

    // 입력폼에서 받아야 하는 것들...
    const [title, setTitle] = useState();
    const [content, setContent] = useState();

    return (
        <PageLayout>
            <TextInput
                height={20}
                value={title}
                onChange={(e) => setTitle(e.target.value)}
            />
            <TextInput
                height={400}
                value={content}
                onChange={(e) => setContent(e.target.value)}
            />
            <Button
                title={"글 작성"}
                onClick={() => navigate("/")}
            />
        </PageLayout>
    );
}

export default PostWritePage;