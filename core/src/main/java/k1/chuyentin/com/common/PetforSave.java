package k1.chuyentin.com.common;

import k1.chuyentin.com.enums.PetName;


public class PetforSave {
    public PetName name;
    public int solanclick = 0;
    public int acc =0;
    public int avoid =0;
    public PetforSave() {}

    public PetforSave(PetName name, int solanclick,int acc,int avoid) {
        this.name = name;
        this.solanclick = solanclick;
        this.acc = acc;
        this.avoid = avoid;
    }
}
