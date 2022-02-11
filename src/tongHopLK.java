/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class tongHopLK {
    private DoVat[] dsdv;
    private String[] loai;
    private int[] giaTri;
    
    private int W;
    private int TGT;
    private int CT;
    private int GLNTT;
    
    public tongHopLK(){
        dsdv = new DoVat[0];
        loai = new String[0];
        giaTri = new int[0];
        
        W = 0;
        TGT = 0;
        CT = 0;
        GLNTT = 0;
    }
    
    public DoVat getDV(int i){
        return dsdv[i];
    }
    public DoVat[] getdsdv(){
        return dsdv;
    }
    public String getLoai(int i){
        return loai[i];
    }
    public int getGiaTri(int i){
        return giaTri[i];
    }
    public int getW(){
        return W;
    }
    public int getTGT(){
        return TGT;
    }
    public int getCT(){
        return CT;
    }
    public int getGLNTT(){
        return GLNTT;
    }
    public void setW(int soTien){
        W = soTien;
    }
    public void setTGT(int giatri){
        TGT = giatri;
    }
    public void setCT(int i){
        CT = i;
    }
    public void setGLNTT(int i){
        GLNTT = i;
    }
    
    public void themLK(DoVat dovat, String loai, int giaTri){
        DoVat[] tempDV = new DoVat[dsdv.length + 1];
        String[] tempLoai = new String[this.loai.length + 1];
        int[] tempGia = new int[this.giaTri.length + 1];
        for(int i=0; i<dsdv.length; i++){
            tempDV[i] = dsdv[i];
            tempLoai[i] = this.loai[i];
            tempGia[i] = this.giaTri[i];      
        }
        
        tempDV[dsdv.length] = dovat;
        tempLoai[this.loai.length] = loai;
        tempGia[this.giaTri.length] = giaTri;
        
        dsdv = tempDV;
        this.loai = tempLoai;
        this.giaTri = tempGia;
    }
    public void themDSLK(DoVat[] dsDVThem, String[] loai, int[] giaTri){
        int length = dsdv.length + dsDVThem.length;
        DoVat[] tempDV = new DoVat[length];
        String[] tempLoai = new String[length];
        int[] tempGia = new int[length];
        for(int i=0; i<dsdv.length;i++){
            tempDV[i] = dsdv[i];
            tempLoai[i] = this.loai[i];
            tempGia[i] = this.giaTri[i];
        }
        for(int i=0; i<dsDVThem.length; i++){
            tempDV[dsdv.length + i] = dsDVThem[i];
            tempLoai[dsdv.length + i] = loai[i];
            tempGia[dsdv.length + i] = giaTri[i];
        }
        dsdv = tempDV;
        this.loai = tempLoai;
        this.giaTri = tempGia;
    }

    public void swapLK(int i, int j){
        DoVat tempDV = dsdv[i];
        dsdv[i] = dsdv[j];
        dsdv[j] = tempDV;
        
        String tempLoai = loai[i];
        loai[i] = loai[j];
        loai[j] = tempLoai;
        
        int tempGia = giaTri[i];
        giaTri[i] = giaTri[j];
        giaTri[j] = tempGia;
    }
    
    public void BubbleSort(){
        int n = dsdv.length;
        for(int i=0;i<=n-2;i++)
            for(int j=n-1;j>=i+1;j--)
                if(giaTri[j] > giaTri[j-1])
                    swapLK(j,j-1); 
    }
    
    public DoVat[] getDSDVChon(){
        int count=0;
        for(int i=0;i<dsdv.length;i++){
            if(dsdv[i].getPA() != 0){
                count++;
            }
        }
        DoVat[] tempDV = new DoVat[count];
        int index=0; 
        for(int i=0;i<dsdv.length;i++){
            if(dsdv[i].getPA() != 0){
                tempDV[index] = dsdv[i];
                index++;
            }
        }
        return tempDV;
    }
    public String[] getDSLoaiChon(){
        int count=0;
        for(int i=0;i<dsdv.length;i++){
            if(dsdv[i].getPA() != 0){
                count++;
            }
        }
        String[] tempLoai = new String[count];
        int index=0; 
        for(int i=0;i<dsdv.length;i++){
            if(dsdv[i].getPA() != 0){
                tempLoai[index] = loai[i];
                index++;
            }
        }
        return tempLoai;
    }
    public int[] getDSGiaTriChon(){
        int count=0;
        for(int i=0;i<dsdv.length;i++){
            if(dsdv[i].getPA() != 0){
                count++;
            }
        }
        int[] tempGia = new int[count];
        int index=0; 
        for(int i=0;i<dsdv.length;i++){
            if(dsdv[i].getPA() != 0){
                tempGia[index] = giaTri[i];
                index++;
            }
        }
        return tempGia;
    }
    
    public void inDSDV(){
        for(int i=0;i<dsdv.length;i++){
            System.out.println("i:" + i + " | ID:" + dsdv[i].getID() + " | Gia:" + dsdv[i].getGia() + " | Loai:" + loai[i]);
        }
    }
    public void inDSChon(){
        for(int i=0;i<dsdv.length;i++){
            if(dsdv[i].getPA() != 0){
                System.out.println("ID:" + dsdv[i].getID() + " | Gia:" + dsdv[i].getGia() + " | Loai LK:" + loai[i]
                + " | Gia Tri LK:" + giaTri[i]);
            }
        }
    }
    
    public void capNhatWvaTGT(){
        for(int i=0;i<dsdv.length;i++){
            this.W = this.W - dsdv[i].getGia();
            this.TGT = this.TGT + giaTri[i];
        }
    }
}
