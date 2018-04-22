<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Add ON(Net) Test^._.^</title>
    <link rel="stylesheet" type="text/css" href="/css/explain.css" />
    <link rel="stylesheet" type="text/css" href="/node_modules/tui-grid/dist/tui-grid.css" />
    <link rel="stylesheet" type="text/css" href="/node_modules/tui-pagination/dist/tui-pagination.css" />

	<style>
		.bgClass {  background-color: coral;  }
		.bgSky {  background-color: skyblue;  }
		.bgWhite {  background-color: white;  }
		/*.tui-grid-body-area {
			background-color: white;
		}*/
	</style>

	<script>
     var ttema =    {
            grid: {
              //  background: '#fff',
                    border: '#ccc',
                    text: '#444'
            },
            selection: {
                background: '#4daaf9',
                    border: '#004082'
            },
            toolbar: {
                border: '#ccc',
                    background: '#fff'
            },
            scrollbar: {
                background: '#f5f5f5',
                    thumb: '#d9d9d9',
                    active: '#c1c1c1'
            },
            cell: {
                normal: {
                    background: '#fffffhack',
                        border: '#e0e0e0'
                },
                head: {
                    //background: '#eee',
                        border: '#ccc'
                },
                editable: {
                   // background: '#fbfbfb'
                },
                selectedHead: {
                    //background: '#d8d8d8'
                },
                focused: {
                    border: '#418ed4'
                },
                disabled: {
                    text: '#b0b0b0'
                },
                evenRow: {
                    //background: '#fbfbfb'
                },
                currentRow: {
                    //background: '#e0ffe0'
                }
            }
        }

	</script>

</head>  
<body>

	<div id="form_skin" > 
			<ul class="form_info">
			<li>조건별로 검색하실 수 있습니다.</li>
			<li>검색조건에서 적절한 범위를 선택하시면 원하는 내용을 검색 하실 수 있습니다.</li>
		</ul>

<!-- 검색폼시작 -->
		<form name="searchform" method="post" action="/source/assembly/detail/detail3.html#postop" >
			<fieldset>
				<legend>조건별 검색</legend>
				<input type="hidden" name="mode" value="sch" title="숨겨진요소" />
				<ul class="con_box" style="font-size:10px;">
					<li class="con">  
						<p class="title"><label for="">대수구분</label></p>
						<p class="details">
							<input type="radio" name="daesu" id="daesu7" value="7" title="7대" class="type-radio" checked="checked" onchange="changeCommitte(this.value);"/><label for="daesu7">7대</label>
							<input type="radio" name="daesu" id="daesu6" value="6" title="6대" class="type-radio"  onchange="changeCommitte(this.value);"/><label for="daesu6">6대</label>
							<input type="radio" name="daesu" id="daesu5" value="5" title="5대" class="type-radio"  onchange="changeCommitte(this.value);"/><label for="daesu5">5대</label>
							<input type="radio" name="daesu" id="daesu4" value="4" title="4대" class="type-radio"  onchange="changeCommitte(this.value);"/><label for="daesu4">4대</label>
							<input type="radio" name="daesu" id="daesu3" value="3" title="3대" class="type-radio"  onchange="changeCommitte(this.value);"/><label for="daesu3">3대</label>
							<input type="radio" name="daesu" id="daesu2" value="2" title="2대" class="type-radio"  onchange="changeCommitte(this.value);"/><label for="daesu2">2대</label>
							<input type="radio" name="daesu" id="daesu1" value="1" title="1대" class="type-radio"  onchange="changeCommitte(this.value);"/><label for="daesu1">1대</label>
						<input type="radio" name="daesu" id="daesux" value="x" title="전체" class="type-radio"  onchange="changeCommitte(this.value);"/><label for="daesux">전체</label>
						</p>
					</li>
					<li class="con">
						<p class="title"><label for="gubun">회의구분</label></p>
						<p class="details">
						<select name="fcode" id="gubun" title="회의구분">
							<option value="x"  title="전체"  >전&nbsp;&nbsp;&nbsp;&nbsp;체</option>
							<option value="A"  title="본회의" >본회의</option>					
							 
								<option value="C"  title="상임위원회" >상임위원회</option> 
														<option value="E"  title="예산결산특별위원회" >예산결산특별위원회</option>
							<option value="G"  title="특별위원회" >특별위원회</option>
							<option value="J"  title="행정사무감사" >행정사무감사</option>
						</select>
						</p>
					</li>
					<li class="con">
						<p class="title"><label for="">검색어</label></p>
						<p class="details">
							<input type="text" name="keyword" id="searchText" class="txt" size="50" title="검색어를 입력하세요" /><span class="impo">(예 : 교육지원 조례안)
						</p>
					</li>
				</ul> 
				<!-- //검색폼종료 -->
				<p class="btn">
					<input type="button" onclick="search_f();"  value="검색" alt="검색" title="검색" />  
				</p>
			</fieldset>
		</form>
	</div>

