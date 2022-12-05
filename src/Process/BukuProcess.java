package Process;

import Entity.BukuEntity;
import Entity.BukuTerdaftarEntity;
import Entity.GenreBuku;
import java.util.Scanner;

public class BukuProcess implements Interface{ //digunakan untuk mewariskan interface
    private static Scanner input = new Scanner(System.in);
    private static BukuEntity[] buku = new BukuEntity[100];
    private static BukuTerdaftarEntity[] BukuTerdaftar = new BukuTerdaftarEntity[100];
    public static int jumlahBuku = 0;
    
    /**
     * method getBuku() dan getBukuTerdaftar() fungsinya hampir sama seperti method Accessor
     * pada umumnya. yang digunakan untuk mengakses variable yang tidak dapat
     * diakses dari luar kelas
     * @return Staff yang berbentuk Array.
     */
    public BukuEntity[] getBuku(){
        return buku;
    }
    
    public BukuTerdaftarEntity[] getBukuTerdaftar(){
        return BukuTerdaftar;
    }
    
    /**
     * method insert() berfungsi untuk memasukkan data ke dalam class Entity
     * sesuai dengan parameter yang telah di tentukan.
     * 
     * @param nama menampung data nama staff dan buku
     */
    public void insert(String judul, String pengarang, String tahun, String halaman){
        buku[jumlahBuku] = new BukuEntity(judul, pengarang, tahun, halaman);
    }
    
    /**
     * method insert() berfungsi untuk memasukkan data ke dalam class Entity
     * sesuai dengan parameter yang telah di tentukan.
     * 
     * juga merupakan bentuk Overloading dari method insert() diatasnya
     * 
     * @param buku menampung satu baris data Array dari BukuEntity
     * @param index menampung data INT dari Index.
     * @param kodeBuku menampung data dari Kode buku yang telah diberikan staff
     */
    public void insert(BukuEntity buku, int indexBuku, String kodeBuku){
        BukuTerdaftar[jumlahBuku] = new BukuTerdaftarEntity(buku, indexBuku, kodeBuku);
        jumlahBuku=jumlahBuku+1;
    }
    
    /**
     * method view() berfugsi untuk menampilkan data buku sesuai dengan data yang telah tersimpan di dalam
     * bukuEntity
     */
    @Override
    public void view() {
        if (jumlahBuku == 0) {
            System.out.println("\n<Belum Terdapat Data Buku>\n");
        } else {
            System.out.println("-------------------");
            System.out.println("| Jumlah Buku : " + BukuProcess.jumlahBuku + " |");
            System.out.println("-------------------");
            for (int i = 0; i < jumlahBuku; i++) {
                System.out.println("Kode Buku : " + BukuTerdaftar[i].getKodeBuku());
                System.out.println("==============================================");
                System.out.println("Judul : " + buku[i].getJudul()
                        + "\nPengarang : " + buku[i].getPengarang()
                        + "\nTahun Terbit : " + buku[i].getTahun()
                        + "\nHalaman : " + buku[i].getHalaman()
                        + "\nGenre : " + GenreBuku.genre[BukuTerdaftar[i].getIndexBuku()]);
                System.out.println("==============================================");
            }
        }
    }
    
    /**
     * method update() berfungsi untuk memperbarui data buku sesuai dengan kode buku yang di masukkan
     */
    public void update() {
        System.out.print("Masukan Kode Buku yang mau di EDIT : ");
        String search = input.next();
        int cari = 0;
        do {
            if (cari == jumlahBuku) {
                System.err.println("Tida ada data");
                break;
            } else if (BukuTerdaftar[cari].getKodeBuku().equals(search)) {
                int pilEdit;
                do {
                    System.out.println("Pilih data yang ingin diubah : ");
                    System.out.println("1. Lihat Biodata");
                    System.out.println("2. Judul");
                    System.out.println("3. Pengarang");
                    System.out.println("4. Tahun Terbit");
                    System.out.println("5. Halaman");
                    System.out.println("0. Exit");
                    System.out.print("Input Pilihan : ");
                    pilEdit = input.nextInt();
                    input.nextLine();
                    if (pilEdit == 1) {
                        System.out.println("==============================================");
                        System.out.println("Kode Buku : " + BukuTerdaftar[cari].getKodeBuku());
                        System.out.println("==============================================");
                        System.out.println("Judul : " + buku[cari].getJudul()
                                + "\nPengarang : " + buku[cari].getPengarang()
                                + "\nTahun Terbit : " + buku[cari].getTahun()
                                + "\nHalaman : " + buku[cari].getHalaman()
                                + "\nGenre : " + GenreBuku.genre[BukuTerdaftar[cari].getIndexBuku()]);
                        System.out.println("==============================================");
                    } else if (pilEdit == 2) {
                        System.out.print("Ubah Judul : ");
                        String editjudul = input.nextLine();
                        buku[cari].setJudul(editjudul);
                    } else if (pilEdit == 3) {
                        System.out.print("Ubah Pengarang : ");
                        String editpengarang = input.nextLine();
                        buku[cari].setPengarang(editpengarang);
                    } else if (pilEdit == 4) {
                        System.out.print("Ubah Tahun Terbit : ");
                        String edittahun = input.nextLine();
                        buku[cari].setTahun(edittahun);
                    } else if (pilEdit == 5) {
                        System.out.print("Ubah Halaman : ");
                        String edithalaman = input.nextLine();
                        buku[cari].setHalaman(edithalaman);
                    } 
                } while (pilEdit != 0);
                break;
            } else {
                cari = cari + 1;
            }
        } while (true);
    }
    
    /**
     * method delete() berfungsi untuk menindah data-data buku sesuai dengan kodebuku
     * yang di masukkan yang tersimpan di dalam bukuEntity dan bukuterdaftarEntity 
     * ke array data selanjutnya sehingga tidak terbaca oleh program lalu mengurangi jumlah jumlahbuku.
     */
    public void delete() {
        System.out.print("Masukan Kode Buku yang akan di HAPUS : ");
        String search = input.next();
        input.nextLine();
        int cari = 0;
        do {
            if (cari == jumlahBuku) {
                System.err.println("Tidak Ada Data!");
                break;
            } else if (BukuTerdaftar[cari].getKodeBuku().equals(search)) {
                if (cari == jumlahBuku - 1) {
                    jumlahBuku = jumlahBuku - 1;
                } else {
                    for (int i = cari; i < jumlahBuku; i++) {
                        BukuTerdaftar[i] = BukuTerdaftar[i + 1];
                        buku[i] = buku[i + 1];
                    }
                    jumlahBuku = jumlahBuku - 1;
                }
                break;
            } else {
                cari = cari + 1;
            }
        } while (true);
    }
}