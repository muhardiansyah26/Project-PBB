package com.ardiansyah.login;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class FragmentVideo extends Fragment {

    private VideoView videoView;
    String KEY_LINK ="android.resource://com.ardiansyah.login/raw/video1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_video, container,false);

        MediaController mc = new MediaController(getActivity());
        videoView=(VideoView)view.findViewById(R.id.videoView);
        //String patch = getArguments().getString(KEY_LINK);
        //Uri path = Uri.parse(getArguments().getString("getVideo"));
        Bundle argument = getArguments();
        String path=argument.getString(KEY_LINK);

        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mc);
        videoView.start();
        return view;


    }
}