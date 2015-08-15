package io.dwak.reactorbinding.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import io.dwak.reactor.ReactorComputation;
import io.dwak.reactor.ReactorVar;
import io.dwak.reactor.interfaces.ReactorComputationFunction;

public class ReactorTextView {
    public static ReactorComputationFunction textRes(final ReactorVar<? extends Integer> source, final TextView target){
        return new ReactorComputationFunction() {
            @Override
            public void react(ReactorComputation reactorComputation) {
                target.setText(source.getValue());
            }
        };
    }
    public static ReactorComputationFunction text(final ReactorVar<? extends CharSequence> source, final TextView target){
        return new ReactorComputationFunction() {
            @Override
            public void react(ReactorComputation reactorComputation) {
                target.setText(source.getValue());
            }
        };
    }

    public static ReactorVar<? super CharSequence> textChanges(final TextView source){
        final ReactorVar<CharSequence> var = new ReactorVar<>();
        source.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                var.setValue(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return var;
    }
}
