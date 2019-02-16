package ca.vastier.depense.web.controllers;

import ca.vastier.depense.services.ArticleService;
import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.wsdto.ArticleWsDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("article")
public class ArticleController extends AbstractController
{
	@Getter
	@Setter
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "{name}", method = RequestMethod.POST)
	public int createArticle(@PathVariable("name") final String name)
	{
		return createArticle(ArticleWsDto.builder().name(name).build());
	}

	@RequestMapping(method = RequestMethod.POST)
	public int createArticle(@RequestBody final ArticleWsDto articleWsDto)
	{
		return createEntity(articleWsDto, ArticleDto.class).getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ArticleWsDto getArticleById(@PathVariable("id") final String id)
	{
		return getEntityById(id, ArticleWsDto.class);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateArticle(@RequestBody final ArticleWsDto articleWsDto)
	{
		updateEntity(articleWsDto, ArticleDto.class);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteArticleById(@PathVariable("id") final String id)
	{
		deleteEntity(id);
	}

	@Override
	protected GenericEntityService getEntityService()
	{
		return articleService;
	}
}
