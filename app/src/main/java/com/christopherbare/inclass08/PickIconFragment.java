package com.christopherbare.inclass08;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class PickIconFragment extends Fragment {
    private SelectIconInterface mListener;

    public PickIconFragment() {
        // Required empty public constructor
    }

    public static PickIconFragment newInstance(String param1, String param2) {
        PickIconFragment fragment = new PickIconFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_pick_icon, container, false);
    }

    public void onButtonPressed(Contact contact) {
        if (mListener != null) {
            mListener.backToNewContact(contact);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SelectIconInterface) {
            mListener = (SelectIconInterface) context;
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

    public interface SelectIconInterface {
        void backToNewContact(Contact contact);
    }
}
