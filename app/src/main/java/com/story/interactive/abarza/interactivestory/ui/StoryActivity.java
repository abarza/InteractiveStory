package com.story.interactive.abarza.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.story.interactive.abarza.interactivestory.R;
import com.story.interactive.abarza.interactivestory.model.Page;
import com.story.interactive.abarza.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {


  public static final String TAG = StoryActivity.class.getSimpleName();

  private Story mStory = new Story();
  private ImageView mImageView;
  private TextView mTextView;
  private Button mChoiceButton1;
  private Button mChoiceButton2;
  private String nName;
  private Page mCurrentPage;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_story);
    Intent intent = getIntent();
    nName = intent.getStringExtra(getString(R.string.key_name));

    if (nName == null) {
      nName = "Friend";
    }
    Log.d(TAG, nName);

    bindUi();

    loadPage(0);


  }

  private void bindUi() {
    mImageView = (ImageView) findViewById(R.id.storyImageView);
    mTextView = (TextView) findViewById(R.id.storyTextview);
    mChoiceButton1 = (Button) findViewById(R.id.choiceButton1);
    mChoiceButton2 = (Button) findViewById(R.id.choiceButton2);
  }

  private void loadPage(int choice) {
    mCurrentPage = mStory.getPage(choice);

    Drawable drawable = ContextCompat.getDrawable(this, mCurrentPage.getImageId());
    mImageView.setImageDrawable(drawable);
    // Add the name is set as parameter
    String pageText = mCurrentPage.getText();
    pageText = String.format(pageText, nName);

    mTextView.setText(pageText);
    if (mCurrentPage.isFinal()) {
      mChoiceButton1.setVisibility(View.INVISIBLE);
      mChoiceButton2.setText("Start Again");
      mChoiceButton2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          finish();
        }
      });
    } else {
      mChoiceButton1.setText(mCurrentPage.getChoice1().getText());
      mChoiceButton2.setText(mCurrentPage.getChoice2().getText());
    }


    mChoiceButton1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int nextPage = mCurrentPage.getChoice1().getNextPage();
        loadPage(nextPage);
      }
    });

    mChoiceButton2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int nextPage = mCurrentPage.getChoice2().getNextPage();
        loadPage(nextPage);
      }
    });


  }

}
