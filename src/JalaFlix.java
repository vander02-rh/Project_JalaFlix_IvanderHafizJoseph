public class JalaFlix {
    public static void main(String[] args) {
        Film film1 = new FilmOriginal("Kehidupan di Malang", Genre.Romance, "2025-05-31", "menceritakan kisah tentang seseorang yang menuntut ilmu namun ia bertemu dengan kisah cintanya", 5, "JalaFlix", "aulia", 17, true);

        film1.getDetails();
    }
}
