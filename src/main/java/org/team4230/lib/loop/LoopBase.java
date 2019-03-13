package org.team4230.lib.loop;

/**
 * Base class for periodic loops
 * <p>
 * NOTE: Implementations must be threadsafe! If this can't be guaranteed,
 * odd behaviour might ensue if multiple loop objects try to modify each
 * other.
 */
public abstract class LoopBase implements Loop {
    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
