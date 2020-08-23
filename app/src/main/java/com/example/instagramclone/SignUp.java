package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    private EditText editName, editKickSpeed, editKickPower, editPunchSpeed, editPunchPower;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(SignUp.this);
        editName = findViewById(R.id.editName);
        editKickPower = findViewById(R.id.editKickPower);
        editKickSpeed = findViewById(R.id.editKickSpeed);
        editPunchPower = findViewById(R.id.editPunchPower);
        editPunchSpeed = findViewById(R.id.editPunchSpeed);
    }
    public void boxerTapped(View view)
    {
        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punch_speed", 200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null)
                {
                    Toast.makeText(SignUp.this, "Boxer Object is saved successfully",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        try {
            final ParseObject kickboxer = new ParseObject("KickBoxer");
            kickboxer.put("name", editName.getText().toString());
            kickboxer.put("punch_speed", Integer.parseInt(editPunchSpeed.getText().toString()));
            kickboxer.put("punch_power", Integer.parseInt(editPunchPower.getText().toString()));
            kickboxer.put("kick_speed", Integer.parseInt(editKickSpeed.getText().toString()));
            kickboxer.put("kick_power", Integer.parseInt(editKickPower.getText().toString()));
            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, kickboxer.get("name") + " is saved successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                        //Toast.makeText(SignUp.this, kickboxer.get("name")+" is saved successfully",Toast.LENGTH_LONG).show();
                    } else {
                        //Toast.makeText(SignUp.this, e.getMessage(),Toast.LENGTH_LONG).show();
                        FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }
                }
            });
        }
        catch(Exception e)
        {
            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }
    }
}