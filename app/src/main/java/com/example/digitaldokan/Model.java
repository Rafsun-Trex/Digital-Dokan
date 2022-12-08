package com.example.digitaldokan;

public class Model {
    String cusname, datetime, id, itemname, phnnum, serialnum, shopname, warranty, price;

    public Model(String cusname, String datetime, String id, String itemname, String phnnum, String serialnum, String shopname, String warranty, String price) {
        this.cusname = cusname;
        this.datetime = datetime;
        this.id = id;
        this.itemname = itemname;
        this.phnnum = phnnum;
        this.serialnum = serialnum;
        this.shopname = shopname;
        this.warranty=warranty;
        this.price = price;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPhnnum() {
        return phnnum;
    }

    public void setPhnnum(String phnnum) {
        this.phnnum = phnnum;
    }

    public String getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
