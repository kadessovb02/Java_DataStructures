//package Ch5;
//// linkList2.java
//// Работа со связанным списком
//// Запуск программы: C>java LinkList2App
//////////////////////////////////////////////////////////////////
//class Link
//{
//    public int iData; // Данные (ключ)
//    public double dData; // Данные
//    public Link next; // Следующий элемент в списке
//    // -------------------------------------------------------------
//    public Link(int id, double dd) // Конструктор
//    {
//        iData = id;
//        dData = dd;
//    }
//    // -------------------------------------------------------------
//    public void displayLink() // Вывод содержимого элемента
//    {
//        System.out.print("{" + iData + ", " + dData + "} ");
//    }
//} // Конец класса Link
//////////////////////////////////////////////////////////////////
//
//
//class LinkList
//{
//    private Link first; // Ссылка на первый элемент списка
//    // -------------------------------------------------------------
//    public LinkList() // Конструктор
//    {
//        first = null; // Список пока не содержит элементов
//    }
//    // -------------------------------------------------------------
//    public void insertFirst(int id, double dd)
//    { // Создание нового элемента
//        Link newLink = new Link(id, dd);
//        newLink.next = first; // newLink --> старое значение first
//        first = newLink; // first --> newLink
//    }
//    // -------------------------------------------------------------
//    public Link find(int key) // Поиск элемента с заданным ключом
//    { // (предполагается, что список не пуст)
//        Link current = first; // Начиная с 'first'
//        while(current.iData != key) // Пока совпадение не найдено
//        {
//            if(current.next == null) // Если достигнут конец списка
//                return null; // и совпадение не найдено
//            else // Если еще остались элементы
//                current = current.next; // Перейти к следующему элементу
//        }
//        return current; // Совпадение обнаружено
//    }
//    // -------------------------------------------------------------
//    public Link delete(int key) // Удаление элемента с заданным ключом
//    { // (предполагается, что список не пуст)
//        Link current = first; // Поиск элемента
//        Link previous = first;
//        while(current.iData != key)
//        {
//            if(current.next == null)
//                return null; // Элемент не найден
//            else
//            {
//                previous = current; // Перейти к следующему элементу
//                current = current.next;
//            }
//        } // Совпадение найдено
//        if(current == first) // Если первый элемент,
//            first = first.next; // изменить first
//        else // В противном случае
//            previous.next = current.next; // обойти его в списке
//        return current;
//    }
//    // -------------------------------------------------------------
//    public void displayList() // Вывод содержимого списка
//    {
//        System.out.print("List (first-->last): ");
//        Link current = first; // От начала списка
//        while(current != null) // Перемещение до конца списка
//        {
//            current.displayLink(); // Вывод данных
//                current = current.next; // Переход к следующему элементу
//        }
//        System.out.println("");
//    }
//// -------------------------------------------------------------
//} // Конец класса LinkList
//////////////////////////////////////////////////////////////////
//class LinkList2App
//{
//    public static void main(String[] args)
//    {
//        LinkList theList = new LinkList(); // Создание нового списка
//        theList.insertFirst(22, 2.99); // Вставка 4 элементов
//        theList.insertFirst(44, 4.99);
//        theList.insertFirst(66, 6.99);
//        theList.insertFirst(88, 8.99);
//        theList.displayList(); // Вывод содержимого списка
//        Link f = theList.find(44); // Поиск элемента
//        if( f != null)
//            System.out.println("Found link with key " + f.iData);
//        else
//            System.out.println("Can’t find link");
//        Link d = theList.delete(66); // Удаление элемента
//        if( d != null )
//            System.out.println("Deleted link with key " + d.iData);
//        else
//            System.out.println("Can’t delete link");
//        theList.displayList(); // Вывод содержимого списка
//    }
//} // Конец класса LinkList2App
//////////////////////////////////////////////////////////////////