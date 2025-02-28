package com.example.adele_dialogs;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRegistration;
    Button btPronounce, btDate, btSave;
    EditText etFirstName, etLastName, etCity;
    private static final String TAG = "MyActivity";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initElements();
        context = this;
    }

     private void initElements () {
        etFirstName = findViewById(R.id.etFirstName);
        // todo add all fields
        tvRegistration = findViewById(R.id.tvRegistration);
        btPronounce = findViewById(R.id.btPronounce);
        btPronounce.setOnClickListener(this);
        btDate = findViewById(R.id.btDate);
        btDate.setOnClickListener(this);
        btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(this);
     }

     public void onClick (View v){
        if (v == btPronounce){
            Log.d(TAG, "onClick:Pronounce");

        }

        if (v == btDate){
            Log.d(TAG, "onClick:Date");

        }

        if (v == btSave){
            Log.d(TAG, "onClick:Save");
            //todo check fields
            if (true){
                createAlertDialog();
            } else {
                createSaveDialog();
            }

        }

     }

    private void createAlertDialog() {
        AlertDialog.Builder errorDialogBuilder = new AlertDialog.Builder(this);
        errorDialogBuilder.setTitle("Save error");
        errorDialogBuilder.setMessage("You didn't fill all fields");
        errorDialogBuilder.setCancelable(true);
        errorDialogBuilder.setNegativeButton("Cancel", new HandleAlertDialogClickListener());
        AlertDialog errorDialog = errorDialogBuilder.create();
        errorDialog.show();
    }

    private void createSaveDialog() {
        HandleAlertDialogClickListener handleAlertDialogClickListener = new HandleAlertDialogClickListener();

        AlertDialog.Builder saveDialogBuilder = new AlertDialog.Builder(this);
        saveDialogBuilder.setTitle("Are you sure?");
        saveDialogBuilder.setMessage("Are you sure you want to save with name: " + etFirstName.getText().toString());
        saveDialogBuilder.setCancelable(true);
        saveDialogBuilder.setPositiveButton("Yes, Im sure", handleAlertDialogClickListener);
        saveDialogBuilder.setNegativeButton("No, let me look again", handleAlertDialogClickListener);
        AlertDialog saveDialog = saveDialogBuilder.create();
        saveDialog.show();
    }

    private class HandleAlertDialogClickListener implements DialogInterface.OnClickListener {

         @Override
         public void onClick(DialogInterface dialog, int which) {
             if (which == BUTTON_NEGATIVE) {
                 Toast.makeText(context, "cancel", Toast.LENGTH_SHORT).show();
             }
             if (which == BUTTON_POSITIVE) {
                 Toast.makeText(context, "try again", Toast.LENGTH_SHORT).show();
             }
         }
     }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }
}