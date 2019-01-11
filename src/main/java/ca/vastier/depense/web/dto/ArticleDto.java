package ca.vastier.depense.web.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
public class ArticleDto
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_article_seq_gen")
	@SequenceGenerator(name = "pk_article_seq_gen", sequenceName = "pk_article")
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "parent_article_id")
	private ArticleDto parentArticle;
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "parent_article_id")
	private Collection<ArticleDto> childArticles;
}
