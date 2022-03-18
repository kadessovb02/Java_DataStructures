//package Ch6;
//
//// stackTriangle.java
//// Вычисление треугольных чисел с заменой рекурсии стеком
//// Запуск программы: C>java StackTriangleApp
//import java.io.*; // Для ввода/вывода
//////////////////////////////////////////////////////////////////
//class Params // Параметры, сохраняемые в стеке
//{
//    public int n;
//    public int returnAddress;
//    public Params(int nn, int ra)
//    {
//        n=nn;
//        returnAddress=ra;
//    }
//} // Конец класса Params
//    ////////////////////////////////////////////////////////////////
//class StackX
//{
//    private int maxSize; // Размер массива StackX
//    private Params[] stackArray;
//    private int top; // Вершина стека
//    //--------------------------------------------------------------
//    public StackX(int s) // Конструктор
//    {
//        maxSize = s; // Определение размера массива
//        stackArray = new Params[maxSize]; // Создание массива
//        top = -1; // Массив пока не содержит элементов
//    }
//    //--------------------------------------------------------------
//    public void push(Params p) // Размещение элемента на вершине стека
//    {
//        stackArray[++top] = p; // Увеличение top, вставка элемента
//    }
//    //--------------------------------------------------------------
//    public Params pop() // Извлечение элемента с вершины стека
//    {
//        return stackArray[top--]; // Обращение к элементу, уменьшение top
//    }
//    //--------------------------------------------------------------
//    public Params peek() // Чтение элемента на вершине стека
//    {
//        return stackArray[top];
//    }
////--------------------------------------------------------------
//} // Конец класса StackX
//////////////////////////////////////////////////////////////////
//class StackTriangleApp
//{
//    static int theNumber;
//    static int theAnswer;
//    static StackX theStack;
//    static int codePart;
//    static Params theseParams;
//    //-------------------------------------------------------------
//    public static void main(String[] args) throws IOException
//    {
//        System.out.print("Enter a number: ");
//        theNumber = getInt();
//        recTriangle();
//        System.out.println("Triangle="+theAnswer);
//    }
//    //-------------------------------------------------------------
//    public static void recTriangle()
//    {
//        theStack = new StackX(10000);
//            codePart = 1;
//        while( step() == false) // Вызывать, пока step() не вернет true
//            ; // Пустое тело цикла
//    }
//    //-------------------------------------------------------------
//    public static boolean step()
//    {
//        switch(codePart)
//        {
//            case 1: // Исходный вызов
//                theseParams = new Params(theNumber, 6);
//                theStack.push(theseParams);
//                codePart = 2;
//                break;
//            case 2: // Вход в метод
//                theseParams = theStack.peek();
//                if(theseParams.n == 1) // Проверка
//                {
//                    theAnswer = 1;
//                    codePart = 5; // Выход
//                }
//                else
//                    codePart = 3; // Рекурсивный вызов
//                break;
//            case 3: // Вызов метода
//                Params newParams = new Params(theseParams.n - 1, 4);
//                theStack.push(newParams);
//                codePart = 2; // Вход в метод
//                break;
//            case 4: // Вычисление
//                theseParams = theStack.peek();
//                theAnswer = theAnswer + theseParams.n;
//                codePart = 5;
//                break;
//            case 5: // Выход из метода
//                theseParams = theStack.peek();
//                codePart = theseParams.returnAddress; // (4 или 6)
//                theStack.pop();
//                break;
//            case 6: // Точка возврата
//                return true;
//        }
//        return false;
//    }
//    //-------------------------------------------------------------
//    public static String getString() throws IOException
//    {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        String s = br.readLine();
//        return s;
//    }
//    //-------------------------------------------------------------
//    public static int getInt() throws IOException
//    {
//        String s = getString();
//        return Integer.parseInt(s);
//    }
////--------------------------------------------------------------
//} // Конец класса StackTriangleApp
//////////////////////////////////////////////////////////////////