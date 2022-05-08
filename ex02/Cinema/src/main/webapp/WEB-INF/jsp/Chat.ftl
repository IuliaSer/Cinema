<html>
<head>
    <style>
        <#setting classic_compatible=true>
<#--        <#include "css/chat.css">-->
    </style>
    <title>Chat</title>
    <meta charset="UTF-8">
</head>

<body>
<div id="username-page">
    <div class="username-page-container">
        <h1 class="title">Type your username</h1>
        <form id="usernameForm" name="usernameForm">
                <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />
                <b> </b>
                <button type="submit" class="accent username-submit">Start Chatting</button>
        </form>
    </div>
</div>

<div id="chat-page" class="hidden">
    <div class="chat-container">
        <h2>${movie.title}</h2>
<#--        <div class="connecting">-->
<#--            Connecting...-->
<#--        </div>-->
        <ul id="messageArea">
            <#list messages as message>
                <li class="chat-message">
                    <span>${message.user.login}</span>
                    <p>${message.message}</p>
                </li>
            </#list>
        </ul>
        <form id="messageForm" name="messageForm">
                <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                <button type="submit" class="primary">Send</button>
        </form>
    </div>

</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script>
    'use strict';
    let usernamePage = document.querySelector('#username-page');
    let chatPage = document.querySelector('#chat-page');
    let usernameForm = document.querySelector('#usernameForm');
    let messageForm = document.querySelector('#messageForm');
    let messageInput = document.querySelector('#message');
    let messageArea = document.querySelector('#messageArea');
    let connectingElement = document.querySelector('.connecting');
    let chatFilmId = '${movie.filmId}';
    let stompClient = null;
    let username = null;

    $(document).ready(function () {
        document.getElementById("formFilmId").value=('${movie.filmId}');
        let userCookie = getCookie("user");
        if (userCookie) {
            username = userCookie;
            usernamePage.classList.add('hidden');  //pochemu zdes udalyaetsya hidden
            // chatPage.classList.remove('hidden');
            let socket = new SockJS('/ws');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, onConnected, onError);
        }
    })

    function connect(event) {
        username = document.querySelector('#name').value.trim();
        if(username) {
            document.cookie = "user=" + username;
            usernamePage.classList.add('hidden');
            chatPage.classList.remove('hidden');
            let socket = new SockJS('/ws');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, onConnected, onError);
        }
        event.preventDefault();
    }

    function onConnected() {
        stompClient.subscribe('/topic/public', onMessageReceived);
        stompClient.send("/app/chat.addUser",
            {},
            JSON.stringify({type: 'JOIN', user: {
                    login: username
                }})
        )
        // connectingElement.classList.add('hidden'); //
    }

    function onError(error) {
        connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
        connectingElement.style.color = 'red';
    }

    function sendMessage(event) {
        let messageContent = messageInput.value.trim();
        if(messageContent && stompClient) {
            let chatMessage = {
                message: messageInput.value,
                type: 'CHAT',
                film: {
                    filmId: chatFilmId
                },
                user: {
                    id: getCookie("userId"),
                    login: username
                }
            };
            stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
            messageInput.value = '';
        }
        event.preventDefault();
    }

    function onMessageReceived(payload) {
        let message = JSON.parse(payload.body);
        let messageElement = document.createElement('li');
        if (message.type === 'JOIN') {
            messageElement.classList.add('event-message');
            message.message = message.user.login + ' joined!';
            if (!getCookie("userId")) {
                document.cookie = "userId=" + message.user.id;
            }
            if (getCookie("userId") == message.user.id) {
                document.getElementById("formUserId").value=(getCookie("userId"));
                getAuthList();
                getListOfAvatar();
            }
        } else if (message.type === 'LEAVE') {
            messageElement.classList.add('event-message');
            message.message = message.user.login + ' left!';
        } else {
            messageElement.classList.add('chat-message');
            let avatarElement = document.createElement('i');
            let avatarText = document.createTextNode(message.user.login[0]);
            avatarElement.appendChild(avatarText);
            avatarElement.style['background-color'] = getAvatarColor(message.user.login);
            messageElement.appendChild(avatarElement);
            let usernameElement = document.createElement('span');
            let usernameText = document.createTextNode(message.user.login);
            usernameElement.appendChild(usernameText);
            messageElement.appendChild(usernameElement);
        }
        let textElement = document.createElement('p');
        let messageText = document.createTextNode(message.message);
        textElement.appendChild(messageText);
        messageElement.appendChild(textElement);
        messageArea.appendChild(messageElement);
        messageArea.scrollTop = messageArea.scrollHeight;
    }

    function getAvatarColor(messageSender) {
        let hash = 0;
        for (let i = 0; i < messageSender.length; i++) {
            hash = 31 * hash + messageSender.charCodeAt(i);
        }
        let index = Math.abs(hash % colors.length);
        return colors[index];
    }

    function getCookie(name) {
        let matches = document.cookie.match(new RegExp(
            "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
        ));
        return matches ? decodeURIComponent(matches[1]) : undefined;
    }

    function setCookie(name, value) {
        document.cookie = encodeURIComponent(name) + "=" + encodeURIComponent(value);
    }

    function deleteCookie(name) {
        setCookie(name, "", {
            'max-age': -1
        })
    }

    usernameForm.addEventListener('submit', connect, true)
    messageForm.addEventListener('submit', sendMessage, true)

</script>
</body>
</html>
