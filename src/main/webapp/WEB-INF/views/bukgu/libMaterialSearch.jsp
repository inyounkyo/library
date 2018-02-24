<%--
  Created by IntelliJ IDEA.
  User: 인연교
  Date: 2018-01-30
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>libMaterialSearch</title>
    <style>
        ul{
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }
        li{
            float:left;
        }

        li a, .dropbtn{
            display: block;
            color:white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover, .dropdown:hover .dropbtn{
            background-color: red;
        }

        li.dropdown{
            display: inline-block;
        }

        .dropdown-content{
            display:none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shodow: 0px 8px 16px 0px
            rgba(0,0,0,0.2);
            z-index:1;
        }

        .dropdown-content a{
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: inline-block;
            text-align: left;
        }

        .dropdown-content a:hover {background-color: #f1f1f1}

        .dropdown:hover .dropdown-content{
            display: block;
        }
    </style>
</head>
<body>

<%--<ul>--%>
    <%--<li><a href="#">자료검색</a> </li>--%>
    <%--<li><a href="#">이용안내</a> </li>--%>
    <%--<li class="dropdown">--%>
        <%--<a href="javascrip:void(0)" class="dropbtn">도서관서비스</a>--%>
        <%--<div class="dropdown-content">--%>
            <%--<a href="#">이달의행사</a>--%>
            <%--<a href="#">영화상영안내</a>--%>
            <%--<a href="#">학교도서관지원</a>--%>
        <%--</div>--%>
    <%--</li>--%>
<%--</ul>--%>

<%@include file="/static/html/nav/bukgu/libLNB.html"%>


<h3>Dropdown Menu inside a Navigation Bar</h3>
<p>Hover over the "Dropdown" link to see the dropdown menu.</p>



</body>
</html>
