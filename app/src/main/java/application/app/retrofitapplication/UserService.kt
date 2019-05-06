package application.app.retrofitapplication

import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("users")
    fun list(): Call<List<User>>

    @POST("users")
    fun save(@Body user: User): Call<User>

    @PUT("users/{id}")
    fun update(@Path("id") id: Int, @Body user: User): Call<User>

    @DELETE("users/{id}")
    fun delete(@Path("id") id: Int): Call<User>
}