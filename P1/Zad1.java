//Реализуйте метод, приимающий в качестве аргумента целочисленный массив.
//Если длинна массива меньш некоторого заданного минимума, методв возвращает
//-1, в качестве кода оишбки, иначе- длину массива.

public class Zad1 {
    static int arrayLength(int[] array){
        if(array.length < 2)
            return -1;
        return array.length;
    }
    public static void main(String[] args) {
        int[] array = {1,3,6,5,8,0};
        int length = arrayLength(array);
        if(length < 0){
            System.out.println("Lengh of array less hen minimum");
        }
        else 
            System.out.println("Lenght of array: " + length);
    }
}