package io.dwak.reactorbinding.view;

import android.view.View;

import io.dwak.reactor.ReactorComputation;
import io.dwak.reactor.ReactorVar;
import io.dwak.reactor.interfaces.ReactorComputationFunction;

public class ReactorView {

    public static ReactorComputationFunction visibility(final ReactorVar<Boolean> source, final View target){
        return visibility(source, target, View.GONE);
    }

    private static ReactorComputationFunction visibility(final ReactorVar<Boolean> source, final View target, final int visibilityWhenFalse) {
        return new ReactorComputationFunction() {
            @Override
            public void react(ReactorComputation reactorComputation) {
                target.setVisibility(source.getValue() ? View.VISIBLE : visibilityWhenFalse);
            }
        };
    }

    public static ReactorComputationFunction clickable(final ReactorVar<Boolean> source, final View target) {
        return new ReactorComputationFunction() {
            @Override
            public void react(ReactorComputation reactorComputation) {
                target.setClickable(source.getValue());
            }
        };
    }

    public static ReactorComputationFunction longClickable(final ReactorVar<Boolean> source, final View target) {
        return new ReactorComputationFunction() {
            @Override
            public void react(ReactorComputation reactorComputation) {
                target.setLongClickable(source.getValue());
            }
        };
    }

    public static ReactorComputationFunction enabled(final ReactorVar<Boolean> source, final View target) {
        return new ReactorComputationFunction() {
            @Override
            public void react(ReactorComputation reactorComputation) {
                target.setEnabled(source.getValue());
            }
        };
    }

    public static ReactorVar<Object> clicks(View view) {
        final ReactorVar<Object> reactorVar = new ReactorVar<>();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reactorVar.setValue(new Object());
            }
        });
        return reactorVar;
    }
}
