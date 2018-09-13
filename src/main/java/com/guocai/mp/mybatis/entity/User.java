package com.guocai.mp.mybatis.entity;

/**
 * java类简单作用描述
 *
 * @ClassName: User
 * @Package: com.guocai.mp.mybatis.entity
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/9/13 15:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class User {
    private String name;
    private Integer age;
    private Double salary;
    private String address;
    private String phone;

    public User() {
    }


    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Double getSalary() {
        return this.salary;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
        final Object this$salary = this.getSalary();
        final Object other$salary = other.getSalary();
        if (this$salary == null ? other$salary != null : !this$salary.equals(other$salary)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $age = this.getAge();
        result = result * PRIME + ($age == null ? 43 : $age.hashCode());
        final Object $salary = this.getSalary();
        result = result * PRIME + ($salary == null ? 43 : $salary.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof User;
    }

    public String toString() {
        return "User(name=" + this.getName() + ", age=" + this.getAge() + ", salary=" + this.getSalary() + ", address=" + this.getAddress() + ", phone=" + this.getPhone() + ")";
    }
}
