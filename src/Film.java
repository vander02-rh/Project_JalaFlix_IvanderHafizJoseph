enum Kategori {
    New, Reguler, Original
} 

enum Genre {
    Comedy, Horror, Drama, Action, SciFi, Fantasy, Mystery, Thriller, Adventure, Romance
}

public class Film{
    private String judul,sinopsis,sutradara,studio;
    private String tanggal;
    private double  rating;
    private int kategoriUsia;

    private Genre genre;
    private Kategori kategori;

    public Film(String judul, Genre genre, String tanggal, String sinopsis, double rating, String studio, String sutradara, int kategoriUsia){
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
    public double getRating(){return rating;}
    public String getStudio(){return studio;}
    public String getSutradara(){return sutradara;}
    public int getKategoriUsia(){return kategoriUsia;}

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
