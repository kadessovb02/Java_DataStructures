//package Ch5;
//
//public class methodSortedList {
//    public void insert(long key) // Вставка в порядке сортировки
//    {
//        Link newLink = new Link(key); // Создание нового элемента
//        Link previous = null; // От начала списка
//        Link current = first;
//        // До конца списка
//        while(current != null && key > current.dData)
//        { // или если key > current,
//            previous = current;
//            current = current.next; // Перейти к следующему элементу
//        }
//        if(previous==null) // В начале списка
//            first = newLink; // first --> newLink
//        else // Не в начале
//            previous.next = newLink; // старое значение prev --> newLink
//        newLink.next = current; // newLink --> старое значение current
//    }
//
//}
