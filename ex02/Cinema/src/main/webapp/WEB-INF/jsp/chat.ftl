<!doctype html>
<html lang="en">
<head>
    <style>
        <#setting classic_compatible=true>
        <#include "css/chat.css">
    </style>
    <title>Chat</title>
    <meta charset="UTF-8">
</head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script type="text/javascript">

        var stompClient = null;
        let messageForm = document.querySelector('#messageForm');
        var movieId = null;

        function connect() {
            var socket = new SockJS('../../chat');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function() {
                stompClient.subscribe('/topic/public', function(messageOutput) {
                    showMessageOutput(JSON.parse(messageOutput.body));
                    scrollToBottom();
                });
            });
        }

        function setCookie(name, value, options = {}) {
            options = {
                path: '/',
                ...options
            };
            if (options.expires instanceof Date) {
                options.expires = options.expires.toUTCString();
            }
            let updatedCookie = encodeURIComponent(name) + "=" + encodeURIComponent(value);

            for (let optionKey in options) {
                updatedCookie += "; " + optionKey;
                let optionValue = options[optionKey];
                if (optionValue !== true) {
                    updatedCookie += "=" + optionValue;
                }
            }
            document.cookie = updatedCookie;
        }

        function getCookie(name) {
            let matches = document.cookie.match(new RegExp(
                "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
            ));
            return matches ? decodeURIComponent(matches[1]) : undefined;
        }

        function sendMessage() {
            var text = document.getElementById('text').value;
            movieId = ${movie.id};
            var userName = getCookie('chatUser');
            if (userName == undefined) {
                while (!userName) {
                    userName = window.prompt('Enter your nickname');
                }
                // userName = userName + '#' + new Date().getTime();
                setCookie('chatUser', userName, {})
                document.getElementById('userName').setAttribute('readonly', 'readonly');
                document.getElementById('userName').setAttribute('value', userName);
            }
            if (text && stompClient) {
                let chatMessage = {
                    message: text,
                    movie: {
                        id: movieId
                    },
                    user: {
                        login: userName
                    }
                };
                stompClient.send("/app/chat.sendMessage", {},
                    JSON.stringify(chatMessage));
            }
        }

        function showMessageOutput(message) {
            let messageElement = document.createElement('li');

            messageElement.classList.add('chat-message');
            let usernameElement = document.createElement('span');
            let usernameText = document.createTextNode(message.user.login);
            usernameElement.appendChild(usernameText);

            messageElement.appendChild(usernameElement);

            let textElement = document.createElement('p');
            let messageText = document.createTextNode(message.message);
            textElement.appendChild(messageText);
            messageElement.appendChild(textElement);
            messageArea.appendChild(messageElement);

        }

        function checkUserName() {
                var userName = getCookie('chatUser');
                if (userName !== undefined) {
                    document.getElementById('userName').setAttribute('value', userName);
                    document.getElementById('userName').setAttribute('readonly', 'readonly');
                }
            }

        function scrollToBottom() {
            var element = document.getElementById('response');
            element.scrollTop = element.scrollHeight;
        }

    </script>
    <title>Cinema - Chat</title>

<body onload="connect();">

<div id="chat-page">
<div class="chat-container">
    <ul id="messageArea">-->
            <#list messages as message>
                <li class="chat-message">
                    <span>${message.user.login}</span>
                    <p>${message.message}</p>
                </li>
            </#list>
    </ul>

    <input type="text" id="text" placeholder="Write a message..."/>
    <button type="submit" id="sendMessage" onclick="sendMessage()">Send</button>
</div>
</div>


<footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</footer>

</body>
</html>
