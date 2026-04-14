import java.util.*;

public class JalaFlix {

    public static List <Film> film = new ArrayList<>();
    public static List<Pelanggan> pelanggan = new ArrayList<>();
    public static void main(String[] args) {
        film.add(new Film("Jala Saga", Genre.Action, 2026, "Misi", 9.5, "Jala", "Budi", 17, true));
        film.add(new Film("Tawa Desa", Genre.Comedy, 2024, "Lucu", 8.0, "Maju", "Siti", 13, false));
        film.add(new Film("Ruang Hampa", Genre.SciFi, 2023, "Hampa", 8.7, "Cosm", "Andi", 13, false));
        film.add(new Film("Kenangan", Genre.Romance, 2010, "Lama", 7.5, "Clas", "Rudi", 13, false));
        film.add(new Film("Hutan Tua", Genre.Horror, 2015, "Serem", 6.8, "Scar", "Eko", 17, false));
        film.add(new Film("Pedang Naga", Genre.Fantasy, 2022, "Pedang", 8.2, "Epic", "Dewi", 13, false));
        film.add(new Film("Detektif", Genre.Mystery, 2025, "Cilik", 7.9, "Kids", "Bamb", 7, false));
        film.add(new Film("Ori Mystery", Genre.Thriller, 2026, "Twist", 9.0, "Jala", "X", 18, true));
        film.add(new Film("Langkah", Genre.Adventure, 2012, "Jauh", 8.5, "Glob", "Joko", 7, false));
        film.add(new Film("Keluarga", Genre.Drama, 2020, "Sedih", 8.8, "Home", "Lest", 7, false));

        pelanggan.add(new PelangganPlatinum("P01", "Andi", 25, "0811"));
        pelanggan.add(new PelangganGold("G02", "Deni", 28, "0814"));
        pelanggan.add(new PelangganGold("G03", "Eka", 35, "0815"));
        pelanggan.add(new PelangganReguler("R01", "Fani", 19, "0816"));
        pelanggan.add(new PelangganReguler("R02", "Gani", 1, "0817"));


        //INFO
        pelanggan.get(0).info();
        pelanggan.get(1).info();
        pelanggan.get(3).info();

        //NONTON
        System.out.println("");
        pelanggan.get(0).putarFilm(film.get(8));
        pelanggan.get(0).putarFilm(film.get(1));
        pelanggan.get(1).putarFilm(film.get(0));
        pelanggan.get(1).putarFilm(film.get(2));

        //History
        System.out.println("");
        pelanggan.get(0).getHistory();
        pelanggan.get(1).getHistory();

    }
}
