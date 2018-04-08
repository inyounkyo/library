<%--
  Created by IntelliJ IDEA.
  User: 인연교
  Date: 2018-01-30
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>refRoomGuide</title>
    <script src="<c:url value="/static/js/jquery-1.11.3.min.js" />"></script>
    <script src="<c:url value="/static/js/nameingJS.js" />"></script>
    <script src="<c:url value="/static/js/bukgu/menuJS.js" />"></script>

    <style type="text/css">
        html, body{
            font-family: Arial, Helvetica, sans-serif;
        }
        .navigation{
            width:300px;
        }
        .mainmenu, .submenu{
            list-style:none;
            padding:0;
            margin:0;
        }
        .mainmenu a {
            display: block;
            background-color: #CCC;
            text-decoration: none;
            padding: 10px;
            color: #000;
        }
        .mainmenu a:hover{
            background-color: #C5C5C5;
        }
        .mainmenu li:hover .submenu{
             display: block;
             max-height: 200px;
         }
        .submenu a {
            padding-left: 25px;
            background-color: #999;
        }
        .submenu a:hover{
            background-color: #67b168;
        }
        .submenu{
            overflow: hidden;
            max-height: 0;
            -webkit-transition: all 0.5s ease-out;
        }
        .off {
            overflow: auto;
            max-height: 200px;
         }

        .on a{
            background-color: #67b168;
        }

        .hasChildMark{
            background-image: url("/static/images/bottomArrow.gif");
            background-repeat: no-repeat;
            background-size: 15px;
            background-position:250px center;
        }

    </style>

    <script type="text/javascript">
        $(document).ready(function(){
            Bukgu.menu.click();
            Bukgu.menu.autoSelect(23);
        });

    </script>

</head>
<body>


<%--<nav class="navigation">
    <ul class="mainmenu">
        <li menu-idx="11"><a href="#" >Home</a></li>
        <li menu-idx="24"><a href="#">About</a></li>
        <li ><a href="#" class="hasChildMark">Products</a>
            <ul class="submenu">
                <li menu-idx="14"><a href="#">Tops</a></li>
                <li menu-idx="23"><a href="#">Bottom</a></li>
                <li menu-idx="12"><a href="#">Footwear</a></li>
            </ul>
        </li>
        <li menu-idx="46"><a href="#">Content us</a></li>
    </ul>
</nav>--%>
<%@include file="/static/html/nav/bukgu/libLNB.html"%>

</body>
</html>
