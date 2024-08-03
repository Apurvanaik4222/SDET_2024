package TestComponent;

public class CustomerDetailsJOFS {
    private String CourseName;
    private String PurchaseDate;
    private int Amount;
    private String Location;

    private String  name;

    public  void setName(String name){
        this.name =name;
    }

    public String getName(){
        return name;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }


}
