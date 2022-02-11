
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minh
 */
public class LoaiLinhKien {
    private int doUuTien;
    private DoVat[] dsdv;
    private String loai;
    private int soLuongLK;
    private boolean daLay;
    
    public LoaiLinhKien(){
        doUuTien = 0;
        loai = new String();
        dsdv = new DoVat[0];
        soLuongLK = 0;
        daLay = false;
    }
    public LoaiLinhKien(int UT, ResultSet rs, String loai, int soLuong, boolean daLay){
        doUuTien = UT;
        this.loai = loai;
        soLuongLK = soLuong;
        dsdv = new DoVat[soLuong];
        int i = 0;
        try{
            while(rs.next()){
                dsdv[i] = new DoVat();
                dsdv[i].setID(rs.getInt(1)) ;
                dsdv[i].setGia(rs.getInt(2)); 
                i++;
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        this.daLay = daLay;
    }
    
    public int getDoUuTien(){
        return doUuTien;
    }
    public String getLoai(){
        return loai;
    }
    public DoVat getLinhkien(int i){
        return dsdv[i];
    }
    public int getSL(){
        return soLuongLK;
    }
    public boolean getDaLay(){
        return daLay;
    }
    
    public void setDoUuTien(int UT){
        doUuTien = UT;
    }
    public void setLoai(String Loai){
        loai = Loai;
    }
    public void setLK(ResultSet rs, int soluong){
        int i = 0;
        this.soLuongLK = soluong;
        dsdv = new DoVat[soluong];
        try{
            while(rs.next()){
                dsdv[i] = new DoVat();
                dsdv[i].setID(rs.getInt(1)) ;
                dsdv[i].setGia(rs.getInt(2));
                i++;
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void setSL(int soluong){
        soLuongLK = soluong;
    }
    public void setDaLay(boolean daLay){
        this.daLay = daLay;
    }
    
    public void addLK(DoVat dv){
        DoVat[] temp = new DoVat[dsdv.length + 1];
        for(int i=0; i<dsdv.length; i++){
            temp[i] = dsdv[i];
        }
        temp[dsdv.length] = dv;
        dsdv = temp;
        this.soLuongLK++;
    }
}
