package Entity;

public class StaffEntity extends NamaStaff {
    private String password;

    public StaffEntity(String password, String nama, String noTelp, String alamat) {
        super(nama, noTelp, alamat);
        this.password = password;
    }
    
    /**
     * funtion-function dibawah ini merupakan 
     * function getter dan setter (accessor) 
     * yang digunakan untuk mengakses 
     * variable yang terenkapsulasi 
     * (dalam class ini private)
    */
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}