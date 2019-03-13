package org.team4230.lib.math;

/**
 * Basic matrix class with simple operations
 * <p>
 * All math operations are chainable:
 * <pre>
 *  {@code
 *  Matrix a = new Matrix(2,2);
 *  Matrix b = new Matrix(2,2);
 *  // chained calls work:
 *  a.add(b).mult(3).mult(27);}
 * </pre>
 */
public class Matrix {

    private double[][] _internal;
    private int rows;
    private int cols;

    /**
     * Instantiate a new Matrix object with the specified rows and columns. All
     * elements are initialized to to the hava default for double arrays (0.0f).
     *
     * @param r Number of rows in the matrix
     * @param c Number of columns in the matrix
     */
    public Matrix(int r, int c) {
        _internal = new double[r][c];
        rows = r;
        cols = c;
    }

    public double getAt(int r, int c) {
        return _internal[r][c];
    }

    public void setAt(int r, int c, double val) {
        _internal[r][c] = val;
    }

    public double[] getRow(int r) {
        return _internal[r];
    }

    public void setRow(int i, double[] vals)
            throws IndexOutOfBoundsException {
        if(vals.length != cols) {
            throw new IndexOutOfBoundsException("Invalid input row length");
        }
        _internal[i] = vals;
    }

    public Matrix add(Matrix other) {
        for(int i = 0; i < other.rows; ++i) {
            for (int j = 0; j < other.cols; ++j) {
                _internal[i][j] += other._internal[i][j];
            }
        }
        return this;
    }

    public Matrix sub(Matrix other) {
        for(int i = 0; i < other.rows; ++i) {
            for (int j = 0; j < other.cols; ++j) {
                _internal[i][j] -= other._internal[i][j];
            }
        }
        return this;
    }

    public Matrix mult(double val) {
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                _internal[i][j] *= val;
            }
        }
        return this;
    }

    /**
     * Multiply two matricies together using the slow copy-and-loop algorithm
     *
     * @param b Matrix to mulitply this matrix with.
     * @return this matrix after the operation has been applied
     */
    public Matrix mult(Matrix b) {
        double[][] temp = new double[rows][b.cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < b.cols; ++j) {
                double acc = 0;
                for (int k = 0; k < cols; ++k) {
                    acc += _internal[i][k] * b._internal[k][j];
                }
                temp[i][j] = acc;
            }
        }
        _internal = temp;
        cols = b.cols;
        return this;
    }

    public double det() {
        return 0;

    }

    private double recurseDet(int size, int colI) {
        if(size == 2) {
            return _internal[0][0] * _internal[1][1] - _internal[0][1];
        }
        return 0;
    }
}
