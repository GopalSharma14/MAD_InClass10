package com.example.ic10;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfile_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfile_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "fname";
    private static final String ARG_PARAM2 = "lname";

    ToAvatarFromEdit toAvatarFromEdit;

    private TextView ip_lname;
    private TextView ip_fname;
    private ImageView iv_avatar;
    private Button save_button;
    private String gender="";



    // TODO: Rename and change types of parameters
    private String fname;
    private String lname;

    public MyProfile_Fragment() {
        // Required empty public constructor
    }
    public void setGender(String gender){
        this.gender = gender;

    }

    @Override
    public void onResume() {
        super.onResume();
        iv_avatar = getView().findViewById(R.id.iv_avatar);
        if(this.gender.equals("male")){
            iv_avatar.setImageResource(R.drawable.male);
        }else if(this.gender.equals("female")){
            iv_avatar.setImageResource(R.drawable.female);
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyProfile.
     */
    // TODO: Rename and change types and number of parameters
/*    public static MyProfile_Fragment newInstance(String fname, String lname) {
        MyProfile_Fragment fragment = new MyProfile_Fragment();
        Bundle args = new Bundle();
        args.putString("first", fname);
        args.putString("last", lname);
        fragment.setArguments(args);
        return fragment;
    }*/



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toAvatarFromEdit= (ToAvatarFromEdit) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_profile, container, false);
        save_button=view.findViewById(R.id.save_button);
        iv_avatar = view.findViewById(R.id.iv_avatar);
        ip_fname = view.findViewById(R.id.ip_fname);
        ip_lname = view.findViewById(R.id.ip_lname);

        iv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAvatarFromEdit.startSelectAvatar();
            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAvatarFromEdit.displayProfile(ip_fname.getText().toString(),ip_lname.getText().toString(),gender);

            }
        });


        return view;
    }

/*    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }*/

    public interface ToAvatarFromEdit{
        void startSelectAvatar();
        void displayProfile(String fname,String lname,String gen);
    }

}
