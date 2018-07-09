package com.example.video.videoapp.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "RAILS")
public class Rails {

    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("railId")
    @Property(nameInDb = "railId")
    private String railId;

    @Expose
    @SerializedName("type")
    @Property(nameInDb = "type")
    private String type;

    @Expose
    @SerializedName("packageName")
    @Property(nameInDb = "packageName")
    private String packageName;

    @Generated(hash = 1767641706)
    public Rails(Long id, String railId, String type, String packageName) {
        this.id = id;
        this.railId = railId;
        this.type = type;
        this.packageName = packageName;
    }

    @Generated(hash = 921018469)
    public Rails() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRailId() {
        return this.railId;
    }

    public void setRailId(String railId) {
        this.railId = railId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
