package com.guocai.mp.mybatis.entity;

/**
 * java类简单作用描述
 *
 * @ClassName: Person
 * @Package: com.guocai.mp.mybatis.entity
 * @Description: Person实体类
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-31-19:41
 */
public class Person {
    private String name;
    private String number;

    public Person() {
    }

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$number = this.getNumber();
        final Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $number = this.getNumber();
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        return result;
    }

    public String toString() {
        return "Person(name=" + this.getName() + ", number=" + this.getNumber() + ")";
    }
}
