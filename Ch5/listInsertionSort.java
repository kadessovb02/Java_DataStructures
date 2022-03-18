//package Ch5;
//
//// listInsertionSort.java
//// Применение сортированного списка для сортировки массива
//// Запуск программы: C>java ListInsertionSortApp
//////////////////////////////////////////////////////////////////
//class Link
//{
//    public long dData; // Данные
//    public Link next; // Следующий элемент списка
//    // -------------------------------------------------------------
//    public Link(long dd) // Конструктор
//    { dData = dd; }
//// -------------------------------------------------------------
//} // Конец класса Link
//////////////////////////////////////////////////////////////////
//class SortedList
//{
//    private Link first; // Ссылка на первый элемент списка
//    // -------------------------------------------------------------
//    public SortedList() // Конструктор (без аргументов)
//    { first = null; } // Инициализация списка
//    // -------------------------------------------------------------
//    public SortedList(Link[] linkArr) // Конструктор (аргумент - массив)
//    { //
//        first = null; // Инициализация списка
//        for(int j=0; j<linkArr.length; j++) // Копирование массива
//            insert( linkArr[j] ); // в список
//    }
//    // -------------------------------------------------------------
//    public void insert(Link k) // Вставка (в порядке сортировки)
//    {
//        Link previous = null; // От начала списка
//        Link current = first;
//        // До конца списка
//        while(current != null && k.dData > current.dData)
//        { // или если ключ > current,
//            previous = current;
//            current = current.next; // Перейти к следующему элементу
//        }
//        if(previous==null) // В начале списка
//            first = k; // first --> k
//        else // Не в начале
//            previous.next = k; // старое значение prev --> k
//        k.next = current; // k --> старое значение current
//    }
//    // -------------------------------------------------------------
//    public Link remove() // Возвращает и удаляет первую ссылку
//    { // (assumes non-empty list)
//        Link temp = first; // Сохранение ссылки
//        first = first.next; // Удаление первого элемента
//        return temp; // Метод возвращает ссылку
//    } // на удаленный элемент
//// -------------------------------------------------------------
//} // Конец класса SortedList
//////////////////////////////////////////////////////////////////
//class ListInsertionSortApp
//{
//    public static void main(String[] args)
//    {
//        int size = 10;
//        // Создание массива
//        Link[] linkArray = new Link[size];
//        for(int j=0; j<size; j++) // Заполнение массива
//        { // Случайные числа
//            int n = (int)(java.lang.Math.random()*99);
//            Link newLink = new Link(n); // Создание элемента
//            linkArray[j] = newLink; // Сохранение в массиве
//        }
//        // Вывод содержимого массива
//        System.out.print("Unsorted array: ");
//        for(int j=0; j<size; j++)
//            System.out.print( linkArray[j].dData + " " );
//        System.out.println("");
//        // Создание нового списка,
//        // инициализированного содержимым массива
//        SortedList theSortedList = new SortedList(linkArray);
//        for(int j=0; j<size; j++) // links from list to array
//            linkArray[j] = theSortedList.remove();
//        // Вывод содержимого массива
//        System.out.print("Sorted Array: ");
//        for(int j=0; j<size; j++)
//            System.out.print(linkArray[j].dData + " ");
//        System.out.println("");
//    }
//} // Конец класса ListInsertionSortApp
//////////////////////////////////////////////////////////////////