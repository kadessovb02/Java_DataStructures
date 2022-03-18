package Ch6;
// towers.java
// Решение головоломки "Ханойская башня"
// Запуск программы: C>java TowersApp
////////////////////////////////////////////////////////////////
class TowersApp
{
    static int nDisks = 3;
    public static void main(String[] args)
    {
        doTowers(nDisks, 'A', 'B', 'C');
    }
    //-----------------------------------------------------------
    public static void doTowers(int topN,
                                char A,
                                char B,
                                char C
    )
    {
        if(topN==1)
            System.out.println("Disk 1 from " + A + " to "+ C);
        else
        {
            doTowers(topN-1, A, C, B); // A-->B
            System.out.println("Disk " + topN +
                    " from " + A + " to "+ C);
            doTowers(topN-1, B, A, C); // B-->C
        }
        //(transitive) A->B,  B->C,  A->C
    }
//----------------------------------------------------------
} // Конец класса TowersApp
///////////////////////////////////////////////////////////////