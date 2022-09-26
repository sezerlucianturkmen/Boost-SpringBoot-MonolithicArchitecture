package com.boost.Java3Monolithic.constant;
public class EndPoints {
    /**
     * DİKKAT!!
     * Uygulamanız ile alakalı tüm URL listesini buraya ekleyin ve buradan kullanın
     * http://localhost:9090/mkv1
     */
    public static final String VERSION = "/mkv1";
    /**
     * http://localhost:9090/mkv1/web
     * http://localhost:9090/mkv1/api
     */
    public static final String WEB = "/web";
    public static final String API = "/api";
    /**
     * Tüm Controller sınıflarınız için End point listei
     * http://localhost:9090/mkv1/api/satis
     * http://localhost:9090/mkv1/api/urun
     * http://localhost:9090/mkv1/api/musteri
     */
    public static final String SATIS = "/satis";
    public static final String URUN = "/urun";
    public static final String MUSTERI = "/musteri";
    /**
     * Uygulama içinde default olarak kullanılan tüm end point
     * lerin listesini ekleriz.
     *
     */
    public static final String SAVE = "/save";
    public static final String SAVEALL = "/saveall";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String GETALL = "/getall";
    public static final String GETBYID = "/getbyid";
    public static final String FINDALL = "/findall";
    public static final String FINDBYID = "/findbyid";
    /**
     * MÜŞTERİ İŞLEMLERİ END POINT LERİ
     */
    public static final String FINDBYNAMEANDSURNAME = "/findbynameandsurname";

    /**
     * ÜRÜN İŞLEMLERİ END PONİT LERİ
     */

    public static final String SAVE_DTO = "/savedto";

}