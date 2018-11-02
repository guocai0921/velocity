package com.guocai.mp.mybatis.entity;

/**
 * java类简单作用描述
 *
 * @ClassName: Student
 * @Package: com.guocai.mp.mybatis.entity
 * @Description: 学生类
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-31-19:14
 */
public class Student {
    private String name;
    private Integer age;
    private Integer score;

    public Student() {
    }

    @java.beans.ConstructorProperties({"name", "age", "score"})
    public Student(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
        final Object this$score = this.getScore();
        final Object other$score = other.getScore();
        if (this$score == null ? other$score != null : !this$score.equals(other$score)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $age = this.getAge();
        result = result * PRIME + ($age == null ? 43 : $age.hashCode());
        final Object $score = this.getScore();
        result = result * PRIME + ($score == null ? 43 : $score.hashCode());
        return result;
    }

    public String toString() {
        return "Student(name=" + this.getName() + ", age=" + this.getAge() + ", score=" + this.getScore() + ")";
    }
}
