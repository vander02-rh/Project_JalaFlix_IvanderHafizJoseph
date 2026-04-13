import java.util.ArrayList;

class Pelanggan {
    private String kodePelanggan;
    private String nama;
    private String nomorTelepon;
    private String statusKeanggotaan;
    private String kategori; 
    private ArrayList<Film> history;

    public Pelanggan(String kodePelanggan, String nama, String nomorTelepon, String kategori) {
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.kategori = kategori; 
        this.statusKeanggotaan = "aktif";
        this.history = new ArrayList<>();
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setStatusKeanggotaan(String status) {
        this.statusKeanggotaan = status;
    }

    public void putarFilm(Film film) {
        if (!statusKeanggotaan.equalsIgnoreCase("aktif")) {
            System.out.println("Keanggotaan tidak aktif.");
            return;
        }

        boolean akses = false;
        Kategori katFilm = film.getKategori();

        if (this.kategori.equalsIgnoreCase("platinum")) {
            akses = true;
        } else if (this.kategori.equalsIgnoreCase("gold")) {
            if (katFilm == Kategori.Reguler || katFilm == Kategori.New) {
                akses = true;
            }
        } else if (this.kategori.equalsIgnoreCase("reguler")) {
            if (katFilm == Kategori.Reguler) {
                akses = true;
            }
        }

        if (akses && film.isAvailable()) {
            history.add(film);
            System.out.println("Memutar: " + film.getJudul());
        } else if (!akses) {
            System.out.println("Kategori akun Anda tidak mencukupi untuk menonton " + film.getJudul());
        } else {
            System.out.println("Film " + film.getJudul() + " sedang tidak tersedia.");
        }
    }

    public void cetakHistory() {
        System.out.println("Riwayat Menonton " + nama + ":");
        if (history.isEmpty()) {
            System.out.println("- Belum ada film yang ditonton.");
        } else {
            for (Film f : history) {
                System.out.println("- " + f.getJudul());
            }
        }
    }
}
