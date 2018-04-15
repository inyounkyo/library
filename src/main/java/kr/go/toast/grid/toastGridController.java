package kr.go.toast.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import kr.go.common.menu.MenuCreatePy;
import kr.go.common.menu.MenuLibCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

//import com.kts.toastGrid.service.ToastGridService;

//import org.json.simple.JSONObject; not import  

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;


/**
 * 
 * NHN toast Grid example's 
 * 
 */

@Controller
@RequestMapping("/addOnNet")
public class toastGridController {
	
	private static final Logger logger = LoggerFactory.getLogger(toastGridController.class);
	
	/*@Autowired
	ToastGridService toastService;*/

	@Autowired
	private MenuLibCache menuMapper;

	@Autowired
	@Qualifier("_extraData")
	private ToastGrid_ExtraData toastGridExtraData;
	
	/**
	 * 
	 * basic grid  
	 * 
	 */
	@RequestMapping("/example01basic.do")
	public String test1( Model model ) throws Exception{
		
		System.out.println("--------------------example01basic-------------------- oos grid ");
		
		return "/toast/grid/example01basic";
	}
	
	/**
	 * 
	 * basic extradata  
	 * 
	 */
	@RequestMapping("/exampleExtradata.do")
	public String exampleExtradata( Model model ) throws Exception{
		
		System.out.println("--------------------exampleExtradata-------------------- oos grid ");
		
		return "/toast/grid/exampleExtradata";
	}
	
	/**
	 * 동적 변경 예제
	 * http://nhnent.github.io/tui.grid/1.1.0/tutorial-sample3.html
	 * 
	 */		
	@RequestMapping("/dynamicEx.do")
	public String dynamicEx( Model model ) throws Exception{
		
		System.out.println("--------------------dynamicEx-------------------- ");
		
		return "/toast/grid/dynamicEx";
	}
	
	/**
	 * 
	 * using addon Net remote(server)  return JSON data
	 * 
	 */
	@RequestMapping("/addOnNetTest.do")
	public String addOnNetTest( Model model ) throws Exception{
		
		System.out.println("--------------------addOnNetTest-------------------- oos grid ");
		
		return "/toast/grid/addOnNetTest2";
	}
	
	/**
	 * 
	 *  paging example and 검색조건 테스트 
	 * 
	 */
	@RequestMapping("/addOnNetTestOk.do")
	public @ResponseBody String  addOnNetTestOk( Model model, HttpServletRequest requst) throws Exception{

		System.out.println("addOnNetTestOk-------------------- oos grid ");
		
		int page     = Integer.parseInt(requst.getParameter("page"));
		int perPage = Integer.parseInt(requst.getParameter("perPage"));
		
		logger.info("page:**: " + page);
		logger.info("perPage:**: " + perPage);
		
		logger.info("searchText ::: "+ requst.getParameter("searchText"));
		
		int start = (page - 1) * perPage;
        int end = start + perPage;
        
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("start", start);
        pMap.put("end", end);
        pMap.put("searchText", requst.getParameter("searchText"));

        List<Map<String, Object>> listMap = menuMapper.menuBupyeongCache(); //toastService.selectToastGrid( pMap );

        String totalRowCount = "100"; //((Map)list.get(0)).get("CNT").toString();
       logger.info("totalRowCount:::**:: " + totalRowCount );

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("toastList", toastGridExtraData.rowSpan("DT", listMap, true));
		System.out.println("List of Collection in Java:::" +listMap);
		System.out.println("JSONObject::: "+ jsonObj.get("toastList"));

		//System.out.println("sample:::"+ "[{\"id\":2, \"_extraData\": {\"rowSpan\": {\"genre\": 2,\"NAME\": 2}}, \"NAME\":\"Hello, ssssss!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\",\"artist\":\"Hello, artist!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!666\"}]" );
		return "{ \"result\": true, \"data\":{\"contents\":"+jsonObj.get("toastList").toString()+",\"pagination\": {\"page\":"+page+",\"totalCount\":"+totalRowCount+"}}}";
	}
	
	@RequestMapping(value = "/addOnNetUpdateData.do", method = RequestMethod.POST)
	public @ResponseBody String  addOnNetUpdateData( Model model , HttpServletRequest requst) throws Exception{
		
		System.out.println("--------------------addOnNetUpdateData-------------------- oos grid!!~ ");
		System.out.println(requst.getParameter("updatedRows"));
		System.out.println(model);
		
		return "aaaaaaaaaaaaaaaa";
		
		/*JSONObject jsonObj = new JSONObject();
		List<String> list = toastService.selectToastGrid();
		
		jsonObj.put("toastList", list);
		
		System.out.println( jsonObj.toString() );
		return jsonObj.toString();*/
		//return "[{\"id\":2,\"NAME\":\"Hello, dfsd!NAME\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\",\"artist\":\"Hello, artist!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!\"},{\"id\":2,\"NAME\":\"Hello, User!!!!666\"}]";
		
	}  
	
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/toastGridSelect.do", method = RequestMethod.POST)
	public @ResponseBody String toastGridSelect( Model model , HttpServletRequest requst) throws Exception{
		
		System.out.println("--------------------toastGridSelect-------------------- oos grid!!~ ");
		
		
		return "";
	}  
	
