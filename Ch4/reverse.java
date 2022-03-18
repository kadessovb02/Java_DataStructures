package Ch4;
// reverse.java
// Использование стека для перестановки символов строки
// Запуск программы: C>java ReverseApp
import java.io.*; // Для ввода/вывода
////////////////////////////////////////////////////////////////
class Reverser
{
    private String input; // Входная строка
    private String output; // Выходная строка
    //--------------------------------------------------------------
    public Reverser(String in) // Конструктор
    { input = in; }
    //--------------------------------------------------------------
    public String doRev() // Перестановка символов
    {
        int stackSize = input.length(); // Определение размера стека
        StackX theStack = new StackX(stackSize); // Создание стека
        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j); // Чтение символа из входного потока
            theStack.push(ch); // Занесение в стек
        }
        output = "";
        while( !theStack.isEmpty() )
        {
            char ch = (char) theStack.pop(); // Извлечение символа из стека
            output = output + ch; // Присоединение к выходной строке
        }
        return output;
    }
//--------------------------------------------------------------
} // Конец класса Reverser
////////////////////////////////////////////////////////////////
class ReverseApp
{
    public static void main(String[] args) throws IOException
    {
        String input, output;
        while(true)
        {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString(); // Чтение строки с клавиатуры
            if( input.equals("") ) // Завершение, если [Enter]
                break;
            // Создание объекта Reverser
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev(); // Использование
            System.out.println("Reversed: " + output);
        }
    }
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------
} // Конец класса ReverseApp
////////////////////////////////////////////////////////////////