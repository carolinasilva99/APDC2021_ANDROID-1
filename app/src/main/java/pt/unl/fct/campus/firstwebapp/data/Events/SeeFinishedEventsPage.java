package pt.unl.fct.campus.firstwebapp.data.Events;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import pt.unl.fct.campus.firstwebapp.LoginApp;
import pt.unl.fct.campus.firstwebapp.R;
import pt.unl.fct.campus.firstwebapp.data.model.EventData2;
import pt.unl.fct.campus.firstwebapp.data.model.EventsAdapter;

public class SeeFinishedEventsPage extends AppCompatActivity {

    private EventViewModel eventViewModel;

    private ArrayList<EventData2> eventsList = new ArrayList<>();

    EventData2 event = null;

    private EventsAdapter adapter;


    ListView listView;

    Bundle params;

    TextView text;

    String token;

    Intent oldIntent;

    Bundle savedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        this.savedInstanceState = savedInstanceState;

        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.listviewadapter);

        text = findViewById(R.id.textListEvents);

        text.setText("Finished Events");
        eventViewModel = new ViewModelProvider(this, new EventViewModelFactory(((LoginApp) getApplication()).getExecutorService()))
                .get(EventViewModel.class);

         oldIntent = getIntent();
         params = oldIntent.getExtras();

         token = params.getString("token");

        eventViewModel.seeEvent(token, token,"finished");




        eventViewModel.getLoginResult().observe(this, new Observer<EventResult>() {
            @Override
            public void onChanged(EventResult eventResult) {
                if (eventResult == null) {
                    return;
                }

                if (eventResult.getError() != null) {
                    //showLoginFailed(loginResult.getError());
                }
                if (eventResult.getSuccess() != null) {

                    EventCreatedView model = eventResult.getSuccess();

                    List<JsonObject> list = model.getEventsList();

                    if (list.size() == 0) {
                        // alerta a dizer que nao existem Eventos ainda terminados!

                        /*AlertDialog.Builder alert = new AlertDialog.Builder(SeeFinishedEventsPage.this);
                        alert.setTitle("no events");
                        alert.setMessage("There aren't finished Events  yet ");

                    } else {

                        Gson gson = new Gson();
                        // String c = list.get(0).toString();
                        // vou obter dados dos eventos


                        for (int i = 0; i < list.size(); i++) {
                            event = gson.fromJson(list.get(i).toString(), EventData2.class);
                            eventsList.add(event);
                        }


                        showEvents(eventsList);
                    }

                    setResult(Activity.RESULT_OK);

                }


                //Complete and destroy  activity once successful
                //finish();
            }
        });
    }


    public void showEvents(ArrayList<EventData2> events) {

        listView = (ListView) findViewById(R.id.listViewEvents);

        adapter = new EventsAdapter( savedInstanceState,false,this,this,this,events,R.layout.finished_events,token,oldIntent);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(SeeFinishedEventsPage.this, "click to item: "+position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    }

