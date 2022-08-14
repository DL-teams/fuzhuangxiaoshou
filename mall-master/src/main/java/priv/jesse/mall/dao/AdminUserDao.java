package priv.jesse.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.jesse.mall.entity.AdminUser;

public interface AdminUserDao extends JpaRepository<AdminUser, Integer> {
    //遵守JPA相关的命名规则
    AdminUser findByUsernameAndPassword(String username, String pwd);
}
