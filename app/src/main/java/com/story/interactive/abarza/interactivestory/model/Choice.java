package com.story.interactive.abarza.interactivestory.model;

/**
 * Created by abarza on 18-10-16.
 */

public class Choice {

  private String mText;
  private int mNextPage;

  public Choice(String text, int nextPage) {
    mText = text;
    mNextPage = nextPage;
  }

  public String getText() {
    return mText;
  }

  public void setText(String text) {
    mText = text;
  }

  public int getNextPage() {
    return mNextPage;
  }

  public void setNextPage(int nextPage) {
    mNextPage = nextPage;
  }
}
