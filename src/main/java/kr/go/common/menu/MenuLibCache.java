package kr.go.common.menu;

import java.util.List;
import java.util.Map;

public interface MenuLibCache {

    public List<Map<String, Object>> menuBukguCache(String libCd);
    public List<Map<String, Object>> menuBupyeongCache();
    public Map<String, Object> menuElibCache(String libCd);
    public Map<String, Object> menuGyeyangCache(String libCd);
    public Map<String, Object> menuHwadojinCache(String libCd);
    public Map<String, Object> menuIceCache(String libCd);
    public Map<String, Object> menuJuanCache(String libCd);
    public Map<String, Object> menuJungangCache(String libCd);
    public Map<String, Object> menuSeoguCache(String libCd);
    public Map<String, Object> menuYeonsuCache(String libCd);

}
