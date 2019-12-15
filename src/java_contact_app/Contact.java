/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_contact_app;

/**
 *
 * @author Sir
 */
public class Contact {
    
    private Integer cid;
    private String fullname;
    private String groupc;
    private String phone;  
    private String email;  
    private String address;  
    private byte[] pic;  
    private int uid;
    
    public Contact() {}

    public Contact(Integer cid, String fullname, String groupc, String phone, String email, String address, byte[] pic, int uid) {
        this.cid = cid;
        this.fullname = fullname;
        this.groupc = groupc;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.pic = pic;
        this.uid = uid;
    }

    Contact(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGroupc() {
        return groupc;
    }

    public void setGroupc(String groupc) {
        this.groupc = groupc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
}
