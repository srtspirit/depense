package ca.vastier.depense.web.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
}
