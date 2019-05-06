package application.app.retrofitapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer{

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:3333")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun userService() =  retrofit.create(UserService::class.java)


}