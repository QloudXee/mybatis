package com.q.mapper;

import java.util.List;

import com.q.model.Author;

public interface AuthorMapper {

	public void alertPassword(Author author);
	
	public List<Author> queryByName(String username);
	
	public void deleteAuthor(String username);
}
