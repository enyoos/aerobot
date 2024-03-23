var counter       = 0;
var isDown        = false;
const CTRL        = 17; 
const DIV_ID      = "chat";
const div         = document.getElementById ( DIV_ID );
let moveable_div  = null;
let button_div    = null;
var state         = {
  closed_container_conv : true,
};

document.addEventListener('mouseup', function() {
  isDown = false;
}, true);

// escape key is for closing the dialog
document.addEventListener('keyup', (e) => {
  if ( e.keyCode === CTRL ) { 
    if ( button_div !== null ) {
      button_div.click();
      state.closed_container_conv = !state.closed_container_conv;
    }
    else { console.log ( "button_div undefined" );}
  }
}) 

// piece of logic for moving the div position.
/*
document.addEventListener('mousemove', function(event) {
    event.preventDefault();
    if (isDown) {
      mousePosition = {
        x : event.clientX,
        y : event.clientY
      };

      let prevx = parseInt (moveable_div.style.left);
      let prevy = parseInt ( moveable_div.style.top);
      let dx    = (mousePosition.x + offset[0]);
      let dy    = (mousePosition.y + offset[1]);

      moveable_div.style.left = (mousePosition.x + offset[0]) + 'px';
      moveable_div.style.top  = (mousePosition.y + offset[1]) + 'px';
    }
}, true);
*/


// @Incomplete


const childMut = "childList";

var obs = new MutationObserver ( function ( muts ) {
  muts.forEach ( function ( mut ) {

    if ( mut.type === childMut ){
      button_div = div.firstChild.firstChild;
      button_div.addEventListener ( "click", (e) => {
        state.closed_container_conv = !state.closed_container_conv;
        /*
        if ( t_div !== null ) {}
        else {
          t_div = document.getElementsByClassName ( t_div_id );
          console.log (t_div );
        }
        */
      });
    }

  });
});

var config   = { attributes: true, childList: true, characterData: true};
obs.observe ( div, config );
