package com.example.administrator.listchattest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity{
    ChatMessageAdapter chatMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatMessageAdapter = new ChatMessageAdapter(this.getApplicationContext(),R.layout.chatting_message);

        Button btn = (Button) findViewById(R.id.buttonSend);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                send(v);
            }
        });
    }


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        chatMessageAdapter = new ChatMessageAdapter(this.getApplicationContext(),R.layout.chatting_message);
        final ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(chatMessageAdapter);
        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); // 이게 필수

        // When message is added, it makes listview to scroll last message
        chatMessageAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatMessageAdapter.getCount()-1);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/


    public void send(View view){
        EditText etMsg = (EditText)findViewById(R.id.chatText);
        String strMsg = (String)etMsg.getText().toString();
        chatMessageAdapter.add(new ChatMessage(strMsg));

        final ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(chatMessageAdapter);
        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); // 이게 필수
        listView.setSelection(chatMessageAdapter.getCount() - 1);

        /*
        // When message is added, it makes listview to scroll last message
        chatMessageAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatMessageAdapter.getCount() - 1);
            }
        });
        */
    }
}
