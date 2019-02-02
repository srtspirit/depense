package ca.vastier.depense.web.dto;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@Entity(name = "article")
public class ArticleDto extends AbstractEntity
{
	private String name;
	@ManyToOne
	@JoinColumn(name = "parent_article_id")
	private ArticleDto parentArticle;
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "parent_article_id")
	private Collection<ArticleDto> childArticles;
}
