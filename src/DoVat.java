/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minh
 */
public class DoVat {
    private int id;
    private int gia;
    
    private int PA=0;
    
    public DoVat(){
        id = 0;
        gia = 0;
        PA = 0;
    }
    public DoVat(int id, int gia, String hang){
        this.id = id;
        this.gia = gia;
    }
    
    public int getID(){
        return id;
    }
    public int getGia(){
        return gia;
    }
    public int getPA(){
        return PA;
    }
    
    public void setID(int id){
        this.id = id;
    }
    public void setGia(int gia){
        this.gia = gia;
    }
    public void setPA(int PA){
        this.PA = PA;
    }
}

