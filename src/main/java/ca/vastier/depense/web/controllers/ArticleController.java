package ca.vastier.depense.web.controllers;

import ca.vastier.depense.generated.model.Article;
import ca.vastier.depense.web.wsdto.ArticleWsDto;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleController
{
	@RequestMapping(value = "article/{name}", method = RequestMethod.POST)
	public ArticleWsDto createArticle(@PathVariable("name") final String name)
	{
		//TODO #10
		// not a real implementation
		final ObjectContext ctx = ServerRuntime.builder().addConfig("cayenne-project.xml").build().newContext();

		final Article article = ctx.newObject(Article.class);
		article.setName(name);

		ctx.commitChanges();

		return ArticleWsDto.builder().id(article.getId()).name(article.getName()).build();
	}
}
