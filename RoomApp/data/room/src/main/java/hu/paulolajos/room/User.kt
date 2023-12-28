package hu.paulolajos.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.paulolajos.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = Constants.DATABASE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
) : Parcelable
