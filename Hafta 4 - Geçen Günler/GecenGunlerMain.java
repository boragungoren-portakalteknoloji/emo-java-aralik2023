import java.util.Scanner;

public class GecenGunlerMain {
    public static void main(String[] args) {

        // Kullanıcı girdisini almak
        Scanner sc = new Scanner(System.in);
        System.out.print("Başlangıç tatihini girin (Ör. 30.10.2023):");
        String baslangicString = sc.next();
        System.out.print("Bitiş tatihini girin (Ör. 25.4.2025):");
        String bitisString = sc.next();

        int baslangicGun, baslangicAy, baslangicYil;
        int indeks1 = baslangicString.indexOf('.');
        int indeks2 = baslangicString.lastIndexOf('.');
        baslangicGun = Integer.parseInt(baslangicString.substring(0,indeks1));
        baslangicAy = Integer.parseInt(baslangicString.substring(indeks1+1,indeks2));
        baslangicYil = Integer.parseInt(baslangicString.substring(indeks2+1));

        int bitisGun, bitisAy, bitisYil;
        indeks1 = bitisString.indexOf('.');
        indeks2 = bitisString.lastIndexOf('.');
        bitisGun = Integer.parseInt(bitisString.substring(0,indeks1));
        bitisAy = Integer.parseInt(bitisString.substring(indeks1+1,indeks2));
        bitisYil = Integer.parseInt(bitisString.substring(indeks2+1));

        // Ek Ödev: Hatalı girdi kontrolleri
        // Eğer Başlangıç bitişten sonra ise programdan çıkılsın.

        // hesaplama başladı.

        int toplam = 0;
        boolean cikis = false;
        boolean artikYil = false;
        int ay = baslangicAy;
        int ayinIlkGunu = baslangicGun;
        for (int yil = baslangicYil; yil <= bitisYil; yil++){
            // Artık yıl bilgisi her ay hesaplanmak zorunda değil.
            // Bu nedenle yılın başında bir kez hesaplıyoruz.
            if (0 == (yil % 4) ){
                // Artık yıl.
                artikYil = true;
            }
            while(ay <= 12){
                // Ayın son gününü hesapla
                int sonGun;
                if (yil == bitisYil && ay == bitisAy){
                    // Son yılın son ayına gelmiş isek kullanıcı girdisi kullanılacak.
                    // Ayrıca bu aydan sonraki aylara bakmak da gerekli değil.
                    sonGun = bitisGun;
                    cikis = true;
                } // Sona gelmemiş isek ayın son günü kullanılacak.
                else if (ay == 1 || ay == 3 || ay == 5 || ay ==7 || ay ==8 || ay == 10 ||ay == 12)
                    sonGun = 31;
                else if (ay == 4 || ay == 6 || ay == 9 || ay == 11)
                    sonGun = 30;
                else if (ay == 2 &&  artikYil == true )
                    // Artık yıl
                    sonGun = 29;
                else
                    sonGun = 28;
                int gecenGun = sonGun - ayinIlkGunu + 1;
                toplam = toplam + gecenGun;
                System.out.println("Yıl: " + yil + " Ay: "+ ay + " Geçen Gün: " + gecenGun + " Toplam: " + toplam);

                // Çıkış yapılacak mı?
                if (cikis == true){
                    break;
                }
                // Çıkış yapmamış isek, sonraki aya geçeceğiz.
                // Sıradaki aya geçerken.
                ay = ay + 1;
                // Ay 13 olduğu zaman ay döngüsü sona erecek.
                ayinIlkGunu = 1;
            }

            if (cikis == true){
                System.out.println ("Hesaplamalar bitti. ");
                break;
            }
            // Sonraki yıla geçerken
            // Ayların 1'den başlaması gerekli.
            // Artık yıl ertesi yılın başında tekrar hesaplanmalı.
            ay =  1;
            artikYil = false;
        }
    }
}