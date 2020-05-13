package com.example.ic10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectAvatar_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectAvatar_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  /*  private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";*/
  ToEditFromSelectAvatar toEditFromSelectAvatar;

    private ImageView iv_female, iv_male;


    // TODO: Rename and change types of parameters
 /*   private String mParam1;
    private String mParam2;*/

    public SelectAvatar_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectAvatar.
     */
    // TODO: Rename and change types and number of parameters
/*    public static SelectAvatar_Fragment newInstance(String param1, String param2) {
        SelectAvatar_Fragment fragment = new SelectAvatar_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toEditFromSelectAvatar = (ToEditFromSelectAvatar) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_select_avatar, container, false);
        iv_male = v.findViewById(R.id.iv_male);
        iv_female = v.findViewById(R.id.iv_female);
        iv_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEditFromSelectAvatar.updateEdit(true);
            }
        });
        iv_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toEditFromSelectAvatar.updateEdit(false);
            }
        });
        return v;
    }
    public interface ToEditFromSelectAvatar{
        void updateEdit(boolean isFemale);
    }
}
