// simple script to check if the div is changed
const observable = document.getElementById('chat');

// TODO : NEED A WAY TO CHANGE THE P TAGS INTO LATEX IN RUNTIME

// const recursive= ( node, pattern ) => {
//     counter += isNaN(node.childElementCount) ? 0 : node.childElementCount ;
//     nodes    = node.childNodes;

//     for ( node_ in nodes ) {
//         console.log ( node_ );
//         // recursive( node_ );
//     }
// } 


// observable.addEventListener("DOMSubtreeModified", function() {
    // const all_msg_box = observable.querySelectorAll('[id=xatkit-message-text]');
    // let p_tags = observable.getElementsByTagName("p");
    // console.log ( "the msg box ; " + msg_box );
    // console.log( all_msg_box );
    // console.log ( p_tags.length );


    // for ( p_tag in p_tags ){
    //     console.log ( new DOMParser().parseFromString(p_tag, "text/html").innerHTML);
    // }

    // recursive( observable );
    // console.log ( "number childs with the p tag : " + counter/*recursive( observable, 0 )*/ );
    // renderMathInElement(document.getElementById(""), {
    //     // customised options
    //     // • auto-render specific keys, e.g.:
    //     delimiters: [
    //     {left: '$$', right: '$$', display: true},
    //     {left: '$', right: '$', display: false},
    //     {left: '\\(', right: '\\)', display: false},
    //     {left: '\\[', right: '\\]', display: false},
    //     ],
    //     // • rendering keys, e.g.:
    //     throwOnError : false
    // });
// });