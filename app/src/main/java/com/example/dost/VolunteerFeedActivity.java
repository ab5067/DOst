package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class VolunteerFeedActivity extends AppCompatActivity {

    Button volunteerSendButton;
    EditText volunteerMessageEditText;
    ListView volunteerChatListView;
    ArrayList<String> volunteerChatArrayList;
    ArrayAdapter volunteerArrayAdapter;
    String volunteerUserMessage;
    Button capsButton;
    //client volunteerClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voulnteer_feed);

        getSupportActionBar().setTitle("Chat Room");

        volunteerSendButton = findViewById(R.id.volunteerSendButton);
        capsButton = findViewById(R.id.capsButton);
        capsButton.setBackgroundColor(Color.RED);
        capsButton.setTextColor(Color.WHITE);
        volunteerMessageEditText = findViewById(R.id.volunteerMessageEditText);
        volunteerChatListView = findViewById(R.id.volunteerChatListView);
        volunteerChatArrayList = new ArrayList<>();
        volunteerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, volunteerChatArrayList);

        volunteerSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                volunteerUserMessage = volunteerMessageEditText.getText().toString();
                //volunteerClient.writer.println(volunteerUserMessage);
                //volunteerClient.writer.flush();
                volunteerChatArrayList.add("> You: " + volunteerUserMessage);
                volunteerChatArrayList.add("> Dost: " + "I had a rough day today!");
                volunteerChatArrayList.add("> You: Tell me about it?" );

                volunteerChatListView.setAdapter(volunteerArrayAdapter);
            }
        });

        capsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VolunteerFeedActivity.this, "Message Sent to Caps", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /*public void networking() throws IOException {
        // Set the ipaddress to be the IP address of the Device
        final String ipaddress = "localhost";
        //set the port for Server
        final int port = 11267;
        Socket socket = new Socket(ipaddress, port);
        volunteerClient = new client(socket);
        new Thread(volunteerClient).start();*/
}
