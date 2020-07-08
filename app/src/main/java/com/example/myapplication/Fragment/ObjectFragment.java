package com.example.myapplication.Fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.myapplication.Object.ListButtonData;
import com.example.myapplication.Object.ObjectList_Button_Adapter;
import com.example.myapplication.Object.Object_List;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.app.Activity.RESULT_OK;

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
    private boolean isOpened=false;

    private RecyclerView mRecyclerView;
    private ObjectList_Button_Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int numData;

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

        Button objectList1 = (Button) view.findViewById(R.id.objectList1);

        FloatingActionButton fabMain = (FloatingActionButton) view.findViewById(R.id.fabMain);
        final FloatingActionButton addImage = (FloatingActionButton) view.findViewById(R.id.addImage);
        final FloatingActionButton addObjectList = (FloatingActionButton) view.findViewById(R.id.addObjectList);
//        if(view instanceof RecyclerView) {
//
//            mRecyclerView = (RecyclerView) view.findViewById(R.id.object_recyclerview);
//            mRecyclerView.setHasFixedSize(true);
//
////            mAdapter = new ObjectList_Button_Adapter(mMydata);
//
//            mLayoutManager = new LinearLayoutManager(getActivity());
//            ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
//
//            mRecyclerView.setLayoutManager(mLayoutManager);
//
//            setData();
//
//            mRecyclerView.setAdapter(mAdapter);
//
//        }

        objectList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Object_List.class);
                startActivity(intent);
            }
        });
        fabMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(isOpened==false)
                    isOpened=true;
                else isOpened=false;

                if(isOpened==true){
                    addImage.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
                    addObjectList.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
                }else{
                    addImage.animate().translationY(0);
                    addObjectList.animate().translationY(0);
                }
            }
        });
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFromAlbum();
            }
        });
//        addObjectList.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//
//            }
//         });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.object_recyclerview);
            mRecyclerView.setHasFixedSize(true);

//            mAdapter = new ObjectList_Button_Adapter(mMydata);

            mLayoutManager = new LinearLayoutManager(getActivity());
            ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);

            mRecyclerView.setLayoutManager(mLayoutManager);

        final FloatingActionButton addObjectList = (FloatingActionButton) view.findViewById(R.id.addObjectList);
                addObjectList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                mRecyclerView.setAdapter(mAdapter);


            }
         });

    }


    private void getImageFromAlbum() {
            //Create an Intent with action as ACTION_PICK
            Intent intent=new Intent(Intent.ACTION_PICK);
            // Sets the type as image/*. This ensures only components of type image are selected
            intent.setType("image/*");
            //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
            String[] mimeTypes = {"image/jpeg", "image/png"};
            intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
            // Launching the Intent
            startActivityForResult(intent,GALLERY_REQUEST_CODE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            // Result code is RESULT_OK only if the user selects an Image
            if (resultCode == Activity.RESULT_OK)
                switch (requestCode){
                    case GALLERY_REQUEST_CODE:
                        //data.getData returns the content URI for the selected Image
                        Uri selectedImage = data.getData();
                        ImageView imageView = (ImageView) getActivity().findViewById(R.id.object1);
                        imageView.setImageURI(selectedImage);
                        break;
                }
    }


    private void setData(){
        List<String> listName = Arrays.asList("first list","second list","third list","fourth list");
        List<Integer> listImage = Arrays.asList(
                R.drawable.add_folder
        );

        mAdapter = new ObjectList_Button_Adapter();
        numData = listName.size();

        for(int i=0; i < numData; i++){
            ListButtonData data = new ListButtonData();

            data.setlistName(listName.get(i));
            data.setlistImage(listImage.get(0));

            mAdapter.addData(data);
        }

    }

}