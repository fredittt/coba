package com.example.rpl2016_09.coba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText username= (EditText) findViewById(R.id.ED3);
        final EditText password= (EditText) findViewById(R.id.ED4);
        final EditText confirmpassword= (EditText) findViewById(R.id.ED5);
        Button register = (Button) findViewById(R.id.BTregister2);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().isEmpty()){
                    Toast.makeText(Main2Activity.this,"Please fill in the username fist",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.getText().toString().equals(password.getText().toString())) {
                    Toast.makeText(Main2Activity.this, "Password tidak sama", Toast.LENGTH_SHORT).show();
                    return;

                }

                AndroidNetworking.post("http://192.168.43.37/Coba/marimas.php")
                        .addBodyParameter("username", username.getText().toString())
                        .addBodyParameter("passwords", password.getText().toString())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override

                            public void onResponse(JSONObject response) {
                                // do anything with response
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    boolean respon=hasil.getBoolean("sukses");
                                    System.out.println("boiiii " + hasil + " okrrr ==== " + respon + "   ==== ");
                                    if(respon){
                                        Toast.makeText(getApplicationContext(),"sukses",Toast.LENGTH_SHORT).show();
                                        finish();


                                    }else {
                                        Toast.makeText(getApplicationContext(),"gagal",Toast.LENGTH_SHORT).show();
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                    Toast.makeText(Main2Activity.this, "oke  "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onError(ANError error) {
                                // handle error
                                System.out.println("boiiii " + error + " okrrr ==== " + error.getMessage() + "   ==== " + error.getErrorBody());
                                Toast.makeText(Main2Activity.this, "oke  "+ error.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
    }

}
