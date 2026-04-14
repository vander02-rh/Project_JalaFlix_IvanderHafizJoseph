public class HistoryTontonan{
    private Film daftarHistory [] = new Film[10];
    private int counter = 0;

    public void tampilkanHistory(){
        for (int i = 0; i < counter; i++) {
            System.out.printf("%02d. %s\n",(i+1),daftarHistory[i].getJudul());
        }
    }

    public void addHistory(Film film){
        if (counter == 10){
            refreshHistory();
        }
        daftarHistory[counter] = film;
        counter++;
    }

    // Masih Rancangan
    public void clearHistory(){

    }

    private void refreshHistory(){
        Film [] newDaftar = new Film[10];
        for(int i = 0 ; i < 9 ; i++){
            newDaftar[i] = daftarHistory[i+1];
        }
        daftarHistory = newDaftar;
        counter = 9;
    } 

    
}