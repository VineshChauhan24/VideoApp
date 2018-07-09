package com.example.video.videoapp.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "CONTENTS")
public class Contents {

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("youtubeID")
    @Property(nameInDb = "youtubeID")
    private Long youtubeID;

    @Expose
    @SerializedName("playID")
    @Property(nameInDb = "playID")
    private Long playID;

    @ToOne(joinProperty = "id")
    private Images images;

    @Expose
    @SerializedName("title")
    @Property(nameInDb = "title")
    private Long title;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 753358048)
    private transient ContentsDao myDao;

    @Generated(hash = 2049067200)
    public Contents(Long id, Long youtubeID, Long playID, Long title) {
        this.id = id;
        this.youtubeID = youtubeID;
        this.playID = playID;
        this.title = title;
    }

    @Generated(hash = 30448907)
    public Contents() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYoutubeID() {
        return this.youtubeID;
    }

    public void setYoutubeID(Long youtubeID) {
        this.youtubeID = youtubeID;
    }

    public Long getPlayID() {
        return this.playID;
    }

    public void setPlayID(Long playID) {
        this.playID = playID;
    }

    public Long getTitle() {
        return this.title;
    }

    public void setTitle(Long title) {
        this.title = title;
    }

    @Generated(hash = 1730634245)
    private transient Long images__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1153876564)
    public Images getImages() {
        Long __key = this.id;
        if (images__resolvedKey == null || !images__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ImagesDao targetDao = daoSession.getImagesDao();
            Images imagesNew = targetDao.load(__key);
            synchronized (this) {
                images = imagesNew;
                images__resolvedKey = __key;
            }
        }
        return images;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 613372682)
    public void setImages(Images images) {
        synchronized (this) {
            this.images = images;
            id = images == null ? null : images.getId();
            images__resolvedKey = id;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1067870293)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getContentsDao() : null;
    }
}
