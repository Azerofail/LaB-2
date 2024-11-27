import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        int n=in.nextInt();
        int m=in.nextInt();
        int [][]a=new int [n][m];
        // Проверка на соответствие массиву
        if ((n<=0)||(m<=0)){
            out.print("Это не матрица");
            System.exit(0);
        }


        // +(Задание 1)Ввод данных
        // ввод данных через вложеные алгоритмы
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                a[i][j]=in.nextInt();
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                out.print(a[i][j]+" ");
            }
            out.println();
        }
        out.println();

        // +(Задание 2)Сортировка по среднему значению строки
        // Пременые для хронения средненго значения строк
        double aver_1line=0;
        double aver_2line=0;
        // Переменые для хранения суммы строк
        int sum_1line=0;
        int sum_2line=0;
        // Переменная для перестановки строк
        int s=0;
        // Переменная для  максимального числа в строках
        int max_1line =-100000;
        int max_2line =-100000;
        // Вложенные циклы для поиска сортироки
        // Цикл для сортировки всех строк
        for (int h=0;h<n;h++) {
            //Циклы для вычисления среднего значения строки а также максимального значения в строках
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    sum_1line += a[i][j];
                    sum_2line += a[i + 1][j];
                    if (a[i][j] > max_1line) {
                        max_1line = a[i][j];
                    }
                    if (a[i + 1][j] > max_2line) {
                        max_2line = a[i + 1][j];
                    }
                }
                //Конечное вычисление среднего значения в строке
                aver_1line = (double) sum_1line / m;
                aver_2line = (double) sum_2line / m;
                // Перестановка строк в массиве по условию
                if (aver_2line < aver_1line) {
                    for (int j = 0; j < m; j++) {
                        s = a[i][j];
                        a[i][j] = a[i + 1][j];
                        a[i + 1][j] = s;
                    }
                } else if (aver_2line == aver_1line) {
                    if (max_1line > max_2line) {
                        for (int j = 0; j < m; j++) {
                            s = a[i][j];
                            a[i][j] = a[i + 1][j];
                            a[i + 1][j] = s;
                        }
                    }
                }
                // Обнуление переменных суммы  строк
                sum_1line = 0;
                sum_2line = 0;
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                out.print(a[i][j]+" ");
            }
            out.println();
        }

        // +(Задание 3)Поиск наибольшей темп и координат
        // Переменные для посика координат максимума в строке
        int x=0;
        int y=0;
        // Переменные для посика координат максимума в массиве
        int x_end=0;
        int y_end=0;
        //Переменная для поиска максимума в строке
        int max_temp=-100;
        //Переменная для поиска максимума в массиве
        int max_temp_end=-100;
        // Поиск максимальной температуры через перебор вложеными массивами
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (a[i][j]>max_temp){
                    max_temp=a[i][j];
                    y=i;
                    x=j;
                }
            }
            // При нахождении большей температуры мы меняем координаты и саму температуру
            if (max_temp>max_temp_end){
                max_temp_end=max_temp;
                y_end =y;
                x_end=x;
            }
        }
        out.println("Максимальная температура: "+max_temp_end+" В точке: x="+x_end+" y="+(n-y_end-1));

        // +(Задание 4)Вывод массива в виде карты
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (a[i][j]>0){
                    // Выыод * если температура положительна
                    out.print("* ");
                }
                else if(a[i][j]<0){
                    //Выыод o если температура отридцательна
                    out.print("o ");
                }
                else{
                    //Вывод - если температура равна 0
                    out.print("- ");
                }
            }
            out.println();
        }


        // +(Задание 5)Вывод разницы максимальной и минимальной температур
        // Переменные для поиска минимального элемента
        int min=100000000;
        int min_end=10000000;
        // Поиск минимального элемента через перебор массива двумя циклами
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (a[i][j]<min){
                    min=a[i][j];
                }
            }
            if (min_end>min){
                min_end=min;
            }
        }
        // Вывод результата с использованием переменной из третей задачи, а также учет того, что температура может быть отридцательной
        if (min_end >=0) {
            out.println("Разница между максимальной и минимальной температурой: " + (max_temp_end - min_end));
        }
        else if (max_temp_end>0){
            out.println("Разница между максимальной и минимальной температурой: " + (max_temp_end -min_end));
        }
        else {
            out.println("Разница между максимальной и минимальной температурой: " + (max_temp_end -min_end));
        }

    }
}