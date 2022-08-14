package priv.jesse.mall.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import priv.jesse.mall.entity.Announcement;

public interface AnnouncementService {

    Page<Announcement> findAll(Pageable pageable);

    void delById(Long id);

    Long create(Announcement announcement);

    Announcement findById(Long id);

    void update(Announcement announcement);
}
