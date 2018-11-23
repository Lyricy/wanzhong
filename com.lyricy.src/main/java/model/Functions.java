package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Functions {
    private Integer id;

    private String function_code;

    private String function_name;

    private String function_type;

    private String function_level;

    private Integer priority;

    private String function_url;

    private Integer up_function;

    private String valid_flag;

    private String remark;

    private Date create_time;

    private List<Functions> childrenList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunction_code() {
        return function_code;
    }

    public void setFunction_code(String function_code) {
        this.function_code = function_code;
    }

    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }

    public String getFunction_type() {
        return function_type;
    }

    public void setFunction_type(String function_type) {
        this.function_type = function_type;
    }

    public String getFunction_level() {
        return function_level;
    }

    public void setFunction_level(String function_level) {
        this.function_level = function_level;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getFunction_url() {
        return function_url;
    }

    public void setFunction_url(String function_url) {
        this.function_url = function_url;
    }

    public Integer getUp_function() {
        return up_function;
    }

    public void setUp_function(Integer up_function) {
        this.up_function = up_function;
    }

    public String getValid_flag() {
        return valid_flag;
    }

    public void setValid_flag(String valid_flag) {
        this.valid_flag = valid_flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public List<Functions> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Functions> childrenList) {
        this.childrenList = childrenList;
    }
}
