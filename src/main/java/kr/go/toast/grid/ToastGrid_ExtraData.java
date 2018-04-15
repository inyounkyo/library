package kr.go.toast.grid;

import java.util.List;
import java.util.Map;

public interface ToastGrid_ExtraData {

    public List<Map<String, Object>>  rowSpan( String  mergeColumnNm,
                                               List<Map<String, Object>> listMap,
                                               boolean isMerge);

}
