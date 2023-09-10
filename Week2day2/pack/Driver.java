public class Driver {
     public static void main(String[] args){
    Salesman[] sales = new Salesman[8];
    sales[0] = newSalesman("Blade", 0);
    sales[1] = newSalesman("Kate", 1000);
    sales[2] = newSalesman("John", 500);
    sales[3] = newSalesman("Jon", 300);
    sales[4] = newSalesman("Steven", 600);
    sales[5] = newSalesman("Homer", 800);
    sales[6] = newSalesman("Matt", 700);
    sales[7] = newSalesman("Peter", 200);
    Salesman.displayAllSaleman(sales);
    System.out.println("Sorting...");
    Salesman[] sorted = Salesman.SortList(sales);
    Salesman.displayAllSaleman(sorted);
    Salesman[] topFive = new Salesman.getTopFive(sorted);
    System.out.println("Give me top 5 salesman list:");
    Salesmann.displayAllSaleman(topFive);
    }
}