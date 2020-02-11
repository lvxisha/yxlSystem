package com.yuan.model;

public class Seat {
    private Integer id;

    private Integer flightId;

    private Boolean rank;

    private Boolean choice;

    private Integer price;

    private Integer jf;

    private String seatnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Boolean getRank() {
        return rank;
    }

    public void setRank(Boolean rank) {
        this.rank = rank;
    }

    public Boolean getChoice() {
        return choice;
    }

    public void setChoice(Boolean choice) {
        this.choice = choice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getJf() {
        return jf;
    }

    public void setJf(Integer jf) {
        this.jf = jf;
    }

    public String getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(String seatnum) {
        this.seatnum = seatnum == null ? null : seatnum.trim();
    }
}