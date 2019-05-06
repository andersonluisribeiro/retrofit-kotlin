package application.app.retrofitapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserWebClient().list(object: UserResponse<List<User>>{
            override fun success(response: List<User>) {
                configureList(response)
            }
        })

        val user = User("Amanda", "Graziela")

        UserWebClient().save(user, object: UserResponse<User> {
            override fun success(response: User) {
                Log.e("cadastrou", response.nome)
                configureList(listOf(response))
            }
        })

        val other = User("Maria", "Joaquina", 1)

        UserWebClient().update(other.id, other, object: UserResponse<User> {
            override fun success(response: User) {
                Log.e("atualizou", response.nome)
                configureList(listOf(response))
            }
        })

        UserWebClient().delete(2, object: UserResponse<User> {
            override fun success(response: User) {
                Log.e("deletou", response.nome)
                configureList(listOf(response))
            }
        })

    }

    private fun configureList(users: List<User>) {
        for(user in users){
            Log.i("user: ", user.sobrenome)
        }
    }


}
