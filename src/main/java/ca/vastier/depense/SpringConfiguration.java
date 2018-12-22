package ca.vastier.depense;

import ca.vastier.depense.web.dto.ArticleDto;
import ca.vastier.depense.web.wsdto.ArticleWsDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfiguration
{
	@Bean
	public ModelMapper modelMapper()
	{

		final ModelMapper modelMapper = new ModelMapper();

		modelMapper.addConverter(ctx -> ctx.getSource().getId(), ArticleDto.class, Integer.class);
		final TypeMap<ArticleDto, ArticleWsDto> typeMap = modelMapper.createTypeMap(ArticleDto.class, ArticleWsDto.class);
		typeMap.addMapping(ArticleDto::getParentArticle, ArticleWsDto::setParentArticleId);

		modelMapper.addConverter(ctx -> ArticleDto.builder().id(ctx.getSource()).build(), Integer.class, ArticleDto.class);
		final TypeMap<ArticleWsDto, ArticleDto> reverseTypeMap = modelMapper.createTypeMap(ArticleWsDto.class, ArticleDto.class);
		reverseTypeMap.addMapping(ArticleWsDto::getParentArticleId, ArticleDto::setParentArticle);

		return modelMapper;
	}
}
