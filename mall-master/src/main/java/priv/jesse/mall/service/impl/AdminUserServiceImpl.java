package priv.jesse.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import priv.jesse.mall.dao.AdminUserDao;
import priv.jesse.mall.entity.AdminUser;
import priv.jesse.mall.service.AdminUserService;
import priv.jesse.mall.service.exception.LoginException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;

    @Override//父类方法的重写
    public AdminUser findById(int id) {
        return adminUserDao.getOne(id);
    }

    @Override
    public Page<AdminUser> findAll(Pageable pageable) {
        return adminUserDao.findAll(pageable);
    }

    @Override
    public List<AdminUser> findAllExample(Example<AdminUser> example) {
        return adminUserDao.findAll(example);
    }

    @Override
    public void update(AdminUser adminUser) {
        adminUserDao.save(adminUser);
    }

    @Override
    public int create(AdminUser adminUser) {
        AdminUser adminUser1 = adminUserDao.save(adminUser);
        return adminUser.getId();
    }

    @Override
    public void delById(int id) {
        adminUserDao.delete(id);
    }

    @Override
    /**
     * request对象用于封装HTTP在当次请求中的数据
     * response对象用于封装响应给客户端浏览器的数据
    * */
    public AdminUser checkLogin(HttpServletRequest request, String username, String pwd) {
        AdminUser adminUser = adminUserDao.findByUsernameAndPassword(username, pwd);
        //adminuser(两种结果)(null)(adminuser)

        if (adminUser != null) {
            request.getSession().setAttribute("login_user", adminUser);
            //把adminUser保存到session里面
        } else {
            throw new LoginException("用户名或密码错误");
        }
        return adminUser;
    }
}
