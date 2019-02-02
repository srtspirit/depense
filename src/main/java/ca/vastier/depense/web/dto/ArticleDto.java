package ca.vastier.depense.web.dto;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.util.stream.Collectors.toList;


@NoArgsConstructor
@Getter
@Setter
@Entity(name = "article")
public class ArticleDto extends AbstractEntity
{
	private String name;
	@ManyToOne
	@JoinColumn(name = "parent_article_id")
	private ArticleDto parentArticle;
	@OneToMany
	@JoinColumn(name = "parent_article_id")
	private Collection<ArticleDto> childArticles;

	@Builder
	public ArticleDto(final int id, final String name, final ArticleDto parentArticle, final Collection<ArticleDto> childArticles)
	{
		super(id);
		this.name = name;
		this.parentArticle = parentArticle;
		if (childArticles != null)
		{
			this.childArticles = childArticles.stream().collect(toList());
		}
	}
}
