package com.example.toolbar.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class MyRecyclerScroll extends RecyclerView.OnScrollListener {
    private static final float HIDE_THRESHOLD =100;
    private static final float SHOW_THRESHOLD =50;

    int scrollDist =0;
    private boolean isVisible = true;

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (isVisible && scrollDist > HIDE_THRESHOLD){
            hide();
            scrollDist =0;
            isVisible =false;
        }

        else if (!isVisible && scrollDist < -SHOW_THRESHOLD){
            show();

            scrollDist =0;
            isVisible = true;
        }

        if ((isVisible && dy >0) || (!isVisible && dy <0)){
            scrollDist +=dy;
        }
    }

    public abstract void show();
    public abstract void hide();
}
