package com.example.ashra.badu_chandorfrealty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ashra on 12/26/2018.
 */

public class HomeFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);

  Button btnFragment =(Button)view.findViewById(R.id.btnId);

 btnFragment.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {

         FragmentTransaction fr = getFragmentManager().beginTransaction();
         fr.replace(R.id.fragment_container,new FullWebViewFragment());
         fr.commit();

     }
 });


       // enterButton = (Button)  getView().findViewById(R.id.btnId);
        return view;
    }
}
