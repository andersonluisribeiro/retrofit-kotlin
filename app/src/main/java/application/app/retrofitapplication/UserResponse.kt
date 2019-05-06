package application.app.retrofitapplication

interface UserResponse<T> {
    fun success(response: T)
}