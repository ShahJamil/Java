package linear.algebra;

public class GaussianElimination {

  private double[][] matrix;
  private int rows;
  private int cols;

  public GaussianElimination(int rows, int columns, double[][] values) {
    this.rows = rows;
    this.cols = columns;
    this.matrix = new double[rows][cols];
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        matrix[i][j] = values[i][j];
      }
    }
  }

  public int getRows() {
    return this.rows;
  }

  public int getCols() {
    return this.cols;
  }

  public double[][] getMatrix() {
    return this.matrix;
  }

  private void checkMatrixDimensions(double[][] array){

      int checkRowCount = array.length;
      int checkColCount = array[0].length;

      if (checkRowCount + 1 != checkColCount){
        throw new IllegalArgumentException("Invalid matrix dimensions");
      }
  }

  public void print() {
    String line;
    int count = 0;
    for (int i = 0; i < this.rows; i++) {
      count = 0;
      line = "";
      for (int j = 0; j < this.cols - 1; j++) {
        if (matrix[i][j] >= 0.0) {
          switch(count){
            case 0: 
            line += "+" + Double.toString(matrix[i][j]) + "x";
            break;
            case 1: 
            line += "+" + Double.toString(matrix[i][j]) + "y";
            break;
            case 2: 
            line += "+" + Double.toString(matrix[i][j]) + "z";
            break;
          }
          count++;
          
        } else {
          switch(count){
            case 0: 
            line += Double.toString(matrix[i][j]) + "x";
            break;
            case 1: 
            line += Double.toString(matrix[i][j]) + "y";
            break;
            case 2: 
            line += Double.toString(matrix[i][j]) + "z";
            break;
          }
          count++;
        }
      }
       
       line += "=" + Double.toString(matrix[i][this.cols - 1]); 
      System.out.println(line);
    }
  
  }

  public void setMatrix(double[][] values) {
    if (this.rows != values.length || this.cols != values[0].length) {
      throw new IllegalArgumentException("Invalid matrix dimensions");
    } else {
      checkMatrixDimensions(values);
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix[i][j] = values[i][j];
        }
      }
    }
  }

  

  

  private void swapRows(int k, int maxInd) {
    double[] temp = this.matrix[k];
    this.matrix[k] = this.matrix[maxInd];
    this.matrix[maxInd] = temp;
  }

  


  private int argMax(int h, int k) {
    double max = Math.abs(matrix[h][k]);
    int maxInd = h;
    for (int i = h + 1; i < this.rows; i++) {
      double n = Math.abs(this.matrix[i][k]);
      if (Math.abs(n) > max) {
        max = Math.abs(n);
        maxInd = i;
      }
    }

    return maxInd;
  }

  private void multiplyRow(int rowIndex, int colIndex) {
    double fact = this.matrix[rowIndex][colIndex];
    for (int j = colIndex; j < this.cols; j++) {
      this.matrix[rowIndex][j] = this.matrix[rowIndex][j] / fact;
    }
  }

  private void multiplyAndAddRow(int addRow, int mulRow, int colIndex) {
    double factor = this.matrix[addRow][colIndex] / this.matrix[mulRow][colIndex];
    for (int j = colIndex; j < this.cols; j++) {
      this.matrix[addRow][j] = this.matrix[addRow][j] - this.matrix[mulRow][j] * factor;
    }
  }

  public void rowEchelonForm() {
    int h = 0;
    int k = 0;

    while (h < this.rows && k < this.cols) {
      int maxInd = argMax(h, k);
      if (this.matrix[maxInd][k] == 0) {
        k++;
      } else {
        swapRows(h, maxInd);
        
        for (int i = h + 1; i < this.rows; i++) {
          multiplyAndAddRow(i, h, k);
        }
          multiplyRow(h,k);
        h++;
        k++;
      }
    }
  }

  public void backSubstitution() {
    int n = Math.min(this.rows, this.cols);

    for (int i = this.rows - 1; i >= 0; i--) {
      if (this.matrix[i][i] == 0.0 || this.matrix[i][i] == -0.0) {
        throw new IllegalArgumentException(
          "Matrix is singular or has a zero diagonal element."
        );
      }

      multiplyRow(i, i);

      for (int j = i - 1; j >= 0; j--) {
        double factor = this.matrix[j][i];
        multiplyAndAddRow(j, i, i);
      }
    }
  }
}
