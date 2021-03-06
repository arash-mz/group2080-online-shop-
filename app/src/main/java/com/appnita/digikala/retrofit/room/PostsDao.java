package com.appnita.digikala.retrofit.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.appnita.digikala.ui.RecyclerObjectClass;

import java.util.List;

@Dao
public interface PostsDao {

    @Insert
    public void insert (RecyclerObjectClass recyclerObjectClass);

    @Update
    void update (RecyclerObjectClass recyclerObjectClass);

    @Query("Delete From posts_table")
    void deleteall();

    @Query("SELECT * FROM posts_table")
    List<RecyclerObjectClass> getAllPosts();

    @Query("SELECT * FROM posts_table WHERE post_category = :postCategory")
    List<RecyclerObjectClass> getCategoraizedPosts(int postCategory);

}
