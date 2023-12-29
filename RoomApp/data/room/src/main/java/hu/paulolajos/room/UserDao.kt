package hu.paulolajos.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import hu.paulolajos.utils.Constants

@Dao
interface UserDao {

    //create user
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    //update user
    @Update
    suspend fun updateUser(user: User)

    //read users
    @Query("SELECT * FROM ${Constants.DATABASE_NAME} ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    //delete user
    @Delete
    suspend fun deleteUser(user: User)

    //deleteAll
    @Query("DELETE FROM ${Constants.DATABASE_NAME}")
    suspend fun deleteAll()
}