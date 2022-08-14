package priv.jesse.mall.web.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import priv.jesse.mall.entity.Announcement;
import priv.jesse.mall.entity.pojo.ResultBean;
import priv.jesse.mall.service.AnnouncementService;

@RestController
@RequestMapping("/admin/announcement")
public class AdminAnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @ResponseBody
    @RequestMapping("/list.do")
    public ResultBean<List<Announcement>> listProduct(int pageindex,
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

    @RequestMapping(method = RequestMethod.POST, value = "/add.do")
    public void add(String announcementValue,
                    HttpServletRequest request,
                    HttpServletResponse response) throws Exception {


        Announcement announcement = new Announcement();
        announcement.setAnnouncementValue(announcementValue);

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
