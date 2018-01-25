package com.example.tholok.lab01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class A1 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        Spinner spinner = (Spinner) findViewById(R.id.L1);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cool_countries, android.R.layout.simple_spinner_item);

        int spinnerstate = 0;

        // read spinner
        try {

            Scanner scanner = new Scanner(
                    openFileInput("spinner_state.txt"));
            spinnerstate = Integer.parseInt(scanner.nextLine());

            System.out.println("loaded successfuly");

        } catch (Exception ex) {

            System.out.println("failed to load");
        }





        // to read the value
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final String name = prefs.getString("username", "");


        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setSelection(spinnerstate);

    }

    public void clicked(View view) {

        Intent intent = new Intent(this, A2.class);
        EditText editText = (EditText) findViewById(R.id.T1);
        String msg = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // kill app.. not working ?? TODO

        try {

            // to store value in shared preferences
            final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            final SharedPreferences.Editor editor = prefs.edit();
            editor.putString("username", "Mariusz");

            editor.apply();

            System.out.println("saved successfully");
        } catch (Exception ex) {

            System.out.println("failed to save");
        }

        finish();
    }
}
