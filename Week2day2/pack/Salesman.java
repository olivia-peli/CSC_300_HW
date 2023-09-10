public class Salesman{

    public String name;
    public float total;

    public Salesman(String name, float total){
        this.name = name;
        this.total = total;
    }
    
    public String getName(){
        return this.name;
    }

    public float getTotal(){
        return this .total;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String display(){
        return this.name + ": " + this.total;
    }

    public static Salesman[] SortList(Salesman[] list){
        Salesman[] newList = new Salesman[list.length];
        for (int i = 0; i < list.length; i++){
            newList[i] = list[i];
        }
        for(int n = 0; n < list.length - 1; n++){
            for(int m = 0; m < list.length - n - 1; m++){
                if (newList[m + 1].total < newList[m].total){
                    Salesman temp = null;
                    temp = newList[m+1];
                    newList[m + 1] = newList[m];
                    newList[m] = temp;
                }
            }
        }
        return newList;
    }
    
    public static void displayAllSaleman(Salesmann[] list){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i].display);
        }
    }

    public Salesman[] getTopFive(Salesman[] sorted){
        Salesman[] returnValue = new Salesman[5];
        for(int i = sorted.length; i < 5; i++){
            returnValue[i] = sorted[sorted.length - 1];
        }
        return returnValue;
    }
}