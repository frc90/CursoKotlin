package com.example.cursokotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursokotlin.R
import com.example.cursokotlin.models.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostsAdapter: RecyclerView.Adapter<PostsAdapter.PostsViewHolder>(){

    class PostsViewHolder(postItem: View): RecyclerView.ViewHolder(postItem)

    fun setListOfPost(listPosts: List<Post>){
        this.listOfPost = listPosts
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
        holder.itemView.tv_id.text = post.id.toString()
        holder.itemView.tv_userId.text = post.userId.toString()
        holder.itemView.tv_title.text = post.title
        holder.itemView.tv_body.text = post.id.toString()
    }


}