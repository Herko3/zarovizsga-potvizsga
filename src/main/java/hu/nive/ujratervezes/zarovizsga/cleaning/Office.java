package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    private String address;
    private int area;
    private int floor;

    public Office(String address, int area, int floor) {
        this.address = address;
        this.area = area;
        this.floor = floor;
    }

    @Override
    public int clean() {
        return area * floor * 100;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }
}
