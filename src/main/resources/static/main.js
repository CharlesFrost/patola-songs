'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');

var stompClient = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect() {
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
}

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);
}


function onError(error) {

}


function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            value: messageInput.value,
        };
        stompClient.send("/app/chat", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    // var audio = new Audio('Nagranie.m4a');
    // audio.play();
    var messageElement = document.createElement('li');

    messageElement.classList.add('chat-message');


    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.value);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);


    var usernameElement = document.createElement('span');
    var usernameText = document.createTextNode(message.author);
    usernameElement.appendChild(usernameText);
    messageElement.appendChild(usernameElement);



    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;

}

messageForm.addEventListener('submit', sendMessage, true);