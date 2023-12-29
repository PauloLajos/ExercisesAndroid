package hu.paulolajos.room

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAlldata:  LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }
}