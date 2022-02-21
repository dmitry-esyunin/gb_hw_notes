package com.gb1919.gb_hw_notes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesListFragment extends Fragment {


    public NotesListFragment() {
        // Required empty public constructor
    }

    public static NotesListFragment newInstance() {
        NotesListFragment fragment = new NotesListFragment();
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
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {


        int view_width = view.getWidth();
        boolean is_landscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        String[] list = getResources().getStringArray(R.array.notes_list);
        String[] content = getResources().getStringArray(R.array.notes_text);
//




        for (int i = 0; i < list.length; i++) {
            String name = list[i];
            String text = content[i];

            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setWidth(view_width);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setTextSize(20f);

            ((LinearLayout) view).addView(textView);


            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Note note = new Note(name, text, 0);
                    NoteContentFragment note_content = NoteContentFragment.newInstance(note);


                    if (is_landscape) {
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.note_content, note_content).commit();
                    } else {
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.notes_list, note_content).addToBackStack("").commit();
                    }


                }
            });
        }


    }


}