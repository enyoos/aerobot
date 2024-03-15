var counter       = 0;
var isDown        = false;
const DIV_ID      = "chat";
const div         = document.getElementById ( DIV_ID );
let t_div         = null;

document.addEventListener('mouseup', function() {
  isDown = false;
}, true);

document.addEventListener('mousemove', function(event) {
   console.log ( "mousemove" );
    event.preventDefault();
    if (isDown) {
      mousePosition = {
        x : event.clientX,
        y : event.clientY
      };

      let prevx = parseInt (t_div.style.left);
      let prevy = parseInt ( t_div.style.top);
      let dx    = (mousePosition.x + offset[0]);
      let dy    = (mousePosition.y + offset[1]);

      t_div.style.left = (mousePosition.x + offset[0]) + 'px';
      t_div.style.top  = (mousePosition.y + offset[1]) + 'px';
    }
}, true);

var obs      = new MutationObserver ( function ( muts ) {
  muts.forEach ( function ( mut ) {
    if ( t_div !==  null ) {obs.disconnect()}
    else {

      t_div = mut.addedNodes[0]
      // attempt  to make the div resizable
      // t_div.appendChild( resizer );
      t_div.style.position = "absolute";
      t_div.style.cursor   = 
      t_div.addEventListener('mousedown', function(e) {
        isDown = true;
        offset = [
          t_div.offsetLeft - e.clientX,
          t_div.offsetTop - e.clientY
        ];
      }, true);

    }
  })
});

var config   = { attributes: false, childList: true, characterData: false };
obs.observe ( div, config );
