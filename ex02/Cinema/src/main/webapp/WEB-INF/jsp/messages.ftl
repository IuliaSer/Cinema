<!doctype html>
<body>

<ul id="messageArea">
    <#list messages as message>
        <li class="chat-message">
            <span>${message.user.login}</span>
            <p>${message.message}</p>
        </li>
    </#list>
</ul>
</body>
</html>

