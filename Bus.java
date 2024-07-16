package busReservation;

public class Bus {
	
	private int busNo;  //Private access specifier is declared to not access these data outside this class
    private boolean ac;  //But to get adequate information about the bus outside the class ,the Setter and Getter method is used
    private int capacity;
    
    Bus(int no,boolean ac,int capacity){
        this.busNo=no;
        this.ac=ac;
        this.capacity=capacity;
    }
    
    public int getCapacity(){  //Getter  or Accessor Method
        return capacity;
    }
    
    public void setCapacity(int x){  //Setter  or  Mutator
        capacity=x;
    }
    
    public int getBusNo(){
        return busNo;
    }
    
    public boolean isAc(){
        return ac;
    }
    
    public void setAc(boolean val){
        ac=val;
    }

    void displayInfo(){  //To display the bus information to the user
        System.out.println("Bus No : "+busNo+" Ac : "+ac+" Capacity : "+capacity);
    }
}
