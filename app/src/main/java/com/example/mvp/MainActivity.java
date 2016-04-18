package com.example.mvp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<HelloWorldView, HelloWorldPresenter>
        implements HelloWorldView {

    @Bind(R.id.greetingTextView)
    TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, LCEActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    @OnClick(R.id.fabHello)
    public void onHelloButtonClicked() {
        presenter.greetHello();
    }

    @OnClick(R.id.fabGoodbye)
    public void onGoodbyeButtonClicked() {
        presenter.greetGoodbye();
    }

    @Override
    public void showHello(String greetingText) {
        greetingTextView.setTextColor(Color.RED);
        greetingTextView.setText(greetingText);
    }

    @Override
    public void showGoodbye(String greetingText) {
        greetingTextView.setTextColor(Color.BLUE);
        greetingTextView.setText(greetingText);
    }
}
