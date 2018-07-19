package com.christopherbare.inclass08;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;



public class ContactListFragment extends Fragment {
    private ArrayList<Contact> contacts;
    ListView listView;

    private ContactListInterface mListener;

    public ContactListFragment() {
        // Required empty public constructor
    }

    public static ContactListFragment newInstance(String param1, String param2) {
        ContactListFragment fragment = new ContactListFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        contacts = new ArrayList<>();
        contacts.add(new Contact("Christopher Bare", "cbare3@uncc.edu", "(828) 781-4547", "SIS", "ID", R.drawable.select_avatar));

        ContactAdapter adapter = new ContactAdapter(getActivity(), R.layout.contact_item, contacts);
        listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().findViewById(R.id.buttonCreate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.toNewContact();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ContactListInterface) {
            mListener = (ContactListInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ContactListInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface ContactListInterface {
        void toNewContact();
    }
}
