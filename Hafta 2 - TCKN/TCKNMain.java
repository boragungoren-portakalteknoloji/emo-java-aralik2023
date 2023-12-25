import java.util.Scanner;

public class TCKNMain {

    // int globaldeneme;

    public static void main(String[] args) {
        //System.out.println("Hello world!");

        // TCKN ve isim için değişkenler seçmek lazım
        // TCKN basamaklardan oluşsa da toplama/çıkarma gibi
        // artimetik işleme konu bir "anlamı" yoktur.
        String tckn;
        String isim;
        Integer ugurlu;
        // int değil. Integer

        // Değerleri kullanıcıdan almalıyız.
        System.out.println("Adınızı girin:");
        Scanner sc = new Scanner(System.in);
        isim = sc.next();
        System.out.println("TCKN girin:");
        tckn = sc.next();
        System.out.println("Ugurlu sayınız nedir?:");
        ugurlu = sc.nextInt();

        // Aldığımız girdinin taşıması gereken şartlar
        // varsa onları sınamalıyız.
        Boolean hatali = false; // hatali değiliz.
        // ^ Bayrak değişkeni. Hatayı görünce kaldırıyoruz.
        //
        // Kriter 1 - Tam olarak 11 basamaklı olacak.
        int uzunluk = tckn.length();
        if (uzunluk != 11){
            System.out.println("TCKN uzunluğu hatalı!");
            // Hatayı not almalıyız
            hatali = true; // hatalıyız.
            int deneme = 2; // bu değişken görünürlüğü lokaldir.
                            // lokal tanımı değişkeni kapsayan {} ikilisi
        }
        // deneme = 3;
        // Kriter 2  - TCKN bir sayı olmalıdır. İçinde basamak hariç
        // veri olmaz.

//        Long l =  Long.parseLong(tckn);
//        if(l == null ){
//            hatali = true;
//        }
        Boolean kriter2Hatali = false;
        String kalanMetin = tckn.toString();
        while (kalanMetin.length() > 0){
            //System.out.println(kalanMetin);
            char sifirinci = kalanMetin.charAt(0);
            kalanMetin = kalanMetin.substring(1);
            if ( Character.isDigit(sifirinci) == false) {
                hatali = true;
                kriter2Hatali = true;
                break; // Yeter, döngüden dışarı zıpla.
            }
        }
        int index = 0;
        while (index < tckn.length()){
            char test = tckn.charAt(index);
            index = index + 1;
            if ( Character.isDigit(test) == false) {
                hatali = true;
                kriter2Hatali = true;
                break; // Yeter, döngüden dışarı zıpla.
            }
        }

        for(int i =0; i < tckn.length(); i = i+1){
            char test = tckn.charAt(i);
            if ( Character.isDigit(test) == false) {
                hatali = true;
                kriter2Hatali = true;
                break; // Yeter, döngüden dışarı zıpla.
            }
        }

        // Kriter 3 - TCKN ilk 10 basamak toplayıp mod 10 yapınca
        // son basamağı bulmalıdır.
        // Ön koşul = Sayı olması. Kriter 2'den kalmışsa buna
        // zaten bakamam
        if (kriter2Hatali == false){
            // Eğer kriter 2 hatalı ise
            // aşağıdaki kodlar hata verecek.
            System.out.println(tckn);
            // Integer tc = Integer.parseInt(tckn);
            // 11 basamaklı sayı Integer a sığmadı.
            Long tcl = Long.parseLong(tckn);
//        if (tc == null)
//            System.out.println("tc null");
//        if (tcl == null)
//            System.out.println("tcl null");
            long ensag = tcl % 10;
            long onbasamak = tcl / 10;
            long toplam = 0;
            while (onbasamak > 0){
                //System.out.println("On Basamak:" + onbasamak);
                long kalan = onbasamak % 10;
                toplam = toplam + kalan;
                onbasamak = onbasamak / 10;
            }
            if ((toplam % 10) != ensag){
                hatali = true;
            }
        }


        // Ödev: her seferinde basamağı String'den kopartıp
        // char halindeki tek basamağı sayıya dönüştürüp toplama eklemek.
        // Bunu do while ile yapmayı deneyebilirsiniz.


        // Kriter 4 - TCKN 0 ile başlayamaz
        /*
        Character ilk = tckn.charAt(0);
        Boolean sonuc = ilk.equals('0');
        if (sonuc == true){
            // İlk karakter '0' ise 0 ile başlamıştır.
        }
        */
        else if (tckn.charAt(0) == '0') {
            System.out.println("TCKN 0 ile başlayamaz.");
            // Hatayı not almalıyız
            hatali = true; // hatalıyız.
        }
        // Bir hata yoksa, yukarıdaki if deyimlerine girmez. hatali değeri false kalır.

        // Aldığımızı teyit etmeliyiz.
        if ( hatali == false){
            // ^ Bayrak kalkmamış ise devam ediyoruz.
            System.out.println("Sayın " + isim + ", ");
            System.out.println("TCKN: " + tckn );
            System.out.println("Ugurlu sayı: " + ugurlu);
            // Ugurlu sayı TCKN içinde var mı?
            // ör 1234909056 uğurlu 90
            // içinde olup olmadığını test etmenin yolu?
            // Boolean sonuc = tckn.contains(ugurlu.toString());
            // System.out.println("Sonuç:" + sonuc);
            // içinde yoksa ve varsa
            // "duruma göre" farklı mesaj nasıl vereceğim?
            //  ^ conditional
            if(tckn.contains(ugurlu.toString())){
                System.out.println("Uğurlu sayınız TCKN içinde.");
            }

        } // if, hatali durumda işlem yapmamak için
        else{
            System.out.println("Hata durumu nedeni ile işlemler sonlandırıldı.");
        }
    }
}