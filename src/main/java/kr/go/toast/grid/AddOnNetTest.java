package kr.go.toast.grid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("addOnNet")
public class AddOnNetTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/example01basic", method = RequestMethod.GET)
    public String example01basic( ModelMap model)throws IOException {

        return "/toast/grid/example01basic";
    }

    @RequestMapping(value="/addOnNetTest1", method = RequestMethod.GET)
    public String addOnNetTest( ModelMap model)throws IOException {
        return "/toast/grid/addOnNetTest1";
    }

    @RequestMapping(value="/addOnNetTestOk")
    public @ResponseBody String addOnNetTest1( ModelMap model)throws IOException {
        System.out.println("/addOnNetTestOk");
        return "[{\"id\":2,\"name\":\"Hello, inyounkyo!\"},{\"id\":2,\"name\":\"Hello, User!!!!\",\"artist\":\"Hello, artist!!!!\"},{\"id\":2,\"name\":\"Hello, User!!!!\"},{\"id\":2,\"name\":\"Hello, User!!!!\"},{\"id\":2,\"name\":\"Hello, User!!!!\"},{\"id\":2,\"name\":\"Hello, User!!!!\"},{\"id\":2,\"name\":\"Hello, User!!!!666\"}]";
        //return "[{name: 'Beautiful Lies', artist: 'Birdy'},{name: 'Beautiful Lies', artist: 'Birdy'},{name: 'Beautiful Lies', artist: 'Birdy'},{name: 'Beautiful Lies', artist: 'Birdy'}]";
    }

}
