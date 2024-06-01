import kotlinx.serialization.Serializable

/*
package ran.am.newsapp

import com.google.gson.annotations.SerializedName


data class News(
    @SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("articles") var articles: List<Articles> = listOf()
)

data class Articles(
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null
)*/


@kotlinx.serialization.Serializable
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles>
)

@Serializable
data class Articles(
    val title: String? = null,
    val description: String? = null,
    val urlToImage: String? = null
)