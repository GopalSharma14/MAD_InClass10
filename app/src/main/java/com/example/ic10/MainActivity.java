package com.example.ic10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyProfile_Fragment.ToAvatarFromEdit, SelectAvatar_Fragment.ToEditFromSelectAvatar, DisplayProfile_Fragment.ToEditFromDisplayProfile{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new MyProfile_Fragment(), "edit")
                .commit();
    }


    @Override
    public void startSelectAvatar() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SelectAvatar_Fragment(), "selectAvatar")
                .addToBackStack(null)
                .commit()
        ;
    }

    @Override
    public void displayProfile(String fname,String lname,String gen) {
        if (fname.toString().isEmpty()||lname.toString().isEmpty()||gen.toString().isEmpty()){
            Toast.makeText(this, "Please enter all details!!!", Toast.LENGTH_SHORT).show();
        }else{
        DisplayProfile_Fragment dpf= new DisplayProfile_Fragment();
        Bundle args=new Bundle();
        args.putString("fname",fname);
        args.putString("lname",lname);
        args.putString("gender",gen);
        dpf.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, dpf, "displayProfile")
                .addToBackStack(null)
                .commit();
    }}

    @Override
    public void updateEdit(boolean isFemale) {

        getSupportFragmentManager().popBackStack();
        MyProfile_Fragment newEditFragment = (MyProfile_Fragment) getSupportFragmentManager().findFragmentByTag("edit");
        Bundle args1=new Bundle();
        args1.putBoolean("gender",isFemale);
        newEditFragment.setArguments(args1);
        if (isFemale){
            newEditFragment.setGender("female");
        }
        else{
            newEditFragment.setGender("male");
        }


    }
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
