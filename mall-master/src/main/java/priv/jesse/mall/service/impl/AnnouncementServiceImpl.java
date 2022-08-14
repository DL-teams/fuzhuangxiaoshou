package priv.jesse.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import priv.jesse.mall.dao.AnnouncementDao;
import priv.jesse.mall.entity.Announcement;
import priv.jesse.mall.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Resource
    private AnnouncementDao announcementDao;

    @Override
    public Page<Announcement> findAll(Pageable pageable) {
        return announcementDao.findAll(pageable);
    }

    @Override
    public List<Announcement> findAll() {
        return announcementDao.findAll();
    }

    @Override
    public void delById(Long id) {
        announcementDao.delete(id);
    }

    @Override
    public Long create(Announcement announcement) {
        return announcementDao.save(announcement).getAnnouncementId();
    }

    @Override
    public Announcement findById(Long id) {
        return announcementDao.findOne(id);
    }

    @Override
    public void update(Announcement announcement) {
        announcementDao.save(announcement);
    }
}
