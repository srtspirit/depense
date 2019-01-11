package ca.vastier.depense.web.controllers;

import ca.vastier.depense.exceptions.EntityNotFoundException;
import ca.vastier.depense.services.ArticleService;
import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.wsdto.ArticleWsDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("article")
public class ArticleController
{
	@Getter
	@Setter
	@Autowired
	private ArticleService articleService;
	@Setter
	@Getter
	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "{name}", method = RequestMethod.POST)
	public int createArticle(@PathVariable("name") final String name)
	{
		final ArticleDto articleDto = getArticleService().createArticle(ArticleDto.builder().name(name).build());
		return articleDto.getId();
	}

	@RequestMapping(method = RequestMethod.POST)
	public int createArticle(@RequestBody final ArticleWsDto articleWsDto)
	{
		final ArticleDto articleDto = getModelMapper().map(articleWsDto, ArticleDto.class);
		final ArticleDto result = getArticleService().createArticle(articleDto);

		return result.getId();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ArticleWsDto getReceiptById(@PathVariable("id") final String id)
	{
		final ArticleDto articleDto = getArticleService().findArticleById(Integer.valueOf(id))
				.orElseThrow(() -> new EntityNotFoundException("Article not found"));

		return getModelMapper().map(articleDto, ArticleWsDto.class);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateArticle(@RequestBody final ArticleWsDto articleWsDto)
	{
		final ArticleDto articleDto = getModelMapper().map(articleWsDto, ArticleDto.class);
		getArticleService().updateArticle(articleDto);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteArticleById(@PathVariable("id") final String id)
	{
		getArticleService().deleteArticleById(Integer.valueOf(id));
	}
}
