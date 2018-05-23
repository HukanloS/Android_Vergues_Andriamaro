package org.esiea.vergues_andriamaro.legrandprojet.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.esiea.vergues_andriamaro.legrandprojet.R;
import org.esiea.vergues_andriamaro.legrandprojet.adapters.RecyclerViewAdapter;
import org.esiea.vergues_andriamaro.legrandprojet.model.JSONmh4u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MH3UActivity extends AppCompatActivity {

    private static final String TAG = "";
    private final String JSON_URL = "https://raw.githubusercontent.com/HukanloS/mh_info_monster_names/master/mh3uMonsterName_en_fr_jp.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<JSONmh4u> lstJSONmh4u;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh4u);

        lstJSONmh4u = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for(int i = 0 ; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        JSONmh4u jsonMh4u = new JSONmh4u();
                        jsonMh4u.setEn_name(jsonObject.getString("EN"));
                        jsonMh4u.setJp_name(jsonObject.getString("JP"));
                        jsonMh4u.setFr_name(jsonObject.getString("FR"));
                        jsonMh4u.setImg_url(jsonObject.getString("img"));
                        lstJSONmh4u.add(jsonMh4u);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setuprecyclerview(lstJSONmh4u);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MH3UActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<JSONmh4u> lstJSONmh4u) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstJSONmh4u);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mh_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.download:
                Toast.makeText(this, "downloading Json table", Toast.LENGTH_LONG).show();
                try{
                    URL uri = new URL("https://raw.githubusercontent.com/HukanloS/mh3u_info_monster_names/master/mh3uMonsterName_en_fr_jp.json");
                    HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                    if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                        copyInputStreamToFile(conn.getInputStream(),new File(getCacheDir(),"mh3u_monster.json"));
                        Log.d(TAG, "Json Table <mh3u_monster.json> downloaded");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.info:
                Uri uri = Uri.parse("http://fr.mogapedia.wikia.com/wiki/MH3U_-_Monstres");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void copyInputStreamToFile(InputStream in, File file){
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

