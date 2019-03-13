package org.team4230.lib.utils;


/**
 * Definite, bounded storage for doubles
 * <p>
 * By using fixed length arrays, "bucket brigade" copies are avoided when
 * inserting into the front of the array. This also means that old data will
 * be overwritten as the buffer fills. This should be realtime safe barring the
 * initial allocation as accesses, insertion, and deletions are constant time.
 * However, resizing the buffer is not realtime safe and should not be done
 * in latency sensitive threads, e.g. PID loops.
 */
public class RingBuffer {

    private int index;
    private int length;
    private double[] internal;

    public RingBuffer(int size) {
        length = 0;
        index = 0;
        internal = new double[size];
    }

    public int length() {
        return length;
    }

    public void insert(double val) {

    }
}
