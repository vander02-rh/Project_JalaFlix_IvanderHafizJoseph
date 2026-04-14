import java.util.ArrayList;

abstract class Pelanggan {
    protected String kodePelanggan;
    protected String nama;
    protected String nomorTelepon;
    protected String statusKeanggotaan;
    protected ArrayList<Film> history;

    public Pelanggan(String kodePelanggan, String nama, String nomorTelepon) {
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.statusKeanggotaan = "aktif";
        this.history = new ArrayList<>();
    }

    public void setStatusKeanggotaan(String status) {
        this.statusKeanggotaan = status;
    }

    public abstract void putarFilm(Film film);

    public void cetakHistory() {
        System.out.println("Riwayat Menonton " + nama + ":");
        if (history.isEmpty()) {
            System.out.println("- Belum ada film yang ditonton.");
        } else {
            for (Film f : history) {
                System.out.println("- " + f.getJudul() + " (" + f.getKategori() + ")");
            }
        }
    }
}

class PelangganPlatinum extends Pelanggan {
    public PelangganPlatinum(String kode, String nama, String telp) {
        super(kode, nama, telp);
    }

    @Override
    public void putarFilm(Film film) {
        if (!statusKeanggotaan.equalsIgnoreCase("aktif")) {
            System.out.println("Keanggotaan tidak aktif.");
            return;
        }

        if (film.isAvailable()) {
            history.add(film);
            System.out.println("[Platinum] Memutar: " + film.getJudul());
        } else {
            System.out.println("Film " + film.getJudul() + " sedang tidak tersedia.");
        }
    }
}

class PelangganGold extends Pelanggan {
    public PelangganGold(String kode, String nama, String telp) {
        super(kode, nama, telp);
    }

    @Override
    public void putarFilm(Film film) {
        if (!statusKeanggotaan.equalsIgnoreCase("aktif")) {
            System.out.println("Keanggotaan tidak aktif.");
            return;
        }

        Kategori katFilm = film.getKategori();
        if (katFilm == Kategori.New || katFilm == Kategori.Reguler) {
            if (film.isAvailable()) {
                history.add(film);
                System.out.println("[Gold] Memutar: " + film.getJudul());
            } else {
                System.out.println("Film " + film.getJudul() + " sedang tidak tersedia.");
            }
        } else {
            System.out.println("Akun Gold tidak mencukupi untuk menonton film " + katFilm);
        }
    }
}

class PelangganReguler extends Pelanggan {
    public PelangganReguler(String kode, String nama, String telp) {
        super(kode, nama, telp);
    }

    @Override
    public void putarFilm(Film film) {
        if (!statusKeanggotaan.equalsIgnoreCase("aktif")) {
            System.out.println("Keanggotaan tidak aktif.");
            return;
        }

        if (film.getKategori() == Kategori.Reguler) {
            if (film.isAvailable()) {
                history.add(film);
                System.out.println("[Reguler] Memutar: " + film.getJudul());
            } else {
                System.out.println("Film " + film.getJudul() + " sedang tidak tersedia.");
            }
        } else {
            System.out.println("Akun Reguler hanya boleh menonton film kategori Reguler.");
        }
    }
}
