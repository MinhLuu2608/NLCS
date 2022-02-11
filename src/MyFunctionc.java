/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
/**
 *
 * @author Minh
 */
public class MyFunctionc {
    public static int max(int a, int b){
        if(a>b) return a;
        else return b;
    }
    public static int min(int a, int b){
        if(a<b) return a;
        else return b;
    }
    
    public static int maxUT(int UT[]){
        int maxUT=0;
        for(int i=0; i<UT.length;i++){
            maxUT = max(maxUT, UT[i]);
        }
        
        return maxUT;
    }
    
    public static void enableAndUpdateCboxHang(JComboBox cbo1, String tenCot1, String tenBang, String donvi){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = DBConnect.getConnection();
        
        cbo1.setEnabled(true);           
        //Cap nhat Hang
        try{   
            ps = con.prepareStatement("SELECT DISTINCT `"+ tenCot1 +"` FROM `"+ tenBang +"`");         
            rs = ps.executeQuery();
                
            while(rs.next()){                    
                boolean exist=false;
                                                            
                for(int i=0; i<cbo1.getItemCount();i++){
                    if(cbo1.getItemAt(i).equals(rs.getString(1))){
                        exist = true;
                        break;
                        }       
                    }
                if(exist == false) cbo1.addItem(rs.getString(1) + donvi);                    
                }
            }
            catch(Exception e){
                System.out.println("Có gì sai sai!");
            }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void enableAndUpdateCboxStr(String dieuKien, JComboBox cbo1, JComboBox cbo2, String tenCot1, String tenCot2, String tenBang, String donvi){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = DBConnect.getConnection();
        String query = "SELECT `"+ tenCot2 +"` FROM `"+ tenBang +"` WHERE `"+ tenCot1 +"`=?"
                + " " + dieuKien + " ORDER BY " + tenCot2;
        if(cbo1.getSelectedItem().toString().equals("None") == false){
            cbo2.setEnabled(true);
            cbo2.removeAllItems();
            cbo2.addItem("None");

            //Cap nhat cbo2
            try{        
                ps = con.prepareStatement(query); 
                ps.setString(1, cbo1.getSelectedItem().toString());
                rs = ps.executeQuery();

                while(rs.next()){                    
                    boolean existSocket=false;

                    //Check ton tai 
                    for(int i=0; i<cbo2.getItemCount();i++){
                        String cboText = cbo2.getItemAt(i).toString().replaceAll("gb", "");
                        if(cboText.equals(rs.getString(1))){
                            existSocket = true;
                            break;
                        }             
                    }
                    if(existSocket == false) cbo2.addItem(rs.getString(1) + donvi);
                }
            }
            catch(Exception e){
                System.out.println("Sai ở Myfunctionc");
            }
        } 
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void enableAndUpdateCboxInt(String dieuKien, JComboBox cbo1, JComboBox cbo2, String tenCot1, String tenCot2, String tenBang, String donvi){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = DBConnect.getConnection();
        String query = "SELECT `"+ tenCot2 +"` FROM `"+ tenBang +"` WHERE `"+ tenCot1 +"`=?" +
                " " + dieuKien + " ORDER BY " + tenCot2;
        
        if(cbo1.getSelectedItem().toString().equals("None") == false){
            cbo2.setEnabled(true);
            cbo2.removeAllItems();
            cbo2.addItem("None");

            //Cap nhat cbo2
            try{        
                ps = con.prepareStatement(query); 
                ps.setString(1, cbo1.getSelectedItem().toString());
                rs = ps.executeQuery();

                while(rs.next()){                    
                    boolean existSocket=false;

                    //Check ton tai
                    for(int i=0; i<cbo2.getItemCount();i++){
                        if(cbo2.getItemAt(i).equals(String.valueOf(rs.getInt(1)))){
                            existSocket = true;
                            break;
                        }             
                    }
                    if(existSocket == false) cbo2.addItem(rs.getString(1)+donvi);
                }
            }
            catch(Exception e){
                System.out.println("Sai ở MyFunctionc.enableAndUpdateCboxInt");
            }
        }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
     
    public static void enableAndUpdateCboxDiskStr(JComboBox cbo1, String tenCot1, String tenBang, String donvi, String loai){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = DBConnect.getConnection();

        cbo1.setEnabled(true);           
        //Cap nhat Hang
        try{   
            ps = con.prepareStatement("SELECT DISTINCT `"+ tenCot1 +"` FROM `"+ tenBang +"` WHERE `Loai`=?");     
            ps.setString(1, loai);
            rs = ps.executeQuery();
                
            while(rs.next()){                    
                boolean exist=false;
                                                            
                for(int i=0; i<cbo1.getItemCount();i++){
                    if(cbo1.getItemAt(i).equals(rs.getString(1))){
                        exist = true;
                        break;
                        }       
                    }
                if(exist == false) cbo1.addItem(rs.getString(1) + donvi);                    
                }
            }
            catch(Exception e){
                System.out.println("Có gì sai sai!");
            }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void enableAndUpdateCboxDiskStr(String dieuKien, JComboBox cbo1, JComboBox cbo2, String tenCot1, String tenCot2, String tenBang, String donvi, String loai){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = DBConnect.getConnection();
        String query = "SELECT `"+ tenCot2 +"` FROM `"+ tenBang +"` WHERE `loai`=? AND `"+ tenCot1 +"`=?" + 
                " " + dieuKien + " ORDER BY " + tenCot2;
                
        if(cbo1.getSelectedItem().toString().equals("None") == false){
            cbo2.setEnabled(true);
            cbo2.removeAllItems();
            cbo2.addItem("None");

            //Cap nhat cbo2
            try{        
                ps = con.prepareStatement(query); 
                ps.setString(1, loai);
                ps.setString(2, cbo1.getSelectedItem().toString());
                rs = ps.executeQuery();

                while(rs.next()){                    
                    boolean existSocket=false;

                    //Check ton tai 
                    for(int i=0; i<cbo2.getItemCount();i++){
                        if(cbo2.getItemAt(i).equals(rs.getString(1))){
                            existSocket = true;
                            break;
                        }             
                    }
                    if(existSocket == false) cbo2.addItem(rs.getString(1) + donvi);
                }
            }
            catch(Exception e){
                System.out.println("Có gì sai sai!");
            }
        }     
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void enableAndUpdateCboxDiskInt(String dieuKien, JComboBox cbo1, JComboBox cbo2, String tenCot1, String tenCot2, String tenBang, String donvi, String loai){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = DBConnect.getConnection();
        String query = "SELECT `"+ tenCot2 +"` FROM `"+ tenBang +"` WHERE `loai`=? AND `"+ tenCot1 +"`=?" +
                " " + dieuKien + " ORDER BY " + tenCot2;
        
        if(cbo1.getSelectedItem().toString().equals("None") == false){
            cbo2.setEnabled(true);
            cbo2.removeAllItems();
            cbo2.addItem("None");

            //Cap nhat cbo2
            try{        
                ps = con.prepareStatement(query); 
                ps.setString(1, loai);
                ps.setString(2, cbo1.getSelectedItem().toString());
                rs = ps.executeQuery();

                while(rs.next()){                    
                    boolean existSocket=false;

                    //Check ton tai
                    for(int i=0; i<cbo2.getItemCount();i++){
                        if(cbo2.getItemAt(i).equals(String.valueOf(rs.getInt(1)))){
                            existSocket = true;
                            break;
                        }             
                    }
                    if(existSocket == false) cbo2.addItem(rs.getString(1)+donvi);
                }
            }
            catch(Exception e){
                System.out.println("Có gì sai sai!");
            }
        }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    //Function Remove Item and Disable checkbox
    public static void removeAndDisable(JComboBox cbo1){
        cbo1.setEnabled(false);
        cbo1.removeAllItems();
        cbo1.addItem("None");
    }
    public static void removeAndDisable(JComboBox cbo1, JComboBox cbo2){
        cbo1.setEnabled(false);
        cbo1.removeAllItems();
        cbo1.addItem("None");
        
        cbo2.setEnabled(false);
        cbo2.removeAllItems();
        cbo2.addItem("None");
    }
    public static void removeAndDisable(JComboBox cbo1, JComboBox cbo2, JComboBox cbo3){
        cbo1.setEnabled(false);
        cbo1.removeAllItems();
        cbo1.addItem("None");
        
        cbo2.setEnabled(false);
        cbo2.removeAllItems();
        cbo2.addItem("None");
        
        cbo3.setEnabled(false);
        cbo3.removeAllItems();
        cbo3.addItem("None");
    }
    public static void removeAndDisable(JComboBox cbo1, JComboBox cbo2, JComboBox cbo3, JComboBox cbo4){
        cbo1.setEnabled(false);
        cbo1.removeAllItems();
        cbo1.addItem("None");
        
        cbo2.setEnabled(false);
        cbo2.removeAllItems();
        cbo2.addItem("None");
        
        cbo3.setEnabled(false);
        cbo3.removeAllItems();
        cbo3.addItem("None");
        
        cbo4.setEnabled(false);
        cbo4.removeAllItems();
        cbo4.addItem("None");
    }
    public static void removeAndDisable(JComboBox cbo1, JComboBox cbo2, JComboBox cbo3, JComboBox cbo4, JComboBox cbo5){
        cbo1.setEnabled(false);
        cbo1.removeAllItems();
        cbo1.addItem("None");
        
        cbo2.setEnabled(false);
        cbo2.removeAllItems();
        cbo2.addItem("None");
        
        cbo3.setEnabled(false);
        cbo3.removeAllItems();
        cbo3.addItem("None");
        
        cbo4.setEnabled(false);
        cbo4.removeAllItems();
        cbo4.addItem("None");
        
        cbo5.setEnabled(false);
        cbo5.removeAllItems();
        cbo5.addItem("None");
    }
    
    public static void capNhatDaLayTT(boolean[] bool, LoaiLinhKien[] loaiLK){
        for(int i=0;i<bool.length;i++){
            loaiLK[i].setDaLay(bool[i]);
        }
    }
    
    public static void capNhatGLNTT(int[] x ,tongHopLK tHLK){
        if(tHLK.getGLNTT() < tHLK.getTGT() ){
            tHLK.setGLNTT(tHLK.getTGT());
            for(int i=0;i<tHLK.getdsdv().length;i++){
                tHLK.getDV(i).setPA(x[i]);
            }
        }
    }
    
    
    public static void nhanhCan(int i, int[] x, boolean[] bool, LoaiLinhKien[] loaiLK, tongHopLK tHLK, int soLuongLK){
        int yk=0;
        int y;
        for(y=0;y<loaiLK.length;y++)
            if( tHLK.getLoai(i).equals(loaiLK[y].getLoai()) == true ){
                if(bool[y] == true) yk = 0;
                else yk = MyFunctionc.min(1, tHLK.getW()/tHLK.getDV(i).getGia());
                break;
            }
        for(int j=yk;j>=0;j--){   
            if(j == 1) bool[y] = true;
            tHLK.setTGT(tHLK.getTGT() + j* tHLK.getGiaTri(i));
            tHLK.setW(tHLK.getW() - j * tHLK.getDV(i).getGia());
            try{
                tHLK.setCT(tHLK.getTGT() + tHLK.getW()*loaiLK[y].getDoUuTien());
            }
            catch(Exception ex){
                tHLK.setCT(tHLK.getTGT());
            } 
            //System.out.println("i="+ i + " || j=" + j);
            if(tHLK.getCT() > tHLK.getGLNTT()){
                int count = 0;
                x[i]=j;
                for(int k=0;k<bool.length;k++){
                    if(bool[k] == true) count++;
                }
                if(i == tHLK.getdsdv().length - 1 || tHLK.getW() == 0 ) {  
                    if(count >= soLuongLK){
                        capNhatGLNTT(x, tHLK);
                        capNhatDaLayTT(bool, loaiLK);    
                    }
                }
                else nhanhCan(i+1, x, bool, loaiLK, tHLK, soLuongLK);
            }        
            if(j == 1){
                x[i] = 0;
                tHLK.setTGT(tHLK.getTGT() - j* tHLK.getGiaTri(i));
                tHLK.setW(tHLK.getW() + j * tHLK.getDV(i).getGia());
                bool[y] = false;   
            }
        }
    }
}
