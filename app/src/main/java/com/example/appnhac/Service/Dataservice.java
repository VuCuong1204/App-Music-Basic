package com.example.appnhac.Service;

import com.example.appnhac.Model.Album;
import com.example.appnhac.Model.Baihat;
import com.example.appnhac.Model.Chude;
import com.example.appnhac.Model.Chudevatheloai;
import com.example.appnhac.Model.Playlist;
import com.example.appnhac.Model.Quangcao;
import com.example.appnhac.Model.Theloai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>>  GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Chudevatheloai> GetDataChudeVaTheloai();

    @GET("album.php")
    Call<List<Album>> GetAlbum();

    @GET("baihat.php")
    Call<List<Baihat>> GetBaihat();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachplaylist.php")
    Call<List<Playlist>> GetDanhsachcacplaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);

    @GET("chude.php")
    Call<List<Chude>> GetChude();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<Theloai>> GetTheloaitheochude(@Field("idchude") String idchude);

    @POST("tatcaalbum.php")
    Call<List<Album>> Gettatcaalbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetBaihattheoalbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("luotthich.php")
    Call<String> GetupdateLuotThich(@Field("luotthich") String luotthich,@Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("timkiem.php")
    Call<List<Baihat>> GetSearchbaihat(@Field("tukhoa") String tukhoa);

}

