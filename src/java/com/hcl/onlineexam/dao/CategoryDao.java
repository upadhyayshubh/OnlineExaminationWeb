/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hcl.onlineexam.dao;

import java.util.List;
import com.hcl.onlineexam.dto.Category;
import com.hcl.onlineexam.services.DataBaseServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author HP
 */
public class CategoryDao {
    
    
    public static  List<Category> GetAllCategory()
    { 
        List<Category> clist=new ArrayList<Category>();
        
        try {
            Connection conn=DataBaseServices.getConnection();
            PreparedStatement ps=conn.prepareStatement("Select * from category");
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {    
                
                String cid=rs.getString(1);
                String cname=rs.getString(2);
                String total=rs.getString(3);
                
               Category c=new Category(cid, cname, total);
               
               clist.add(c);
            }
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
        return clist;
        
    }
    
}
        
    
    
    

