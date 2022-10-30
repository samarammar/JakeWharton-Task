package com.jakewharton.repos.data.model

import com.jakewharton.repos.domain.entity.Owner

data class RepoReponce (val name:String,
                        val full_name:String,
                        val url:String,
                        val description:String,
                        val owner:Owner

)