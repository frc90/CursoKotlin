package com.example.cursokotlin.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cursokotlin.models.Post
import com.example.cursokotlin.R
import com.example.cursokotlin.adapters.PostsAdapter
import com.example.cursokotlin.services.JsonPlaceHolderService
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        rv_retrofit.layoutManager = LinearLayoutManager(this)
        rv_retrofit.adapter = PostsAdapter()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(JsonPlaceHolderService::class.java)

        val posts = service.getPost()

        posts.enqueue(object : Callback<List<Post>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
//                    response.body()?.let { posts ->
//                        (rv_retrofit.adapter as PostsAdapter).setListOfPost(listP)
//                    }

                    val posts = response?.body()
                    var content = ""
                    posts?.forEach { post ->
                        content += "Id: " + post.id + "\n"
                        content += "UserId: " + post.userId + "\n"
                        content += "Title: " + post.title + "\n"
                        content += "Body: " + post.body + "\n"
                        content += "__________________________" + "\n"
                    }
                    tv_jsonPlaceholder.append(content)

//                    Log.i("TAG_LOG", Gson().toJson(posts))

//                    response.body()?.let {
//                        tv_jsonPlaceholder.text = "Code: " + response.code()
//                            .toString() + "\n" + "Body: " + response.body().toString()
//                    }
                } else {
                    Toast.makeText(this@RetrofitActivity, response.message(), Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@RetrofitActivity, "Algo fallo!!!", Toast.LENGTH_LONG).show()
                t?.printStackTrace()
                call.cancel()
            }

        })
    }
}


//                    var jsonPost = "{" +
//                            "'id':1," +
//                            "'userId':1," +
//                            "'title':'test of test'," +
//                            "'body':'this is a test'," +
//                            "}"