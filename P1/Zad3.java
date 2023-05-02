//Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//Неоходимо посчитать и вернуть сумму элментов этого массива.
//При этом накладываем на метод 2 ограничения:метод может работать только с квадратными массивами
//(кол-во строк = кол-ву столбцов), и в каждой ячейке может лжать только значние 0 ил 1.
//Если нарушается одно из условий, метод должен бросить RunimeExtpion с сообщением об ошибке.


public class Zad3 {
    private static  int sumMatrix(int[][]matrix) {
        if(matrix == null){
            throw new NullPointerException("matrix was null");
        }
        if(matrix.length == 0){
            throw new RuntimeException("matrix was empty");
        }
        for(int i=0; i<matrix.length;i++){
            if(matrix[i].length != matrix.length){
                throw new RuntimeException("matrix mast be square");
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{1,1,0},{1,1,1}};

    }
    
}