	/**
	 * 
	 * toast grid request ( json data ) to server parsing test 	
	 * 
	 */
	@RequestMapping(value = "/toastGridUpdate.do", method = RequestMethod.POST)
	public @ResponseBody String toastGridUpdate( Model model , HttpServletRequest requst) throws Exception{
		
		System.out.println("--------------------toastGridUpdate-------------------- oos grid!!~ ");
		
		System.out.println( requst.getParameter("updatedRows") );
		
		String strJsonObject = requst.getParameter("updatedRows").replaceAll("&quot;", "\"");
		strJsonObject = "{\"gridDatas\":"+strJsonObject+"}";
		System.out.println(strJsonObject);

		//String str = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
		//{"phonetype":"N95","cat":"WP"}
		
		JSONParser parser = new JSONParser();	
		JSONObject jsonObj = (JSONObject) parser.parse(strJsonObject);
		JSONArray jsonArr= (JSONArray) jsonObj.get("gridDatas");
		
		for(int i=0; i<jsonArr.size(); i++){
			 
            System.out.println("=toastGrid__"+i+" ===========================================");
             
            //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
            JSONObject jsonCellObj = (JSONObject) jsonArr.get(i);
             
            //JSON name으로 추출
            System.out.println("toastGrid: id==>"+jsonCellObj.get("id"));
            System.out.println("toastGrid: NAME==>"+jsonCellObj.get("NAME"));
            System.out.println("toastGrid: artist==>"+jsonCellObj.get("artist"));
            System.out.println("toastGrid: release==>"+jsonCellObj.get("release"));
            System.out.println("toastGrid: type==>"+jsonCellObj.get("type"));

        }
		
		return "";
		
		
	}  
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/toastGridInsert.do", method = RequestMethod.POST)
	public @ResponseBody String toastGridInsert( Model model , HttpServletRequest requst) throws Exception{
		
		System.out.println("--------------------toastGridInsert-------------------- oos grid!!~ ");
		System.out.println( requst.getParameter("createdRows") );
		return "";
		
	}  
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/toastGridDelete.do", method = RequestMethod.POST)
	public @ResponseBody String toastGridDelete( Model model , HttpServletRequest requst) throws Exception{
		
		System.out.println("--------------------toastGridDelete-------------------- oos grid!!~ ");
		
		System.out.println( requst.getParameter("deletedRows") );
		
		String strJsonObject = requst.getParameter("deletedRows").replaceAll("&quot;", "\"");
		strJsonObject = "{\"gridDatas\":"+strJsonObject+"}";
		System.out.println(strJsonObject);
		
		
		//String str = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
		//{"phonetype":"N95","cat":"WP"}
		
		JSONParser parser = new JSONParser();	
		JSONObject jsonObj = (JSONObject) parser.parse(strJsonObject);
		JSONArray jsonArr= (JSONArray) jsonObj.get("gridDatas");
		
		for(int i=0; i<jsonArr.size(); i++){
			 
            System.out.println("=toastGrid__"+i+" ===========================================");
             
            //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
            JSONObject jsonCellObj = (JSONObject) jsonArr.get(i);
             
            //JSON name으로 추출
            System.out.println("toastGrid: id==>"+jsonCellObj.get("id"));
            System.out.println("toastGrid: NAME==>"+jsonCellObj.get("NAME"));
            System.out.println("toastGrid: artist==>"+jsonCellObj.get("artist"));
            System.out.println("toastGrid: release==>"+jsonCellObj.get("release"));
            System.out.println("toastGrid: type==>"+jsonCellObj.get("type"));

        }
		
		return "";
		
		
	}  
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/downloadExcel.do", method = RequestMethod.POST)
	public @ResponseBody String downloadExcel( Model model , HttpServletRequest requst) throws Exception{
		
		System.out.println("--------------------downloadExcel-------------------- oos grid!!~ ");
		//System.out.println( requst.getParameter("XX") );
		
		return "";
		
	} 
	
	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/downloadExcelAll.do", method = RequestMethod.POST)
	public @ResponseBody String downloadExcelAll( Model model , HttpServletRequest requst) throws Exception{
		
		System.out.println("--------------------downloadExcelAll-------------------- oos grid!!~ ");
		//System.out.println( requst.getParameter("XXX") );
		
		return "";
		
	}  
	
}


