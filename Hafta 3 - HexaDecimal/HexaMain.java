import java.util.Scanner;

public class HexaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String basamaklar = "0123456789ABCDEF";
        // Girilen sayıyı 16'lık düzene çevirme.
        System.out.print("Onluk duzende bir sayi girin: ");
        long sayi = sc.nextLong();
        String onaltilik ="";
                    //    ^ İçi boş bir String değeri.
        do{
         long bolum = sayi / 16;
                    // Tamsayı bölmesi ile eninde sonunda sıfır olacak.
         int kalan = (int) (sayi % 16);
         //            ^ tür dönüşümü
         char basamak = basamaklar.charAt(kalan);
                        // Örnek "0123456789ABCDEF" charat(10) -> 'A'
         onaltilik = basamak + onaltilik;
         //             ^ yeni basamak sola eklenecek.
         sayi = bolum;
         // ^ Döngünün bir noktada sona ermesini sağlayan güncelleme
        }
        while(sayi != 0);
        System.out.println("Onaltılık düzendeki karşılığı:" + onaltilik);

        // 16'lık düzenden ondalık düzene geri dönüşüm.
        System.out.print("Şimdi de 16lık düzende bir sayı girin: ");
        String onaltilikSayi = sc.next();
        // örnek : "AE3" = 10 x 16^2 + 14 x 16^1 + 3 x 16^0
        //             = (( (10 x 16) + 14 ) x 16 ) + 3
        // Gereken değişkenler:
        // Toplam, işlenmekte olan basamak değeri (örnekte 10,14,3)
        // (belki) işlenmekte olan basamağın metindeki konumu (örnekte 0,1,2)
        // (belki) basamak sayısı (örnekte 3)
        // veya kaç kere döngü işleteceğimizin (örnekte 2) bilgisi
        long toplam = 0;
        char basamakOnalti;
        int basamak; // 0 ile 15 arası
        int basamakSayisi = onaltilikSayi.length();

        for (int konum = 0; konum < basamakSayisi; konum++){
            // konum ne olursa olsun toplama var.

            // Onaltılık düzendeki sayıda mevcut basamak ne?
            basamakOnalti = onaltilikSayi.charAt(konum);
                        // char 'A', 'E', '3'
            // Bu basamağın 10'luk düzendeki karşılığı ne?
            basamak = basamaklar.indexOf(basamakOnalti);
            // İki işlem tek satırda bir araya gelebilirdi...
            // basamak = basamaklar.indexOf(onaltilikSayi.charAt(konum));
            toplam = toplam + basamak;
            //   10  <- 0 + 10 (konum 0)
            //   174 <- 160 + 14 (konum 1)
            //   .... < ... + 3 (konum 2)
            // konum en son basamağa gelene kadar çarpılacak
            // en son basamakta çarpılmayacak
            if (konum != basamakSayisi-1){
                // Çarpılacak
                toplam = toplam * 16;
                // 160 <- 10 x 16
                // ... <- 174 x 16
            }
        }
        System.out.println("Ondalık değeri:" + toplam );

        // Ödev: Aralarında nokta olan IPv4 adresini 16lık düzende gösterme.
        // Örnek: 192.168.1.1 -> C0:A8:01:01
        // Alt problem 1: Noktalardan dörde bölmek (İng split)
        // Alt problem 2: Tam dört kere işlem yapmak (yada her seferinde).


    }
}