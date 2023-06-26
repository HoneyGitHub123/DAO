package patterns.builders;

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

    public Passenger(PassengerBuilder builder) {
        this.passengerID = builder.passengerID;
        this.passengerName = builder.passengerName;
        this.mobileNum = builder.mobileNum;
        this.age = builder.age;
        this.dob = builder.dob;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.countryCode = builder.countryCode;
    }


    public int getPassengerID() {
        return passengerID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getMobileNum() {
        return mobileNum;
    }


    public int getAge() {
        return age;
    }


    public String getDob() {
        return dob;
    }


    public String getAddress() {
        return address;
    }


    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    public String getCountryCode() {
        return countryCode;
    }

    //Create PassengerBuilder class for creating passenger objects.
    public static class PassengerBuilder {
        private int passengerID;
        private String passengerName;
        private String mobileNum;
        private int age;
        private String dob;
        private String address;
        private String city;
        private String state;
        private String countryCode;


        public PassengerBuilder setPassengerID(int passengerID) {
            this.passengerID = passengerID;
            return this;
        }

        public PassengerBuilder setPassengerName(String passengerName) {
            this.passengerName = passengerName;
            return this;
        }


        public PassengerBuilder setMobileNum(String mobileNum) {
            this.mobileNum = mobileNum;
            return this;
        }


        public PassengerBuilder setAge(int age) {
            this.age = age;
            return this;

        }


        public PassengerBuilder setDob(String dob) {
            this.dob = dob;
            return this;

        }


        public PassengerBuilder setAddress(String address) {
            this.address = address;
            return this;

        }


        public PassengerBuilder setCity(String city) {
            this.city = city;
            return this;

        }


        public PassengerBuilder setState(String state) {
            this.state = state;
            return this;

        }


        public PassengerBuilder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;

        }

        public Passenger build() {
            return new Passenger(this);
        }


    }
}
