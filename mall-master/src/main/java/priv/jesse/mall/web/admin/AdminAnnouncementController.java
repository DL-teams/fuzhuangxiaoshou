package priv.jesse.mall.web.admin;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.jesse.mall.entity.Announcement;
import priv.jesse.mall.entity.User;
import priv.jesse.mall.entity.pojo.ResultBean;
import priv.jesse.mall.service.AnnouncementService;

@Controller
@RequestMapping("/admin/announcement")
public class AdminAnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    /**
     * 打开公告列表页面
     * @return
     */
    @RequestMapping(value = "/toList.html",method = RequestMethod.GET)
    public String toList() {
        return "admin/announcement/list";
    }

    @ResponseBody
    @GetMapping("/list.do")
    public ResultBean<List<Announcement>> listAnnouncement(int pageindex,
                                                      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        Pageable pageable = new PageRequest(pageindex, pageSize, null);
        List<Announcement> list = announcementService.findAll(pageable).getContent();
        return new ResultBean<>(list);
    }

    @ResponseBody
    @RequestMapping("/getTotal")
    public ResultBean<Integer> getTotal() {
        Pageable pageable = new PageRequest(1, 15, null);
        int total = (int) announcementService.findAll(pageable).getTotalElements();
        return new ResultBean<>(total);
    }

    @RequestMapping("/del.do")
    @ResponseBody
    public ResultBean<Boolean> del(Long id) {
        announcementService.delById(id);
        return new ResultBean<>(true);
    }

    @RequestMapping("/toEdit.html")
    public String toEdit(int id, Map<String, Object> map) {
        Announcement anno = announcementService.findById((long) id);
        map.put("announcement", anno);
        return "admin/announcement/edit";
    }

    @RequestMapping("/toAdd.html")
    public String toAdd() {
        return "admin/announcement/add";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add.do")
    public void add(String announcementValue,
                    HttpServletRequest request,
                    HttpServletResponse response) throws Exception {


        Announcement announcement = new Announcement();
        announcement.setAnnouncementValue(announcementValue);
        announcement.setAnnouncementCreateTime(new Date());
        announcement.setAnnouncementLastModifyTime(new Date());
        Long id = announcementService.create(announcement);
        if (id <= 0) {
            request.setAttribute("message", "添加失败！");
            request.getRequestDispatcher("toAdd.html").forward(request, response);
        } else {
            request.getRequestDispatcher("toEdit.html?id=" + id).forward(request, response);
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/update.do")
    public void update(Long id,
                       String announcementValue,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        Announcement announcement = announcementService.findById(id);
        announcement.setAnnouncementValue(announcementValue);
        Boolean flag = false;
        try {
            announcementService.update(announcement);
            flag = true;
        } catch (Exception e) {
            throw new Exception(e);
        }
        if (!flag) {
            request.setAttribute("message", "更新失败！");
        }
        response.sendRedirect("toList.html");
    }
}
