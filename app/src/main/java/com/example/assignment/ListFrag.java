package com.example.assignment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFrag# newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFrag extends Fragment {
    ListView listView;
    ArrayList<String> chapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public ListFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.lvList);

        chapter = new ArrayList<>();
        chapter.add("Chương 1. Sự bình yên");
        chapter.add("Chương 2. Holmes");
        chapter.add("Chương 3. Sự đồng thuận");
        chapter.add("Chương 4. Chi tiết");
        chapter.add("Chương 5. Cái chậu nứt");
        chapter.add("Chương 6. Lạc lối");
        chapter.add("Chương 7. Địa ngục");
        chapter.add("Chương 8. Hai đáp án");
        chapter.add("Chương 9. Chờ đợi");
        chapter.add("Chương 10. Cái giá của sự tức giận");
        chapter.add("Chương 11. Mẩu thuốc");
        chapter.add("Chương 12. Nguy hiểm");
        chapter.add("Chương 13. Án mạng liên hoàn");
        chapter.add("Chương 14. Lộ tẩy");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, chapter){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }
        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    Intent intent = new Intent(getActivity().getApplicationContext(),DetailActivity.class);
                    intent.putExtra("index", i);
                    startActivity(intent);
                }
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    Intent intent = new Intent(getActivity().getApplicationContext(),MainActivity.class);
                    intent.putExtra("index", i);
                    startActivity(intent);
                }


            }
        });
        return view;
    }
}