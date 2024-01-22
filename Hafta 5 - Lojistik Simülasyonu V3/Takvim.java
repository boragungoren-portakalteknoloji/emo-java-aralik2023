public class Takvim {

    public Takvim(){
        // Adı sınıfla aynı. Bir şey dönmüyor.
        // new Takvim(); bunu çağıracak
        this.bugun = 1;
        // Parametre almadı. Varsayılan değerleri verdi.
        // Varsayılan kurucu/yapıcı (default constructor)
    }

    public Takvim(int bugun) {
        this.bugun = bugun;
    }

    public Takvim(Takvim oteki){
        // Takvim tak2 = new Takvim(tak);
        // Kopyalama gerçekleştirdiği için kopyalama yapıcısı (copy constructor)
        this.bugun = oteki.bugun;
    }

    public int getBugun() {
        return bugun;
    }

    public void setBugun(int bugun) {
        this.bugun = bugun;
        // this nesnenin kendisi
        // this.bugun bendeki bugun, parametre gelen bugun ile karışmadı.
    }

    private int bugun;
    // Encapsulation - Saklama / Kapsülleme. Yumurta gibi.

    public void gunSonu() {
        bugun = bugun + 1;
    }
    // private diye etiketleyince sadece içeride erişilir oldu.
    // bu değişkene yazma hakkı da sadece bu sınıf içndeki metodlarda


    @Override
    public String toString() {
        return "Takvim{" +
                "bugun=" + bugun +
                '}';
    }
}
