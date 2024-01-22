public class Siparis {

    int buyukluk;
    int teslimatSuresi;
    int siparisZamani;
    // int teslimatZamani;

    public int getBuyukluk() {
        return buyukluk;
    }

    private void setBuyukluk(int buyukluk) {
        this.buyukluk = buyukluk;
    }

    public int getTeslimatSuresi() {
        return teslimatSuresi;
    }

    private void setTeslimatSuresi(int teslimatSuresi) {
        this.teslimatSuresi = teslimatSuresi;
    }

    public int getSiparisZamani() {
        return siparisZamani;
    }

    private void setSiparisZamani(int siparisZamani) {
        this.siparisZamani = siparisZamani;
    }

    public int getTeslimatZamani() {
        // return teslimatZamani;
        // Türetilmiş bir nitelik olduğu için değer saklamıyoruz.
        // Hesaplaması kolay olduğu için her seferinde hesaplıyoruz.
        return siparisZamani + teslimatSuresi;
    }

    private void setTeslimatZamani(int teslimatZamani) {
        // this.teslimatZamani = teslimatZamani;
    }

    public Siparis() {
        this.buyukluk = 0;
        this.siparisZamani = 1;
        this.teslimatSuresi = 1;
    }

    public Siparis(int buyukluk, int teslimatSuresi, int siparisZamani) {
        this.setBuyukluk(buyukluk);
        this.setTeslimatSuresi(teslimatSuresi);
        this.setSiparisZamani(siparisZamani);
    }

    @Override
    public String toString() {
        return "Siparis{" +
                "buyukluk=" + buyukluk +
                ", teslimatSuresi=" + teslimatSuresi +
                ", siparisZamani=" + siparisZamani +
                '}';
    }
}
