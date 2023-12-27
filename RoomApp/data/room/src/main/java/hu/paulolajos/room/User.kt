package hu.paulolajos.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.paulolajos.utils.Constants

@Entity(tableName = Constants.DATABASE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
)