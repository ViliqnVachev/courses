package com.viliqn.entities;

import com.viliqn.db.anotation.Column;
import com.viliqn.db.anotation.Entity;
import com.viliqn.db.anotation.PrimaryKey;

@Entity(name = "minions")
public class Minions {
    @PrimaryKey(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private long age;

    @Column(name = "town_id")
    private long townId;

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Column(name = "town_name")
    private String townName;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setTownId(long townId) {
        this.townId = townId;
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }

    public long getTownId() {
        return townId;
    }

    @Override
    public String toString() {
        return String.format("%d    | %s    | %s    | %d",
                getId(), getName(), getAge(), getTownId());
    }
}
