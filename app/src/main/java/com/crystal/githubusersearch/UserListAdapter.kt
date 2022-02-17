package com.crystal.githubusersearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.crystal.githubusersearch.Model.User
import com.crystal.githubusersearch.databinding.ItemGithubUsersBinding

class UserListAdapter : ListAdapter<User, UserListAdapter.UserViewHolder>(diffUtil) {
    inner class UserViewHolder(private val binding: ItemGithubUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                nameTextView.text = user.name
                if (user.isLiked) {
                    likeImageButton.setImageResource(R.drawable.ic_baseline_star_rate_24)
                } else {
                    likeImageButton.setImageResource(R.drawable.ic_baseline_star_border_24)
                }
                if (user.imageUrl.isNotEmpty()) {
                    Glide.with(userImageView.context)
                        .load(user.imageUrl)
                        .into(userImageView)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            ItemGithubUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }
}
