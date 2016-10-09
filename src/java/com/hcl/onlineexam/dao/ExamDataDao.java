/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hcl.onlineexam.dao;
import com.hcl.onlineexam.dto.ExamData;
import com.hcl.onlineexam.services.DataBaseServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class ExamDataDao {
    
    public static List<ExamData> GetAllQuestions(String cat){
 
        List<ExamData> qlist=new ArrayList<ExamData>();
        
        try {
           
            Connection conn=DataBaseServices.getConnection();
            PreparedStatement ps=conn.prepareStatement("Select * from examdata where category=?");
            ps.setString(1, cat);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                
                String qno=rs.getString(1);
                String ques=rs.getString(2);
                String ans1=rs.getString(3);
                String ans2=rs.getString(4);
                String ans3=rs.getString(5);
                String ans4=rs.getString(6);
                String rightans=rs.getString(7);
                String category=rs.getString(8);
                
                
                ExamData e=new ExamData(qno, ques, ans1, ans2, ans3, ans4, rightans, category);
                qlist.add(e);
                
            }
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return qlist;
  
    }
    
}
