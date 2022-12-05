package Entity;

public class NamaBuku {
    protected String judul, pengarang, tahun; // untuk hak akses buku
    
    public NamaBuku(String judul, String pengarang, String tahun) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
    }
    
    /**
     * funtion-function dibawah ini merupakan 
     * function getter dan setter (accessor) 
     * yang digunakan untuk mengakses 
     * variable yang terenkapsulasi 
     * (dalam kasus ini protected)
    */
    
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    
    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
