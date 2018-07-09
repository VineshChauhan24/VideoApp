package com.example.video.videoapp.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "IMAGES")
public class Images {

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("typeBanner")
    @Property(nameInDb = "typeBanner")
    private String typeBanner;

    @Expose
    @SerializedName("typePortrait")
    @Property(nameInDb = "typePortrait")
    private String typePortrait;

    @Generated(hash = 827674712)
    public Images(Long id, String typeBanner, String typePortrait) {
        this.id = id;
        this.typeBanner = typeBanner;
        this.typePortrait = typePortrait;
    }

    @Generated(hash = 1787213703)
    public Images() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeBanner() {
        return this.typeBanner;
    }

    public void setTypeBanner(String typeBanner) {
        this.typeBanner = typeBanner;
    }

    public String getTypePortrait() {
        return this.typePortrait;
    }

    public void setTypePortrait(String typePortrait) {
        this.typePortrait = typePortrait;
    }

}
