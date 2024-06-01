package ran.am.newsapp

import NewsResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

interface NewsApiService {

    @GET("top-headlines?country=us&category=business&apiKey=684cb893caf7425abeffad82ac1d0f4e")
    suspend fun getNews() : NewsResponse

    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"



        var apiService: NewsApiService? = null
        fun getInstance() : NewsApiService {
            if (apiService == null) {

                val contentType = "application/json".toMediaType()
                val json = Json { ignoreUnknownKeys = true }

                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //.addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(json.asConverterFactory(contentType)) //added Kotlinx
                    .build().create(NewsApiService::class.java)
            }
            return apiService!!
        }
    }
}

