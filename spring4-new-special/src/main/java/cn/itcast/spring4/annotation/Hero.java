package cn.itcast.spring4.annotation;

import java.util.Date;
import java.util.LinkedList;

import com.google.common.base.Joiner;

public class Hero {
	// 编号
    private long id;
    // 名称
    private String name;
    // 等级
    private int level;
    // 性别
    private Boolean gender;
    // 出生日期
    private Date birthDate;
    // 所获荣誉
    private String[] honors;
    // 改动记录
    private LinkedList<String> logs = new LinkedList<String>();
    // 配偶
    private Hero spouse;
    // 子女
    private Hero[] children;
    
    // Getter & Setter
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Boolean getGender() {
        return gender;
    }
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String[] getHonors() {
        return honors;
    }
    public void setHonors(String[] honors) {
        this.honors = honors;
    }
    public LinkedList<String> getLog() {
        return logs;
    }
    public void setLog(LinkedList<String> logs) {
        this.logs = logs;
    }
    public Hero getSpouse() {
        return spouse;
    }
    public void setSpouse(Hero spouse) {
        this.spouse = spouse;
    }
    public Hero[] getChildren() {
        return children;
    }
    public void setChildren(Hero[] children) {
        this.children = children;
    }
    
    public String toString()  
    {
        StringBuilder sb = new StringBuilder();
        sb.append("id:" + id + "\n");
        sb.append("name:" + name + "\n");
        sb.append("level:" + level + "\n");
        sb.append("gender:" + gender + "\n");
        sb.append("birthDate:" + birthDate.toString() + "\n");
        sb.append("honors:" + Joiner.on(",").join(honors) + "\n");
        sb.append("logs:" + Joiner.on(",").join(logs) + "\n");
        sb.append("spouse:" + spouse.name + "\n");
        sb.append("children:");
        for (int i = 0; i < children.length; i++) {
            if (i < children.length - 1) {
                sb.append(children[i].name + ",");
            } else {
                sb.append(children[i].name);
            }
        }
        sb.append("\n");
        return sb.toString();
    }

}
