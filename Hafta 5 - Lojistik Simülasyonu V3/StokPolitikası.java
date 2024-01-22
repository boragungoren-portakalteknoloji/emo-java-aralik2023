public class StokPolitikası {
    // EOQ formülünde olanlar
    int donemselToplamTalepD;
    int siparisMaliyetiK;
    int bulundurmaMaliyetiH;

    public int getDonemselToplamTalepD() {
        return donemselToplamTalepD;
    }

    public void setDonemselToplamTalepD(int donemselToplamTalepD) {
        this.donemselToplamTalepD = donemselToplamTalepD;
    }

    public int getSiparisMaliyetiK() {
        return siparisMaliyetiK;
    }

    public void setSiparisMaliyetiK(int siparisMaliyetiK) {
        this.siparisMaliyetiK = siparisMaliyetiK;
    }

    public int getBulundurmaMaliyetiH() {
        return bulundurmaMaliyetiH;
    }

    public void setBulundurmaMaliyetiH(int bulundurmaMaliyetiH) {
        this.bulundurmaMaliyetiH = bulundurmaMaliyetiH;
    }

    public int getEoq() {
        // EOQ türetilmiş değişkendir.
        return (int) Math.ceil (
                Math.sqrt(2.0*donemselToplamTalepD*siparisMaliyetiK/bulundurmaMaliyetiH)
                );
        // return eoq;
    }

    private void setEoq(int eoq) {
        // this.eoq = eoq;
    }

    public int getYenidenSiparisNoktasi(int donemUzunlugu, int teslimatSuresi){
        return (int) Math.ceil( (donemselToplamTalepD / donemUzunlugu) * teslimatSuresi);
    }

    public StokPolitikası() {
    }

    public StokPolitikası(int donemselToplamTalepD, int siparisMaliyetiK, int bulundurmaMaliyetiH) {
        this.setDonemselToplamTalepD(donemselToplamTalepD);
        this.setSiparisMaliyetiK(siparisMaliyetiK);
        this.setBulundurmaMaliyetiH(bulundurmaMaliyetiH);
    }

    @Override
    public String toString() {
        return "StokPolitikası{" +
                "donemselToplamTalepD=" + donemselToplamTalepD +
                ", siparisMaliyetiK=" + siparisMaliyetiK +
                ", bulundurmaMaliyetiH=" + bulundurmaMaliyetiH +
                '}';
    }

}
