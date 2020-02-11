package com.yuan.model;

public class Airplane {
    private Integer id;

    private String airnumber;

    private Integer companyId;

    private Integer firstclass;

    private String aptype;

    private Integer economyclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirnumber() {
        return airnumber;
    }

    public void setAirnumber(String airnumber) {
        this.airnumber = airnumber == null ? null : airnumber.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getFirstclass() {
        return firstclass;
    }

    public void setFirstclass(Integer firstclass) {
        this.firstclass = firstclass;
    }

    public String getAptype() {
        return aptype;
    }

    public void setAptype(String aptype) {
        this.aptype = aptype == null ? null : aptype.trim();
    }

    public Integer getEconomyclass() {
        return economyclass;
    }

    public void setEconomyclass(Integer economyclass) {
        this.economyclass = economyclass;
    }
}