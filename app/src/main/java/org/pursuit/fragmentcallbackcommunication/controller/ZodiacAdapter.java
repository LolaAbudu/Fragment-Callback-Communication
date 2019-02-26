package org.pursuit.fragmentcallbackcommunication.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentcallbackcommunication.FragmentInterface;
import org.pursuit.fragmentcallbackcommunication.R;
import org.pursuit.fragmentcallbackcommunication.model.Zodiac;
import org.pursuit.fragmentcallbackcommunication.model.ZodiacList;
import org.pursuit.fragmentcallbackcommunication.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {

    private FragmentInterface fragmentInterface;
    private List<Zodiac> zodiacList;

    public ZodiacAdapter(List<Zodiac> zodiacList, FragmentInterface fragmentInterface) {
        this.zodiacList = zodiacList;
        this.fragmentInterface = fragmentInterface;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zodiac_itemview, parent, false);
        return new ZodiacViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int position) {
        zodiacViewHolder.onBind(zodiacList.get(position), fragmentInterface);
    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }
}
