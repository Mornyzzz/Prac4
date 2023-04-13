package com.example.prac4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListFragment extends Fragment {

    private final static String TAG = "ListViewFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.listView);

        String text = getArguments().getString("1");

        List<String> items = new ArrayList<>(200);
        for (int i = 1; i <= 200; i++) {
            //String item = Integer.toString(i);
            String item = text;
            items.add(item);
        }

        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.format, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Log.d(TAG, "ListView: Element " + (position + 1));
                Toast.makeText(getActivity(), "ListView: Element " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }

}