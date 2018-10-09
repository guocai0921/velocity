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
    private String content;
    private String type;
    private String lowerField;
    private String upperField;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLowerField() {
        return lowerField;
    }

    public void setLowerField(String lowerField) {
        this.lowerField = lowerField;
    }

    public String getUpperField() {
        return upperField;
    }

    public void setUpperField(String upperField) {
        this.upperField = upperField;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", lowerField='" + lowerField + '\'' +
                ", upperField='" + upperField + '\'' +
                '}';
    }
}
