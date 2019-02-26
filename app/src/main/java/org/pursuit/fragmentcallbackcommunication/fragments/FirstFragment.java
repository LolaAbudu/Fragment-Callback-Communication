package org.pursuit.fragmentcallbackcommunication.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentcallbackcommunication.FragmentInterface;
import org.pursuit.fragmentcallbackcommunication.R;
import org.pursuit.fragmentcallbackcommunication.controller.ZodiacAdapter;
import org.pursuit.fragmentcallbackcommunication.model.Zodiac;
import org.pursuit.fragmentcallbackcommunication.model.ZodiacList;
import org.pursuit.fragmentcallbackcommunication.network.RetrofitSingleton;
import org.pursuit.fragmentcallbackcommunication.network.ZodiacServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FirstFragment extends Fragment {
    private FragmentInterface fragmentInterface;
    private RecyclerView recyclerView;
    private ZodiacAdapter zodiacAdapter;

    public FirstFragment() {
        // Required empty public constructor
    }


    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);

        Retrofit retrofit = RetrofitSingleton.getOneInstance();
        ZodiacServices zodiacServices = retrofit.create(ZodiacServices.class);
        Call<ZodiacList> zodiacListCall = zodiacServices.getZodiac();
        zodiacListCall.enqueue(new Callback<ZodiacList>() {
            @Override
            public void onResponse(Call<ZodiacList> call, Response<ZodiacList> response) {
                List<Zodiac> zodiacList = response.body().getZodiac();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                ZodiacAdapter zodiacAdapter = new ZodiacAdapter(zodiacList, fragmentInterface);
                recyclerView.setAdapter(zodiacAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
                Log.d("onResponse", response.body().getZodiac().get(1).getName());
            }

            @Override
            public void onFailure(Call<ZodiacList> call, Throwable t) {
                Log.d("tag", "onFailure"  + t.toString());
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }

}
