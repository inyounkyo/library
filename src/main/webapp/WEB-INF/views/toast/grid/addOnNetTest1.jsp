<%--
  Created by IntelliJ IDEA.
  User: 인연교
  Date: 2018-04-07
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="/css/explain.css" />
    <link rel="stylesheet" type="text/css" href="/node_modules/tui-grid/dist/tui-grid.css" />
    <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/nhnent/tui.pagination/v3.0.0/dist/tui-pagination.css" />

</head>
<body>

<div class="code-html">
    <div id="grid"></div>
</div>

</body>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/node_modules/underscore/underscore.js"></script>
<script src="/node_modules/backbone/backbone.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-mockjax/1.6.2/jquery.mockjax.min.js"></script>
<script src="/node_modules/tui-code-snippet/dist/tui-code-snippet.js"></script>
<script src="/node_modules/tui-pagination/dist/tui-pagination.js"></script>
<script src="/node_modules/tui-date-picker/dist/tui-date-picker.js"></script>
<script src="/node_modules/tui-grid/dist/tui-grid.js"></script>

<script src="/data/basic-dummy.js"></script>

<script type="text/javascript">

    $.mockjax({
        url: '/addOnNet/addOnNetTestOk',
        responseTime: 0,
        response: function(settings) {
            console.log(settings);
            var page = settings.data.page;
            var perPage = settings.data.perPage;
            var start = (page - 1) * perPage;
            var end = start + perPage;
            var data = gridData.slice(start, end);
            console.log(data);
            this.responseText = JSON.stringify({
                result: true,
                data: {
                    contents: data,
                    pagination: {
                        page: page,
                        totalCount: gridData.length
                    }
                }
            });
        }
    });

</script>


<script type="text/javascript" class="code-js">
    var grid = new tui.Grid({
        el: $('#grid'),
        scrollX: false,
        scrollY: false,
        minBodyHeight: 30,
        rowHeaders: ['rowNum'],
        pagination: true,
        columns: [
            {
                title: 'Name',
                name: 'name'
            },
            {
                title: 'Artist',
                name: 'artist'
            }/*,
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
            }*/
        ]
    });


    grid.use('Net', {
        perPage: 3,
        readDataMethod: 'GET',
        api: {
            'readData': '/addOnNet/addOnNetTestOk',
            'updateData': './api/update'
        }
    });
    // Bind event handlers
    grid.on('beforeRequest', function(data) {
        // For all requests
    }).on('response', function(data) {
        console.log(data);
    }).on('successResponse', function(data) {
        // Only if response.result is true
    }).on('failResponse', function(data) {
        // Only if response.result is false
    }).on('errorResponse', function(data) {
        // For error response
    });
    net = grid.getAddOn('Net');
    //net.request('updateData');

</script>

</html>
