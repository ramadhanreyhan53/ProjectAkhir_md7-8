package Entity;

//extend disini digunakan untuk mewariskan method dan atribut dari class namastaffdanbuku
public class BukuEntity extends NamaBuku{
    private String halaman;

    public BukuEntity(String judul, String pengarang, String tahun, String halaman) {
        super(judul, pengarang, tahun);
        this.halaman = halaman;
    }
    
    /**
     * funtion-function dibawah ini merupakan 
     * function getter dan setter (accessor) 
     * yang digunakan untuk mengakses 
     * variable yang terenkapsulasi 
     * (dalam class ini private)
    */
    
    public String getHalaman() {
        return halaman;
    }

    public void setHalaman(String halaman) {
        this.halaman = halaman;
    }
}