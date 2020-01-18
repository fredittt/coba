package com.example.rpl2016_09.coba;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public EditText editemail;
    public EditText editpass;
    public Button btn;
    public Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());


        editemail = findViewById(R.id.ED1);
        editpass = findViewById(R.id.ED2);
        btn = findViewById(R.id.BT);
        btn2 = findViewById(R.id.BTregister);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editemail.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "email  tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (editpass.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    AndroidNetworking.post("http://192.168.43.37/Coba/login2.php")
                            .addBodyParameter("Email", editemail.getText().toString())
                            .addBodyParameter("Password", editpass.getText().toString())
                            .setTag("Test")
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        JSONObject hasil = response.getJSONObject("hasil");
                                        if (hasil.getBoolean("sukses")) {
                                            Toast.makeText(MainActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                                            startActivity(intent);
                                            finish();
                                        }else {
                                            Toast.makeText(MainActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(MainActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                                        System.out.println("erroromn  " + e.getMessage());

                                    }
                                }

                                @Override
                                public void onError(ANError error) {
                                    Toast.makeText(MainActivity.this, "Error" +
                                            "", Toast.LENGTH_SHORT).show();
                                    Log.d("fredi", "onError: "+ "" + error);
                                    System.out.println("erroromn  " + error.getErrorDetail());
                                    System.out.println("erroromn  " + error.getErrorBody());
                                    System.out.println("erroromn  " + error.getMessage());
                                }
                            });
                }
            }
        });
    }
}
