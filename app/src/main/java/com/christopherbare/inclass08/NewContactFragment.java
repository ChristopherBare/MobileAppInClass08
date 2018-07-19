package com.christopherbare.inclass08;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;


public class NewContactFragment extends Fragment {
    private NewContactInterface mListener;

    public NewContactFragment() {
        // Required empty public constructor
    }

    public static NewContactFragment newInstance(String param1, String param2) {
        NewContactFragment fragment = new NewContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_contact, container, false);

        ImageButton imageButton = view.findViewById(R.id.imageViewSelect);
        imageButton.setImageResource(R.drawable.avatar_f_2);

        return view;
    }

    public void onButtonPressed(Contact contact) {
        if (mListener != null) {
            mListener.toSelectIcon(contact);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NewContactInterface) {
            mListener = (NewContactInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface NewContactInterface {
        void toSelectIcon(Contact contact);
    }
}