<div class="code-html">
    <div id="grid"></div>
</div>

</body>

<script src="/node_modules/jquery/dist/jquery.min.js"></script>
<script src="/node_modules/underscore/underscore.js"></script>
<script src="/node_modules/backbone/backbone.js"></script>
<script src="/node_modules/tui-code-snippet/dist/tui-code-snippet.js"></script>
<script src="/node_modules/tui-pagination/dist/tui-pagination.js"></script>
<script src="/node_modules/tui-date-picker/dist/tui-date-picker.js"></script>
<script src="/node_modules/tui-grid/dist/tui-grid.js"></script>

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
                title: 'Date',
                name: 'DT'
            },
            {
                title: 'Name',
                name: 'NAME'
            },
            {
                title: 'Artist',
                name: 'ARTIST',
                formatter: function(value, rowData) {

                    var albumId = rowData.GUBUN;
                    var url = 'http://music.bugs.co.kr/album/' + albumId;
                    if( rowData.GUBUN == 10) {
                        grid.addCellClassName(rowData.rowKey, "ARTIST", "bgClass");


                        return value;
                        //return '<div style="padding:0;background-color:coral;">' + value + '</div>';
                    }else if(rowData.GUBUN == 20) {

                        grid.addCellClassName(rowData.rowKey, "NAME", "bgSky");
                        return value;
                        //return '<div style="padding:0;background-color:pink;">' + value + '</div>';
                    }else if(rowData.GUBUN == 30){
                       // return value;
                        //return '<div style="padding:0;background-color:yellowgreen;">' + value + '</div>';
                    }
                }
            }
        ]
    });
    
    grid.use('Net', {
        perPage: 10,
        readDataMethod: 'POST',
        enableAjaxHistory: true,
        api: {
            'readData': '/addOnNet/addOnNetTestOk.do'
        }
    });
    
    var net = grid.getAddOn('Net');
    
    // Bind event handlers
    grid.on('beforeRequest', function(data) {
        // For all requests
        
    }).on('response', function(data) {
       // this.setData(data.responseData);

           
    }).on('successResponse', function(data) {
        // Only if response.result is true

       // console.log(data.responseData.data);
        $('.tui-grid-body-area').attr("class", 'bgWhite');
        tui.Grid.applyTheme('default', ttema);
        this.setData(data.responseData.data);
          
    }).on('failResponse', function(data) {
        // Only if response.result is false
        console.log('failResponse');
        
    }).on('errorResponse', function(data) {
        // For error response
    	console.log('errorResponse444');
        console.log(data);
		this.destroy();
		//this.restore();
		this.getAddOn("grid");
    });

   // console.log(net.api.readData);

    function search_f(){

    	// url parameters setting
    	var searchObj = {
				"searchText" : $("#searchText").val()
		};
    	//net.reloadData();
    	//net.readData(1, searchObj);
    }

</script>

</html>