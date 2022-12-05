package programperpustakaan;

import Process.*;
import Entity.GenreBuku;
import java.util.Scanner;

public class ProgramPerpustakaan {

    private static Scanner input = new Scanner(System.in);
    private static StaffProcess prosesStaff = new StaffProcess();
    private static BukuProcess prosesbuku = new BukuProcess();
    private static int pilgenre;
    private static int cekData;
    
    public static void main(String[] args) {
        dataStaff();        
        int pil;
        do {
            System.out.println("1. Login Staff");
            System.out.println("2. Lihat Daftar Data Buku");
            System.out.println("3. Biodata Staff");
            System.out.println("0. Exit");
            System.out.print("Masukkan Pilihan Anda : ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    loginStaff();
                    break;
                case 2:
                    prosesbuku.view();
                    break;
                case 3:
                    prosesStaff.view();
                    break;
            }

        } while (pil != 0);
            System.out.println("\n<Anda Berhasil Keluar Dari Menu Login>\n");
    }
    
    /**
     * method dataStaff berfungsi untuk memasukkan data-data staff ke staffEntity
     * @return mengembalikan nilai dari total jumlah data yang telah dimasukkan dalam staffEntity
     */
    static void dataStaff() {
        String namaStaff[] = {"Reyhan", "Aldiansyah"};
        String passStaff[] = {"074", "419"};
        String noTelpStaff[] = {"081", "082"};
        String alamatStaff[] = {"Jl. SIDOMULYO", "jl. PEPELEGI"};
        prosesStaff.insert(passStaff, namaStaff, noTelpStaff, alamatStaff);
    }
    
    /**
     * method loginStaff ini berfungsi menyimpan input untuk Nama dan Password yang nantinya akan di cek,
     * setelah itu menampilkan pilihan-pilihan yang dapat dilakukan oleh Staff
     */
    static void loginStaff() {
        System.out.print("\nMasukkan Username Anda : ");
        String nama = input.next();
        System.out.print("Masukkan Password Anda : ");
        String password = input.next();
        cekData = prosesStaff.cekData(nama, password);
        System.out.println("\n<Selamat Datang Staff " + prosesStaff.getStaff()[cekData].getNama() + ">");
        int pil;

        do {
            System.out.println("\n1. Daftarkan Data Buku");
            System.out.println("2. Update Data Buku");
            System.out.println("3. Lihat Data Buku");
            System.out.println("4. Hapus Data Buku");
            System.out.println("0. Log Out");
            System.out.print("Masukkan Pilihan : ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    insertbuku();
                    break;
                case 2:
                    prosesbuku.update();
                    break;
                case 3:
                    prosesbuku.view();
                    break;
                case 4:
                    prosesbuku.delete();
                    break;
            }

        } while (pil != 0);
            System.out.println("\n<Anda Berhasil Logout>\n");
    }
    
    /**
     * method insertstaff berfungsi untuk memasukkan data ke dalam staffEntity sesuai dengan inputan yang
     * dimasukkan oleh user
     */
    static void insertbuku() {
        input.nextLine();
        System.out.print("Judul Buku     : ");
        String judul = input.nextLine();

        System.out.print("Pengarang Buku : ");
        String pengarang = input.nextLine();

        System.out.print("Tahun Terbit   : ");
        String tahun = input.nextLine();

        System.out.print("Halaman Buku   : ");
        String halaman = input.nextLine();

        prosesbuku.insert(judul, pengarang, tahun, halaman);
        insertGenre();
    }
    
    static void insertGenre() {
        System.out.println("Genre : ");
        for (int i = 0; i < GenreBuku.genre.length; i++) {
            System.out.println(i + ". " + GenreBuku.genre[i]);
        }
        System.out.print("Pilih Genre : ");
        pilgenre = input.nextInt();
        System.out.print("Input Kode Data Buku : ");
        String kodebuku = input.next();
        prosesbuku.insert(prosesbuku.getBuku()[prosesbuku.jumlahBuku], pilgenre, kodebuku);
    }   
}