package it.posts.gianvitoblog.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;

import it.posts.gianvitoblog.model.Author;

public interface PagingAndSortingAuthorRepository extends ListPagingAndSortingRepository<Author, Integer>{
    
}
