package com.example.tholok.lab01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class A1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String SPINNER_STATE_PREF = "spinnerstate";     // used for pref storage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cool_countries, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // fetch spinner
        Spinner spinner = (Spinner) findViewById(R.id.L1);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // fetch prefs and try to fetch state of spinner
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int spinnerState = prefs.getInt("spinnerstate", 0);

        // set position of spinner
        spinner.setSelection(spinnerState);

        // add this (implements interface) as a listener
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        // fetch prefs
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = prefs.edit();

        // fetch spinner
        Spinner spinner = (Spinner) findViewById(R.id.L1);

        // put the position of the spinner
        editor.putInt(SPINNER_STATE_PREF, spinner.getSelectedItemPosition());

        // apply changes
        editor.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // <nop>
    }

    // on click of button, move to activity A2
    public void clicked(View view) {

        // create intent
        Intent intent = new Intent(this, A2.class);

        // fetch text in T1
        EditText editText = (EditText) findViewById(R.id.T1);
        String msg = editText.getText().toString();

        // put message in intent
        intent.putExtra(EXTRA_MESSAGE, msg);

        // start A2
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // kill app.. not working ?? TODO
        finish();
    }
}
