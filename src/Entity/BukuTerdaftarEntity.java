package Entity;

//private untuk 
public class BukuTerdaftarEntity {
    private BukuEntity BukuEntity;
    private int indexBuku;
    private String KodeBuku;

    public BukuTerdaftarEntity(BukuEntity BukuEntity, int indexBuku, String KodeBuku) {
        this.BukuEntity = BukuEntity;
        this.indexBuku = indexBuku;
        this.KodeBuku = KodeBuku;
    }
    
    /**
     * funtion-function dibawah ini merupakan 
     * function getter dan setter (accessor) 
     * yang digunakan untuk mengakses 
     * variable yang terenkapsulasi 
     * (dalam class ini private)
    */
    
    public BukuEntity getBukuEntity() {
        return BukuEntity;
    }

    public void setBukuEntity(BukuEntity BukuEntity) {
        this.BukuEntity = BukuEntity;
    }

    public int getIndexBuku() {
        return indexBuku;
    }

    public void setIndexBuku(int indexBuku) {
        this.indexBuku = indexBuku;
    }

    public String getKodeBuku() {
        return KodeBuku;
    }

    public void setKodeBuku(String KodeBuku) {
        this.KodeBuku = KodeBuku;
    }
}