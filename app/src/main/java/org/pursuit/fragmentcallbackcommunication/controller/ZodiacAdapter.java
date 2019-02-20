package org.pursuit.fragmentcallbackcommunication.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentcallbackcommunication.R;
import org.pursuit.fragmentcallbackcommunication.model.Zodiac;
import org.pursuit.fragmentcallbackcommunication.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {

    private FragmentInterface fragmentInterface;

    private List<ZodiacAdapter> zodiacList;

    public ZodiacAdapter(List<Zodiac> planetList) {
        this.zodiacList = zod;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zodiac_itemview, parent, false);
        return new ZodiacViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int position) {
        zodiacViewHolder.onBind(zodiacList.get(position));

    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }
}
