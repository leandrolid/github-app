package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.services.GithubService
import kotlinx.coroutines.flow.flow

class RepoRepositoryImp(private val githubService: GithubService) : RepoRepository {
    override suspend fun listRepos(user: String) = flow {
        try {
            val repoList = githubService.listRepos(user)
            emit(repoList)
        } catch (e: Throwable) {
            throw Throwable("Algo deu errado!")
        }
    }
}