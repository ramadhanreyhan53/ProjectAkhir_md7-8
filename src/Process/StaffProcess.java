package Process;

import Entity.StaffEntity;

public class StaffProcess implements Interface{
    private static StaffEntity[] staff = new StaffEntity[100];
    private static int jumlahStaff = 0;
    
    /**
     * method getbuku() fungsinya hampir sama seperti method Accessor
     * pada umumnya. yang digunakan untuk mengakses variable yang tidak dapat
     * diakses dari luar kelas
     * @return staff yang berbentuk Array.
     */
    public StaffEntity[] getStaff(){
        return staff;
    }
    
    /**
     * method insert() berfungsi untuk memasukkan data ke dalam class Entity
     * sesuai dengan parameter yang telah di tentukan.
     * 
     * @param passstaff menampung data Password Staff
     * @param namastaff menampung data Nama Staff
     * 
     * kedua parameter tersebut nantinya akan dimasukkan ke dalam staffEntity
     */
    public void insert(String[] passStaff, String[] namaStaff, String[] noTelpStaff, String[] alamatStaff){
        for (int i = 0; i < namaStaff.length; i++) {
            staff[i] = new StaffEntity(passStaff[i], namaStaff[i], noTelpStaff[i], alamatStaff[i]);
            jumlahStaff++;
        }
    }
    
    /**
     * method view() berfugsi untuk menampilkan data buku sesuai dengan data yang telah tersimpan di dalam
     * staffentity
     */
    @Override
    public void view() {
        for (int i = 0; i < jumlahStaff; i++) {
            System.out.println("=====================================");
            System.out.println("Nama : " + staff[i].getNama()
                    + "\nNo. Telp : " + staff[i].getNoTelp()
                    + "\nAlamat   : " + staff[i].getAlamat());
            System.out.println("=====================================");
        }
    }
    
    
    /**
     * method cekData() berdungsi untuk melakukan pencocokan data dari inputan
     * dan dari yang sudah tersimpan dalam sistem.
     * 
     * @param user menampung data nama user / username
     * @param password menampung data password user
     * @return loop yang bernilai INT yang nantinya digunakan untuk menetukan kondisi
     */
    public int cekData(String user, String password) {
        int ulang = 0;
        for (StaffEntity prosesStaff : staff) {
            if (prosesStaff.getNama().equals(user) && prosesStaff.getPassword().equals(password)) {
                break;
            } else {
                ulang++;
            }
        }
        return ulang;
    }
}