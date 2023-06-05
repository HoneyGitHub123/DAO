package model;

public class Passenger {

    private int passengerID;
    private String passengerName;
    private String mobileNum;

    private int age;
    private String dob;
    private String address;
    private String city;
    private String state;
    private String countryCode;

    public Passenger(int passengerID, String passengerName, String mobileNum, int age, String dob, String address, String city, String state, String countryCode) {
        this.passengerID = passengerID;
        this.passengerName = passengerName;
        this.mobileNum = mobileNum;
        this.age = age;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.countryCode = countryCode;
    }

    public Passenger(){}

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return String.format("Passenger[passengerID=%d,passengerName=%s,mobileNum=%s,dob=%s,age=%d,address=%s,city=%s,state=%s,countryCode=%S]", passengerID, passengerName, mobileNum, dob, age, address, city, state, countryCode);

    }
}

