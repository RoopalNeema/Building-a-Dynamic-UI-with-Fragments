package com.roopal.leftshift.fragmentdemo;

import android.os.Bundle;
import com.roopal.leftshift.fragmentdemo.R.layout.*;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vikassingh on 21/01/16.
 */
public class ArticleFragment extends Fragment {

    final static String ARG_POSITION ="position";
    int mCurrentPosition= -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (savedInstanceState!=null)
        {
            mCurrentPosition=savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        Bundle args =getArguments();
        if (args!=null)
        {
            updateArticleView(args.getInt(ARG_POSITION));
        }
        else if(mCurrentPosition!= -1)
        {
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position)
    {
        TextView article=(TextView)getActivity().findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);
        mCurrentPosition=position;
    }


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_POSITION, mCurrentPosition);

    }
}
