package com.reflection.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * Created by mesut on 27.07.2016.
 */
@MappedSuperclass
public class BaseModel implements Serializable {

    @Column(name = "VERION", nullable = true)
    @Version
    private int version = 1;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active = true;

    @Column(name = "DELETED", nullable = false)
    private boolean deleted = false;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
