package ca.vastier.depense.web.controllers;

import java.util.Collection;

import ca.vastier.depense.services.ArticleService;
import ca.vastier.depense.services.GenericEntityService;
import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.wsdto.ArticleWsDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
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
	public ArticleWsDto createArticle(@PathVariable("name") final String name)
	{
		return createArticle(ArticleWsDto.builder().name(name).build());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ArticleWsDto createArticle(@RequestBody final ArticleWsDto articleWsDto)
	{
		final  ArticleDto articleDto = createEntity(articleWsDto, ArticleDto.class);
		return getModelMapper().map(articleDto, ArticleWsDto.class);
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

	@RequestMapping(method = RequestMethod.GET)
	public Collection<ArticleWsDto> getAllArticles()
	{
		return findAllEntities(ArticleWsDto.class);
	}

	@Override
	protected GenericEntityService getEntityService()
	{
		return articleService;
	}

	@Override
	protected ModelMapper createMapper()
	{
		final ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(ArticleDto.class, ArticleWsDto.class) //
				.addMappings(mapper -> mapper //
						.using((MappingContext<ArticleDto, Integer> ctx) -> ctx.getSource() != null ? ctx.getSource().getId() : null) //
						.map(ArticleDto::getParentArticle, ArticleWsDto::setParentArticleId));

		modelMapper.createTypeMap(ArticleWsDto.class, ArticleDto.class) //
				.addMappings(mapper -> mapper //
						.using((MappingContext<Integer, ArticleDto> ctx) -> ctx.getSource() != null ?
								ArticleDto.builder().id(ctx.getSource()).build() :
								null) //
						.map(ArticleWsDto::getParentArticleId, ArticleDto::setParentArticle));

		modelMapper.validate();
		return modelMapper;
	}
}
