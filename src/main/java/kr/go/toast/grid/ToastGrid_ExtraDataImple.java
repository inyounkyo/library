package kr.go.toast.grid;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value="_extraData")
public class ToastGrid_ExtraDataImple implements ToastGrid_ExtraData {

    @Override
    public List<Map<String, Object>> rowSpan(String mergeColumnNm, List<Map<String, Object>> listMap, boolean isMerge) {

        /*JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("_extraData", "{rowSpan: {genre: 2,NAME: 2}}");
        System.out.println(jsonObj1.get("_extraData"));
        list.get(0).put("_extraData", jsonObj1.get("_extraData"));
        System.out.println(list.get(0));
        "_extraData": {"rowSpan": {"genre": 2,"NAME": 2}}*/

        String _mergeColumnNmUpper = mergeColumnNm.toUpperCase();
        int merCnt = 0;
        for (int o = 0; o < listMap.size() && isMerge; o++) {
            Map<String, Object> outMap = listMap.get(o);

            for (int i = (o + 1); i < listMap.size(); i++) {
                Map<String, Object> inMap = listMap.get(i);
                if (outMap.get(_mergeColumnNmUpper).equals(inMap.get(_mergeColumnNmUpper))) {
                    merCnt++;
                }
                //System.out.println("o:: "+o);
                //System.out.println( outMap.get("ID") + "  outMap.get(DT)"+ outMap.get("DT") +" == "+ "inMap.get(DT)"+ inMap.get("DT") +" , "+merCnt );
            }
            o += merCnt; //outer loop move to point

            JSONObject jsonObj = new JSONObject();
            if (merCnt > 0) {
                jsonObj.put("_extraData", "{rowSpan: {"+_mergeColumnNmUpper+": " + (merCnt + 1) + "}}");
                listMap.get(o - merCnt).put("_extraData", jsonObj.get("_extraData"));
            }
            //System.out.println("o:: "+ o +" , " + outMap.get("ID") + "  outMap.get(DT)"+ outMap.get("DT")+" , "+merCnt);

            jsonObj = null;
            merCnt = 0;
        }

        return listMap;
    }

}
