package com.mikunitensai.newsia.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "favorit")
public class News implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTb")
    public int idTb;

    public int id;
    public String title;
    public String desc;
    public String image;
    public int category_id;
    public String created_at;
    public String updated_at;
}
