package com.example.myapplication.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import com.example.myapplication.Object.FolderData;
import com.example.myapplication.Object.FolderAdapter;
import com.example.myapplication.Object.ObjectAdapter;
import com.example.myapplication.Object.ObjectData;
import com.example.myapplication.Object.Object_List;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ObjectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjectFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Activity view;
    public static final int GALLERY_REQUEST_CODE = 1;
    private Context context;
    private boolean isOpened = false;

    private RecyclerView fRecyclerView, oRecyclerView;
    private FolderAdapter fAdapter;
    private ObjectAdapter oAdapter;
    private RecyclerView.LayoutManager fLayoutManager, oLayoutManager;


    List<String> listName = new ArrayList();
    List<Integer> listImage = Arrays.asList(R.drawable.add_folder);
    List<String> objectName = new ArrayList();
    List<Uri> userObjectImage = new ArrayList();
    private int folderNum = 0;
    private int objectNum = 0;

    private boolean imageAdded = false;


    public ObjectFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ObjectFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObjectFragment newInstance(String param1, String param2) {
        ObjectFragment fragment = new ObjectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_object, container, false);

        FloatingActionButton fabMain = (FloatingActionButton) view.findViewById(R.id.fabMain);
        final FloatingActionButton addImage = (FloatingActionButton) view.findViewById(R.id.addImage);
        final FloatingActionButton addObjectList = (FloatingActionButton) view.findViewById(R.id.addObjectList);

        fabMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isOpened == false)
                    isOpened = true;
                else isOpened = false;

                if (isOpened == true) {
                    addImage.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
                    addObjectList.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
                } else {
                    addImage.animate().translationY(0);
                    addObjectList.animate().translationY(0);
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        fRecyclerView = (RecyclerView) view.findViewById(R.id.object_recyclerview_folder);
        oRecyclerView = (RecyclerView) view.findViewById(R.id.object_recyclerview_object);

        fRecyclerView.setHasFixedSize(true);
        oRecyclerView.setHasFixedSize(true);

        fAdapter = new FolderAdapter();
        oAdapter = new ObjectAdapter();

        fLayoutManager = new GridLayoutManager(getActivity(), 2);
        oLayoutManager = new GridLayoutManager(getActivity(), 4);

        fRecyclerView.setLayoutManager(fLayoutManager);
        oRecyclerView.setLayoutManager(oLayoutManager);

        FloatingActionButton addObjectList = (FloatingActionButton) view.findViewById(R.id.addObjectList);
        FloatingActionButton addImage = (FloatingActionButton) view.findViewById(R.id.addImage);

        addObjectList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addFolder(folderNum);
                folderNum++;
                fRecyclerView.setAdapter(fAdapter);

            }
        });
        addImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getImageFromAlbum();
                if (imageAdded) {
                    imageAdded = false;
                }
            }
        });

    }

    private void getImageFromAlbum() {
        //Create an Intent with action as ACTION_PICK
        Intent intent = new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        // Launching the Intent
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    //data.getData returns the content URI for the selected Image
                    Uri selectedImage = data.getData();
                    userObjectImage.add(selectedImage);

                    addObject(objectNum);
                    objectNum++;

                    oRecyclerView.setAdapter(oAdapter);

                    imageAdded = true;
                    break;
            }
    }

    public void addFolder(int i) {

        listName.add("folder " + Integer.toString(i + 1));

        FolderData data = new FolderData();

        data.setlistName(listName.get(i));
        data.setlistImage(listImage.get(0));

        fAdapter.addData(data);

    }


    public void addObject(int i) {

        objectName.add("image " + Integer.toString(i + 1));

        ObjectData data = new ObjectData();

        data.setobjectName(objectName.get(i));
        data.setuserObjectImage(userObjectImage.get(i));

        oAdapter.addData(data);
    }

}