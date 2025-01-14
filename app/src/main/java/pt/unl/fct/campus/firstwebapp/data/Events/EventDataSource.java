package pt.unl.fct.campus.firstwebapp.data.Events;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;

import androidx.annotation.Nullable;

import com.google.android.gms.common.api.Api;
import com.google.gson.JsonObject;


import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import pt.unl.fct.campus.firstwebapp.data.Result;
import pt.unl.fct.campus.firstwebapp.data.model.EventData2;
import pt.unl.fct.campus.firstwebapp.data.model.ExecuteService;
import pt.unl.fct.campus.firstwebapp.data.model.UpcomingEventsArgs;
import pt.unl.fct.campus.firstwebapp.data.model.UserService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class EventDataSource {

    private UserService service;

    public EventDataSource() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apdc-project-310922.ew.r.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(UserService.class);


    }


    public Result<EventData2> createEvent(String token,Map<String,RequestBody> map) {

        Call<EventData2> userAuthenticatedCall = service.createEvent(token,map);
        try {

            Response<EventData2> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            if (!response.isSuccessful()){
                int errorCode=response.code();

                if(errorCode==401)
                    return new Result.Error(new Exception("401"));
            }


            return executeService.ExecuteServiceCreateEvent(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error Creating Event", e));
        }

    }

    public Result<JsonObject> getEvent(long eventId, String token) {

        Call<JsonObject> userAuthenticatedCall = service.getEvent(eventId,token);
        try {

            Response<JsonObject> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceGetEvent(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error Creating Event", e));
        }
    }

    public Result<List<JsonObject>> seeEvents(String value, String token, UpcomingEventsArgs upcomingEventsArgs)  {

        Cookie cookie = new Cookie.Builder()
                .value(token)
                .name("Cookie")
                .domain("appspot.com")
                .path("/")
                .build();


        Call<List<JsonObject> > userAuthenticatedCall = service.seeEvents(value,  upcomingEventsArgs);
        try {

            Response<List<JsonObject>> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceEvents(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error To see Events", e));
        }
    }


    public Result<List<JsonObject>> seeFinishedEvents(String value, String token) {


        Call<List<JsonObject>> userAuthenticatedCall = service.seeFinishedEvents(value);
        try {

            Response<List<JsonObject>> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceEvents(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error To see Events", e));
        }
    }

    public Result<Void> participate(String token, long eventId) {

        Call<Void> userAuthenticatedCall = service.participate(token,eventId);
        try {

            Response<Void> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceParticipate(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error To see Events", e));
        }
    }


    public Result<Void> removeParticipation(String token, long eventId) {

        Call<Void> userAuthenticatedCall = service.removeParticipation(token,eventId);
        try {

            Response<Void> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceParticipate(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error To see Events", e));
        }
    }

    public Result<List<JsonObject>> seemyEvents(String value, String token) {

        Call<List<JsonObject>> userAuthenticatedCall = service.seeMyEvents(value);
        try {

            Response<List<JsonObject>> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceEvents(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error To see Events", e));
        }
    }

    public Result<List<JsonObject>> seeParticipatingEvents(String value, String token) {

        Call<List<JsonObject>> userAuthenticatedCall = service.seeParticipatingEvents(value);
        try {

            Response<List<JsonObject>> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceEvents(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error To see Events", e));
        }
    }

    public Result<Void> doRemoveEvent(String eventId, String token) {

        Call<Void> userAuthenticatedCall = service.doRemoveEvent(eventId,token);
        try {

            Response<Void> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceRemoveEvent(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error To Remove Event", e));
        }
    }



}
