package ca.vastier.depense.web.wsdto;


import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
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
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer parentArticleId;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Collection<ArticleWsDto> childArticles;
}
