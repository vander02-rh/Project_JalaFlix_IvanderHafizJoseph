enum Kategori {
    New, Reguler, Original
} 

enum Genre {
    Comedy, Horror, Drama, Action, SciFi, Fantasy, Mystery, Thriller, Adventure, Romance
}

abstract class Film{
    private String judul;
    private Genre genre;
    private String tanggal;
    private String sinopsis;
    private float rating;
    private String studio;
    private String sutradara;
    private int kategoriUsia;

    public Film(String judul, Genre genre, String tanggal, String sinopsis, float rating, String studio, String sutradara, int kategoriUsia){
        this.judul = judul;
        this.genre = genre;
        this.tanggal = tanggal;
        this.sinopsis = sinopsis;
        this.rating = rating;
        this.studio = studio;
        this.sutradara = sutradara;
        this.kategoriUsia = kategoriUsia;
    }

    public String getJudul(){return judul;}
    public Genre getGenre(){return genre;}
    public String getTanggal(){return tanggal;}
    public String getSinopsis(){return sinopsis;}
    public float getRating(){return rating;}
    public String getStudio(){return studio;}
    public String getSutradara(){return sutradara;}
    public int getKategoriUsia(){return kategoriUsia;}

    public abstract boolean isAvailable();
    public abstract Kategori getKategori();

    public void getDetails(){
        System.out.printf("%-16s : %s \n",  "Judul", judul);
        System.out.printf("%-16s : %s \n",  "Genre", genre);
        System.out.printf("%-16s : %.2f \n",  "Rating", rating);
        System.out.printf("%-16s : %s \n",  "Tanggal Rilis", tanggal);
        System.out.printf("%-16s : %s \n",  "Studio", studio);
        System.out.printf("%-16s : %s \n",  "Sutradara", sutradara);
        System.out.printf("%-16s : %d \n",  "Usia Minimal", kategoriUsia);
        System.out.printf("%-16s : %s \n",  "Sinopsis", sinopsis);
    }
}

class FilmOriginal extends Film{
    private boolean exclusive;

    public FilmOriginal(String judul, Genre genre, String tanggal, String sinopsis, float rating, String studio, String sutradara, int kategoriUsia, boolean exclusive){
        super(judul, genre, tanggal, sinopsis, rating, studio, sutradara, kategoriUsia);
        this.exclusive = exclusive;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public Kategori getKategori(){
        return Kategori.Original;
    }
}

class FilmReguler extends Film{

    public FilmReguler(String judul, Genre genre, String tanggal, String sinopsis, float rating, String studio, String sutradara, int kategoriUsia){
        super(judul, genre, tanggal, sinopsis, rating, studio, sutradara, kategoriUsia);
    }

    @Override
    public boolean isAvailable(){
        int tanggalProduksi = Integer.parseInt(getTanggal().substring(0, 4));
        int now = java.time.Year.now().getValue();
        return (now - tanggalProduksi) > 5;
    }

    @Override
    public Kategori getKategori(){
        return Kategori.Reguler;
    }
}

class FilmNew extends Film{

    public FilmNew(String judul, Genre genre, String tanggal, String sinopsis, float rating, String studio, String sutradara, int kategoriUsia){
        super(judul, genre, tanggal, sinopsis, rating, studio, sutradara, kategoriUsia);
    }

    @Override
    public boolean isAvailable(){
        int tanggalProduksi = Integer.parseInt(getTanggal().substring(0, 4));
        int now = java.time.Year.now().getValue();
        return (now - tanggalProduksi) <= 5;
    }

    @Override
    public Kategori getKategori(){
        return Kategori.New;
    }
}