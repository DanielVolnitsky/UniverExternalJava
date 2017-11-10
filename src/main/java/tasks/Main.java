package tasks;

import tasks.helpers.MatrixHelper;
import tasks.task0_02_11_2017.entities.ConsoleFigureMaker;

public class Main {
    public static void main(String[] args) {
        try {
            int rows = 5;
            int cols = 10;
            ConsoleFigureMaker.printRectangle(rows, cols);
            System.out.println();

            int n = 7;
            ConsoleFigureMaker.printRightTriangle(n);
            System.out.println();

            cols = 9;
            String[][] eqTriangle = ConsoleFigureMaker.getEquilateralTriangle(cols);
            MatrixHelper.printMatrix(eqTriangle);
            System.out.println();

            ConsoleFigureMaker.printRhombus(n);
            System.out.println();

            String[][] rhombus2 = ConsoleFigureMaker.getRhombusBy2Triangles(cols);
            MatrixHelper.printMatrix(rhombus2);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
