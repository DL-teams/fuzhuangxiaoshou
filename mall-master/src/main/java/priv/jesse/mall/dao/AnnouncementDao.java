package priv.jesse.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.jesse.mall.entity.Announcement;

public interface AnnouncementDao extends JpaRepository<Announcement, Long> {
}
