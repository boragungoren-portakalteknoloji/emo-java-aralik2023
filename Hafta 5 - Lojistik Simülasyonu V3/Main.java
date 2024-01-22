import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Takvim ilk günden başladı.");
        Takvim tak = new Takvim(1);
        int baslangicStok = 100;
        DepolamaBirimi depo = new DepolamaBirimi(baslangicStok);
        int donemselToplamTalep = 100;
        int siparisMaliyeti = 10;
        int bulundurmaMaliyeti = 20;
        StokPolitikası sp =
                new StokPolitikası(
                        donemselToplamTalep, siparisMaliyeti, bulundurmaMaliyeti
                );
        Scanner sc = new Scanner(System.in);

        List<Siparis> siparisListesi = new ArrayList<Siparis>();
        // İçi boş. Sadece Siparis türünden nesne saklayacak.

        int SURE = 1;
        while (tak.getBugun() <= SURE){
            // Her günün işlemleri yapılır.
            System.out.println("Bugun:" + tak.getBugun());
            // TODO: Gelen teslimat varsa stoğa ekleyeceğiz
            // Mevcut bütün teslimatlar içinde teslimat tarihi bugün olanı bulmak
            // O teslimat için
            // depo.stokEkle(yeniSiparis.getBuyukluk());
            for(Siparis siparis : siparisListesi) {
                if (siparis.getTeslimatZamani() == tak.getBugun()){
                        depo.stokEkle(siparis.getBuyukluk());
                        System.out.println("Depoya eklenen:" + siparis.getBuyukluk());
                        // İşi biten siparis silinsin istersek
                        // siparisListesi.remove(siparis);
                }
            }


            // Müşteriden sipariş alıyoruz.
            {
                System.out.print("Son kullanıcı siparişi:");
            }
            int siparisAdedi = Integer.parseInt(sc.next());

            // TODO: Müşteri siparişini depodan düşeceğiz.
            int teslimEdilen = depo.stokCikart(siparisAdedi);
            System.out.println("Son kullanıcıya teslim edilebilen:" + teslimEdilen);
            System.out.println(depo);

            // TODO: Eğer stok seviyesi düşmüş ise ileride teslim edilecek
            //  şekilde toptancı siparişi yaratacağız.

            int s = sp.getYenidenSiparisNoktasi(50,2);
            if (depo.getStokSeviyesi() <= s){
                // Stok seviyem kritğin altına düşmüş
                // sipariş vermem lazım.
                int q = sp.getEoq();
                int buyukluk = q; // hesaplanacak
                int teslimatSuresi = 2;
                int siparisZamani = tak.getBugun();
                Siparis yeniSiparis = new Siparis(buyukluk, teslimatSuresi, siparisZamani);
                System.out.println("Depoya gelecek yeni sipariş: "+ buyukluk);
                // TODO: Bu yeni siparişi mevcut bütün teslimatlar "öbeğine" eklemek
                siparisListesi.add(yeniSiparis);
            }

            tak.gunSonu();
        }



    }
}