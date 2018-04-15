<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>동적 변경 예제</title>
    <link rel="stylesheet" type="text/css" href="/css/explain.css" />
    <link rel="stylesheet" type="text/css" href="/node_modules/tui-grid/dist/tui-grid.css" />
    <link rel="stylesheet" type="text/css" href="/node_modules/tui-pagination/dist/tui-pagination.css" />
  
</head>
<body>

<div class="code-html">
    <div id=grid></div>
    <form id="gridForm" ></form>
</div>

<div class="code-html">
    <input type="button" value="select" onclick="toastGridSelect();">
    <input type="button" value="update fix" onclick="toastGridUpdate();">
    <input type="button" value="delete fix" onclick="toastGridDelete();">
    <input type="button" value="appendRow fix" onclick="toastGridAppendRow();">
    <input type="button" value="insert fix" onclick="toastGridInsert();">
    <input type="button" value="reload" onclick="toastGridReload();">
    
    <input type="button" value="excel" onclick="toastGridExcel();"> 
    <input type="button" value="excelAll" onclick="toastGridExcelAll();">
</div>
</body>

<script src="/node_modules/jquery/dist/jquery.min.js"></script>
<script src="/node_modules/underscore/underscore.js"></script>
<script src="/node_modules/backbone/backbone.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-mockjax/1.6.2/jquery.mockjax.min.js"></script>
<script src="/node_modules/tui-code-snippet/dist/tui-code-snippet.js"></script>
<script src="/node_modules/tui-pagination/dist/tui-pagination.js"></script>
<script src="/node_modules/tui-date-picker/dist/tui-date-picker.js"></script>
<script src="/node_modules/tui-grid/dist/tui-grid.js"></script>

<script src="/data/basic-dummy.js"></script>
  

<script type="text/javascript" class="code-js">   
   


	var grid = new tui.Grid({
	    el: $('#gridForm'),
	    scrollX: false,
	    scrollY: false,
	    minBodyHeight: 50,
	    rowHeaders: ['rowNum','checkbox'],
	    columns: [
	              {
	                  title: 'Name',
	                  name: 'name'
		                  , editOptions: {
		                     type: 'text',
		                     useViewMode: false
		                  },
			              onAfterChange: function(ev){
			            	 
			                  grid.check( ev.rowKey );
			                  //console.log(  ev.instance.el[ev.rowKey]  );
			                  //$(ev.instance.el[ev.rowKey+1]).prop('checked', true);
			              }
	              },  
	              {
	                  title: 'Artist',
	                  name: 'artist'
	                	  , editOptions: {
	 	                     type: 'text',
	 	                     useViewMode: true
	 	                  }
	              },
	              {
	                  title: 'Type',
	                  name: 'type'
	                	  , editOptions: {
	 	                     type: 'text',
	 	                     useViewMode: true
	 	                  }
	              },
	              {
	                  title: 'Release',
	                  name: 'release'
	                	  , editOptions: {
	 	                     type: 'text',
	 	                     useViewMode: true
	 	                  }
	              },
	              {
	                  title: 'Genre',
	                  name: 'genre'
	                	  , editOptions: {
	 	                     type: 'text',
	 	                     useViewMode: true
	 	                  }
	              }
	          ]
	});
	
	
	grid.setData(gridData);
	
	grid.use('Net', {
        perPage: 3,
        /* readDataMethod: 'POST', */
        enableAjaxHistory: true,
        api: {
        	'readData': '/kts/toastGrid/toastGridSelect.do',
            'updateData': '/kts/toastGrid/toastGridUpdate.do',
            'createData': '/kts/toastGrid/toastGridInsert.do',
            'deleteData': '/kts/toastGrid/toastGridDelete.do',
            'modifyData': '/kts/toastGrid/xxxxxxxxxxxxxxxxxxxxxxx.do',
            
            'downloadExcel': './api/download/toastExcel',
            'downloadExcelAll': './api/download/toastExcelAll'
        },
        checkedOnly: false
    });
	
	
    /*********************
    Bind event handlers
    **********************/
    grid.on('beforeRequest', function(data) {
        // For all requests
        
    }).on('response', function(data) {
        console.log("response:::  "+data);
        console.log(data);
         
    }).on('successResponse', function(data) {
        // Only if response.result is true
        
    }).on('failResponse', function(data) {
        // Only if response.result is false
        
    }).on('errorResponse', function(data) {
        // For error response
        
    });
    net = grid.getAddOn('Net');
    //net.request('createData');
  
  function toastGridSelect(){
	  
  }
  
  function toastGridUpdate(){
	  
	  console.log('**toastGridUpdate**');
	  net.request('updateData');
	  
  }   
  
  function toastGridInsert(){
	  
	  console.log('**toastGridInsert**');
	  net.request('createData');
	  
  }
  
  function toastGridDelete(){
	  console.log('**toastGridDelete**');
	  
	  $("#gridForm input:checkbox").each(function( rowKey ){
		   
		   if( this.checked){
			   //this.checked = true; //checked 처리
			   console.log('delete rowKey %s:: ', rowKey-1);
			   grid.removeRow( rowKey-1 );
			   
		   }
	  });
	  
	  net.request('deleteData');
	
  }
    
  function toastGridAppendRow(){
	 //appendRow(rowopt, optionsopt)
	  grid.appendRow();
  }
  
  function toastGridReload(){
	  
  }
  
  function toastGridExcel(){
	  console.log('**downloadExcel**');
  }
  
  function toastGridExcelAll(){
	  console.log('**downloadExcelAll**');
  }
  
  grid.on('click', function(ev) {
	    console.log('clicked!!!! %s', ev.rowKey);
	    //console.log(ev.instance.el[ev.rowKey+1]);
	    //console.log(ev.currentTarget);
	}).on('dblclick', function() {
	    console.log('double clicked!!');
	    
	}).on('check', function(ev) {
	    console.log('check clicked!!! %s', ev.rowKey);
	    console.log(ev);
	    
	});
  
 
</script>

</html>