import renderMathInElement from "https://cdn.jsdelivr.net/npm/katex@0.16.10/dist/contrib/auto-render.mjs";

const span        = document.getElementById ( "eq" );
const button      = document.getElementById ( "button" );
const targetNode  = document.getElementById ( "chat");

/*
const observer = new PerformanceObserver((list) => {
  for (const entry of list.getEntries()) {
    if (entry.initiatorType === "fetch") {
      console.log('Fetch request detected to', entry.name);
    }
  }
});

observer.observe({
  entryTypes: ["resource"]
});
*/

// Options for the observer (which mutations to observe)
/*
var config = { attributes: true, childList: true };

// Callback function to execute when mutations are observed
var callback = function(mutationsList) {
    for(var mutation of mutationsList) {
        if (mutation.type == 'childList') {
            console.log('A child node has been added or removed.');
        }
        else if (mutation.type == 'attributes') {
            console.log('The ' + mutation.attributeName + ' attribute was modified.');
        }
    }
};

// Create an observer instance linked to the callback function
var observer = new MutationObserver(callback);

// Start observing the target node for configured mutations
observer.observe(targetNode, config);

/*
function render () {
  span.innerHTML = "Render Latex : " + "$5xx$";
  renderMathInElement( document.body ,
    {
      delimiters: [
        {left: '$$', right: '$$', display: true},
        {left: '\\[', right: '\\]', display: true},
        {left: '$', right: '$', display: false},
        {left: '\\(', right: '\\)', display: false}
      ],
      throwOnError : true, //change it when it comes to production
    }
 );
}
*/

// button.addEventListener( "click", render );
// it works
