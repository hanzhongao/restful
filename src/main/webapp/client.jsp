<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>restfull实验室</title>
    <script src="/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#btnGet").click(function () {
                $.ajax({
                    url : "/restful/request" ,
                    type : "get" ,
                    dataType : "json" ,
                    success : function (json) {
                        $("#message").text(json.message) ;
                    }
                })
            })
        }) ;

        $(function () {
            $("#btnPost").click(function () {
                $.ajax({
                    url : "/restful/request/100" ,
                    type : "post" ,
                    data : "name=hza&age=21" ,
                    dataType : "json" ,
                    success : function (json) {
                        $("#message").text(json.message + ":" + json.id) ;
                    }
                })
            });
        }) ;

        $(function () {
            $("#btnPut").click(function () {
                $.ajax({
                    url : "/restful/request/3" ,
                    type : "put",
                    data : "name=hza&age=21" ,
                    dataType : "json" ,
                    success : function (json) {
                        $("#message").text(json.message + json.id) ;
                    }
                })
            }) ;
        }) ;

        $(function () {
            $("#btnDelete").click(function () {
                $.ajax({
                    url : "/restful/request/123" ,
                    type : "delete" ,
                    dataType : "json" ,
                    success : function (json) {
                        $("#message").text(json.message + ":" + json.id) ;
                    }
                })
            }) ;
        });

        $(function () {
            $("#btnPersions").click(function () {
                $.ajax({
                    url : "/restful/persions" ,
                    type : "post" ,
                    dataType : "json",
                    success : function (json) {
                        console.info(json);
                        for(var i = 0 ; i < json.length ; i ++) {
                            var p = json[i] ;
                            $("#persions").append("<h2>" + p.name + "-" + p.age + "-" + p.birthday + "</h2>")
                        }
                    }
                })
            })
        }) ;

    </script>
</head>
<body>
    <input type="button" id="btnGet"    value="发送get请求">
    <input type="button" id="btnPost"   value="发送post请求">
    <input type="button" id="btnPut"    value="发送put请求">
    <input type="button" id="btnDelete" value="发送delete请求">
    <h1 id="message"></h1>
    <hr/>
    <input type="button" id="btnPersions" value="获取全部人员信息">
    <div id="persions"></div>
</body>
</html>
