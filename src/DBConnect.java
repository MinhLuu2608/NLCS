
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minh
 */
public class DBConnect {
    public static Connection getConnection(){
        
        String IP = "42.119.218.36";        
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/minhluu2608", "minhluu2608", "b1805890");
            //con = DriverManager.getConnection("jdbc:mysql://" + IP + "/minhluu2608", "minhluu2608", "b1805890");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public static int getCountCPU(String hang, String series, String core, String xung, String socket){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        int count=0;
        String query = "SELECT COUNT(*) FROM `cpu`";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " WHERE `HANGSX`=?";
        }
        if(!series.equals("None")){
            query = query + " AND `Series`=?";
        }
        if(!core.equals("None")){
            query = query + " AND `Core`=?" ;
        }
        if(!xung.equals("None")){
            query = query + " AND `Xung`=?" ;
        }
        if(!socket.equals("None")){
            query = query + " AND `Socket`=?" ;
        }       

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!series.equals("None")){
                ps.setInt(i, Integer.parseInt(series));
                i++;
            }
            if(!core.equals("None")){
                ps.setInt(i, Integer.parseInt(core));
                i++;
            }
            if(!xung.equals("None")){
                ps.setString(i, xung);
                i++;
            }
            if(!socket.equals("None")){
                ps.setString(i, socket);
            }
            
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return count;
    }
    
    public static int getCountGPU(String hang, String chip, String VMemory, String theHe){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        int count=0;
        VMemory=VMemory.replaceAll("gb", "");
        String query = "SELECT COUNT(*) FROM `gpu`";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " WHERE `HANGSX`=?";
        }
        if(!chip.equals("None")){
            query = query + " AND `chip_do_hoa`=?";
        }
        if(!VMemory.equals("None")){
            query = query + " AND `VMemory`=?" ;
        }
        if(!theHe.equals("None")){
            query = query + " AND `the_he_bo_nho`=?" ;
        }      

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!chip.equals("None")){
                ps.setString(i, chip);
                i++;
            }
            if(!VMemory.equals("None")){
                ps.setInt(i, Integer.parseInt(VMemory));
                i++;
            }
            if(!theHe.equals("None")){
                ps.setString(i, theHe);
                i++;
            }
            
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
    
    public static int getCountMain(String hang, String socket, String chipset, String chuanKT){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        int count=0;
        String query = "SELECT COUNT(*) FROM `Mainboard`";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " WHERE `HANGSX`=?";
        }
        if(!socket.equals("None")){
            query = query + " AND `Socket`=?";
        }
        if(!chipset.equals("None")){
            query = query + " AND `chipset`=?" ;
        }
        if(!chuanKT.equals("None")){
            query = query + " AND `Chuan_kich_thuoc`=?" ;
        }

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!socket.equals("None")){
                ps.setString(i, socket);
                i++;
            }
            if(!chipset.equals("None")){
                ps.setString(i, chipset);
                i++;
            }
            if(!chuanKT.equals("None")){
                ps.setString(i, chuanKT);
                i++;
            }
            
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
    
    public static int getCountRAM(String hang, String DDR, String DL, String bus){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        DL=DL.replaceAll("gb", "");
        int count=0;
        String query = "SELECT COUNT(*) FROM `RAM`";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " WHERE `HANGSX`=?";
        }
        if(!DDR.equals("None")){
            query = query + " AND `DDR`=?";
        }
        if(!DL.equals("None")){
            query = query + " AND `Dung_luong`=?" ;
        }
        if(!bus.equals("None")){
            query = query + " AND `Bus`=?" ;
        }

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!DDR.equals("None")){
                ps.setInt(i, Integer.parseInt(DDR));
                i++;
            }
            if(!DL.equals("None")){
                ps.setInt(i, Integer.parseInt(DL));
                i++;
            }
            if(!bus.equals("None")){
                ps.setInt(i, Integer.parseInt(bus));
                i++;
            }

            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
    
    public static int getCountDisk(String hang, String Loai, String chuanKN, String KT, String DL){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        int count=0;
        String query = "SELECT COUNT(*) FROM `disk` WHERE `Loai`='" + Loai + "'";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " AND `HANGSX`=?";
        }

        if(!chuanKN.equals("None")){
            query = query + " AND `chuan_ket_noi`=?" ;
        }
        if(!KT.equals("None")){
            query = query + " AND `Kich_thuoc`=?" ;
        }
        if(!DL.equals("None")){
            query = query + " AND `dung_luong`=?" ;
        }       

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!chuanKN.equals("None")){
                ps.setString(i, chuanKN);
                i++;
            }
            if(!KT.equals("None")){
                ps.setString(i, KT);
                i++;
            }
            if(!DL.equals("None")){
                ps.setString(i, DL);
            }
            
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
    
    public static int getCountCase(String hang, String kieuCase, String mau, String kieuMain, String chatLieu){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        int count=0;
        String query = "SELECT COUNT(*) FROM `case`";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " WHERE `HANGSX`=?";
        }
        if(!kieuCase.equals("None")){
            query = query + " AND `kieu_case`=?";
        }
        if(!mau.equals("None")){
            query = query + " AND `mau`=?" ;
        }
        if(!kieuMain.equals("None")){
            query = query + " AND `kieu_Mainboard`=?" ;
        }
        if(!chatLieu.equals("None")){
            query = query + " AND `chat_lieu`=?" ;
        }       

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!kieuCase.equals("None")){
                ps.setString(i, kieuCase);
                i++;
            }
            if(!mau.equals("None")){
                ps.setString(i, mau);
                i++;
            }
            if(!kieuMain.equals("None")){
                ps.setString(i, kieuMain);
                i++;
            }
            if(!chatLieu.equals("None")){
                ps.setString(i, chatLieu);
            }
            
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
    
    public static ResultSet getCPU(String hang, String series, String core, String xung, String socket){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        String query = "SELECT linhkien.ID_LK,Gia_LK FROM `linhkien`,`cpu` WHERE linhkien.ID_LK=cpu.ID_LK";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " AND `HANGSX`=?";
        }
        if(!series.equals("None")){
            query = query + " AND `Series`=?";
        }
        if(!core.equals("None")){
            query = query + " AND `Core`=?" ;
        }
        if(!xung.equals("None")){
            query = query + " AND `Xung`=?" ;
        }
        if(!socket.equals("None")){
            query = query + " AND `Socket`=?" ;
        }        

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!series.equals("None")){
                ps.setInt(i, Integer.parseInt(series));
                i++;
            }
            if(!core.equals("None")){
                ps.setInt(i, Integer.parseInt(core));
                i++;
            }
            if(!xung.equals("None")){
                ps.setString(i, xung);
                i++;
            }
            if(!socket.equals("None")){
                ps.setString(i, socket);
            }
            
            rs = ps.executeQuery();
        }
        catch(Exception e){
            System.out.println("Không lấy được rs");
        }
        
        return rs;
    }
    
    public static ResultSet getGPU(String hang, String chip, String VMemory, String theHe){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        VMemory=VMemory.replaceAll("gb", "");
        String query = "SELECT linhkien.ID_LK,Gia_LK FROM `linhkien`,`gpu` WHERE linhkien.ID_LK=gpu.ID_LK";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " AND `HANGSX`=?";
        }
        if(!chip.equals("None")){
            query = query + " AND `Chip_do_hoa`=?";
        }
        if(!VMemory.equals("None")){
            query = query + " AND `VMemory`=?" ;
        }
        if(!theHe.equals("None")){
            query = query + " AND `the_he_bo_nho`=?" ;
        }         

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!chip.equals("None")){
                ps.setString(i, chip);
                i++;
            }
            if(!VMemory.equals("None")){
                ps.setString(i, VMemory);
                i++;
            }
            if(!theHe.equals("None")){
                ps.setString(i, theHe);
            }
            
            rs = ps.executeQuery();
        }
        catch(Exception e){
            System.out.println("Không lấy được rs");
        }

        return rs;
    }
    
    public static ResultSet getMain(String hang, String socket, String chipset, String chuanKT){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        String query = "SELECT linhkien.ID_LK,Gia_LK FROM `linhkien`,`mainboard` WHERE linhkien.ID_LK=mainboard.ID_LK";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " AND `HANGSX`=?";
        }
        if(!socket.equals("None")){
            query = query + " AND `Socket`=?";
        }
        if(!chipset.equals("None")){
            query = query + " AND `chipset`=?" ;
        }
        if(!chuanKT.equals("None")){
            query = query + " AND `Chuan_kich_thuoc`=?" ;
        }

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!socket.equals("None")){
                ps.setString(i, socket);
                i++;
            }
            if(!chipset.equals("None")){
                ps.setString(i, chipset);
                i++;
            }
            if(!chuanKT.equals("None")){
                ps.setString(i, chuanKT);
                i++;
            }
            
            rs = ps.executeQuery();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return rs;
    }
    
    public static ResultSet getRAM(String hang, String DDR, String DL, String bus){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        DL=DL.replaceAll("gb", "");
        String query = "SELECT linhkien.ID_LK,Gia_LK FROM `linhkien`,`ram` WHERE linhkien.ID_LK=ram.ID_LK";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " AND `HANGSX`=?";
        }
        if(!DDR.equals("None")){
            query = query + " AND `DDR`=?";
        }
        if(!DL.equals("None")){
            query = query + " AND `Dung_luong`=?" ;
        }
        if(!bus.equals("None")){
            query = query + " AND `Bus`=?" ;
        }
        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!DDR.equals("None")){
                ps.setInt(i, Integer.parseInt(DDR));
                i++;
            }
            if(!DL.equals("None")){
                ps.setInt(i, Integer.parseInt(DL));
                i++;
            }
            if(!bus.equals("None")){
                ps.setInt(i, Integer.parseInt(bus));
                i++;
            }

            rs = ps.executeQuery();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return rs;
    }
    
    public static ResultSet getDisk(String hang, String Loai, String chuanKN, String KT, String DL){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        String query = "SELECT linhkien.ID_LK,Gia_LK FROM `linhkien`,`disk` WHERE linhkien.ID_LK=disk.ID_LK "
                + "AND Loai='" + Loai + "'";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " AND `HANGSX`=?";
        }
        if(!chuanKN.equals("None")){
            query = query + " AND `chuan_ket_noi`=?" ;
        }
        if(!KT.equals("None")){
            query = query + " AND `Kich_thuoc`=?" ;
        }
        if(!DL.equals("None")){
            query = query + " AND `dung_luong`=?" ;
        }       

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }

            if(!chuanKN.equals("None")){
                ps.setString(i, chuanKN);
                i++;
            }
            if(!KT.equals("None")){
                ps.setString(i, KT);
                i++;
            }
            if(!DL.equals("None")){
                ps.setString(i, DL);
            }
            
            rs = ps.executeQuery();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return rs;
    }
    
    public static ResultSet getCase(String hang, String kieuCase, String mau, String kieuMain, String chatLieu){
        PreparedStatement ps;
        ResultSet rs = null;
        int i=1;
        String query = "SELECT linhkien.ID_LK,Gia_LK FROM `linhkien`,`case` WHERE linhkien.ID_LK=case.ID_LK";
        Connection con = DBConnect.getConnection();
        if(!hang.equals("None")){
            query = query + " AND `HANGSX`=?";
        }
        if(!kieuCase.equals("None")){
            query = query + " AND `kieu_case`=?";
        }
        if(!mau.equals("None")){
            query = query + " AND `mau`=?" ;
        }
        if(!kieuMain.equals("None")){
            query = query + " AND `kieu_Mainboard`=?" ;
        }
        if(!chatLieu.equals("None")){
            query = query + " AND `chat_lieu`=?" ;
        }       

        try{   
            ps = con.prepareStatement(query);
            if(!hang.equals("None")){
                ps.setString(i, hang);
                i++;
            }
            if(!kieuCase.equals("None")){
                ps.setString(i, kieuCase);
                i++;
            }
            if(!mau.equals("None")){
                ps.setString(i, mau);
                i++;
            }
            if(!kieuMain.equals("None")){
                ps.setString(i, kieuMain);
                i++;
            }
            if(!chatLieu.equals("None")){
                ps.setString(i, chatLieu);
            }
            
            rs = ps.executeQuery();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return rs;
    }
}
