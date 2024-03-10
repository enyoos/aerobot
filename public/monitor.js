// simple script to check if the observable is changed
const observable        = document.getElementById('chat');
const chat_container_id = "xatkit-conversation-container";
var   chat_container    = null; // for now 

const container        = document.body;
const containerDomrect = container.getBoundingClientRect();

// console.log ( chat_container);
// console.log ( /*"the container bounds : " +*/ containerDomrect);
// console.log ( /*"the obs container bounds : "+*/ elementDomrect);
const init_x = 0;
const init_y = -10;
console.log ( init_x + " and the init y : " + init_y);

observable.setAttribute('data-x', init_x);
observable.setAttribute('data-y', init_y);
observable.style.touchAction = null;
observable.style.userSelect  = null;

// target elements with the "draggable" class
interact('#chat')
  .draggable({
    // enable inertial throwing
    inertia: false,
    // keep the element within the area of it's parent
    modifiers: [
      interact.modifiers.restrictRect({
        restriction : "window",
        endOnly: true, 
      })
    ],

    // enable autoScroll
    autoScroll: true,

    listeners: {
      // call this function on every dragmove event
      move: dragMoveListener,

      // call this function on every dragend event
      end (event) {
        console.log ( "dragged" );
      }
    }
  })

function dragMoveListener (event) {

    var target = event.target;

    // keep the dragged position in the data-x/data-y attributes
    var data_x = isNaN(parseFloat(target.getAttribute('data-x'))) ? 0 : parseFloat(target.getAttribute('data-x'));
    var data_y = isNaN(parseFloat(target.getAttribute('data-y'))) ? 0 : parseFloat(target.getAttribute('data-y'));

    var x = data_x + event.dx;
    var y = data_y + event.dy;

    console.log ( "eventdx : " + event.dx );
    console.log ( "eventdy : " + event.dy );

    console.log ( 'the dtx : ' + data_x );
    console.log ( 'the dty : ' + data_y );

    console.log ( "the x : " +  x );
    console.log ( "the y : " +  y );

    // translate the element
    target.style.transform = 'translate(' + x + 'px, ' + y + 'px)'

    // update the posiion attributes
    target.setAttribute('data-x', x)
    target.setAttribute('data-y', y)

}

// this function is used later in the resizing and gesture demos
window.dragMoveListener = dragMoveListener

// // TODO : NEED A WAY TO CHANGE THE P TAGS INTO LATEX IN RUNTIME
// // https://davidrajm.medium.com/using-mathjax-with-dynamic-data-rendering-using-vennila-js-ff426ca48e3b
