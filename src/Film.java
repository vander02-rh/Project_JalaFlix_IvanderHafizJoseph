import java.time.LocalDate;

enum Kategori {
    New, Reguler, Original
} 

enum Genre {
    Comedy, Horror, Drama, Action, SciFi, Fantasy, Mystery, Thriller, Adventure, Romance
}

public class Film{
    private String judul,sinopsis,sutradara,studio;
    private double  rating;
    private int kategoriUsia,tahunRilis;

    private Genre genre;
    private Kategori kategori;
    private boolean isOriginal;

    public Film(String judul, Genre genre, int tahunRilis, String sinopsis, 
                double rating, String studio, String sutradara, int kategoriUsia, boolean isOriginal){
        if (tahunRilis < 1800){
            throw new TahunTooOldException();  
        }

        this.tahunRilis = tahunRilis;
        this.judul = judul;
        this.genre = genre;
        this.sinopsis = sinopsis;
        this.kategoriUsia = kategoriUsia;
        this.isOriginal = isOriginal;

        if (isOriginal) {
            kategori = Kategori.Original;
        }else{
            updateKategori();
        }

        this.rating = rating;
        this.studio = studio;
        this.sutradara = sutradara;
    }

    private void updateKategori(){
        int tahunSekarang = LocalDate.now().getYear();
        if (tahunSekarang - tahunRilis <= 5) {
            kategori = Kategori.New;
        } else {
            kategori = Kategori.Reguler;
        }
    }

    public String getJudul(){return judul;}
    public Genre getGenre(){return genre;}
    public Kategori getKategori(){return kategori;}
    public int getKategoriUsia(){return kategoriUsia;}
    public int tahunRilis(){return tahunRilis;}
    public String getSinopsis(){return sinopsis;}
    
    public double getRating(){return rating;}
    public String getStudio(){return studio;}
    public String getSutradara(){return sutradara;}

    public void getDetails(){
        if (!isOriginal){updateKategori();}
        System.out.printf("%-16s : %s \n",  "Judul", judul);
        System.out.printf("%-16s : %s \n",  "Genre", genre);
        System.out.printf("%-16s : %.2f \n",  "Rating", rating);
        System.out.printf("%-16s : %s \n",  "Tanggal Rilis", tahunRilis);
        System.out.printf("%-16s : %s \n",  "Studio", studio);
        System.out.printf("%-16s : %s \n",  "Sutradara", sutradara);
        System.out.printf("%-16s : %d \n",  "Usia Minimal", kategoriUsia);
        System.out.printf("%-16s : %s \n",  "Sinopsis", sinopsis);
    }
}
