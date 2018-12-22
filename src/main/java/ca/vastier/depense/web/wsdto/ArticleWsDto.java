package ca.vastier.depense.web.wsdto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleWsDto
{
	private int id;
	private String name;
	private Integer parentArticleId;
	private Collection<ArticleWsDto> childArticles;
}
