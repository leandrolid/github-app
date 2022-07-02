package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.services.GithubService
import kotlinx.coroutines.flow.flow

class RepoRepositoryImp(private val githubService: GithubService) : RepoRepository {
    override suspend fun listRepos(user: String) = flow {
        try {
            val repoList = githubService.listRepos(user)
            val repoFiltered = repoList.filter { it.description != null }
            val repoSorted = repoFiltered.sortedByDescending { it.id }
            emit(repoSorted)
        } catch (e: Throwable) {
            throw Throwable("Algo deu errado!")
        }
    }
}