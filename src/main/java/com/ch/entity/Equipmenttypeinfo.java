package com.ch.entity;

public class Equipmenttypeinfo {
    private Integer id;

    private String name;

    private String equiptype;

    private String typenumber;

    private String userange;

    private Integer uselimit;

    private String status;

    private Integer infoid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquiptype() {
        return equiptype;
    }

    public void setEquiptype(String equiptype) {
        this.equiptype = equiptype;
    }

    public String getTypenumber() {
        return typenumber;
    }

    public void setTypenumber(String typenumber) {
        this.typenumber = typenumber;
    }

    public String getUserange() {
        return userange;
    }

    public void setUserange(String userange) {
        this.userange = userange;
    }

    public Integer getUselimit() {
        return uselimit;
    }

    public void setUselimit(Integer uselimit) {
        this.uselimit = uselimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }
}