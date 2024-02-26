package com.afiq.acad_simpledbroom;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(CourseModal model);
    @Update
    void update(CourseModal model);
    @Delete
    void delete(CourseModal model);
    @Query("DELETE FROM course_table")
    void deleteAllCourses();
    @Query("SELECT * FROM course_table ORDER BY courseName ASC")
    LiveData<List<CourseModal>> getAllCourses();
}
