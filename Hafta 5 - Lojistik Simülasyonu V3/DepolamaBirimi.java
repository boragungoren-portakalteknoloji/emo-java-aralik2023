public class DepolamaBirimi {
    public DepolamaBirimi() {

    }

    public DepolamaBirimi(int stokSeviyesi) {
        this.stokSeviyesi = stokSeviyesi;
    }

    public int getStokSeviyesi() {
        return stokSeviyesi;
    }

    private void setStokSeviyesi(int stokSeviyesi) {
        // private yaparak direkt değer değiştirme becerisini içeriye sağladık.
        // İleride burada bir sürü kural işletiliyor olabilir.
        this.stokSeviyesi = stokSeviyesi;
        // TODO: Acaba burada (s,Q) vb politika uygulamali miyim? Yoksa başka bir yerde mi?
    }

    public void stokEkle(int gelen){
        // Opsiyon 1 - Direkt güncelleme
        //this.stokSeviyesi = this.stokSeviyesi + gelen;
        // Opsiyon 2 - get/set kullanarak güncelleme
        // get/set içinde gömülü iş kurallarını işletmeyi garanti ettim.
        int varOlan = this.getStokSeviyesi();
        int yeniDeger = varOlan + gelen;
        this.setStokSeviyesi(yeniDeger);
    }

    public int stokCikart(int istenen){
        // Kullanım şekli:
        // int aldigim = depo.stokCikart(istedigim);
        int varOlan = this.getStokSeviyesi();
        if (varOlan >= istenen){
          // yeterince var
            int kalan = varOlan - istenen;
            this.setStokSeviyesi(kalan);
            return istenen;
        }
        else {
            // yeterince yok.
            int verebildigim = this.getStokSeviyesi();
            this.setStokSeviyesi(0);
            return verebildigim;
        }
    }


    private int stokSeviyesi;
    // negatif olmaz; vb iş kuralları.


    @Override
    public String toString() {
        return "DepolamaBirimi{" +
                "stokSeviyesi=" + stokSeviyesi +
                '}';
    }
}
