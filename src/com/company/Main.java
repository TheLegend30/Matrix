package com.company;

public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(new int[][]{{1, 2, 3}, {2, 3, 4}});
        Matrix matrix1 = new Matrix(new int[][]{{3, 1, 0}, {2, 3, 4}});
        matrix.showMatrix();
        matrix.addToMatrix(matrix1);
        matrix.showMatrix();
        matrix.subFromMatrix(matrix1);
        matrix.showMatrix();

        Matrix a = new Matrix(new int[][]{{1, 2}, {2, 3}, {5, -8}, {4, 2}, {9, 0}});
        Matrix b = new Matrix(new int[][]{{0, 2, 1}, {5, 3, 1}});

        Matrix newMatrix = Matrix.multiplyMatrix(a, b);
        newMatrix.showMatrix();

        Matrix c = new Matrix(new int[][]{{5, -5}, {1, 5}, {3, 7}});
        //System.out.println(c.detMatrix());

        Matrix.transposeMatrix(c).showMatrix();
    }
}

class Matrix {
    private int x;
    private int y;
    private int matrix[][];

    public Matrix(int arr[][]) {
        this.x = arr.length;
        this.y = arr[0].length;
        matrix = arr;
    }

    public void showMatrix() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addToMatrix(Matrix matrix) {
        if (this.x != matrix.x || this.y != matrix.y) {
            System.out.println("Error: Impossible");
            return;
        }
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                this.matrix[i][j] += matrix.matrix[i][j];
            }
        }
    }

    public void subFromMatrix(Matrix matrix) {
        if (this.x != matrix.x || this.y != matrix.y) {
            System.out.println("Error: Impossible");
            return;
        }
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                this.matrix[i][j] -= matrix.matrix[i][j];
            }
        }
    }

    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.y != matrix2.x) {
            System.out.println("Error: Impossible");
            return new Matrix(new int[][]{{1}});
        }
        int newArr[][] = new int[matrix1.x][matrix2.y];
        int a;
        int b;
        int result;
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                a = 0;
                b = 0;
                result = 0;
                for (int k = 0; k < matrix2.x; k++) {
                    a = matrix1.matrix[i][k];
                    b = matrix2.matrix[k][j];
                    result += a * b;
                }
                newArr[i][j] = result;
            }
        }
        return new Matrix(newArr);
    }

    public int detMatrix() {
        int det = 0;
        int[][] mat = this.matrix;
        if (this.x == 3 && this.y == 3) {
            det = ((mat[0][0] * mat[1][1] * mat[2][2]) + (mat[0][1] * mat[1][2] * mat[2][0]) + (mat[0][2] * mat[1][0] * mat[2][1])) - ((mat[0][2] * mat[1][1] * mat[2][0]) + (mat[0][0] * mat[1][2] * mat[2][1]) + (mat[0][1] * mat[1][0] * mat[2][2]));
            return det;
        } else if (this.x == 2 && this.y == 2) {
            det = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
            return det;
        } else {
            System.out.println("Error");
            det = -1;
            return det;
        }
    }

    public static Matrix transposeMatrix(Matrix m) {
        Matrix mT;
        int arr[][] = new int[m.y][m.x];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = m.matrix[j][i];
            }
        }
        mT = new Matrix(arr);
        return mT;
    }
}
