package kr.go.common.menu;

import java.util.List;
import java.util.Map;

public interface MenuLibCache {

    public List<Map<String, Object>> menuBukguCache(String libCd);
    public Map<String, Object> menuBupyeongCache();
    public Map<String, Object> menuElibCache();
    public Map<String, Object> menuGyeyangCache();
    public Map<String, Object> menuHwadojinCache();
    public Map<String, Object> menuIceCache();
    public Map<String, Object> menuJuanCache();
    public Map<String, Object> menuJungangCache();
    public Map<String, Object> menuSeoguCache();
    public Map<String, Object> menuYeonsuCache();

}
