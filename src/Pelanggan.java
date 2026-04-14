public abstract class Pelanggan implements FilmAccess,HistoryAction,MembershipAction{
    protected String kodePelanggan,nama,nomorTelepon,statusKeanggotaan;
    protected HistoryTontonan history [] = new HistoryTontonan[10];

    public Pelanggan(String kodePelanggan, String nama, String nomorTelepon) {
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.statusKeanggotaan = "aktif";
    }

    public void setStatusKeanggotaan(String status) {
        this.statusKeanggotaan = status;
    }

    abstract void info ();
}

class PelangganPlatinum extends Pelanggan {
    public PelangganPlatinum(String kode, String nama, String telp) {
        super(kode, nama, telp);
    }

    @Override
    public void putarFilm(Film film) {
        history.add(film);
        System.out.println("[Platinum] Memutar: " + film.getJudul());
    }
}

class PelangganGold extends Pelanggan {
    public PelangganGold(String kode, String nama, String telp) {
        super(kode, nama, telp);
    }

    @Override
    public void putarFilm(Film film) {
        Kategori katFilm = film.getKategori();
        if (katFilm == Kategori.New || katFilm == Kategori.Reguler) {
            history.add(film);
            System.out.println("[Gold] Memutar: " + film.getJudul());
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

        if (film.getKategori() == Kategori.Reguler) {
                history.add(film);
                System.out.println("[Reguler] Memutar: " + film.getJudul());
        } else {
            System.out.println("Akun Reguler hanya boleh menonton film kategori Reguler.");
        }
    }
}
