package edu.lwtech.csd230_winter2018.mymessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {
    final static int CHANGE_CASE_REQUEST = 1;

    private EditText messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        messageView = (EditText) findViewById(R.id.message);
    }

    public void onSendMessage(View view) {
        // extract the message from the edit text widget
        String messageText = messageView.getText().toString();

        // explicit intent
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);

        // start the activity
        startActivityForResult(intent, CHANGE_CASE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // check which request we're responding to
        if (requestCode == CHANGE_CASE_REQUEST) {
            // make sure the request was successful
            if (resultCode == RESULT_OK) {
                String messageText = data.getStringExtra(ReceiveMessageActivity.EXTRA_MESSAGE);
                messageView.setText(messageText);
            }
        }
    }
}
