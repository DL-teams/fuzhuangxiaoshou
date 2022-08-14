package priv.jesse.mall.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import priv.jesse.mall.entity.AdminUser;
import priv.jesse.mall.entity.Product;
import priv.jesse.mall.entity.pojo.ResultBean;
import priv.jesse.mall.service.AdminUserService;
import priv.jesse.mall.utils.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: hzl
 * @CreateDate: 2022/8/12
 */

@Controller
@RequestMapping("/admin/adminuser")
public class AdminGuanController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 打开管理员列表页面
     * @return
     */
    @RequestMapping("/toList.html")
    public String toList() {
        return "admin/adminuser/list";
    }

    /**
     * 打开添加管理员页面
     *
     * @param
     * @return
     */
    @RequestMapping("/toAdd.html")
    public String toAdd() {
        return "admin/adminuser/add";
    }

    /**
     * 打开编辑页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/toEdit.html")
    public String toEdit(int id, Map<String, Object> map) {
        AdminUser adminUser = adminUserService.findById(id);
        map.put("adminuser", adminUser);
        return "admin/adminuser/edit";
    }

    /**
     * 获取所有管理员列表
     *
     * @param pageindex
     * @return
     */
    @ResponseBody
    @RequestMapping("/list.do")
    public ResultBean<List<AdminUser>> findAllUser(int pageindex,
                                                   @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        Pageable pageable = new PageRequest(pageindex, pageSize, null);
        List<AdminUser> adminUsers = adminUserService.findAll(pageable).getContent();
        return new ResultBean<>(adminUsers);
    }

    @ResponseBody
    @RequestMapping("/getTotal.do")
    public ResultBean<Integer> geTotal() {
        Pageable pageable = new PageRequest(1, 15, null);
        int total = (int) adminUserService.findAll(pageable).getTotalElements();
        return new ResultBean<>(total);
    }

    @ResponseBody
    @RequestMapping("/del.do")
    public ResultBean<Boolean> del(int id) {
        adminUserService.delById(id);
        return new ResultBean<>(true);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add.do")
    public void add(String username,String password,
                    HttpServletRequest request,
                    HttpServletResponse response) throws Exception {


        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPassword(password);

        int id = adminUserService.create(adminUser);
        if (id <= 0) {
            request.setAttribute("message", "添加失败！");
            request.getRequestDispatcher("toAdd.html").forward(request, response);
        } else {
            request.getRequestDispatcher("toEdit.html?id=" + id).forward(request, response);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/update.do")
    public ResultBean<Boolean> update(int id,String username,
                                      String password) {
        // 更新前先查询
        AdminUser adminUser = adminUserService.findById(id);
        adminUser.setUsername(username);
        adminUser.setPassword(password);
        adminUserService.update(adminUser);
        return new ResultBean<>(true);
    }

}
