import {renderXatkitWidget} from 'xatkit-chat-widget'
import 'xatkit-chat-widget/lib/xatkit.css';

export default function make (url, rootName ){ 
  renderXatkitWidget({
    elementId : rootName,
    widget : {
      title : "Aerobot",
      subtitle : "Aerobot🤖",
      startMinimized : true, // when push to prod, toggle true
      placeHolders : {
        sender : "Écrit moi quelque chose",
        buttons : "Choisis une option",
      },
      images : {
        profileAvatar  : process.env.PUBLIC_URL + "/rosemont.svg",
      }
    },
    location : {
      url : url
    },
    storage : {
      autoClear : true,
    }
  });

}