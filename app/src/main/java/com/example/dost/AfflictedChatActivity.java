package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AfflictedChatActivity extends AppCompatActivity {

    ListView chatActivityList;
    Button sendButton;
    EditText messageEditText;
    ArrayList<String> afflictedChatArrayList;
    ArrayAdapter afflictedArrayAdapter;
    String afflictedUserMessage;
    ArrayList<client> ActiveUsers;// storing all the active users
    //client afflictedClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_afflicted_chat);
        try {
            networking();
        } catch (IOException e) {
            String TAG = "MyActivity";
            Log.e(TAG, "onCreate: issue", e);
        }*/

        chatActivityList = findViewById(R.id.chatActivityList);
        sendButton = findViewById(R.id.sendButton);
        messageEditText = findViewById(R.id.messageEditText);
        afflictedChatArrayList = new ArrayList<>();
        afflictedArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, afflictedChatArrayList);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afflictedUserMessage = messageEditText.getText().toString();
                //afflictedClient.writer.println(afflictedUserMessage);
                //afflictedClient.writer.flush();
                afflictedChatArrayList.add("> You: " + afflictedUserMessage);
                chatActivityList.setAdapter(afflictedArrayAdapter);
            }
        });
    }
    /*public void networking() throws IOException {
        // Set the ipaddress to be the IP address of the Device
        final String ipaddress = "localhost";
        //set the port for Server
        final int port = 11267;
        Socket socket = new Socket(ipaddress, port);
        afflictedClient = new client(socket);
        new Thread(afflictedClient).start();
        }*/
    }

