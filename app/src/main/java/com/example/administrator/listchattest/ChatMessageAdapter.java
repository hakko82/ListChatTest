package com.example.administrator.listchattest;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-12-14.
 */
public class ChatMessageAdapter extends ArrayAdapter{
    List<ChatMessage> msgs = new ArrayList<ChatMessage>();
    boolean message_left = true;

    public ChatMessageAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    //@Override
    public void add(ChatMessage object){
        msgs.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    public ChatMessage getItem(int index) {
        return (ChatMessage) msgs.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            // inflator를 생성하여, chatting_message.xml을 읽어서 View객체로 생성한다.
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.chatting_message, parent, false);
        }

        // Array List에 들어 있는 채팅 문자열을 읽어
        ChatMessage msg = (ChatMessage) msgs.get(position);

        // Inflater를 이용해서 생성한 View에, ChatMessage를 삽입한다.
        TextView msgText = (TextView) row.findViewById(R.id.chatmessage);
        msgText.setText(msg.getMessage());
        msgText.setTextColor(Color.parseColor("#000000"));


        if( message_left ){
            msgText.setBackground(this.getContext().getResources().getDrawable(R.drawable.a));
        }else{
            msgText.setBackground(this.getContext().getResources().getDrawable(R.drawable.b));
        }

        LinearLayout chatMessageContainer = (LinearLayout)row.findViewById(R.id.chatmessage_container);
        int align;
        if( message_left ){
            align = Gravity.LEFT;
            message_left = false;
        }else{
            align = Gravity.RIGHT;
            message_left = true;
        }
        chatMessageContainer.setGravity(align);

        return row;
    }
}
