package com.hebat.sibat.sibat.ui.ui;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.hebat.sibat.sibat.R;
import com.hebat.sibat.sibat.Register;
import org.json.JSONException;
import org.json.JSONObject;

public class Detailaduan extends AppCompatActivity {

    Intent intent;
    EditText keluhan;
    Button btnReg;
    int success;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailaduan);
        keluhan = findViewById(R.id.keluhan);
        btnReg = findViewById(R.id.buttonaduan);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                runningReg(keluhan);

            }
        });
    }

    private void runningReg(final EditText keluhan) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Aduan ...");
        showDialog();
        AndroidNetworking.post("http://192.168.43.93/desalauwba/api/pengaduan.php")
                .addBodyParameter("id", "") //id bersifat Auto_Increment tidak perlu diisi/(diisi NULL) cek create.php
                .addBodyParameter("keluhan", keluhan.getText().toString()) //mengirimkan data nama yang akan diisi dengan varibel nama
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {

                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            success = response.getInt("success");
                            if (success ==1){
                                Toast.makeText(getApplicationContext(),
                                        response.getString("message"), Toast.LENGTH_LONG).show();

                                keluhan.setText("");
                            }else{
                                Toast.makeText(getApplicationContext(),
                                        response.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        hideDialog();
                    }
                });
    }

    private void showMessage(String message) {
        Toast.makeText(Detailaduan.this, message, Toast.LENGTH_LONG).show();
    }

    public void login(View view) {
        intent = new Intent(Detailaduan.this, Detailaduan.class);
        finish();
        startActivity(intent);
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
