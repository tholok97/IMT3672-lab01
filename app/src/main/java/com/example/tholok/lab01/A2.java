package com.example.tholok.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class A2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        // idk what this does.......... auto generated {{{
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // }}}

        // fetch message from intent that sent us here
        Intent intent = getIntent();
        String msg = intent.getStringExtra(A1.EXTRA_MESSAGE);

        // set value of T2 based on this
        TextView textView = (TextView) findViewById(R.id.T2);
        textView.setText("Hello " + msg);

    }

    // onclick of button -> start activity A3
    public void clicked(View view) {
        Intent intent = new Intent(this, A3.class);
        startActivityForResult(intent, 123);
    }

    // when an activity we called returns info to us -> fetch info and set T3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String msg = data.getStringExtra("T4Value");

        TextView textView = (TextView) findViewById(R.id.T3);
        textView.setText("From A3 " + msg);
    }
}
