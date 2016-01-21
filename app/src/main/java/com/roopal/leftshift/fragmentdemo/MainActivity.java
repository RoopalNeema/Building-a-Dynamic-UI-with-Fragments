package com.roopal.leftshift.fragmentdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements HeadlinesFragment.OnHeadlineSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        if(findViewById(R.id.fragment_container)!= null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            HeadlinesFragment firstFragment=new HeadlinesFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();
        }
    }

    public void onArticleSelected(int position)
    {
        ArticleFragment articleFragment=(ArticleFragment)getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        if(articleFragment!= null)
        {
            articleFragment.updateArticleView(position);
        }
        else
        {
            ArticleFragment newFragment=new ArticleFragment();
            Bundle bundle= new Bundle();
            bundle.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,newFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


    }


}
