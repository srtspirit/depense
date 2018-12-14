package ca.vastier.depense.web.dto;


import java.time.LocalDate;

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
public class ArticleDto
{
	private int hui;
	private String article_name;
	private LocalDate date;
}
