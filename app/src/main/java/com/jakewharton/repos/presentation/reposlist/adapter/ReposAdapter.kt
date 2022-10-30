package com.jakewharton.repos.presentation.reposlist.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.databinding.ItemRepoBinding

class ReposAdapter constructor(
    private val context: Context, private val onItemClicked: (repo:RepoEntity) -> Unit
) : RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {


    private var repoItem: ArrayList<RepoEntity> = ArrayList()


    inner class RepoViewHolder(binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val fullName = binding.tvFullNameValue
        val repoName = binding.tvRepoNameValue
        val repoUrl = binding.tvRepoUrlValue
        val container=binding.containerView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val viewBinding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context))
        return RepoViewHolder(viewBinding)

    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {

        repoItem[position].also {
            holder.fullName.text = it.full_name
            holder.repoUrl.text = it.url
            holder.repoName.text = it.name

            val repo=it
//         holder?.containerView?.setOnClickListener { clickListener(item, position) }
            holder.container.setOnClickListener{onItemClicked(repo)}

        }
    }
    override fun getItemCount(): Int = repoItem.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(product: List<RepoEntity>) {
        repoItem.run {
            clear()
            addAll(product)
            notifyDataSetChanged()

        }
    }

}