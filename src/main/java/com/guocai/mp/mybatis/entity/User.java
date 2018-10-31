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

    public User() {
    }

    public User(String name, String content, String type, String lowerField, String upperField) {
        this.name = name;
        this.content = content;
        this.type = type;
        this.lowerField = lowerField;
        this.upperField = upperField;
    }


    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content;
    }

    public String getType() {
        return this.type;
    }

    public String getLowerField() {
        return this.lowerField;
    }

    public String getUpperField() {
        return this.upperField;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLowerField(String lowerField) {
        this.lowerField = lowerField;
    }

    public void setUpperField(String upperField) {
        this.upperField = upperField;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$lowerField = this.getLowerField();
        final Object other$lowerField = other.getLowerField();
        if (this$lowerField == null ? other$lowerField != null : !this$lowerField.equals(other$lowerField))
            return false;
        final Object this$upperField = this.getUpperField();
        final Object other$upperField = other.getUpperField();
        if (this$upperField == null ? other$upperField != null : !this$upperField.equals(other$upperField))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $lowerField = this.getLowerField();
        result = result * PRIME + ($lowerField == null ? 43 : $lowerField.hashCode());
        final Object $upperField = this.getUpperField();
        result = result * PRIME + ($upperField == null ? 43 : $upperField.hashCode());
        return result;
    }

    public String toString() {
        return "User(name=" + this.getName() + ", content=" + this.getContent() + ", type=" + this.getType() + ", lowerField=" + this.getLowerField() + ", upperField=" + this.getUpperField() + ")";
    }
}
