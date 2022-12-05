package Entity;

public class NamaStaff {
    protected String nama, noTelp, alamat; //untuk hak akses staff

    public NamaStaff(String nama, String noTelp, String alamat) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    
    /**
     * funtion-function dibawah ini merupakan 
     * function getter dan setter (accessor) 
     * yang digunakan untuk mengakses 
     * variable yang terenkapsulasi 
     * (dalam kasus ini protected)
    */
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}