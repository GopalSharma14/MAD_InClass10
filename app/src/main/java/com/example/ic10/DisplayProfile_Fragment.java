package com.example.ic10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayProfile_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayProfile_Fragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";*/

    // TODO: Rename and change types of parameters
/*    private String mParam1;
    private String mParam2;*/

ToEditFromDisplayProfile toEditFromDisplayProfile;

    private TextView dp_name;
    private TextView dp_gender;

    private ImageView dp_avatar;

    private Button edit_button;

    public DisplayProfile_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplayProfile_Fragment.
     */
    // TODO: Rename and change types and number of parameters
/*    public static DisplayProfile_Fragment newInstance(String param1, String param2) {
        DisplayProfile_Fragment fragment = new DisplayProfile_Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toEditFromDisplayProfile= (ToEditFromDisplayProfile) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_display_profile_, container, false);
       /* String firstName=getArguments().getString("first");
        String lastName=getArguments().getString("last");*/
        String fname = getArguments().getString("fname");
        String lname = getArguments().getString("lname");
        String gen=getArguments().getString("gender");
        Log.d("demo", "onCreateView: "+gen);


        dp_name = v1.findViewById(R.id.display_name);
        dp_name.setText(fname+" "+lname);
        dp_gender = v1.findViewById(R.id.display_gender);

        dp_avatar = v1.findViewById(R.id.dp_avatar);
        if(gen.equals("female")) {
            dp_gender.setText("Female");
            dp_avatar.setImageDrawable(getActivity().getDrawable(R.drawable.female));
        }else if(gen.equals("male")){
            dp_gender.setText("Male");
            dp_avatar.setImageDrawable(getActivity().getDrawable(R.drawable.male));
        }

        edit_button = v1.findViewById(R.id.edit_button);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEditFromDisplayProfile.onBackPressed();
            }
        });
        return v1;
    }
    public interface ToEditFromDisplayProfile{
        void onBackPressed();
    }
}
