import java.util.Scanner;

public class LojistikSimulasyonuV1 {
    static double D1 = 100.0;
    static double K1 = 10.0;
    static double H1 = 20.0;
    static int L1 = 2;
    static int S1 = 10;
    static int Q1 = 10;
    static int stokSeviyesi = 20;
    static int SIMULASYONSURESI = 8;
    static int HICBIRZAMAN = SIMULASYONSURESI + 1;
    static int teslimatTarihi = HICBIRZAMAN;
    static int teslimatMiktari = 0;
    static Scanner sc = new Scanner(System.in);
    // ^ Statik metodlardan erişilebilir.
    //   Program yüklenirken, hiç bir şey yokken bu değişken baştan yaratılır.

    public static void main(String[] args) {
        System.out.println("Haftalar boyunca mağaza talebini gireceksiniz.");
        int siparisMiktari;
        for (int hafta = 1; hafta <= SIMULASYONSURESI; hafta++){
            // Stok seviyesini göster
            stokSeviyesiGoster(hafta);
            // Sipariş al
            siparisMiktari = musteriSiparisiniOgren();
            // Stoğu güncelle
            stoguGuncelle(siparisMiktari, hafta);
                        // ^ Burada yazdığım değişkenin türü
                        // imzadaki tür ile eşleşmeli veya dönüşebilmeli
                        // Beklenen double gelen int sorun yok.
                        // Beklenen int gelen double olsa sorun var.
            // Parametreleri güncelle
            parametreleriGuncelle(siparisMiktari);
            // Sipariş vermen gerekiyor ise ver
           teslimatTalepEt(hafta);

           // Mağazadaki işlemler depoya nasıl yansıyacak?

        }
    }

    private static void teslimatTalepEt(int hafta) {
        if (stokSeviyesi < S1){
            System.out.println("Sipariş verilecek.");
            teslimatTarihi = hafta + L1;
            teslimatMiktari = Q1;
        }
    }

    private static void parametreleriGuncelle(int siparisMiktari) {
        D1 = (D1 / 52) * 51 + siparisMiktari;
        Q1 = (int) (Math.ceil(Math.sqrt(2 * D1 * K1 / H1)));
        S1 = (int) (D1 / 52 * L1);
    }

    private static void stoguGuncelle(int siparisMiktari, int hafta) {
                                    // ^ Geçilmesi beklenen verinin türü
        if (hafta == teslimatTarihi){
            stokSeviyesi = stokSeviyesi + teslimatMiktari;
        }

        if (siparisMiktari <= stokSeviyesi)
            stokSeviyesi = stokSeviyesi - siparisMiktari;
        else {
            // Yetersiz
            System.out.println("Yeterli stok yok. " + stokSeviyesi + " kadar teslim edilecek.");
            stokSeviyesi = 0;
        }
    }

    private static int musteriSiparisiniOgren() {
        System.out.print("Sipariş miktarı: ");
        return Integer.parseInt(sc.next());
    }

    private static void stokSeviyesiGoster(int hafta) {
        System.out.println(hafta + ". haftadaki stok seviyesi: " + stokSeviyesi);
    }
}