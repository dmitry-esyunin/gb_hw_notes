package com.gb1919.gb_hw_notes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteContentFragment extends Fragment {


    public static final String KEY_NOTE = "KEY_NOTE";

    private Note note;

    public NoteContentFragment() {
        // Required empty public constructor
    }


    public static NoteContentFragment newInstance(Note note) {
        NoteContentFragment fragment = new NoteContentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_NOTE, note);
        fragment.setArguments(bundle);
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
        return inflater.inflate(R.layout.fragment_note_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        note = getArguments().getParcelable(KEY_NOTE);
        TextView tv = view.findViewById(R.id.text_content);
        tv.setText(note.getText());

        Button button_back = view.findViewById(R.id.back_button_content);
        boolean is_landscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (is_landscape) {
            button_back.setVisibility(View.GONE);
        } else {
            button_back.setOnClickListener( (View v) -> {requireActivity().getSupportFragmentManager().popBackStack();});
        }


    }
}