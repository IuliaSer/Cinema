<!doctype html>
<html lang="en">
<head>

<#--    <form id="messageForm" name="messageForm">-->
<#--        <div class="form-group">-->
<#--            <div class="input-group clearfix">-->
<#--                <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>-->
<#--                <button type="submit" class="primary">Send</button>-->
<#--            </div>-->
<#--        </div>-->
<#--    </form>-->


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script type="text/javascript">


        var stompClient = null;
        let messageForm = document.querySelector('#messageForm');

        function connect() {
            var socket = new SockJS('../../chat');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function() {
                <#--stompClient.subscribe('/films/' + ${movie.id?string.computer}  + '/chat', function(messageOutput)-->
                stompClient.subscribe('/topic/public', function(messageOutput) {
                    showMessageOutput(JSON.parse(messageOutput.body));
                    scrollToBottom();
                });
            });
        }

        function setCookie(name, value, options = {}) {
            options = {
                path: '/',
                // при необходимости добавьте другие значения по умолчанию
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
            var movieId = ${movie.id};
            var userName = getCookie('chatUser');
            if (userName == undefined) {
                while (!userName) {
                    userName = window.prompt('Enter your nickname');
                }
                userName = userName + '#' + new Date().getTime();
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
                        // id: getCookie("userId"), //tut ispravit
                        id: 1,
                        login: userName
                    }
                };
                stompClient.send("/app/chat.sendMessage", {},
                    JSON.stringify(chatMessage));
            }
        }

        function showMessageOutput(messageOutput) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            var br = document.createElement('br');
            p.style.wordWrap = 'break-word';
            var div = document.createElement('div');
            p.className = "align-left";
            var userName = messageOutput.user.login;
            if (messageOutput.user.login == getCookie('chatUser')) {
                userName ="Me";
                p.className = "align-right";
            } else
                userName = userName.toString().slice(0,-13);
            p.appendChild(document.createTextNode(userName + ": "
                + messageOutput.message));
            div.append(p);
            div.append(br);
            response.appendChild(div);
        }

        function checkUserName() {
                var userName = getCookie('chatUser');
                if (userName !== undefined) {
                    document.getElementById('userName').setAttribute('value', userName);
                    document.getElementById('userName').setAttribute('readonly', 'readonly');
                }
            }

        function show() {
            $.ajax({
                type: "GET",
                success: function (response) {
                    var messages = response.messages;
                    for (var i = 0; i < messages.length; i++) {
                        showMessageOutput(messages[i]);
                    }
                }
            })
            return false;
        }

        function scrollToBottom() {
            var element = document.getElementById('response');
            element.scrollTop = element.scrollHeight;
        }

    </script>
    <title>Cinema - Chat</title>

<body onload="connect();show()">

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-md">
            <a class="navbar-brand" href="#">Cinema</a>
        </div>
    </nav>
</header>


<div class="container">
    <div class="message-box-border">
        <div id="response" class="message-box" ></div>
    </div>
    <input type="text" id="text" placeholder="Write a message..."/>
    <button type="submit" id="sendMessage" onclick="sendMessage()">Send</button>
</div>

<footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</footer>

</body>
</html>
