public abstract class PearlService {
    protected String custName;
    protected int ID;
    protected String phoneNum;
    private String type;
    
    //default constructor
    public PearlService(String custName, int ID, String phoneNum) {
        this.custName = custName;
        this.ID = ID;
        this.phoneNum = phoneNum;
    }
    
    //mutator
    public void setCustInfo(String custName, int ID, String phoneNum) {
        this.custName = custName;
        this.ID = ID;
        this.phoneNum = phoneNum;        
    }
    
    //accessor
    public String getCustName() {return custName; }
    public int getIC() {return ID; }
    public String getPhoneNum() {return phoneNum; }
    
    //call calculateCharge
    public abstract double calculateCharge();
    public String getType() {return type; }
    
    
    
    //display
    public String toString(){
        return "Customer ID = " + ID +
             "\nCustomer Name = " + custName +
             "\nPhone Number = " + phoneNum  ;
    
    }
}
