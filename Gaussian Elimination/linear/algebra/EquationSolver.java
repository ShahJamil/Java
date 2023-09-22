package linear.algebra;

public class EquationSolver {
    private static double[] stringsToDoubles(String[] values) {
        double[] doubles = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            doubles[i] = Double.parseDouble(values[i]);
        }

        return doubles;
    }

    public static void main(String[] args)
    {
        double[][] matrix = new double[args.length][args.length+1] ;
        for(int i = 0; i < args.length; i++){
            String[] equation = args[i].split(",");
            double[] equation1 = stringsToDoubles(equation);
            for(int j = 0; j < equation.length; j++){
                matrix[i][j] = equation1[j];
            }
        }
        GaussianElimination matrix1 = new GaussianElimination(args.length, args.length+1, matrix);
        matrix1.print();
        System.out.println(" ");
        matrix1.rowEchelonForm();
        matrix1.print();
        System.out.println(" ");
        matrix1.backSubstitution();
        matrix1.print();
    }
}
