package ran.am.newsapp

 import Articles
 import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    var NewsListResponse:List<Articles> by mutableStateOf(listOf())

    var errorMessage: String by mutableStateOf("")

    fun getNewsList(){

        viewModelScope.launch {

            val apiService = NewsApiService.getInstance()
            try {
                NewsListResponse = apiService.getNews().articles

            }
            catch (e: Exception){
                errorMessage = e.message.toString()
            }

        }

    }

}