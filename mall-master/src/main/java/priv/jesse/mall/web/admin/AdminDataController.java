package priv.jesse.mall.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: hzl
 * @CreateDate: 2022/8/10
 */

@Controller
@RequestMapping("/admin/data")
public class AdminDataController {

    @RequestMapping("/toList.html")
    public String toIndex(){
        return "admin/data/data";
    }
}
