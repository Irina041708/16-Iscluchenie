//Рализуйте метод, принимающий в качестве аргумента целочисленный массив и некторое значение.
// Метод ищет заданное значение и возвращает его индкс. При этом, например:
//1.если длина массива меньше некоторого заданного минимума, метод возвращает -1 , в качстве кода ошибки.
//2.если искомый элемент не найден, метод вернет -2 в качстве кода ошибки.
//3.если вместо массива пришел null метод вернет -3
//4.придумайте свои варианты исключительных ситуаций и верните соотвтствующи коды ошибок.
//Напишите метод, в котором реализуйте взаимодействие с пользователем. ТО есть, этот метод запросит искомое значение у 
//пользователя, вызовет первый, обработает возвращенное значение и покажет чиаемый результат пользователю. 
//Например: если вернулся -2 , пользоватлю выведется сообщение : "Искомый элемент не найден".
public class Zad2 {

    private static final int MINSIZE = 5;
    public static void main(String[] args) {
        int[] arr = {5,4,8,8,8,8,8,0};
        userInterface(findElement(arr, 0));
        
    }

    public static int getSize(int[] array) {
        if(array.length < MINSIZE){
            return -1;
        }
        return array.length;
    }

    public static  int findElement(int[] array, int value){
       
        if(array == null){
            return -3;
        }
        if(array.length < 2){
            return -1;
        }
        for(int i = 0; i < array.length; i++){
            if (array[i] == value){
                return i;
            }
        }
        return -2;
    }

    public static void userInterface(int answer) {
        if(answer == -1){
            System.out.println("Длина массива меньш " + MINSIZE);
        }
        else if(answer == -2){
            System.out.println("Искомый элемент не найден");
        }
        else if(answer == -3){
            System.out.println("Массив не существует");
        }
        else System.out.println("Индекс искомого элемента равен " + answer);
    }
    
}
