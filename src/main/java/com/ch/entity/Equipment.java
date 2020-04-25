package com.ch.entity;

public class Equipment {
    private Integer id;

    private String equipmentname;

    private Integer uselimit;

    private String status;

    private String isinput;

    private String isoutput;

    private Integer typeid;

    private Integer infoid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
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

    public String getIsinput() {
        return isinput;
    }

    public void setIsinput(String isinput) {
        this.isinput = isinput;
    }

    public String getIsoutput() {
        return isoutput;
    }

    public void setIsoutput(String isoutput) {
        this.isoutput = isoutput;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentname='" + equipmentname + '\'' +
                ", uselimit=" + uselimit +
                ", status='" + status + '\'' +
                ", isinput='" + isinput + '\'' +
                ", isoutput='" + isoutput + '\'' +
                ", typeid=" + typeid +
                ", infoid=" + infoid +
                '}';
    }
}