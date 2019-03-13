package org.team4230.lib.loop;

public interface Loop {
    void onStart();
    void execute();
    void onStop();
    boolean isFinished();
    String getName();
}
