package kr.go.common.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuLibCacheImple {

        Logger logger = LoggerFactory.getLogger(this.getClass());

        @Autowired
        private MenuLibCache menuMapper;

        @PostConstruct
        public void menuInit(){
            logger.info("menuInit TEST....");

       /* menuBukguCache();
        menuBupyeongCache();
        menuElibCache();
        menuGyeyangCache();
        menuHwadojinCache();
        menuIceCache();
        menuJuanCache();
        menuJungangCache();
        menuSeoguCache();
        menuYeonsuCache();*/
    }

    @Cacheable(value = "menu.bukgu", key = "#root.methodName")
    public List<Map<String, Object>> menuBukguCache() {
        logger.info("bukgu.....");
        return menuMapper.menuBukguCache("LIB001");
    }

    @Cacheable("menu.bupyeong")
    public Map<String, Object> menuBupyeongCache() {
        return null;
    }

    @Cacheable("menu.elib")
    public Map<String, Object> menuElibCache() {
        return null;
    }

    @Cacheable("menu.gyeyang")
    public Map<String, Object> menuGyeyangCache() {
        return null;
    }

    @Cacheable("menu.hwadojin")
    public Map<String, Object> menuHwadojinCache() {
        return null;
    }

    @Cacheable("menu.ice")
    public Map<String, Object> menuIceCache() {
        return null;
    }

    @Cacheable("menu.juan")
    public List<Map<String, Object>> menuJuanCache() {
        logger.info("juan.....");
        return menuMapper.menuBukguCache("LIB004");
    }
    @Cacheable("menu.jungang")
    public Map<String, Object> menuJungangCache() {
        return null;
    }

    @Cacheable("menu.seogu")
    public Map<String, Object> menuSeoguCache() {
        return null;
    }

    @Cacheable("menu.yeonsu")
    public Map<String, Object> menuYeonsuCache() {
        return null;
    }
}
