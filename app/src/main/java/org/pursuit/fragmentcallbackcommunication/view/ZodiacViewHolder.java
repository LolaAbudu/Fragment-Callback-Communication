package org.pursuit.fragmentcallbackcommunication.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.fragmentcallbackcommunication.FragmentInterface;
import org.pursuit.fragmentcallbackcommunication.R;
import org.pursuit.fragmentcallbackcommunication.model.Zodiac;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private TextView numberTextView;

    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_textview);
        numberTextView = itemView.findViewById(R.id.number_textview);

    }

    public void onBind(final Zodiac zodiac, final FragmentInterface fragmentInterface){
        nameTextView.setText(zodiac.getName());
        numberTextView.setText(String.valueOf(zodiac.getNumber()));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.toDisplayFragment(zodiac.getName(), zodiac.getNumber(), zodiac.getImage());
            }
        });
    }
}
