package com.story.interactive.abarza.interactivestory;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText mNameField;
  private Button mStartButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bindUi();

    mStartButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String name = mNameField.getText().toString();
        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
        startActivity(name);
      }
    });

  }

  private void bindUi() {
    mNameField = (EditText) findViewById(R.id.nameEditText);
    mStartButton = (Button) findViewById(R.id.startButton);
  }

  private void startActivity(String name) {
    Intent intent = new Intent(this, StoryActivity.class);
    intent.putExtra(getString(R.string.key_name), name);
    startActivity(intent);
  }




}
