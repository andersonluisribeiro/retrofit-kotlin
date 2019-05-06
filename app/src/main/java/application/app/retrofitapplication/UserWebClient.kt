package application.app.retrofitapplication

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserWebClient {

    fun list(userResponse: UserResponse<List<User>>){
        val call = RetrofitInitializer().userService().list()
        call.enqueue(object: Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                response?.body()?.let {
                    val users: List<User> = it
                    userResponse.success(users)
                }
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                Log.e("error: ", t?.message)
            }
        })
    }

    fun save(user: User, userResponse: UserResponse<User>){
        val call = RetrofitInitializer().userService().save(user)

        call.enqueue(object: Callback<User?> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                Log.e("saved", response?.toString())
                response?.body()?.let {
                    val user: User = it
                    userResponse.success(user)
                }

            }

            override fun onFailure(call: Call<User?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }


    fun update(id: Int, user: User, userResponse: UserResponse<User>){
        val call = RetrofitInitializer().userService().update(user.id, user)

        call.enqueue(object: Callback<User?> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                Log.e("updated", response?.toString())
                response?.body()?.let {
                    val user: User = it
                    userResponse.success(user)
                }

            }

            override fun onFailure(call: Call<User?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    fun delete(id: Int, userResponse: UserResponse<User>){
        val call = RetrofitInitializer().userService().delete(id)

        call.enqueue(object: Callback<User?> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                Log.e("deleted", response?.toString())
                response?.body()?.let {
                    val user: User = it
                    userResponse.success(user)
                }

            }

            override fun onFailure(call: Call<User?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }
}