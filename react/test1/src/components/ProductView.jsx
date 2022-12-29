import React from "react";

function ProductView(props) {

    console.log(props)

    return (
        <>
            <div style={{backgroundColor:'gray', display:'inline', width:'50vW'}}>
                left{props.left}
            </div>
            <div style={{backgroundColor:'pink', display:'inline', width:'50vW'}}>
                right{props.right}
            </div>
        </>
    )

}

export default ProductView