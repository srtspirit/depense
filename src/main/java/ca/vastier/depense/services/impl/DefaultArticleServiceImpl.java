package ca.vastier.depense.services.impl;

import java.util.Optional;

import ca.vastier.depense.daos.ArticleDao;
import ca.vastier.depense.services.ArticleService;
import ca.vastier.depense.web.dto.ArticleDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultArticleServiceImpl implements ArticleService
{
	@Autowired
	@Getter
	@Setter
	private ArticleDao articleDao;

	@Override
	public ArticleDto createArticle(final ArticleDto articleDto)
	{
		return getArticleDao().save(articleDto);
	}

	@Override
	public Optional<ArticleDto> findArticleById(final int id)
	{
		return getArticleDao().findById(id);
	}

	@Override
	public void updateArticle(final ArticleDto articleDto)
	{
		if (!getArticleDao().existsById(articleDto.getId()))
		{
			throw new IllegalStateException("article with id " + articleDto.getId() + " doesn't exist");
		}

		getArticleDao().save(articleDto);
	}

	@Override
	public void deleteArticleById(final int id)
	{
		getArticleDao().deleteById(id);
	}
}
