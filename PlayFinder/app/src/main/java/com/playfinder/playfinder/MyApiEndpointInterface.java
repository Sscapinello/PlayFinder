package com.playfinder.playfinder;

import android.icu.text.Replaceable;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by itsadmin on 20/02/2018.
 */


    public interface MyApiEndpointInterface {
        //servlet implemented

        //login
        //@Multipart
        @POST("login")

        @FormUrlEncoded
        Call<ResponsoLogin> login(@Field("username") String username, @Field("password") String password);

        //Registrazione

        @POST("registrazione")
        @FormUrlEncoded
        Call<Utente> registrazione(@Field("nome") String nome,@Field("cognome")String cognome,@Field("anni") int anni,
                                     @Field("regione") String regione,@Field("citta") String citta,@Field("user_name") String user_name,
                                     @Field("email") String email,@Field("contact_no") String contact_no, @Field("password") String password);
        //Crea Evento
        @Multipart
        @POST("creaEvento")
        Call<Partita> creaEvento(@Part("nome")String nome,@Part("password") String password,@Part("data") String data, @Part("eta") int durata,
                                  @Part("privato") Boolean privato,@Part("citta") String citta,@Part("regione") String regione,
                                  @Part("civico") String civico,@Part("nomeSport") String nomeSport);

        //home

        @GET("profilo")
        Call<Partita> home();


        @POST("EventoServlet")
        Call<Partita> evento (@Part("id") String id);

        @GET("RicercaUtenti")
        Call<Utente> ricerca(@Part("Utente") ArrayList utenti);


    }

