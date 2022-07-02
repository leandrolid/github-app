package br.com.dio.app.repositories.data.services

import br.com.dio.app.repositories.data.model.Repo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Repo>
}