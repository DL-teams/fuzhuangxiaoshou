package priv.jesse.mall.web.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.jesse.mall.entity.Announcement;
import priv.jesse.mall.entity.pojo.ResultBean;
import priv.jesse.mall.service.AnnouncementService;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping("/get.do")
    public ResultBean<List<Announcement>> get() {
        List<Announcement> announcementList = announcementService.findAll();
        return new ResultBean<>(announcementList);
    }
}
