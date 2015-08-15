package io.dwak.reactorbinding.view;

import android.view.View;

public class ViewClickEvent {
    private final View mView;

    private ViewClickEvent(View view) {
        mView = view;
    }

    public static ViewClickEvent create(View view){
        return new ViewClickEvent(view);
    }
}
