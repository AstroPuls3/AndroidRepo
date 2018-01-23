package edu.lwtech.csd230_winter2018.mymessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {
    final static String EXTRA_MESSAGE = "message";

    private TextView messageView;
    private String messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();

        messageText = intent.getStringExtra(EXTRA_MESSAGE);

        messageView = (TextView) findViewById(R.id.message);
        messageView.setText(messageText);
    }

    void onToUpperClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_MESSAGE, messageText.toUpperCase());
        setResult(RESULT_OK, intent);
        finish();
    }

    void onToLowerClick(View view) {

    }

}
