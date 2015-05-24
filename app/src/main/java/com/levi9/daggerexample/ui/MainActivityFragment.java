package com.levi9.daggerexample.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import com.levi9.daggerexample.R;
import com.levi9.daggerexample.application.DaggerExampleApplication;
import com.levi9.daggerexample.communication.CommunicationManager;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private TextView mExampleTv;

    @Inject
    CommunicationManager mCommunicationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DaggerExampleApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);

        mExampleTv = (TextView) rootView.findViewById(R.id.example_tv);

        mExampleTv.setText(mCommunicationManager.getCurrentVersion());
        return rootView;
    }
}
