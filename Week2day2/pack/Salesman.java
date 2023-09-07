public class Driver{

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
    
    public setName(String name){
        return this.name +": " +this.total;

    }
}