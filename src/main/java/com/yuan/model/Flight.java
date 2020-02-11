package com.yuan.model;

import java.util.Date;

public class Flight {
    private Integer id;

    private Integer airplaneId;

    private String startstation;

    private String terminus;

    private Date deptime;

    private Date arrtime;

    private String firstclass;

    private String economyclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Integer airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public String getTerminus() {
        return terminus;
    }

    public void setTerminus(String terminus) {
        this.terminus = terminus == null ? null : terminus.trim();
    }

    public Date getDeptime() {
        return deptime;
    }

    public void setDeptime(Date deptime) {
        this.deptime = deptime;
    }

    public Date getArrtime() {
        return arrtime;
    }

    public void setArrtime(Date arrtime) {
        this.arrtime = arrtime;
    }

    public String getFirstclass() {
        return firstclass;
    }

    public void setFirstclass(String firstclass) {
        this.firstclass = firstclass == null ? null : firstclass.trim();
    }

    public String getEconomyclass() {
        return economyclass;
    }

    public void setEconomyclass(String economyclass) {
        this.economyclass = economyclass == null ? null : economyclass.trim();
    }
}