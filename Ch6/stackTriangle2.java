package Ch6;

// stackTriangle2.java
// Вычисление треугольных чисел (стек вместо рекурсии)
// Запуск программы: C>java StackTriangle2App
import java.io.*; // Для ввода/вывода
////////////////////////////////////////////////////////////////
class StackX
{
    private int maxSize; // Размер массива
    private int[] stackArray;
    private int top; // Вершина стека
    //--------------------------------------------------------------
    public StackX(int s) // Конструктор
    {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }
    //--------------------------------------------------------------
    public void push(int p) // Размещение элемента на вершине стека
    { stackArray[++top] = p; }
    //--------------------------------------------------------------
    public int pop() // Извлечение элемента с вершины стека
    { return stackArray[top--]; }
    //--------------------------------------------------------------
    public int peek() // Чтение элемента с вершины стека
    { return stackArray[top]; }
//--------------------------------------------------------------
    public boolean isEmpty() // true, если стек пуст
    { return (top == -1); }
//--------------------------------------------------------------
} // Конец класса StackX
////////////////////////////////////////////////////////////////
class StackTriangle2App
{
    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    public static void main(String[] args) throws IOException
    {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        stackTriangle();
        System.out.println("Triangle="+theAnswer);
    }
    //-------------------------------------------------------------
    public static void stackTriangle()
    {
        theStack = new StackX(10000); // Создание стека
        theAnswer = 0; // Инициализация ответа
        while(theNumber > 0) // Пока счетчик не уменьшится до 1
        {
            theStack.push(theNumber); // Занесение элемента в стек
            --theNumber; // Уменьшение счетчика
        }
        while( !theStack.isEmpty() ) // Пока в стеке остаются элементы
        {
            int newN = theStack.pop(); // Извлечение значения
            theAnswer += newN; // Суммирование с ответом
        }
    }
    //-------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
//-------------------------------------------------------------
} // Конец класса StackTriangle2App
