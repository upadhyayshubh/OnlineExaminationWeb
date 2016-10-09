/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hcl.onlineexam.dto;

/**
 *
 * @author HP
 */
public class Category {
    
    String cid;
    String cname;
    String total;

    public Category() {
    }

    public Category(String cid, String cname, String total) {
        this.cid = cid;
        this.cname = cname;
        this.total = total;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
    
    
}
