package org.pursuit.fragmentcallbackcommunication.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.pursuit.fragmentcallbackcommunication.FragmentInterface;
import org.pursuit.fragmentcallbackcommunication.model.Zodiac;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {

    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void onBind(final FragmentInterface fragmentInterface){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.toDisplayFragment();
            }
        });

    }
}
