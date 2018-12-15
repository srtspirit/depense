package ca.vastier.depense.web.controllers;

import ca.vastier.depense.daos.ArticleDao;
import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.wsdto.ArticleWsDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleController
{
	@Getter
	@Setter
	@Autowired
	private ArticleDao articleDao;

	@RequestMapping(value = "article/{name}", method = RequestMethod.POST)
	public ArticleWsDto createArticle(@PathVariable("name") final String name)
	{
		//TODO #10
		// not a real implementation
		final ArticleDto articleDto = getArticleDao().save(ArticleDto.builder().name(name).build());

		return ArticleWsDto.builder().id(articleDto.getId()).name(articleDto.getName()).build();
	}
}
