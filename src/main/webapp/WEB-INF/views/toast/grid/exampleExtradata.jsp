<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
    <title>example06-using-extradata</title>

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
    scrollX: false,
    scrollY: false,
    rowHeaders: ['checkbox'],
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

var gridData = [
                {
                    name: 'Beautiful Lies',
                    artist: 'Birdy',
                    release: '2016.03.26',
                    type: 'Deluxe',
                    genre: 'Pop'
                },
                {
                    name: 'X',
                    artist: 'Ed Sheeran',
                    release: '2014.06.24',
                    type: 'Deluxe',
                    genre: 'Pop'
                },
                {
                    name: 'Moves Like Jagger',
                    release: '2011.08.08',
                    artist: 'Maroon5',
                    type: 'Single',
                    genre: 'Pop,Rock'
                   
                },
                {
                    name: 'A Head Full Of Dreams',
                    artist: 'Coldplay',
                    release: '2015.12.04',
                    type: 'Deluxe',
                    genre: 'Rock'
                    
                },
                {
                    name: '19',
                    artist: 'Adele',
                    release: '2008.01.27',
                    type: 'EP',
                    genre: 'Pop,R&B'
                   
                },
                {
                    name: '21',
                    artist: 'Adele',
                    release: '2011.01.21',
                    type: 'Deluxe',
                    genre: 'Pop,R&B'
                },
                {
                    name: '25',
                    artist: 'Adele',
                    release: '2015.11.20',
                    type: 'EP',
                    genre: 'Pop'                    
                }
            ];

            grid.setData(gridData);
            
</script>

</html>