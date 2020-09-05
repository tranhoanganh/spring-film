package com.demo.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseDto {
    protected int id;
    protected String name;
    @JsonIgnore
    protected Timestamp createAt;
    @JsonIgnore
    protected Timestamp updateAt;

    protected String create_at;
    protected String update_at;

    public String getCreate_at() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(createAt);
        } catch (Exception exception) {
            return null;
        }
    }

    public String getUpdate_at() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(updateAt);
        } catch (Exception exception) {
            return null;
        }
    }
}
