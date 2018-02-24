package kr.go.common.aspectj;

import kr.go.common.menu.MenuLibCacheImple;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class MenuAuthAj {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MenuLibCacheImple mlCache;

    private final String PRIVATE = "Private";
    private final String PUBLIC = "Public";

    @Before("execution(* kr.go.lib.*.controller.*.*(..))")
    public void menuAuthBefore(JoinPoint joinPoint)throws Throwable{
    }

    @Around("execution(* kr.go.lib.*.controller.*.*(..))")
    public Object menuAuthAround(final ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse rep = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HttpSession session = req.getSession();

        logger.info("aop_id:::"+session.getAttribute("id"));
        logger.info("aop_password:::"+session.getAttribute("password"));
        //logger.info("menuCacheTest::"+ mlCache.menuBukguCache());
        logger.info("getUri::"+req.getRequestURI());
        logger.info("getUrlContext::"+ req.getRequestURI().indexOf("/",2) );
        logger.info("getUrlsubstring::"+ req.getRequestURI().substring(0,req.getRequestURI().indexOf("/",2)) );
        logger.info("getUrL::"+req.getRequestURL());
        logger.info("StringMehthodFirstUpper():::"+StringUtils.capitalize(req.getRequestURI().replaceAll("/","")));

        String urlContext = req.getRequestURI().substring(0,req.getRequestURI().indexOf("/",2));
        Method method = mlCache.getClass().getMethod(
                "menu"+StringUtils.capitalize(urlContext.replaceAll("/",""))+"Cache");

        Map<String,Object> sameRowMap = null;
        for(Map<String,Object> rowMap : (List<Map<String, Object>>)method.invoke(mlCache)){
            //logger.info("rowMap.M_URL:::"+rowMap.get("M_URL"));
            if(rowMap.get("M_URL").equals(req.getRequestURI())){
                sameRowMap = rowMap;
            }
        }
        logger.info("sameRowMap:::"+sameRowMap);
        //if call not url forwarding for main page
        if(sameRowMap == null){
            //req.getRequestDispatcher("/main").forward(req, rep);
        }
        //public page
        else if(sameRowMap != null && sameRowMap.get("M_ACCESSAUTH").equals(PUBLIC)){

        }
        //if private this page so need to session
        else if(sameRowMap != null &&
                sameRowMap.get("M_ACCESSAUTH").equals(PRIVATE) &&
                session.getAttribute("id") == null){

            session.setAttribute("afterUri", req.getRequestURI());
            req.getRequestDispatcher("/login/").forward(req, rep);

        }
        else{}

        return joinPoint.proceed();
    }


}
