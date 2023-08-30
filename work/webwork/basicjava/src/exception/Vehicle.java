package exception;

import java.util.Objects;

public class Vehicle {
    private Owner owner;
    private int price;

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return price == vehicle.price && Objects.equals(owner, vehicle.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, price);
    }

    @Override
    public String toString() {
        return "소유주 정보 : 이름은 " + owner.name + " 이고, 핸드폰 번호는 " + owner.cellPhone + " 입니다."
                + "\n 차량 정보 : 가격은 " + price + "입니다.";
    }
}
