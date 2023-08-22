package exception;

import java.util.Objects;

public class Owner {
    String name;
    String cellPhone;

    public Owner(String name, String cellPhone) {
        this.name = name;
        this.cellPhone = cellPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(name, owner.name) && Objects.equals(cellPhone, owner.cellPhone);
    }

    @Override
    public String toString() {
        return "이름은 " + name + " 이고, 핸드폰 번호는 " + cellPhone + " 입니다.";
    }
}
