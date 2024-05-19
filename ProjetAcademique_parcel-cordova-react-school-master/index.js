import React from 'react';
import ReactDOM from 'react-dom/client';
import './src/style.css';
import './src/config.js';
import App from './src/App';

const root = ReactDOM.createRoot(document.getElementById("root"));

var cordova = document.createElement('script')
cordova.setAttribute('type','text/javascript')
cordova.setAttribute('src', 'cordova.js')
document.getElementsByTagName("head")[0].appendChild(cordova)
if (window.cordova) {
    document.addEventListener('deviceready', root.render(<App/>), false);
}
else root.render(<App/>);
