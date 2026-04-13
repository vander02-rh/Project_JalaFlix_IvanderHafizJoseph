import java.util.ArrayList;

abstract class Pelanggan {
    private String nama;
    private String email;
    private String password;
    protected int usia;
    protected ArrayList<Film> daftarTontonan;

    public Pelanggan(String nama, String email, String password, int usia) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.usia = usia;
        this.daftarTontonan = new ArrayList<>();
    }

    public abstract int getMaxDevices();
    
    public String getNama() { return nama; }
    public String getEmail() { return email; }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void tambahFilm(Film film) {
        if (this.usia < film.getKategoriUsia()) {
            System.out.println("Gagal: Usia tidak mencukupi untuk menonton " + film.getJudul());
            return;
        }

        if (!film.isAvailable()) {
            System.out.println("Gagal: Film " + film.getJudul() + " saat ini tidak tersedia.");
            return;
        }

        daftarTontonan.add(film);
        System.out.println("Berhasil: " + film.getJudul() + " ditambahkan ke daftar.");
    }

    public void cetakInfoAkun() {
        System.out.println("=== Profil Pelanggan ===");
        System.out.println("Nama      : " + nama);
        System.out.println("Email     : " + email);
        System.out.println("Max Device: " + getMaxDevices());
    }
}

class PelangganPremium extends Pelanggan {
    
    public PelangganPremium(String nama, String email, String password, int usia) {
        super(nama, email, password, usia);
    }

    @Override
    public int getMaxDevices() {
        return 5; 
    }

    @Override
    public void tambahFilm(Film film) {
        super.tambahFilm(film);
    }
}

class PelangganBiasa extends Pelanggan {

    public PelangganBiasa(String nama, String email, String password, int usia) {
        super(nama, email, password, usia);
    }

    @Override
    public int getMaxDevices() {
        return 1; 
    }

    @Override
    public void tambahFilm(Film film) {
        if (film instanceof FilmOriginal) {
            System.out.println("Gagal: " + film.getJudul() + " hanya untuk member Premium!");
        } else {
            super.tambahFilm(film);
        }
    }
}
