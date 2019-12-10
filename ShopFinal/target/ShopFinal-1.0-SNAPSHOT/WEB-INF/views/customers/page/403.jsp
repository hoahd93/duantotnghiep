<%-- 
    Document   : 403
    Created on : Oct 10, 2019, 2:03:02 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lỗi truy cập</title>
        <style>
            @import url(https://fonts.googleapis.com/css?family=Raleway:700);
            *, *:before, *:after {
                box-sizing: border-box;
            }

            html {
                height: 100%;
            }

            body {
                background: no-repeat center center fixed;
                background-size: cover;
                font-family: 'Raleway', sans-serif;
                background-color: #342643;
                height: 100%;
            }

            .text-wrapper {
                height: 100%;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
            }

            .title {
                font-size: 6em;
                font-weight: 700;
                color: #EE4B5E;
            }

            .subtitle {
                font-size: 40px;
                font-weight: 700;
                color: #1FA9D6;
            }

            .buttons {
                margin: 30px;
            }
            .buttons a.button {
                font-weight: 700;
                border: 2px solid #EE4B5E;
                text-decoration: none;
                padding: 15px;
                text-transform: uppercase;
                color: #EE4B5E;
                border-radius: 26px;
                transition: all 0.2s ease-in-out;
            }
            .buttons a.button:hover {
                background-color: #EE4B5E;
                color: white;
                transition: all 0.2s ease-in-out;
            }
        </style>
    </head>

    <body>
        <div class="text-wrapper">
            <div class="title" data-content="403">
                403
            </div>

            <div class="subtitle">
                ACCESS FORBIDDEN
                <p>I'm sorry to that!</p>
            </div>
            <div class="buttons">
                <a class="button" onclick="back()">QUAY LẠI</a>
            </div>
            <script>
                function back() {
                    history.back();
                }
            </script>
        </div>
    </body>
</html>
