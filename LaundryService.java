public class LaundryService extends PearlService{
    private String type;
    private String clothType;
    private int quantity;
   
    //normal constructor
    public LaundryService(String custName, int IC, String phoneNum, String t, String ct, int q) {
        super(custName,IC,phoneNum);
        type = t;
        clothType = ct;
        quantity = q;
    }    

   //mutator
    public void setLaundryService(String custName, int IC, String phoneNum, String t, String ct, int q) {
        super.setCustInfo(custName, IC, phoneNum);
        type = t;
        clothType = ct;
        quantity = q;
    }  

    //accessor
    public String getType(){return type;}
    public String getClothType(){return clothType;}
    public int getQuantity(){return quantity;}
    
    //processor
    public double calculateCharge(){
        double charge = 0.00;
        
        if(getType().equalsIgnoreCase("Normal"))
        {
            charge = 2.50 * quantity;
        }
        else if(getType().equalsIgnoreCase("Dry"))
        {
            
            if(getClothType().equalsIgnoreCase("Baju Kurung"))
            charge = 8 * quantity;
            
            else if(getClothType().equalsIgnoreCase("Baju Melayu"))
            charge = 8 * quantity;
            
            else if(getClothType().equalsIgnoreCase("Blazer"))
            charge = 10 * quantity;
            
            else if(getClothType().equalsIgnoreCase("Jacket"))
            charge = 9 * quantity;
            
            else if(getClothType().equalsIgnoreCase("Coat")) {
            charge = 9 * quantity;
            }

        }
        
        return charge;        
    }  
    
    public String toString(){
        return ("\n\t\t\tCustomer ID = " + ID +
             "\n\t\t\tCustomer Name = " + custName +
             "\n\t\t\tPhone Number = " + phoneNum +
             "\n\t\t\tLaundry Type = " + type +
             "\n\t\t\tCloth Type = " + clothType +
             "\n\t\t\tCloth Quantity = " + quantity +
             "\n\t\t\tFee = RM " + calculateCharge()    );
    
    }  
    
}
