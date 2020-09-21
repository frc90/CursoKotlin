package com.example.cursokotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursokotlin.R
import com.example.cursokotlin.models.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostsAdapter: RecyclerView.Adapter<PostsAdapter.PostsViewHolder>(){

    class PostsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val id: TextView = itemView.tv_id
        val userId: TextView = itemView.tv_userId
        val title: TextView = itemView.tv_title
        val body: TextView = itemView.tv_body
    }

    fun setListOfPost(listPosts: List<Post>){
        this.listOfPost = listPosts
        notifyDataSetChanged() // super importante
    }

    private var listOfPost: List<Post> = emptyList()

    override fun getItemCount(): Int {
        return listOfPost.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsAdapter.PostsViewHolder {
        return PostsAdapter.PostsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostsAdapter.PostsViewHolder, position: Int) {

        val post = listOfPost[position]
        holder.id.text = post.id.toString()
        holder.userId.text = post.userId.toString()
        holder.title.text = post.title.toString()
        holder.body.text = post.body.toString()
//        holder.itemView.tv_id.text = post.id.toString()
//        holder.itemView.tv_userId.text = post.userId.toString()
//        holder.itemView.tv_title.text = post.title
//        holder.itemView.tv_body.text = post.id.toString()
    }


}