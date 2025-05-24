package k1.chuyentin.com.common;

import k1.chuyentin.com.enums.PetName;


public class PetforSave {
    public PetName name;
    public int solanclick = 0;
    public int acc =0;
    public int avoid =0;
    public float time =0;
    public String ten="";
    public int a;
    public int diam;
    public PetforSave() {}

    public PetforSave(PetName name, int solanclick,int acc,int avoid,float time,String ten,int a,int diam) {
        this.solanclick = solanclick;
        this.acc = acc;
        this.avoid = avoid;
        this.time = time;
        this.ten = ten;
        this.a = a;
        this.diam = diam;
    }
}
