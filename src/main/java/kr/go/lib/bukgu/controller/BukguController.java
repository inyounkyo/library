package kr.go.lib.bukgu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping("bukgu")
public class BukguController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.pyMenuMain.path}")
    String path;

    @RequestMapping("/index")
    public String index(){
        return "bukgu/index";
    }

    @RequestMapping(value="/libMaterialSearch", method = RequestMethod.GET)
    public String libMaterialSearch( ModelMap model)throws IOException {

        return "/bukgu/libMaterialSearch";
    }

    @RequestMapping(value="/otherLibMaterialSearch", method= RequestMethod.GET)
    public String otherLibMaterialSearch(     ModelMap model ){
        return "/bukgu/otherLibMaterialSearch";
    }

    @RequestMapping(value="/infoUse", method= RequestMethod.GET)
    public String infoUse( ModelMap model ){
        return "/bukgu/infoUse";
    }

    @RequestMapping(value="/surveyClosed", method= RequestMethod.GET)
    public String surveyClosed(     ModelMap model ){
        return "/bukgu/surveyClosed";
    }

    @RequestMapping(value="/refRoomGuide", method= RequestMethod.GET)
    public String refRoomGuide(     ModelMap model ){
        return "/bukgu/refRoomGuide";
    }

    @RequestMapping(value="/synthRefRoom", method= RequestMethod.GET)
    public String synthRefRoom(     ModelMap model ){
        return "/bukgu/synthRefRoom";
    }

    @RequestMapping(value="/kidRefRoom", method= RequestMethod.GET)
    public String kidRefRoom(     ModelMap model ){
        return "/bukgu/kidRefRoom";
    }

    @RequestMapping(value="/routinPub", method= RequestMethod.GET)
    public String routinPub(     ModelMap model ){
        return "/bukgu/routinPub";
    }

    @RequestMapping(value="/digiRefRoom", method= RequestMethod.GET)
    public String digiRefRoom(     ModelMap model ){
        return "/bukgu/digiRefRoom";
    }

    @RequestMapping(value="/loanReturnGuide", method= RequestMethod.GET)
    public String loanReturnGuide(     ModelMap model ){
        return "/bukgu/loanReturnGuide";
    }

    @RequestMapping(value="/foreverLing", method= RequestMethod.GET)
    public String foreverLing(     ModelMap model ){
        return "/bukgu/foreverLing";
    }

    @RequestMapping(value="/foreverLNews", method= RequestMethod.GET)
    public String foreverLNews(     ModelMap model ){
        return "/bukgu/foreverLNews";
    }

    @RequestMapping(value="/activeWork", method= RequestMethod.GET)
    public String activeWork(     ModelMap model ){
        return "/bukgu/activeWork";
    }

    @RequestMapping(value="/eventGallery", method= RequestMethod.GET)
    public String eventGallery(     ModelMap model ){
        return "/bukgu/eventGallery";
    }

    @RequestMapping(value="/onlineReceipt", method= RequestMethod.GET)
    public String onlineReceipt(     ModelMap model ){
        return "/bukgu/onlineReceipt";
    }

    @RequestMapping(value="/foreverLGuide", method= RequestMethod.GET)
    public String foreverLGuide(     ModelMap model ){
        return "/bukgu/foreverLGuide";
    }

    @RequestMapping(value="/libService", method= RequestMethod.GET)
    public String libService(     ModelMap model ){
        return "/bukgu/libService";
    }

    @RequestMapping(value="/thisMonthEvent", method= RequestMethod.GET)
    public String thisMonthEvent(     ModelMap model ){
        return "/bukgu/thisMonthEvent";
    }

    @RequestMapping(value="/interLoan", method= RequestMethod.GET)
    public String interLoan(     ModelMap model ){
        return "/bukgu/interLoan";
    }

    @RequestMapping(value="/ReadingCerSeatingStatus", method= RequestMethod.GET)
    public String ReadingCerSeatingStatus(     ModelMap model ){
        return "/bukgu/ReadingCerSeatingStatus";
    }

    @RequestMapping(value="/digiRefSeatReser", method= RequestMethod.GET)
    public String digiRefSeatReser(     ModelMap model ){
        return "/bukgu/digiRefSeatReser";
    }

    @RequestMapping(value="/movieScreenGuide", method= RequestMethod.GET)
    public String movieScreenGuide(     ModelMap model ){
        return "/bukgu/movieScreenGuide";
    }

    @RequestMapping(value="/supportPur", method= RequestMethod.GET)
    public String supportPur(     ModelMap model ){
        return "/bukgu/supportPur";
    }

    @RequestMapping(value="/refRoom", method= RequestMethod.GET)
    public String refRoom(     ModelMap model ){
        return "/bukgu/refRoom";
    }

    @RequestMapping(value="/openField", method= RequestMethod.GET)
    public String openField(     ModelMap model ){
        return "/bukgu/openField";
    }

    @RequestMapping(value="/notice", method= RequestMethod.GET)
    public String notice(     ModelMap model ){
        return "/bukgu/notice";
    }


    @RequestMapping(value="/lostProGuide", method= RequestMethod.GET)
    public String lostProGuide(     ModelMap model ){
        return "/bukgu/lostProGuide";
    }

}