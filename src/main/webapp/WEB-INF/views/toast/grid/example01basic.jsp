<%--
  Created by IntelliJ IDEA.
  User: 인연교
  Date: 2018-04-07
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <link rel="stylesheet" type="text/css" href="/node_modules/tui-grid/dist/tui-grid.css" />

</head>
<body>

<div id="grid"></div>
</body>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/node_modules/underscore/underscore.js"></script>
<script src="/node_modules/backbone/backbone.js"></script>
<script src="/node_modules/tui-code-snippet/dist/tui-code-snippet.js"></script>
<script src="/node_modules/tui-pagination/dist/tui-pagination.js"></script>
<script src="/node_modules/tui-date-picker/dist/tui-date-picker.js"></script>
<script src="/node_modules/tui-grid/dist/tui-grid.js"></script>

<script src="/data/basic-dummy.js"></script>

<script type="text/javascript" class="code-js">
    var grid = new tui.Grid({
        el: $('#grid'),
        data: gridData,
        scrollX: false,
        scrollY: false,
        columns: [
            {
                title: 'Name',
                name: 'name'
            },
            {
                title: 'Artist',
                name: 'artist'
            },
            {
                title: 'Type',
                name: 'type'
            },
            {
                title: 'Release',
                name: 'release'
            },
            {
                title: 'Genre',
                name: 'genre'
            }
        ]
    });

</script>

</html>
