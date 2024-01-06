import java.util.Scanner;

public class LojistikSimulasyonuV2 {
    // static double D1 = 100.0; // Haftalık değişiyor. Eski değeri ile hesaplanıyor.
    static double K1 = 10.0; // Hiç değişmiyor.
    static double H1 = 20.0; // Hiç değişmiyor.
    static int L1 = 2; // Hiç değişmiyor.
    static int S1 = 10; // Haftalık değişiyor.
    static int Q1 = 10; // Haftalık değişiyor.
    // static int stokSeviyesi = 20; // Haftalık değişiyor.
    static int SIMULASYONSURESI = 8; // Hiç değişmiyor.
    static int HICBIRZAMAN = SIMULASYONSURESI + 1; // Hiç değişmiyor.
    // static int teslimatTarihi = HICBIRZAMAN; // Haftalık değişiyor.
    static int teslimatMiktari = 0; // Haftalık değişiyor.
    static Scanner sc = new Scanner(System.in); // Hiç değişmiyor.

    public static void main(String[] args) {
        System.out.println("Haftalar boyunca mağaza talebini gireceksiniz.");
        int siparisMiktari;
        double d1 = 100.0;
        int stok = 20;
        int talepTarihi = HICBIRZAMAN;
        for (int hafta = 1; hafta <= SIMULASYONSURESI; hafta++){
            // Stok seviyesini göster
            stokSeviyesiGoster(hafta, stok);
            // Sipariş al
            siparisMiktari = musteriSiparisiniOgren();
            // Stoğu güncelle
            stok = stoguGuncelle(siparisMiktari, stok, hafta, talepTarihi);
            d1 = parametreleriGuncelle(siparisMiktari,d1);
            // Sipariş vermen gerekiyor ise ver
            talepTarihi = teslimatTalepEt(hafta,stok);

            // Mağazadaki işlemler depoya nasıl yansıyacak?
        }
    }

    private static int teslimatTalepEt(int hafta, int stok) {
        int teslimatTarihi = HICBIRZAMAN;
        if (stok < S1){
            System.out.println("Sipariş verilecek.");
            teslimatTarihi = hafta + L1;
            teslimatMiktari = Q1;
            // Keşke bir arada paketleyebilsek.
        }
        return teslimatTarihi;
    }

    private static double parametreleriGuncelle(int siparisMiktari, double talep) {
        talep = (talep / 52) * 51 + siparisMiktari; // Belleksiz kayan toplam
        Q1 = (int) (Math.ceil(Math.sqrt(2 * talep * K1 / H1)));
        S1 = (int) (talep / 52 * L1);
        return talep;
    }

    private static int stoguGuncelle(int siparisMiktari, int stokSeviyesi, int hafta, int teslimatTarihi) {
        // Gelen teslimat varsa stoğa ekle
        if (hafta == teslimatTarihi){
            stokSeviyesi = stokSeviyesi + teslimatMiktari;
        }
        // Gelen sipariş varsa stoktan düş
        if (siparisMiktari <= stokSeviyesi)
            stokSeviyesi = stokSeviyesi - siparisMiktari;
        else {
            // Yetersiz stok.
            System.out.println("Yeterli stok yok. " + stokSeviyesi + " kadar teslim edilecek.");
            stokSeviyesi = 0;
        }
        return stokSeviyesi;
    }

    private static int musteriSiparisiniOgren() {
        System.out.print("Sipariş miktarı: ");
        return Integer.parseInt(sc.next());
    }

    private static void stokSeviyesiGoster(int hafta, int stok) {
        System.out.println(hafta + ". haftadaki stok seviyesi: " + stok);
    }
}