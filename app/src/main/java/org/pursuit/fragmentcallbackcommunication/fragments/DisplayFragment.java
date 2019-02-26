package org.pursuit.fragmentcallbackcommunication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.fragmentcallbackcommunication.FragmentInterface;
import org.pursuit.fragmentcallbackcommunication.R;

public class DisplayFragment extends Fragment {
    private FragmentInterface fragmentInterface;

    private static final String KEY_NAME = "name";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_IMAGE = "image";

    private String name;
    private String number;
    private String image;

    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView imageImageView;


    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(String name, String number, String image) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(KEY_NAME, name);
        args.putString(KEY_NUMBER, number);
        args.putString(KEY_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(KEY_NAME);
            number = getArguments().getString(KEY_NUMBER);
            image = getArguments().getString(KEY_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextView = view.findViewById(R.id.name_display_textview);
        numberTextView = view.findViewById(R.id.number_display_textview);
        imageImageView = view.findViewById(R.id.image_display_imageview);

        nameTextView.setText(name);
        numberTextView.setText(String.valueOf(number));
        Picasso.get().load(image).into(imageImageView);
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
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }
}
