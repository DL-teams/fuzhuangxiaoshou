package priv.jesse.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Announcement implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private Long announcementId;

    @Column(nullable = false)
    private String announcementValue;

    @Column
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date announcementCreateTime;

    @Column
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date announcementLastModifyTime;

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementValue() {
        return announcementValue;
    }

    public void setAnnouncementValue(String announcementValue) {
        this.announcementValue = announcementValue;
    }

    public Date getAnnouncementCreateTime() {
        return announcementCreateTime;
    }

    public void setAnnouncementCreateTime(Date announcementCreateTime) {
        this.announcementCreateTime = announcementCreateTime;
    }

    public Date getAnnouncementLastModifyTime() {
        return announcementLastModifyTime;
    }

    public void setAnnouncementLastModifyTime(Date announcementLastModifyTime) {
        this.announcementLastModifyTime = announcementLastModifyTime;
    }
}
