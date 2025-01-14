package pt.unl.fct.campus.firstwebapp.data.model;

import com.google.gson.JsonObject;


import java.net.CookieHandler;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    //UESER ENDPOINTS
    @POST("rest/login/op2")
    Call<LoginData> authenticateUser(@Body LoginData data);

   @GET("rest/login/op7")
   Call<Void> logoutUser();

   @POST("rest/login/op1")
   Call<Void> register(@Body RegisterData data,@Header("vrfcck") String serverVcode);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @GET("rest/login/vcd/{email}")
    Call<Void> verification_code(@Path("email") String email, @Query("n") String newUser);

   @POST("rest/login/op3")
   Call<Void> updateInfos(@Header("Cookie") String value,@Body AdditionalAttributes atributs);

    @Headers({"Accept: application/json"})
    @Multipart
    @POST("rest/login/savep")
    Call<String> updateProfilePicture(@Header("Cookie") String value,@PartMap Map<String,RequestBody> map);

   @GET("rest/login/infos/{userid}")
   Call<AdditionalAttributes> getInfos(@Header("Cookie") String value,@Path(value = "userid") String userid);


   @FormUrlEncoded
   @HTTP(method = "DELETE",path = "rest/login/op8", hasBody = true)
    Call<Void> removeAccount(@Header("Cookie") String value, @Field("p") String password);

    //Nao completa pelo servidor
    @POST("rest/login/op11")
    Call<Void> changePassword();

    //EVENTS ENDPOINTS
    @Multipart
    @POST("rest/events/create")
    Call<EventData2> createEvent(@Header("Cookie") String value,@PartMap Map<String,RequestBody> map);

    // da 401 whyy???  supostamente nao autorizado?? hmmm
    @DELETE("rest/events/delete/{eventId}")
    Call<Void>  doRemoveEvent(@Path(value = "eventId") String eventId, @Header("Cookie") String token);


    @POST("rest/events/view")
    Call<List<JsonObject>> seeEvents(@Header("crsck") String value,
                                     @Body UpcomingEventsArgs upcomingEventsArgs);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @GET("rest/events/view/finished")
    Call< List<JsonObject>> seeFinishedEvents(@Header("Cookie") String value);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @GET("rest/events/view/myevents")
    Call< List<JsonObject>> seeMyEvents(@Header("Cookie") String value);

    @FormUrlEncoded
    @HTTP(method = "POST",path = "rest/events/participate", hasBody = true)
    Call<Void> participate(@Header("Cookie") String token, @Field("eid") long eventid);

   @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @DELETE("rest/events/rparticipation/{eventid}")
  //@FormUrlEncoded
  //@HTTP(method = "DELETE",path = "rest/events/rparticipation/{eventid}", hasBody = true)
    Call<Void> removeParticipation(@Header("Cookie") String token, @Path("eventid") long eventid);

   @Headers({"Content-Type: application/json","Accept: application/json"})
   @GET("rest/events/view/interested")
   Call< List<JsonObject>> seeParticipatingEvents(@Header("Cookie") String token);


    @Headers({"Content-Type: application/json","Accept: application/json"})
    @GET("rest/events/event/{eventId}")
    Call< JsonObject> getEvent(@Path("eventId") long eventid,@Header("Cookie") String token);


}
