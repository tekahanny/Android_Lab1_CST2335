package com.example.androidlabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ChatRoomActivity extends AppCompatActivity {


    //ArrayList to hold the messages of the chat.
    private ArrayList<Message> msgs = new ArrayList<>();
    private ChatAdapter adapter = new ChatAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView list = findViewById(R.id.the_list);
        list.setAdapter(adapter);


        Button send = findViewById(R.id.sendB);
        send.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        TextView type = findViewById(R.id.type);

                                        msgs.add(new Message(type.getText().toString(), true));
                                        type.setText(""); // this needs changing so it clears text
                                        adapter.notifyDataSetChanged();

                                    }
                                }
        );

        Button receive = findViewById(R.id.receiveB);
        receive.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        TextView type = findViewById(R.id.type);

                                        msgs.add(new Message(type.getText().toString(), false));
                                        type.setText("");
                                        adapter.notifyDataSetChanged();

                                    }
                                }
        );

    }

    private class ChatAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return msgs.size();
        }

        @Override
        public Object getItem(int position) {
            return msgs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return (long)position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Message chat = msgs.get(position);
            View view;
            if (chat.sender)
                view = getLayoutInflater().inflate(R.layout.row_send, null);
            else
                view = getLayoutInflater().inflate(R.layout.row_receive, null);
            TextView text = view.findViewById(R.id.messageText);
            text.setText(chat.message);
            return view;

        }
    }


    private class Message{
        public String message;
        public boolean sender;
        public Message(String message, boolean sender){
            this.message = message;
            this.sender = sender;
        }
    }
}

