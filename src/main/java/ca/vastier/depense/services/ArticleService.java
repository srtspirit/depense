package ca.vastier.depense.services;

import java.util.Optional;

import ca.vastier.depense.web.dto.ArticleDto;


public interface ArticleService
{
	ArticleDto createArticle(ArticleDto articleDto);

	Optional<ArticleDto> findArticleById(int id);

	void updateArticle(ArticleDto articleDto);

	void deleteArticleById(int id);
}
