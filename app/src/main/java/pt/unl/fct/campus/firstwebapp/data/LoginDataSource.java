package pt.unl.fct.campus.firstwebapp.data;

import android.app.Application;

import pt.unl.fct.campus.firstwebapp.data.model.AdditionalAttributes;
import pt.unl.fct.campus.firstwebapp.data.model.ExecuteService;
import pt.unl.fct.campus.firstwebapp.data.model.RegisterData;
import pt.unl.fct.campus.firstwebapp.data.model.LoginData;
import pt.unl.fct.campus.firstwebapp.data.model.UserAuthenticated;
import pt.unl.fct.campus.firstwebapp.data.model.UserService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */

public class LoginDataSource extends Application {

    private UserService service;


    public LoginDataSource() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apdc-project-310922.ew.r.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(UserService.class);
    }

    public Result<LoginData> login(String username, String password) {

        LoginData a = new LoginData(username,password);


        Call<LoginData> userAuthenticatedCall = service.authenticateUser(a);
        try {

            Response<LoginData> response = userAuthenticatedCall.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteService(response);

        } catch (Exception e) {

           return new Result.Error(new IOException("Error logging in", e));
        }

    }

    public Result<Void> logout( ) {


        Call<Void> logoutUser = service.logoutUser();


        try {

            Response<Void> response = logoutUser.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceLogout(response);

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging out", e));
        }

    }


    public Result<RegisterData> register(String name, String password, String email) {

        RegisterData data = new RegisterData(name,password,email);


        Call<Void> registrate = service.register(data);


        try {

            Response<Void> response = registrate.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceRegister(response);

        } catch (Exception e) {
            return new Result.Error(new IOException("Error Making Register", e));
        }
    }

    public Result<AdditionalAttributes> updateInfo(String cookie,AdditionalAttributes atribs) {

        Call<Void> updateInfos = service.updateInfos(cookie,atribs);


        try {

            Response<Void> response = updateInfos.execute();


            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceUpdateInfo(response);

        } catch (Exception e) {

            return new Result.Error(new IOException("Error Making Update", e));
        }
    }


    public Result<AdditionalAttributes> getInfos(String token) {

        Call<AdditionalAttributes> updateInfos = service.getInfos(token);


        try {

            Response<AdditionalAttributes> response = updateInfos.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceGetInfo(response);

        } catch (Exception e) {
            return new Result.Error(new IOException("Error Making Update", e));
        }
    }


    public Result<LoginData> removeAccount(String token,String password) {

        Call<Void> removeAccount = service.removeAccount(token,password);




        try {

            Response<Void> response = removeAccount.execute();

            ExecuteService executeService = new ExecuteService();

            return executeService.ExecuteServiceLRemoveAccount(response);

        } catch (Exception e) {
            return new Result.Error(new IOException("Error Removing Account", e));
        }
    }


}