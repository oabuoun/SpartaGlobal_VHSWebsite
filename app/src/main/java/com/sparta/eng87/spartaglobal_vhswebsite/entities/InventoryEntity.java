package com.sparta.eng87.spartaglobal_vhswebsite.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "inventory", schema = "sakila", catalog = "")
public class InventoryEntity {
    private Integer inventoryId;
    private Integer filmId;
    private Integer storeId;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "inventory_id")
    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Basic
    @Column(name = "film_id")
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "store_id")
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryEntity that = (InventoryEntity) o;

        if (inventoryId != null ? !inventoryId.equals(that.inventoryId) : that.inventoryId != null) return false;
        if (filmId != null ? !filmId.equals(that.filmId) : that.filmId != null) return false;
        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inventoryId != null ? inventoryId.hashCode() : 0;
        result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
