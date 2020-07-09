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

    //하나의 fragment 속에 2개의 recyclerview를 사용할거에요.
    private RecyclerView fRecyclerView, oRecyclerView;

    //어댑터는 각각
    private FolderAdapter fAdapter;
    private ObjectAdapter oAdapter;

    //layoutManager도 각각
    private RecyclerView.LayoutManager fLayoutManager, oLayoutManager;

    //folder에 해당하는 각각의 정보를 arraylist 속에 순서대로 저장할거에요
    List<String> listName = new ArrayList();
    List<Integer> listImage = Arrays.asList(R.drawable.add_folder);

    //user가 추가한 image에 대한 각각의 정보를 arraylist속에 순서대로 저장할거에요
    List<String> objectName = new ArrayList();
    //그중에서도 getImageFromAlbum메소드를 통해 이미지의 Uri정보를 가져옵니다.
    List<Uri> userObjectImage = new ArrayList();

    //초기에는 폴더가 0개에요
    private int folderNum = 0;
    //초기에는 사용자가 가져온 이미지가 0개에요
    private int objectNum = 0;

    //이미지 가져오는거 잘 됐는지 확인하려구
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

        //Floating Action Button 3개가 있음,
        // fabMain: 열었다 닫았다,
        // addImage: 아래에 있는 recyclerview에 사진을 추가함,
        // addObjectList: 위에 있는 recyclerview 에 폴더를 추가함
        FloatingActionButton fabMain = (FloatingActionButton) view.findViewById(R.id.fabMain);
        final FloatingActionButton addImage = (FloatingActionButton) view.findViewById(R.id.addImage);
        final FloatingActionButton addObjectList = (FloatingActionButton) view.findViewById(R.id.addObjectList);


        fabMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //FAB 열려있으면 닫히게, 닫혀있으면 열리게함
                if (isOpened == false)
                    isOpened = true;
                else isOpened = false;

                //열릴때 속에 들어있는 FAB들이 위로 올라감
                if (isOpened == true) {
                    //get dimension에 대한 정의는 res>values>dimens에 되어있음
                    addImage.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
                    addObjectList.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
                } else {
                    //속으로 다시 들어가세요.
                    addImage.animate().translationY(0);
                    addObjectList.animate().translationY(0);
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //recyclerview 보여주는 곳

        super.onViewCreated(view, savedInstanceState);

        //2개의 recyclerview 선언
        //fRecyclerView: folder list 보여주는 곳(위쪽에 위치)
        //oRecyclerView: user image list 보여주는 곳 (아래쪽에 위치)
        fRecyclerView = (RecyclerView) view.findViewById(R.id.object_recyclerview_folder);
        oRecyclerView = (RecyclerView) view.findViewById(R.id.object_recyclerview_object);

        fRecyclerView.setHasFixedSize(true);
        oRecyclerView.setHasFixedSize(true);

        //adapter선언
        fAdapter = new FolderAdapter();
        oAdapter = new ObjectAdapter();

        //layoutmanager 선언, spancount는 fragment_object에서도 같이 정의할 수 있음
        fLayoutManager = new GridLayoutManager(getActivity(), 2);
        oLayoutManager = new GridLayoutManager(getActivity(), 4);

        //recyclerview가 layoutmanager를 통해 viewholder를 보여주기 때문에 둘을 연결해줌
        //view holder는 adapter속에 정의
        fRecyclerView.setLayoutManager(fLayoutManager);
        oRecyclerView.setLayoutManager(oLayoutManager);

        FloatingActionButton addObjectList = (FloatingActionButton) view.findViewById(R.id.addObjectList);
        FloatingActionButton addImage = (FloatingActionButton) view.findViewById(R.id.addImage);

        //폴더 추가하는 것
        //fab 속에 있는 addObjectList 버튼을 누르면 폴더가 추가됨
        addObjectList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addFolder(folderNum);
                folderNum++;
                fRecyclerView.setAdapter(fAdapter);
            }
        });
        //fab 속에 있는 addImage 버튼을 누르면 갤러리에서 이미지를 가지고옴
        addImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getImageFromAlbum();
                if (imageAdded) {
                    imageAdded = false;
                }
            }
        });

    }

    //갤러리 화면으로 넘어갑니다.
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

    //갤러리 속에서 이미지 버튼을 클릭하면 동작합니다.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    //data.getData returns the content URI for the selected Image
                    Uri selectedImage = data.getData();

                    //현재 자바 파일 속 리스트에 user가 선택한 이미지 Uri값을 저장함
                    userObjectImage.add(selectedImage);

                    //Adapter내의 Arraylist에 ObjectData형식(이름+uri)의 데이터를 추가함
                    addObject(objectNum);
                    objectNum++;

                    //adapter속에서 정보를 가져와서 recyclerview에 보여줌
                    oRecyclerView.setAdapter(oAdapter);

                    imageAdded = true;
                    break;
            }
    }

    //각 폴더에 대한 정보를 어댑터로 넘겨주는 메소드
    public void addFolder(int i) {

        //폴더 이름은 현 폴더 리스트에 추가하여 저장
        listName.add("folder " + Integer.toString(i + 1));

        //FolderData형식의 데이터 생성
        FolderData data = new FolderData();

        //데이터에대한 각각의 정보를 update
        data.setlistName(listName.get(i));
        data.setlistImage(listImage.get(0));

        //어댑터 속 folder에 해당하는 arraylist에 정보를 추가
        fAdapter.addData(data);

    }

    //유저가 추가한 이미지에 대한 정보를 어댑터로 넘겨주는 메소드
    public void addObject(int i) {

        //이미지 이름은 현 폴더 리스트에 추가하여 저장
        objectName.add("image " + Integer.toString(i + 1));

        //ObjectData형식의 데이터 생성
        ObjectData data = new ObjectData();

        //데이터에 대한 각각의 정보를 update
        data.setobjectName(objectName.get(i));
        data.setuserObjectImage(userObjectImage.get(i));

        //어댑터 속 userobject에 해당하는 arraylist에 정보를 추가
        oAdapter.addData(data);
    }

}